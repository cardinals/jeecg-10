package com.jeecg.wuyesfgl.entity;

public class WuyeSfFjsfxmszPageEntity {
	/**主键*/
	private String id;
	/**管理处*/
	private String glqmc;
	/**管理区id*/
	private String glqid;
	/**楼宇id*/
	private String lyid;
	/**房间主键*/
	private String fwxxid;
	/**房间id*/
	private Integer fjid;
	/**收费项目id*/
	private String sfxmid;
	/**优惠类型*/
	private String yhlx;
	/**折扣系数/金额*/
	private Double yhbl;
	/**备注*/
	private String bz;
	
	/**收费项目代码*/
	private String xmdm;
	/**收费项目名称*/
	private String xmmc;
	/**收费方式*/
	private String sffs;
	/**计费单价*/
	private Double jfdj;
	/**是否收费*/
	private String sfbz;
	/**计费周期*/
	private String jfzq;
	/**计费周期单位*/
	private String jfzqdw;
	
	
	public WuyeSfFjsfxmszPageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFjid() {
		return fjid;
	}

	public void setFjid(int fjid) {
		this.fjid = fjid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGlqmc() {
		return glqmc;
	}

	public void setGlqmc(String glqmc) {
		this.glqmc = glqmc;
	}

	public String getSffs() {
		return sffs;
	}

	public void setSffs(String sffs) {
		this.sffs = sffs;
	}

	public String getXmdm() {
		return xmdm;
	}

	public void setXmdm(String xmdm) {
		this.xmdm = xmdm;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public Double getJfdj() {
		return jfdj;
	}

	public void setJfdj(Double jfdj) {
		this.jfdj = jfdj;
	}

	public String getSfbz() {
		return sfbz;
	}

	public void setSfbz(String sfbz) {
		this.sfbz = sfbz;
	}

	public String getJfzq() {
		return jfzq;
	}

	public void setJfzq(String jfzq) {
		this.jfzq = jfzq;
	}

	public String getJfzqdw() {
		return jfzqdw;
	}

	public void setJfzqdw(String jfzqdw) {
		this.jfzqdw = jfzqdw;
	}

	public String getGlqid() {
		return glqid;
	}

	public void setGlqid(String glqid) {
		this.glqid = glqid;
	}

	public String getLyid() {
		return lyid;
	}

	public void setLyid(String lyid) {
		this.lyid = lyid;
	}

	public String getFwxxid() {
		return fwxxid;
	}

	public void setFwxxid(String fwxxid) {
		this.fwxxid = fwxxid;
	}

	public String getSfxmid() {
		return sfxmid;
	}

	public void setSfxmid(String sfxmid) {
		this.sfxmid = sfxmid;
	}

	public String getYhlx() {
		return yhlx;
	}

	public void setYhlx(String yhlx) {
		this.yhlx = yhlx;
	}

	public Double getYhbl() {
		return yhbl;
	}

	public void setYhbl(Double yhbl) {
		this.yhbl = yhbl;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Override
	public String toString() {
		return "WuyeSfFjsfxmszPageEntity [id=" + id + ", glqmc=" + glqmc + ", glqid=" + glqid + ", lyid=" + lyid
				+ ", fwxxid=" + fwxxid + ", fjid=" + fjid + ", sfxmid=" + sfxmid + ", yhlx=" + yhlx + ", yhbl=" + yhbl
				+ ", bz=" + bz + ", xmdm=" + xmdm + ", xmmc=" + xmmc + ", sffs=" + sffs + ", jfdj=" + jfdj + ", sfbz="
				+ sfbz + ", jfzq=" + jfzq + ", jfzqdw=" + jfzqdw + "]";
	}

	
}
