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
 * @Description: 房间收费项目设置
 * @author onlineGenerator
 * @date 2018-03-17 10:09:06
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_sfgl_fjsfxmsz", schema = "")
@SuppressWarnings("serial")
public class WuyeSfglFjsfxmszEntity implements java.io.Serializable {
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
	/**管理区ID*/
    @Excel(name="管理区ID",width=15)
		
	private java.lang.String glqid;
	/**楼宇ID*/
    @Excel(name="楼宇ID",width=15)
		
	private java.lang.String lyid;
	/**房屋主键*/
    @Excel(name="房屋主键",width=15)
		
	private java.lang.String fwxxid;
	/**房间ID*/
    @Excel(name="房间ID",width=15)
		
	private Long fjid;
	/**收费项目ID*/
    @Excel(name="收费项目ID",width=15)
		
	private java.lang.String sfxmid;
	/**优惠类型*/
    @Excel(name="优惠类型",width=15)
		
	private java.lang.String yhlx;
	/**折扣系数*/
    @Excel(name="折扣系数",width=15)
		
	private java.lang.Double yhbl;
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
	 *@return: java.lang.String  管理区ID
	 */
	@Column(name ="GLQID",nullable=true,length=32)
	public java.lang.String getGlqid(){
		return this.glqid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理区ID
	 */
	public void setGlqid(java.lang.String glqid){
		this.glqid = glqid;
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
	@Column(name ="FJID",nullable=true,length=8)
	public java.lang.Long getFjid(){
		return this.fjid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  房间ID
	 */
	public void setFjid(Long fjid){
		this.fjid = fjid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费项目ID
	 */
	@Column(name ="SFXMID",nullable=true,length=32)
	public java.lang.String getSfxmid(){
		return this.sfxmid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费项目ID
	 */
	public void setSfxmid(java.lang.String sfxmid){
		this.sfxmid = sfxmid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  优惠类型
	 */
	@Column(name ="YHLX",nullable=true,length=32)
	public java.lang.String getYhlx(){
		return this.yhlx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  优惠类型
	 */
	public void setYhlx(java.lang.String yhlx){
		this.yhlx = yhlx;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  折扣系数
	 */
	@Column(name ="YHBL",nullable=true,length=32)
	public java.lang.Double getYhbl(){
		return this.yhbl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  折扣系数
	 */
	public void setYhbl(java.lang.Double yhbl){
		this.yhbl = yhbl;
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

	@Override
	public String toString() {
		return "WuyeSfglFjsfxmszEntity [id=" + id + ", createName=" + createName + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", updateName=" + updateName + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + ", sysOrgCode=" + sysOrgCode + ", sysCompanyCode=" + sysCompanyCode
				+ ", bpmStatus=" + bpmStatus + ", glqid=" + glqid + ", lyid=" + lyid + ", fwxxid=" + fwxxid + ", fjid="
				+ fjid + ", sfxmid=" + sfxmid + ", yhlx=" + yhlx + ", yhbl=" + yhbl + ", bz=" + bz + "]";
	}
	
}
