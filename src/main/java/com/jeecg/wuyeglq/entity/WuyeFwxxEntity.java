package com.jeecg.wuyeglq.entity;

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
 * @Description: 房屋基本信息
 * @author onlineGenerator
 * @date 2018-03-12 13:33:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_fwxx", schema = "")
@SuppressWarnings("serial")
public class WuyeFwxxEntity implements java.io.Serializable {
	/**id*/

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
	/**房间ID*/
   @Excel(name="房间序号",width=15)
		
	private java.lang.Long fjid;
	/**管理区id*/
  /*  @Excel(name="管理区id",width=15)*/
		
	private java.lang.String glqid;
	/**楼宇id*/
  /*  @Excel(name="楼宇id",width=15)*/
		
	private java.lang.String lyid;
	/**楼型*/
    @Excel(name="楼型",width=15,dicCode="lx")
		
	private java.lang.String loux;
	/**总楼层数*/
    @Excel(name="总楼层数",width=15)
		
	private java.lang.Integer zlcs;
	/**单元号*/
    @Excel(name="单元号",width=15)
		
	private java.lang.String dyh;
	/**所在楼层*/
    @Excel(name="所在楼层",width=15)
		
	private java.lang.Integer lch;
	/**房间编号*/
    @Excel(name="房间编号",width=15)
		
	private java.lang.String fjbh;
	/**建筑面积*/
    @Excel(name="建筑面积",width=15)
		
	private java.lang.Double jzmj;
	/**套内面积*/
    @Excel(name="套内面积",width=15)
		
	private java.lang.Double tnmj;
	/**公摊面积*/
    @Excel(name="公摊面积",width=15)
		
	private java.lang.Double gtmj;
	/**阳台面积*/
    @Excel(name="阳台面积",width=15)
		
	private java.lang.Double ytmj;
	/**房屋户型*/
    @Excel(name="房屋户型",width=15,dicCode="fwhx")
		
	private java.lang.String fwhx;
	/**房屋类型*/
    @Excel(name="房屋类型",width=15,dicCode="fwlx")
		
	private java.lang.String fwlx;
	/**住房类别*/
    @Excel(name="住房类别",width=15,dicCode="zflb")
		
	private java.lang.String zflb;
	/**房屋用途*/
    @Excel(name="房屋用途",width=15)
		
	private java.lang.String fwyt;
	/**房屋朝向*/
    @Excel(name="房屋朝向",width=15)
		
	private java.lang.String fwcx;
	/**房屋状态*/
    @Excel(name="房屋状态",width=15,dicCode="fwzt")
		
