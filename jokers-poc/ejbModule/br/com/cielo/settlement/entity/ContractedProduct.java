package br.com.cielo.settlement.entity;

public class ContractedProduct {
  public SettlementTypeEnum getSettlementTypeIndicator() {
    return SettlementTypeEnum.CREDIT;
  }

  public Integer getCodeProduct() {
    return 40;
  }

  public boolean isActive() {
    return true;
  }

  public PaymentCategoryEnum getPaymentCategory() {
    return PaymentCategoryEnum.CREDIT;
  }


}
