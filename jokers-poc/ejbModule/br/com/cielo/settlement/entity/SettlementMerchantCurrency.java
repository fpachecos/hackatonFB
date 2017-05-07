package br.com.cielo.settlement.entity;


public class SettlementMerchantCurrency{

	private String codeCurrency;

	private String codeContry;

	private String currencyAlpha;

	private int decimalPlaces;

	public String getCodeCurrency() {
		return codeCurrency;
	}

	public void setCodeCurrency(String codeCurrency) {
		this.codeCurrency = codeCurrency;
	}

	public String getCodeContry() {
		return codeContry;
	}

	public void setCodeContry(String codeContry) {
		this.codeContry = codeContry;
	}

	public String getCurrencyAlpha() {
		return currencyAlpha;
	}

	public void setCurrencyAlpha(String currencyAlpha) {
		this.currencyAlpha = currencyAlpha;
	}

	public int getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}


}
