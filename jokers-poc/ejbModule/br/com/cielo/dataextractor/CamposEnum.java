package br.com.cielo.dataextractor;


public enum CamposEnum {
  NU_REQUEST(0), CD_REQUEST_TYPE(1), DH_REQUEST(2), CD_REJECT_REASON(3), DT_SETTLEMENT_ADJUSTMENT(
      4), VL_GROSS(5), CD_USER_ID(6), CD_TECHNOLOGY_TYPE(7), CD_STATUS_REQUEST(8), NU_CUSTOMER(
          9), NU_MOD_CUSTOMER(10), NU_BATCH(11), CD_MOVEMENT_TYPE(12), CD_REFUND_STATUS_REQUEST(
              13), CD_ADJUSTMENT_REASON(14), DC_ADJUSTMENT_COMMENTS(
                  15), NU_LOAD_FILE_ID(16), CD_PRODUCT(17), CD_ENTRY_TYPE(18);


  public final Integer valor;

  CamposEnum(Integer valorOpcao) {
    valor = valorOpcao;
  }

  public Integer getValor() {
    return valor;
  }

}
