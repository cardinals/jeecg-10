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
 * @Description: 单位代扣信息
 * @author onlineGenerator
 * @date 2018-04-19 09:43:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_sfgl_dwdkxx", schema = "")
@SuppressWarnings("serial")
public class WuyeSfglDwdkxxEntity implements java.io.Serializable {
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
	/**年度*/
    @Excel(name="年度",width=15)
		
	private java.lang.String year;
	/**月份*/
    @Excel(name="月份",width=15)
		
	private java.lang.String month;
	/**代扣单位*/
    @Excel(name="代扣单位",width=15)
		
	private java.lang.String dkdw;
	/**住户姓名*/
    @Excel(name="住户姓名",width=15)
		
	private java.lang.String zhxm;
	/**实收金额*/
    @Excel(name="实收金额",width=15)
		
	private java.lang.Double ssje;
	/**代扣单位工号*/
    @Excel(name="代扣单位工号",width=15)
		
	private java.lang.String dkdwgh;
	/**提交金额*/
    @Excel(name="提交金额",width=15)
		
	private java.lang.Double tjje;
	/**实际扣款额*/
    @Excel(name="实际扣款额",width=15)
		
	private java.lang.Double sjkke;
	/**交易日期*/
    @Excel(name="交易日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date jyrq;
	/**状态*/
    @Excel(name="状态",width=15)
		
	private java.lang.String zt;
	/**响应信息*/
    @Excel(name="响应信息",width=15)
		
	private java.lang.String xyxx;
	
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
	 *@return: java.lang.String  住户姓名
	 */
	@Column(name ="ZHXM",nullable=true,length=32)
	public java.lang.String getZhxm(){
		return this.zhxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住户姓名
	 */
	public void setZhxm(java.lang.String zhxm){
		this.zhxm = zhxm;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实收金额
	 */
	@Column(name ="SSJE",nullable=true,length=32)
	public java.lang.Double getSsje(){
		return this.ssje;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实收金额
	 */
	public void setSsje(java.lang.Double ssje){
		this.ssje = ssje;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣单位工号
	 */
	@Column(name ="DKDWGH",nullable=true,length=32)
	public java.lang.String getDkdwgh(){
		return this.dkdwgh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣单位工号
	 */
	public void setDkdwgh(java.lang.String dkdwgh){
		this.dkdwgh = dkdwgh;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  提交金额
	 */
	@Column(name ="TJJE",nullable=true,length=32)
	public java.lang.Double getTjje(){
		return this.tjje;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  提交金额
	 */
	public void setTjje(java.lang.Double tjje){
		this.tjje = tjje;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实际扣款额
	 */
	@Column(name ="SJKKE",nullable=true,length=32)
	public java.lang.Double getSjkke(){
		return this.sjkke;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际扣款额
	 */
	public void setSjkke(java.lang.Double sjkke){
		this.sjkke = sjkke;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  交易日期
	 */
	@Column(name ="JYRQ",nullable=true,length=32)
	public java.util.Date getJyrq(){
		return this.jyrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  交易日期
	 */
	public void setJyrq(java.util.Date jyrq){
		this.jyrq = jyrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="ZT",nullable=true,length=32)
	public java.lang.String getZt(){
		return this.zt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setZt(java.lang.String zt){
		this.zt = zt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  响应信息
	 */
	@Column(name ="XYXX",nullable=true,length=32)
	public java.lang.String getXyxx(){
		return this.xyxx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  响应信息
	 */
	public void setXyxx(java.lang.String xyxx){
		this.xyxx = xyxx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年度
	 */
	@Column(name ="YEAR",nullable=true,length=32)
	public java.lang.String getYear(){
		return this.year;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年度
	 */
	public void setYear(java.lang.String year){
		this.year = year;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  月份
	 */
	@Column(name ="MONTH",nullable=true,length=32)
	public java.lang.String getMonth(){
		return this.month;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  月份
	 */
	public void setMonth(java.lang.String month){
		this.month = month;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣单位
	 */
	@Column(name ="DKDW",nullable=true,length=32)
	public java.lang.String getDkdw(){
		return this.dkdw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣单位
	 */
	public void setDkdw(java.lang.String dkdw){
		this.dkdw = dkdw;
	}
}
