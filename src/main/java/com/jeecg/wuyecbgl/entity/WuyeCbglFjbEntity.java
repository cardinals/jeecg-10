package com.jeecg.wuyecbgl.entity;

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
 * @Description: 房间表管理
 * @author onlineGenerator
 * @date 2018-03-22 10:37:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_cbgl_fjb", schema = "")
@SuppressWarnings("serial")
public class WuyeCbglFjbEntity implements java.io.Serializable {
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
	/*@Excel(name="管理区id",width=15)*/
	private java.lang.String glqid;
	/**房屋主键*/
	/*@Excel(name="房屋主键",width=15)*/
	private java.lang.String fwxxid;
	/**房间id*/
	@Excel(name="房间id",width=15)
	private java.lang.Integer fjid;
	/**公摊表ID*/
	@Excel(name="公摊表编号",width=15)
	private java.lang.String gtbid;
	/**房间地址*/
	@Excel(name="房间地址",width=15)
	private java.lang.String fjdz;
	/**收费项目代码*/
	@Excel(name="收费项目代码",width=15)
	private java.lang.String sfxmdm;
	/**仪表编号*/
	@Excel(name="仪表编号",width=15)
	private java.lang.Integer ybbh;
	/**仪表类型*/
	@Excel(name="仪表类型",width=15,dicCode="yblx")
	private java.lang.String yblx;
	/**倍率*/
	@Excel(name="倍率",width=15)
	private java.lang.Double bl;
	/**初始读数*/
	@Excel(name="初始读数",width=15)
	private java.lang.Double csds;
	/**有效标志*/
	/*@Excel(name="有效标志",width=15)*/
	private java.lang.String yxbz;
	
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
	 *@return: java.lang.Integer  房间id
	 */

	@Column(name ="FJID",nullable=true,length=32)
	public java.lang.Integer getFjid(){
		return this.fjid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  房间id
	 */
	public void setFjid(java.lang.Integer fjid){
		this.fjid = fjid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公摊表ID
	 */

	@Column(name ="GTBID",nullable=true,length=32)
	public java.lang.String getGtbid(){
		return this.gtbid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公摊表ID
	 */
	public void setGtbid(java.lang.String gtbid){
		this.gtbid = gtbid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间地址
	 */

	@Column(name ="FJDZ",nullable=true,length=200)
	public java.lang.String getFjdz(){
		return this.fjdz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间地址
	 */
	public void setFjdz(java.lang.String fjdz){
		this.fjdz = fjdz;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  仪表编号
	 */

	@Column(name ="YBBH",nullable=true,length=32)
	public java.lang.Integer getYbbh(){
		return this.ybbh;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  仪表编号
	 */
	public void setYbbh(java.lang.Integer ybbh){
		this.ybbh = ybbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仪表类型
	 */

	@Column(name ="YBLX",nullable=true,length=32)
	public java.lang.String getYblx(){
		return this.yblx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仪表类型
	 */
	public void setYblx(java.lang.String yblx){
		this.yblx = yblx;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  倍率
	 */

	@Column(name ="BL",nullable=true,length=32)
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
	 *@return: java.lang.Double  初始读数
	 */

	@Column(name ="CSDS",nullable=true,length=32)
	public java.lang.Double getCsds(){
		return this.csds;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  初始读数
	 */
	public void setCsds(java.lang.Double csds){
		this.csds = csds;
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
}
