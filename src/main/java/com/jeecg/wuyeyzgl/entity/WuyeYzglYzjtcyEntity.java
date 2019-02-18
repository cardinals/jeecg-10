package com.jeecg.wuyeyzgl.entity;

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
 * @Description: 业主家庭成员管理
 * @author onlineGenerator
 * @date 2018-03-15 10:27:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_yzgl_yzjtcy", schema = "")
@SuppressWarnings("serial")
public class WuyeYzglYzjtcyEntity implements java.io.Serializable {
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
	/**管理区id*/
   /* @Excel(name="管理区id",width=15)*/
		
	private java.lang.String glqid;
	/**房屋主键*/
    /*@Excel(name="房屋主键",width=15)*/
		
	private java.lang.String fwxxid;
	/**迁入房间id*/
    @Excel(name="迁入房间id",width=15)
		
	private java.lang.Integer fjid;
	/**业主主键*/
    @Excel(name="业主主键",width=15)
		
	private java.lang.String fwyzxxid;
	/**户主及家庭成员姓名*/
    @Excel(name="户主及家庭成员姓名",width=15)
		
	private java.lang.String jtcyxm;
	/**与户主关系*/
    @Excel(name="与户主关系",width=15)
		
	private java.lang.String hzgx;
	/**性别*/
    @Excel(name="性别",width=15,dicCode="yzxb")
		
	private java.lang.String xb;
	/**身份证号*/
    @Excel(name="身份证号",width=15)
		
	private java.lang.String sfzh;
	/**人员现状*/
    @Excel(name="人员现状",width=15)
		
	private java.lang.String gzxz;
	/**工作单位*/
    @Excel(name="工作单位",width=15)
		
	private java.lang.String gzdw;
	/**备注*/
    @Excel(name="备注",width=15)
		
	private java.lang.String bz;
	
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
	 *@return: java.lang.Integer  迁入房间id
	 */
	@Column(name ="FJID",nullable=true,length=32)
	public java.lang.Integer getFjid(){
		return this.fjid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  迁入房间id
	 */
	public void setFjid(java.lang.Integer fjid){
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
	 *@return: java.lang.String  户主及家庭成员姓名
	 */
	@Column(name ="JTCYXM",nullable=true,length=60)
	public java.lang.String getJtcyxm(){
		return this.jtcyxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户主及家庭成员姓名
	 */
	public void setJtcyxm(java.lang.String jtcyxm){
		this.jtcyxm = jtcyxm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  与户主关系
	 */
	@Column(name ="HZGX",nullable=true,length=10)
	public java.lang.String getHzgx(){
		return this.hzgx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  与户主关系
	 */
	public void setHzgx(java.lang.String hzgx){
		this.hzgx = hzgx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="XB",nullable=true,length=10)
	public java.lang.String getXb(){
		return this.xb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setXb(java.lang.String xb){
		this.xb = xb;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="SFZH",nullable=true,length=20)
	public java.lang.String getSfzh(){
		return this.sfzh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setSfzh(java.lang.String sfzh){
		this.sfzh = sfzh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人员现状
	 */
	@Column(name ="GZXZ",nullable=true,length=10)
	public java.lang.String getGzxz(){
		return this.gzxz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员现状
	 */
	public void setGzxz(java.lang.String gzxz){
		this.gzxz = gzxz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作单位
	 */
	@Column(name ="GZDW",nullable=true,length=60)
	public java.lang.String getGzdw(){
		return this.gzdw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作单位
	 */
	public void setGzdw(java.lang.String gzdw){
		this.gzdw = gzdw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BZ",nullable=true,length=300)
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
}