	private java.lang.String fwzt;
	/**竣工日期*/
    @Excel(name="竣工日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date jgrq;
	/**交房日期*/
    @Excel(name="交房日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date jfrq;
	/**装修日期*/
    @Excel(name="装修日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date zxrq;
	/**入住日期*/
    @Excel(name="入住日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date rzrq;
	/**产权人*/
    @Excel(name="产权人",width=15)
		
	private java.lang.String fwcqr;
	/**产权人类型*/
    @Excel(name="产权人类型",width=15)
		
	private java.lang.String cqrzjlx;
	/**产权人号码*/
    @Excel(name="产权人号码",width=15)
		
	private java.lang.String cqrzjhm;
	/**是否拆分出租*/
    @Excel(name="是否拆分出租",width=15,dicCode="cfcz")
		
	private java.lang.String cfczbz;
	/**收费服务对象*/
    @Excel(name="收费服务对象",width=15,dicCode="sfdx")
		
	private java.lang.String sffwdx;
	/**排序号*/
    /*@Excel(name="排序号",width=15)*/
		
	private java.lang.Integer pxh;
	/**有效标志*/
    /*@Excel(name="有效标志",width=15)*/
		
	private java.lang.String yxbz;
	/**证件类型*/
    @Excel(name="证件类型",width=15,dicCode="zjlx")
		
	private java.lang.String zjmc;
	/**证件号码*/
    @Excel(name="证件号码",width=15)
		
	private java.lang.String zjhm;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
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
	@Column(name ="CREATE_DATE",nullable=true)
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
	@Column(name ="UPDATE_DATE",nullable=true)
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  房间ID
	 */
	@Column(name ="FJID",nullable=true,length=10)
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
	 *@return: java.lang.String  管理区id
	 */
	@Column(name ="GLQID",nullable=true,length=32)
	public java.lang.String getGlqid(){
		return this.glqid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理区id
	 */
	public void setGlqid(java.lang.String glqid){
		this.glqid = glqid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇id
	 */
	@Column(name ="LYID",nullable=true,length=32)
	public java.lang.String getLyid(){
		return this.lyid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇id
	 */
	public void setLyid(java.lang.String lyid){
		this.lyid = lyid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼型
	 */
	@Column(name ="LOUX",nullable=true,length=10)
	public java.lang.String getLoux(){
		return this.loux;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼型
	 */
	public void setLoux(java.lang.String loux){
		this.loux = loux;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总楼层数
	 */
	@Column(name ="ZLCS",nullable=true,length=10)
	public java.lang.Integer getZlcs(){
		return this.zlcs;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总楼层数
	 */
	public void setZlcs(java.lang.Integer zlcs){
		this.zlcs = zlcs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单元号
	 */
	@Column(name ="DYH",nullable=true,length=32)
	public java.lang.String getDyh(){
		return this.dyh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单元号
	 */
	public void setDyh(java.lang.String dyh){
		this.dyh = dyh;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  所在楼层
	 */
	@Column(name ="LCH",nullable=true,length=10)
	public java.lang.Integer getLch(){
		return this.lch;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  所在楼层
	 */
	public void setLch(java.lang.Integer lch){
		this.lch = lch;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间编号
	 */
	@Column(name ="FJBH",nullable=true,length=30)
	public java.lang.String getFjbh(){
		return this.fjbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间编号
	 */
	public void setFjbh(java.lang.String fjbh){
		this.fjbh = fjbh;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  建筑面积
	 */
	@Column(name ="JZMJ",nullable=true,length=22)
	public java.lang.Double getJzmj(){
		return this.jzmj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  建筑面积
	 */
	public void setJzmj(java.lang.Double jzmj){
		this.jzmj = jzmj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  套内面积
	 */
	@Column(name ="TNMJ",nullable=true,length=22)
	public java.lang.Double getTnmj(){
		return this.tnmj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  套内面积
	 */
	public void setTnmj(java.lang.Double tnmj){
		this.tnmj = tnmj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公摊面积
	 */
	@Column(name ="GTMJ",nullable=true,length=22)
	public java.lang.Double getGtmj(){
		return this.gtmj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公摊面积
	 */
	public void setGtmj(java.lang.Double gtmj){
		this.gtmj = gtmj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  阳台面积
	 */
	@Column(name ="YTMJ",nullable=true,length=22)
	public java.lang.Double getYtmj(){
		return this.ytmj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  阳台面积
	 */
	public void setYtmj(java.lang.Double ytmj){
		this.ytmj = ytmj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋户型
	 */
	@Column(name ="FWHX",nullable=true,length=10)
	public java.lang.String getFwhx(){
		return this.fwhx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋户型
	 */
	public void setFwhx(java.lang.String fwhx){
		this.fwhx = fwhx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋类型
	 */
	@Column(name ="FWLX",nullable=true,length=10)
	public java.lang.String getFwlx(){
		return this.fwlx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋类型
	 */
	public void setFwlx(java.lang.String fwlx){
		this.fwlx = fwlx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住房类别
	 */
	@Column(name ="ZFLB",nullable=true,length=10)
	public java.lang.String getZflb(){
		return this.zflb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住房类别
	 */
	public void setZflb(java.lang.String zflb){
		this.zflb = zflb;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋用途
	 */
	@Column(name ="FWYT",nullable=true,length=10)
	public java.lang.String getFwyt(){
		return this.fwyt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋用途
	 */
	public void setFwyt(java.lang.String fwyt){
		this.fwyt = fwyt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋朝向
	 */
	@Column(name ="FWCX",nullable=true,length=10)
	public java.lang.String getFwcx(){
		return this.fwcx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋朝向
	 */
	public void setFwcx(java.lang.String fwcx){
		this.fwcx = fwcx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋状态
	 */
	@Column(name ="FWZT",nullable=true,length=10)
	public java.lang.String getFwzt(){
		return this.fwzt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋状态
	 */
	public void setFwzt(java.lang.String fwzt){
		this.fwzt = fwzt;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  竣工日期
	 */
	@Column(name ="JGRQ",nullable=true)
	public java.util.Date getJgrq(){
		return this.jgrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  竣工日期
	 */
	public void setJgrq(java.util.Date jgrq){
		this.jgrq = jgrq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  交房日期
	 */
	@Column(name ="JFRQ",nullable=true)
	public java.util.Date getJfrq(){
		return this.jfrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  交房日期
	 */
	public void setJfrq(java.util.Date jfrq){
		this.jfrq = jfrq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  装修日期
	 */
	@Column(name ="ZXRQ",nullable=true)
	public java.util.Date getZxrq(){
		return this.zxrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  装修日期
	 */
	public void setZxrq(java.util.Date zxrq){
		this.zxrq = zxrq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入住日期
	 */
	@Column(name ="RZRQ",nullable=true)
	public java.util.Date getRzrq(){
		return this.rzrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入住日期
	 */
	public void setRzrq(java.util.Date rzrq){
		this.rzrq = rzrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产权人
	 */
	@Column(name ="FWCQR",nullable=true,length=100)
	public java.lang.String getFwcqr(){
		return this.fwcqr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产权人
	 */
	public void setFwcqr(java.lang.String fwcqr){
		this.fwcqr = fwcqr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产权人类型
	 */
	@Column(name ="CQRZJLX",nullable=true,length=10)
	public java.lang.String getCqrzjlx(){
		return this.cqrzjlx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产权人类型
	 */
	public void setCqrzjlx(java.lang.String cqrzjlx){
		this.cqrzjlx = cqrzjlx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产权人号码
	 */
	@Column(name ="CQRZJHM",nullable=true,length=20)
	public java.lang.String getCqrzjhm(){
		return this.cqrzjhm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产权人号码
	 */
	public void setCqrzjhm(java.lang.String cqrzjhm){
		this.cqrzjhm = cqrzjhm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否拆分出租
	 */
	@Column(name ="CFCZBZ",nullable=true,length=10)
	public java.lang.String getCfczbz(){
		return this.cfczbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否拆分出租
	 */
	public void setCfczbz(java.lang.String cfczbz){
		this.cfczbz = cfczbz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费服务对象
	 */
	@Column(name ="SFFWDX",nullable=true,length=10)
	public java.lang.String getSffwdx(){
		return this.sffwdx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费服务对象
	 */
	public void setSffwdx(java.lang.String sffwdx){
		this.sffwdx = sffwdx;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序号
	 */
	@Column(name ="PXH",nullable=true,length=10)
	public java.lang.Integer getPxh(){
		return this.pxh;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序号
	 */
	public void setPxh(java.lang.Integer pxh){
		this.pxh = pxh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  有效标志
	 */
	@Column(name ="YXBZ",nullable=true,length=10)
	public java.lang.String getYxbz(){
		return this.yxbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  有效标志
	 */
	public void setYxbz(java.lang.String yxbz){
		this.yxbz = yxbz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件类型
	 */
	@Column(name ="ZJMC",nullable=true,length=10)
	public java.lang.String getZjmc(){
		return this.zjmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件类型
	 */
	public void setZjmc(java.lang.String zjmc){
		this.zjmc = zjmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号码
	 */
	@Column(name ="ZJHM",nullable=true,length=20)
	public java.lang.String getZjhm(){
		return this.zjhm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码
	 */
	public void setZjhm(java.lang.String zjhm){
		this.zjhm = zjhm;
	}

	@Override
	public String toString() {
		return "WuyeFwxxEntity [id=" + id + ", createName=" + createName + ", createBy=" + createBy + ", createDate="
				+ createDate + ", updateName=" + updateName + ", updateBy=" + updateBy + ", updateDate=" + updateDate
				+ ", sysOrgCode=" + sysOrgCode + ", sysCompanyCode=" + sysCompanyCode + ", bpmStatus=" + bpmStatus
				+ ", fjid=" + fjid + ", glqid=" + glqid + ", lyid=" + lyid + ", loux=" + loux + ", zlcs=" + zlcs
				+ ", dyh=" + dyh + ", lch=" + lch + ", fjbh=" + fjbh + ", jzmj=" + jzmj + ", tnmj=" + tnmj + ", gtmj="
				+ gtmj + ", ytmj=" + ytmj + ", fwhx=" + fwhx + ", fwlx=" + fwlx + ", zflb=" + zflb + ", fwyt=" + fwyt
				+ ", fwcx=" + fwcx + ", fwzt=" + fwzt + ", jgrq=" + jgrq + ", jfrq=" + jfrq + ", zxrq=" + zxrq
				+ ", rzrq=" + rzrq + ", fwcqr=" + fwcqr + ", cqrzjlx=" + cqrzjlx + ", cqrzjhm=" + cqrzjhm + ", cfczbz="
				+ cfczbz + ", sffwdx=" + sffwdx + ", pxh=" + pxh + ", yxbz=" + yxbz + ", zjmc=" + zjmc + ", zjhm="
				+ zjhm + "]";
	}	
}
