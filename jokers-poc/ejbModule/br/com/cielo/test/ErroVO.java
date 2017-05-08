package br.com.cielo.test;

import java.util.List;

public class ErroVO {
  private List<String> lista;
  private String tipoErro;
  private Integer linhaCorrente;

  public ErroVO(int linhaCorrente, List<String> list, String error) {
    this.setLinhaCorrente(linhaCorrente);
    this.setLista(list);
    this.setTipoErro(error);
  }

  public List<String> getLista() {
    return lista;
  }

  public void setLista(List<String> lista) {
    this.lista = lista;
  }

  public String getTipoErro() {
    return tipoErro;
  }

  public void setTipoErro(String tipoErro) {
    this.tipoErro = tipoErro;
  }

  public Integer getLinhaCorrente() {
    return linhaCorrente;
  }

  public void setLinhaCorrente(Integer linhaCorrente) {
    this.linhaCorrente = linhaCorrente;
  }

}
