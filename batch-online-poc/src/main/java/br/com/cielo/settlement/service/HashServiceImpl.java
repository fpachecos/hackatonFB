/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cielo.settlement.service;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;

import br.com.cielo.common.exception.BusinessException;
import br.com.cielo.common.util.HashGenerator;
import br.com.cielo.settlement.batch.entity.HashFields;
import br.com.cielo.settlement.entity.HashFieldsCompany;

/**
 * Serviço para geração de hash destinado ao número do lançamento financeiro. <br/>
 * Provê método para criação da chave de agrupamento e geração do hash em si.
 * Serviço para geração de hash destinado ao número do lançamento financeiro. <br/>
 * Provê método para criação da chave de agrupamento e geração do hash em si.
 *
 * @author <a href="mailto:salvador@cielo.com.br>Marcos Paulo Salvador de
 *         Oliveira</a>
 * @version $Id: HashServiceImpl.java 78996 2016-11-09 20:32:57Z eyve4g $
 */
@Stateless
public class HashServiceImpl implements HashService {

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.cielo.settlement.batch.service.HashService#generateGroupingKey
     * (br.com.cielo.settlement.batch.entity.HashFields )
     */
    @Override
    public String generateGroupingKey(final HashFields hashFieldsKey) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());

        return sdf.format(hashFieldsKey.getSettlementDate())
                        + sdf.format(hashFieldsKey.getBatchDate())
                        + StringUtils.leftPad(hashFieldsKey.getLoadFileId(), Integer.valueOf("30"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getCustomerNumber().toString(), Integer.valueOf("22"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getProductCode().toString(), Integer.valueOf("4"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getCustomerModNumber().toString(), Integer.valueOf("3"),
                                        "0")
                        + StringUtils.leftPad(hashFieldsKey.getInstallmentSegment().toString(), Integer.valueOf("2"),
                                        "0")
                        + StringUtils.leftPad(hashFieldsKey.getMovementType().toString(), Integer.valueOf("10"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getFundingCurrency().toString(), Integer.valueOf("6"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getInstallmentSequenceNumber().toString(),
                                        Integer.valueOf("2"), "0");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.cielo.settlement.batch.service.HashService#generateGroupingKey
     * (br.com.cielo.settlement.batch.entity.HashFields )
     */
    @Override
    public String generateGroupingKeyMovementCompany(final HashFieldsCompany hashFieldsKey) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());

        return sdf.format(hashFieldsKey.getSettlementDate())
                        + sdf.format(hashFieldsKey.getBatchDate())
                        + StringUtils.leftPad(hashFieldsKey.getLoadFileId(), Integer.valueOf("30"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getCompanyNumber().toString(), Integer.valueOf("22"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getProductCode().toString(), Integer.valueOf("4"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getCompanyModNumber().toString(), Integer.valueOf("3"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getInstallmentSegment().toString(), Integer.valueOf("2"),
                                        "0")
                        + StringUtils.leftPad(hashFieldsKey.getMovementType().toString(), Integer.valueOf("10"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getFundingCurrency().toString(), Integer.valueOf("6"), "0")
                        + StringUtils.leftPad(hashFieldsKey.getInstallmentSequenceNumber().toString(),
                                        Integer.valueOf("2"), "0");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.com.cielo.settlement.batch.service.HashService#generateHashSHA1(java
     * .lang.String)
     */
    @Override
    public String generateHashSHA1(final String characters) throws BusinessException {
        try {
            return HashGenerator.generateHashSHA1(characters);
        } catch (final NoSuchAlgorithmException nsae) {
            throw new BusinessException("Erro na geração do hash de agrupamento das transações", nsae);
        }
    }
}
