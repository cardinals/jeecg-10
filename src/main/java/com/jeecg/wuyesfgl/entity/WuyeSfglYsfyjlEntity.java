package com.jeecg.wuyesfgl.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 应收费用记录
 * @author onlineGenerator
 * @date 2018-03-28 17:34:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_sfgl_ysfyjl", schema = "")
@SuppressWarnings("serial")
public class WuyeSfglYsfyjlEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**管区ID*/
	@Excel(name="管区ID",width=15)
	private java.lang.String glqid;
	/**小区ID*/
	@Excel(name="小区ID",width=15)
	private java.lang.String xqid;
	/**楼宇ID*/
	@Excel(name="楼宇ID",width=15)
	private java.lang.String lyid;
	/**房屋主键*/
	@Excel(name="房屋主键",width=15)
	private java.lang.String fwxxid;
	/**房间ID*/
	@Excel(name="房间ID",width=15)
	private java.lang.Long fjid;
	/**业主主键*/
	@Excel(name="业主主键",width=15)
	private java.lang.String fwyzxxid;
	/**业主姓名*/
	@Excel(name="业主姓名",width=15)
	private java.lang.String yzmc;
	/**收费状态*/
	@Excel(name="收费状态",width=15)
	private java.lang.String sfzt;
	/**收费项目代码*/
	@Excel(name="收费项目代码",width=15)
	private java.lang.String sfxmdm;
	/**收费项目名称*/
	@Excel(name="收费项目名称",width=15)
	private java.lang.String sfxmmc;
	/**计费起始时间*/
	@Excel(name="计费起始时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date jfqssj;
	/**计费终止时间*/
	@Excel(name="计费终止时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date jfjzsj;
	/**数量*/
	@Excel(name="数量",width=15)
	private java.lang.Double sl;
	/**价格*/
	@Excel(name="价格",width=15)
	private java.lang.Double jg;
	/**应收金额*/
	@Excel(name="应收金额",width=15)
	private java.lang.Double ysje;
	/**起数*/
	@Excel(name="起数",width=15)
	private java.lang.Double qss;
	/**止数*/
	@Excel(name="止数",width=15)
	private java.lang.Double jzs;
	/**倍率*/
	@Excel(name="倍率",width=15)
	private java.lang.Double bl;
	/**公摊*/
	@Excel(name="公摊",width=15)
	private java.lang.Double gts;
	/**计费年度*/
	@Excel(name="计费年度",width=15)
	private java.lang.String jfnd;
	/**计费月份*/
	@Excel(name="计费月份",width=15)
	private java.lang.String jfyf;
	/**收费起始日期*/
	@Excel(name="收费起始日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date sfqsrq;
	/**收费截止日期*/
	@Excel(name="收费截止日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date sfjzrq;
	/**滞纳金起始日期*/
	@Excel(name="滞纳金起始日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date znjqsrq;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String bz;
	/**审核状态*/
	@Excel(name="审核状态",width=15)
	private java.lang.String shzt;
	/**审核时间*/
	@Excel(name="审核时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date shsj;
	/**审核人员*/
	@Excel(name="审核人员",width=15)
	private java.lang.String shry;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */

	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管区ID
	 */

	@Column(name ="GLQID",nullable=true,length=32)
	public java.lang.String getGlqid(){
		return this.glqid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管区ID
	 */
	public void setGlqid(java.lang.String glqid){
		this.glqid = glqid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  小区ID
	 */

	@Column(name ="XQID",nullable=true,length=32)
	public java.lang.String getXqid(){
		return this.xqid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  小区ID
	 */
	public void setXqid(java.lang.String xqid){
		this.xqid = xqid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇ID
	 */

	@Column(name ="LYID",nullable=true,length=32)
	public java.lang.String getLyid(){
		return this.lyid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇ID
	 */
	public void setLyid(java.lang.String lyid){
		this.lyid = lyid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋主键
	 */

	@Column(name ="FWXXID",nullable=true,length=32)
	public java.lang.String getFwxxid(){
		return this.fwxxid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋主键
	 */
	public void setFwxxid(java.lang.String fwxxid){
		this.fwxxid = fwxxid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  房间ID
	 */

	@Column(name ="FJID",nullable=true)
	public java.lang.Long getFjid(){
		return this.fjid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  房间ID
	 */
	public void setFjid(java.lang.Long fjid){
		this.fjid = fjid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业主主键
	 */

	@Column(name ="FWYZXXID",nullable=true,length=32)
	public java.lang.String getFwyzxxid(){
		return this.fwyzxxid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业主主键
	 */
	public void setFwyzxxid(java.lang.String fwyzxxid){
		this.fwyzxxid = fwyzxxid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业主姓名
	 */

	@Column(name ="YZMC",nullable=true,length=100)
	public java.lang.String getYzmc(){
		return this.yzmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业主姓名
	 */
	public void setYzmc(java.lang.String yzmc){
		this.yzmc = yzmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费状态
	 */

	@Column(name ="SFZT",nullable=true,length=10)
	public java.lang.String getSfzt(){
		return this.sfzt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费状态
	 */
	public void setSfzt(java.lang.String sfzt){
		this.sfzt = sfzt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费项目代码
	 */

	@Column(name ="SFXMDM",nullable=true,length=10)
	public java.lang.String getSfxmdm(){
		return this.sfxmdm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费项目代码
	 */
	public void setSfxmdm(java.lang.String sfxmdm){
		this.sfxmdm = sfxmdm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费项目名称
	 */

	@Column(name ="SFXMMC",nullable=true,length=32)
	public java.lang.String getSfxmmc(){
		return this.sfxmmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费项目名称
	 */
	public void setSfxmmc(java.lang.String sfxmmc){
		this.sfxmmc = sfxmmc;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计费起始时间
	 */

	@Column(name ="JFQSSJ",nullable=true)
	public java.util.Date getJfqssj(){
		return this.jfqssj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计费起始时间
	 */
	public void setJfqssj(java.util.Date jfqssj){
		this.jfqssj = jfqssj;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计费终止时间
	 */

	@Column(name ="JFJZSJ",nullable=true)
	public java.util.Date getJfjzsj(){
		return this.jfjzsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计费终止时间
	 */
	public void setJfjzsj(java.util.Date jfjzsj){
		this.jfjzsj = jfjzsj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  数量
	 */

	@Column(name ="SL",nullable=true)
	public java.lang.Double getSl(){
		return this.sl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  数量
	 */
	public void setSl(java.lang.Double sl){
		this.sl = sl;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  价格
	 */

	@Column(name ="JG",nullable=true)
	public java.lang.Double getJg(){
		return this.jg;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  价格
	 */
	public void setJg(java.lang.Double jg){
		this.jg = jg;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  应收金额
	 */

	@Column(name ="YSJE",nullable=true)
	public java.lang.Double getYsje(){
		return this.ysje;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  应收金额
	 */
	public void setYsje(java.lang.Double ysje){
		this.ysje = ysje;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  起数
	 */

	@Column(name ="QSS",nullable=true)
	public java.lang.Double getQss(){
		return this.qss;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  起数
	 */
	public void setQss(java.lang.Double qss){
		this.qss = qss;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  止数
	 */

	@Column(name ="JZS",nullable=true)
	public java.lang.Double getJzs(){
		return this.jzs;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  止数
	 */
	public void setJzs(java.lang.Double jzs){
		this.jzs = jzs;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  倍率
	 */

	@Column(name ="BL",nullable=true)
	public java.lang.Double getBl(){
		return this.bl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  倍率
	 */
	public void setBl(java.lang.Double bl){
		this.bl = bl;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公摊
	 */

	@Column(name ="GTS",nullable=true)
	public java.lang.Double getGts(){
		return this.gts;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公摊
	 */
	public void setGts(java.lang.Double gts){
		this.gts = gts;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费年度
	 */

	@Column(name ="JFND",nullable=true,length=10)
	public java.lang.String getJfnd(){
		return this.jfnd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费年度
	 */
	public void setJfnd(java.lang.String jfnd){
		this.jfnd = jfnd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费月份
	 */

	@Column(name ="JFYF",nullable=true,length=10)
	public java.lang.String getJfyf(){
		return this.jfyf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费月份
	 */
	public void setJfyf(java.lang.String jfyf){
		this.jfyf = jfyf;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收费起始日期
	 */

	@Column(name ="SFQSRQ",nullable=true)
	public java.util.Date getSfqsrq(){
		return this.sfqsrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收费起始日期
	 */
	public void setSfqsrq(java.util.Date sfqsrq){
		this.sfqsrq = sfqsrq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收费截止日期
	 */

	@Column(name ="SFJZRQ",nullable=true)
	public java.util.Date getSfjzrq(){
		return this.sfjzrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收费截止日期
	 */
	public void setSfjzrq(java.util.Date sfjzrq){
		this.sfjzrq = sfjzrq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  滞纳金起始日期
	 */

	@Column(name ="ZNJQSRQ",nullable=true)
	public java.util.Date getZnjqsrq(){
		return this.znjqsrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  滞纳金起始日期
	 */
	public void setZnjqsrq(java.util.Date znjqsrq){
		this.znjqsrq = znjqsrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="BZ",nullable=true,length=320)
	public java.lang.String getBz(){
		return this.bz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBz(java.lang.String bz){
		this.bz = bz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核状态
	 */

	@Column(name ="SHZT",nullable=true,length=10)
	public java.lang.String getShzt(){
		return this.shzt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核状态
	 */
	public void setShzt(java.lang.String shzt){
		this.shzt = shzt;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核时间
	 */

	@Column(name ="SHSJ",nullable=true)
	public java.util.Date getShsj(){
		return this.shsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核时间
	 */
	public void setShsj(java.util.Date shsj){
		this.shsj = shsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人员
	 */

	@Column(name ="SHRY",nullable=true,length=32)
	public java.lang.String getShry(){
		return this.shry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人员
	 */
	public void setShry(java.lang.String shry){
		this.shry = shry;
	}

	@Override
	public String toString() {
		return "WuyeSfglYsfyjlEntity [id=" + id + ", createName=" + createName + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", updateName=" + updateName + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + ", sysOrgCode=" + sysOrgCode + ", sysCompanyCode=" + sysCompanyCode
				+ ", bpmStatus=" + bpmStatus + ", glqid=" + glqid + ", xqid=" + xqid + ", lyid=" + lyid + ", fwxxid="
				+ fwxxid + ", fjid=" + fjid + ", fwyzxxid=" + fwyzxxid + ", yzmc=" + yzmc + ", sfzt=" + sfzt
				+ ", sfxmdm=" + sfxmdm + ", sfxmmc=" + sfxmmc + ", jfqssj=" + jfqssj + ", jfjzsj=" + jfjzsj + ", sl="
				+ sl + ", jg=" + jg + ", ysje=" + ysje + ", qss=" + qss + ", jzs=" + jzs + ", bl=" + bl + ", gts=" + gts
				+ ", jfnd=" + jfnd + ", jfyf=" + jfyf + ", sfqsrq=" + sfqsrq + ", sfjzrq=" + sfjzrq + ", znjqsrq="
				+ znjqsrq + ", bz=" + bz + ", shzt=" + shzt + ", shsj=" + shsj + ", shry=" + shry + "]";
	}
	
}
