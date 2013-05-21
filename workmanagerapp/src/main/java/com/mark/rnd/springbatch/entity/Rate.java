package com.mark.rnd.springbatch.entity;

public class Rate {

	private String branch;
	private String xrateType;

	private String currency;
	private String qouteType;
	private String midRate;
	private String centralBankRate;
	private String buySpread;
	private String sellSpread;
	private String buyRate;
	private String sellRate;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getXrateType() {
		return xrateType;
	}

	public void setXrateType(String xrateType) {
		this.xrateType = xrateType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getQouteType() {
		return qouteType;
	}

	public void setQouteType(String qouteType) {
		this.qouteType = qouteType;
	}

	public String getMidRate() {
		return midRate;
	}

	public void setMidRate(String midrate) {
		this.midRate = midrate;
	}

	public String getCentralBankRate() {
		return centralBankRate;
	}

	public void setCentralBankRate(String centralBankRate) {
		this.centralBankRate = centralBankRate;
	}

	public String getBuySpread() {
		return buySpread;
	}

	public void setBuySpread(String buySpread) {
		this.buySpread = buySpread;
	}

	public String getSellSpread() {
		return sellSpread;
	}

	public void setSellSpread(String sellSpread) {
		this.sellSpread = sellSpread;
	}

	public String getBuyRate() {
		return buyRate;
	}

	public void setBuyRate(String buyRate) {
		this.buyRate = buyRate;
	}

	public String getSellRate() {
		return sellRate;
	}

	public void setSellRate(String sellRate) {
		this.sellRate = sellRate;
	}

	@Override
	public String toString() {
		return "Rate [branch=" + branch + ", xrateType=" + xrateType
				+ ", currency=" + currency + ", qouteType=" + qouteType
				+ ", midRate=" + midRate + ", centralBankRate="
				+ centralBankRate + ", buySpread=" + buySpread
				+ ", sellSpread=" + sellSpread + ", buyRate=" + buyRate
				+ ", sellRate=" + sellRate + "]";
	}
	
	
}
