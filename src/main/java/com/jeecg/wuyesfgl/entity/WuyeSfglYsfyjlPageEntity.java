package com.jeecg.wuyesfgl.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

public class WuyeSfglYsfyjlPageEntity extends Object{
	/**主键*/

	private java.lang.String id;
	/**管区ID*/
	private java.lang.String glqid;
	/**管理区名称*/
	private String glqmc;
	/**小区ID*/
	private java.lang.String xqid;
	/**楼宇ID*/
	private java.lang.String lyid;
	/**房屋主键*/
	private java.lang.String fwxxid;
	/**房间ID*/
	private java.lang.Integer fjid;
	/**房间编号*/
	private String fjbh;
	/**业主主键*/
	private java.lang.String fwyzxxid;
	/**业主姓名*/
	private java.lang.String yzmc;
	/**收费状态*/
	private java.lang.String sfzt;
	/**收费项目代码*/
	private java.lang.String sfxmdm;
	/**收费项目名称*/
	private java.lang.String sfxmmc;
	/**计费起始时间*/
	private java.util.Date jfqssj;
	/**计费终止时间*/
	private java.util.Date jfjzsj;
	/**数量*/
	private java.lang.Double sl;
	/**价格*/
	private java.lang.Double jg;
	/**应收金额*/
	private java.lang.Double ysje;
	/**起数*/
	private java.lang.Double qss;
	/**止数*/
	private java.lang.Double jzs;
	/**倍率*/
	private java.lang.Double bl;
	/**公摊*/
	private java.lang.Double gts;
	/**计费年度*/
	private java.lang.String jfnd;
	/**计费月份*/
	private java.lang.String jfyf;
	/**收费起始日期*/
	private java.util.Date sfqsrq;
	/**收费截止日期*/
	private java.util.Date sfjzrq;
	/**滞纳金起始日期*/
	private java.util.Date znjqsrq;
	/**备注*/
	private java.lang.String bz;
	/**审核状态*/
	private java.lang.String shzt;
	/**审核时间*/
	private java.util.Date shsj;
	/**审核人员*/
	private java.lang.String shry;
	/**代扣信息主键*/
	private java.lang.String dkxxzj;
	
	public WuyeSfglYsfyjlPageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getGlqid() {
		return glqid;
	}

	public void setGlqid(java.lang.String glqid) {
		this.glqid = glqid;
	}

	public String getGlqmc() {
		return glqmc;
	}

	public void setGlqmc(String glqmc) {
		this.glqmc = glqmc;
	}

	public java.lang.String getXqid() {
		return xqid;
	}

	public void setXqid(java.lang.String xqid) {
		this.xqid = xqid;
	}

	public java.lang.String getLyid() {
		return lyid;
	}

	public void setLyid(java.lang.String lyid) {
		this.lyid = lyid;
	}

	public java.lang.String getFwxxid() {
		return fwxxid;
	}

	public void setFwxxid(java.lang.String fwxxid) {
		this.fwxxid = fwxxid;
	}

	public java.lang.Integer getFjid() {
		return fjid;
	}

	public void setFjid(java.lang.Integer fjid) {
		this.fjid = fjid;
	}

	public String getFjbh() {
		return fjbh;
	}

	public void setFjbh(String fjbh) {
		this.fjbh = fjbh;
	}

	public java.lang.String getFwyzxxid() {
		return fwyzxxid;
	}

	public void setFwyzxxid(java.lang.String fwyzxxid) {
		this.fwyzxxid = fwyzxxid;
	}

	public java.lang.String getYzmc() {
		return yzmc;
	}

	public void setYzmc(java.lang.String yzmc) {
		this.yzmc = yzmc;
	}

	public java.lang.String getSfzt() {
		return sfzt;
	}

	public void setSfzt(java.lang.String sfzt) {
		this.sfzt = sfzt;
	}

	public java.lang.String getSfxmdm() {
		return sfxmdm;
	}

	public void setSfxmdm(java.lang.String sfxmdm) {
		this.sfxmdm = sfxmdm;
	}

	public java.lang.String getSfxmmc() {
		return sfxmmc;
	}

	public void setSfxmmc(java.lang.String sfxmmc) {
		this.sfxmmc = sfxmmc;
	}

	public java.util.Date getJfqssj() {
		return jfqssj;
	}

