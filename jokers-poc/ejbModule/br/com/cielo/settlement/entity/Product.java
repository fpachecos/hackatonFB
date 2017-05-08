package br.com.cielo.settlement.entity;

public class Product {

  private Integer code;
  private SettlementTypeEnum settlementType;

  public Product(Integer productCode) {
    this.code = productCode;
  }

  public Integer getCode() {
    return code;
  }

  public SettlementTypeEnum getSettlementType() {
    return settlementType;
  }

  public void setSettlementType(SettlementTypeEnum settlementTypeEnum) {
    this.settlementType = settlementTypeEnum;
  }

}
