package br.com.cielo.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import br.com.cielo.settlement.entity.SettlementFinancialAdjustment;
import br.com.cielo.settlement.financialadjustment.SettlementFinancialAdjustmentClient;

@Stateless
public class Importacao {

	private String delimitador = ";";
	private Map<Integer, List<String>> mapa;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private int VALOR_MAXIMO = 1000;
	BufferedReader br;
	private Long dataInicial = null;
	private String PULA_LINHA = "/r/n";
	// private String ESPACO = " ";
	private String VIRGULA = ",";

	private String ERRO_PARCER = "ERRO_PARCER";
	private String ERRO_FILA = "ERRO_FILA";
	private String arquivoIn = "C:/Users/fpach/git/hackatonFB/testData/testData.csv";

	@EJB
	private transient SettlementFinancialAdjustmentClient settlementFinancialAdjustmentClient;

	@Schedule(second = "*", minute = "*/1", hour = "*", persistent = false)
	public void importaFile() {
		boolean isPrimeiraLinha = true;
		List<ErroVO> listaErro = new ArrayList<ErroVO>();
		try {
			String sCurrentLine;
			dataInicial = System.currentTimeMillis();
			br = new BufferedReader(new FileReader(arquivoIn));
			int i = 0;
			List<String> lista;

			mapa = new HashMap<Integer, List<String>>();
			while ((sCurrentLine = br.readLine()) != null) {
				if (isPrimeiraLinha) {
					isPrimeiraLinha = false;
					continue;
				}
				String[] sTemp = sCurrentLine.split(delimitador, -1);
				lista = new ArrayList<String>();
				for (int j = 0; j < sTemp.length; j++) {
					lista.add(sTemp[j].trim());
				}
				mapa.put(i++, lista);
				if (mapa.size() > VALOR_MAXIMO) {
					processaMapa(mapa, listaErro); // processa o mapa e envia
													// para a fila
					mapa.clear();
				}
			}
			if (mapa.size() > 0) {
				processaMapa(mapa, listaErro);
				mapa.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Map<Integer, List<String>> obtemDadosArquivo(String caminhoArquivo)", e);
		} finally {
			writterError(listaErro);
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			System.out.println("Tempo de processamento em miliseconds - " + (System.currentTimeMillis() - dataInicial));
		}

		// exibe leitura
		// for (int i = 0; i < mapa.size(); i++) {
		// List<String> listaOut = mapa.get(i);
		// String sOut = new String();
		// for (int j = 0; j < listaOut.size(); j++) {
		// sOut += "-" + listaOut.get(j);
		// }
		// System.out.println(sOut);
		// }
	}

	/**
	 * processa os dados do mapa e envia para a fila
	 * 
	 * @param mapa2
	 * @param mapaErro
	 */
	private void processaMapa(Map<Integer, List<String>> mapa2, List<ErroVO> listaError) {
		int linhaCorrente = -1;
		for (Map.Entry<Integer, List<String>> listaCampos : mapa.entrySet()) {
			linhaCorrente = listaCampos.getKey();
			SettlementFinancialAdjustment settlementAdjustment = null;
			try {
				settlementAdjustment = new SettlementFinancialAdjustment(listaCampos.getValue());
			} catch (ParseException e) {
				e.printStackTrace();
				listaError.add(new ErroVO(linhaCorrente, mapa.get(linhaCorrente), ERRO_PARCER));
			}

			try {
				settlementFinancialAdjustmentClient.send(settlementAdjustment);
			} catch (Exception e) {
				listaError.add(new ErroVO(linhaCorrente, mapa.get(linhaCorrente), ERRO_FILA));
			}
		}
	}

	private void writterError(List<ErroVO> lista) {
		String nomeArquivo = "C:/Users/fpach/git/hackatonFB/testData/testDataERROR.csv";
		try {
			Writer writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(nomeArquivo, true), "UTF-8"));

			for (ErroVO erroVO : lista) {
				writer.append(erroVO.getLinhaCorrente() + VIRGULA + erroVO.getTipoErro() + VIRGULA
						+ String.join(VIRGULA, erroVO.getLista()) + PULA_LINHA);
			}
			writer.close();

		} catch (IOException e) {
			logger.log(Level.SEVERE, "Erro na gravação do arquivo: " + nomeArquivo, e);
			System.out.println("erro na gravação do arquivo " + e);
		}
	}

}