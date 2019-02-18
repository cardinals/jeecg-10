package com.jeecg.wuyesfgl.entity;


public class WuyeSfglDwdkxxPageEntity  {
	/**业主姓名*/
	private String yzmc;
	/**实收金额*/
	private Double ssje;
	/**代扣单位工号*/
	private String dkdwgh;
	public WuyeSfglDwdkxxPageEntity() {
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


	public String getDkdwgh() {
		return dkdwgh;
	}


	public void setDkdwgh(String dkdwgh) {
		this.dkdwgh = dkdwgh;
	}


	@Override
	public String toString() {
		return "WuyeSfglDwdkxxPageEntity [yzmc=" + yzmc + ", ssje=" + ssje + ", dkdwgh=" + dkdwgh + "]";
	}
	
	
	
}
