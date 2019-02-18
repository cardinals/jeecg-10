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
 * @Description: 应收费用计算项目表
 * @author onlineGenerator
 * @date 2018-03-21 17:55:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_sfgl_ysfyjsxm", schema = "")
@SuppressWarnings("serial")
public class WuyeSfglYsfyjsxmEntity implements java.io.Serializable {
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
	
	/**主表id*/
    /*@Excel(name="主表id",width=15)*/
		
	private java.lang.String zbid;
	/**管理区id*/
    /*@Excel(name="管理区id",width=15)*/
		
	private java.lang.String glqid;
	/**收费项目代码*/
    @Excel(name="收费项目代码",width=15)
		
	private java.lang.String sfxmdm;
	/**收费项目名称*/
    @Excel(name="收费项目名称",width=15)
		
	private java.lang.String sfxmmc;
	/**计费开始时间*/
    @Excel(name="计费开始时间",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date jfqssj;
	/**计费终止时间*/
    @Excel(name="计费终止时间",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date jfjzsj;
	/**收费方式*/
    @Excel(name="收费方式",width=15)
		
	private java.lang.String sffs;
	/**计费方式*/
    @Excel(name="计费方式",width=15)
		
	private java.lang.String jffs;
	/**计费周期*/
    @Excel(name="计费周期",width=15)
		
	private java.lang.String jfzq;
	/**计费周期单位*/
    @Excel(name="计费周期单位",width=15)
		
	private java.lang.String jfzqdw;
	/**计费单价*/
    @Excel(name="计费单价",width=15)
		
	private java.lang.Double jfdj;
	/**计费精度*/
    @Excel(name="计费精度",width=15)
		
	private java.lang.String jfjd;
	/**滞纳金率*/
    @Excel(name="滞纳金率",width=15)
		
	private java.lang.Double znjl;
	/**滞纳金开始天数*/
    @Excel(name="滞纳金开始天数",width=15)
		
	private java.lang.Integer znjksts;
	/**计算公式*/
    @Excel(name="计算公式",width=15)
		
	private java.lang.String jsgs;
	
    /**收费项目id*/
		
	private java.lang.String sfxmid;
	
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
	 *@return: java.lang.String  主表id
	 */
	@Column(name ="ZBID",nullable=true,length=32)
	public java.lang.String getZbid(){
		return this.zbid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表id
	 */
	public void setZbid(java.lang.String zbid){
		this.zbid = zbid;
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
	@Column(name ="SFXMMC",nullable=true,length=30)
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
	 *@return: java.util.Date  计费开始时间
	 */
	@Column(name ="JFQSSJ",nullable=true,length=32)
	public java.util.Date getJfqssj(){
		return this.jfqssj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计费开始时间
	 */
	public void setJfqssj(java.util.Date jfqssj){
		this.jfqssj = jfqssj;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计费终止时间
	 */
	@Column(name ="JFJZSJ",nullable=true,length=32)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费方式
	 */
	@Column(name ="SFFS",nullable=true,length=10)
	public java.lang.String getSffs(){
		return this.sffs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费方式
	 */
	public void setSffs(java.lang.String sffs){
		this.sffs = sffs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费方式
	 */
	@Column(name ="JFFS",nullable=true,length=10)
	public java.lang.String getJffs(){
		return this.jffs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费方式
	 */
	public void setJffs(java.lang.String jffs){
		this.jffs = jffs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费周期
	 */
	@Column(name ="JFZQ",nullable=true,length=10)
	public java.lang.String getJfzq(){
		return this.jfzq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费周期
	 */
	public void setJfzq(java.lang.String jfzq){
		this.jfzq = jfzq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费周期单位
	 */
	@Column(name ="JFZQDW",nullable=true,length=10)
	public java.lang.String getJfzqdw(){
		return this.jfzqdw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费周期单位
	 */
	public void setJfzqdw(java.lang.String jfzqdw){
		this.jfzqdw = jfzqdw;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  计费单价
	 */
	@Column(name ="JFDJ",nullable=true,length=32)
	public java.lang.Double getJfdj(){
		return this.jfdj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  计费单价
	 */
	public void setJfdj(java.lang.Double jfdj){
		this.jfdj = jfdj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费精度
	 */
	@Column(name ="JFJD",nullable=true,length=10)
	public java.lang.String getJfjd(){
		return this.jfjd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费精度
	 */
	public void setJfjd(java.lang.String jfjd){
		this.jfjd = jfjd;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  滞纳金率
	 */
	@Column(name ="ZNJL",nullable=true,length=32)
	public java.lang.Double getZnjl(){
		return this.znjl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  滞纳金率
	 */
	public void setZnjl(java.lang.Double znjl){
		this.znjl = znjl;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  滞纳金开始天数
	 */
	@Column(name ="ZNJKSTS",nullable=true,length=32)
	public java.lang.Integer getZnjksts(){
		return this.znjksts;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  滞纳金开始天数
	 */
	public void setZnjksts(java.lang.Integer znjksts){
		this.znjksts = znjksts;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计算公式
	 */
	@Column(name ="JSGS",nullable=true,length=3000)
	public java.lang.String getJsgs(){
		return this.jsgs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计算公式
	 */
	public void setJsgs(java.lang.String jsgs){
		this.jsgs = jsgs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费项目id
	 */
	@Column(name ="SFXMID",nullable=true,length=36)
	public java.lang.String getSfxmid(){
		return this.sfxmid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费项目id
	 */
	public void setSfxmid(java.lang.String sfxmid){
		this.sfxmid = sfxmid;
	}
}
