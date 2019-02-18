package com.jeecg.wuyesfgl.entity;


public class WuyeSfglYhdkxxPageEntity  {
	/**业主姓名*/
	private String yzmc;
	/**实收金额*/
	private Double ssje;
	/**账户*/
	private String zh;
	public WuyeSfglYhdkxxPageEntity() {
		super();
	}
	

	public String getYzmc() {
		return yzmc;
	}
	public void setYzmc(String yzmc) {
		this.yzmc = yzmc;
	}
	public Double getSsje() {
		return ssje;
	}
	public void setSsje(Double ssje) {
		this.ssje = ssje;
	}
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	@Override
	public String toString() {
		return "WuyeSfglYhdkxxPageEntity [yzmc=" + yzmc + ", ssje=" + ssje + ", zh=" + zh + "]";
	}
	
	
}