	public void setJfqssj(java.util.Date jfqssj) {
		this.jfqssj = jfqssj;
	}

	public java.util.Date getJfjzsj() {
		return jfjzsj;
	}

	public void setJfjzsj(java.util.Date jfjzsj) {
		this.jfjzsj = jfjzsj;
	}

	public java.lang.Double getSl() {
		return sl;
	}

	public void setSl(java.lang.Double sl) {
		this.sl = sl;
	}

	public java.lang.Double getJg() {
		return jg;
	}

	public void setJg(java.lang.Double jg) {
		this.jg = jg;
	}

	public java.lang.Double getYsje() {
		return ysje;
	}

	public void setYsje(java.lang.Double ysje) {
		this.ysje = ysje;
	}

	public java.lang.Double getQss() {
		return qss;
	}

	public void setQss(java.lang.Double qss) {
		this.qss = qss;
	}

	public java.lang.Double getJzs() {
		return jzs;
	}

	public void setJzs(java.lang.Double jzs) {
		this.jzs = jzs;
	}

	public java.lang.Double getBl() {
		return bl;
	}

	public void setBl(java.lang.Double bl) {
		this.bl = bl;
	}

	public java.lang.Double getGts() {
		return gts;
	}

	public void setGts(java.lang.Double gts) {
		this.gts = gts;
	}

	public java.lang.String getJfnd() {
		return jfnd;
	}

	public void setJfnd(java.lang.String jfnd) {
		this.jfnd = jfnd;
	}

	public java.lang.String getJfyf() {
		return jfyf;
	}

	public void setJfyf(java.lang.String jfyf) {
		this.jfyf = jfyf;
	}

	public java.util.Date getSfqsrq() {
		return sfqsrq;
	}

	public void setSfqsrq(java.util.Date sfqsrq) {
		this.sfqsrq = sfqsrq;
	}

	public java.util.Date getSfjzrq() {
		return sfjzrq;
	}

	public void setSfjzrq(java.util.Date sfjzrq) {
		this.sfjzrq = sfjzrq;
	}

	public java.util.Date getZnjqsrq() {
		return znjqsrq;
	}

	public void setZnjqsrq(java.util.Date znjqsrq) {
		this.znjqsrq = znjqsrq;
	}

	public java.lang.String getBz() {
		return bz;
	}

	public void setBz(java.lang.String bz) {
		this.bz = bz;
	}

	public java.lang.String getShzt() {
		return shzt;
	}

	public void setShzt(java.lang.String shzt) {
		this.shzt = shzt;
	}

	public java.util.Date getShsj() {
		return shsj;
	}

	public void setShsj(java.util.Date shsj) {
		this.shsj = shsj;
	}

	public java.lang.String getShry() {
		return shry;
	}

	public void setShry(java.lang.String shry) {
		this.shry = shry;
	}

	public java.lang.String getDkxxzj() {
		return dkxxzj;
	}

	public void setDkxxzj(java.lang.String dkxxzj) {
		this.dkxxzj = dkxxzj;
	}

	@Override
	public String toString() {
		return "WuyeSfglYsfyjlPageEntity [id=" + id + ", glqid=" + glqid + ", glqmc=" + glqmc + ", xqid=" + xqid
				+ ", lyid=" + lyid + ", fwxxid=" + fwxxid + ", fjid=" + fjid + ", fjbh=" + fjbh + ", fwyzxxid="
				+ fwyzxxid + ", yzmc=" + yzmc + ", sfzt=" + sfzt + ", sfxmdm=" + sfxmdm + ", sfxmmc=" + sfxmmc
				+ ", jfqssj=" + jfqssj + ", jfjzsj=" + jfjzsj + ", sl=" + sl + ", jg=" + jg + ", ysje=" + ysje
				+ ", qss=" + qss + ", jzs=" + jzs + ", bl=" + bl + ", gts=" + gts + ", jfnd=" + jfnd + ", jfyf=" + jfyf
				+ ", sfqsrq=" + sfqsrq + ", sfjzrq=" + sfjzrq + ", znjqsrq=" + znjqsrq + ", bz=" + bz + ", shzt=" + shzt
				+ ", shsj=" + shsj + ", shry=" + shry + ", dkxxzj=" + dkxxzj + "]";
	}


	
}
