package com.jeecg.estate.entity;

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
 * @Description: 小区表
 * @author onlineGenerator
 * @date 2019-01-22 15:27:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "community", schema = "")
@SuppressWarnings("serial")
public class CommunityEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**小区名称*/
	@Excel(name="小区名称",width=15)
	private java.lang.String commName;
	/**小区地址*/
	@Excel(name="小区地址",width=15)
	private java.lang.String commAddress;
	/**小区负责人*/
	@Excel(name="小区负责人",width=15)
	private java.lang.String commMan;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private java.lang.String commPhone;
	/**所属管区id*/
	@Excel(name="所属管区id",width=15)
	private java.lang.String fatherId;
	/**占地面积*/
	@Excel(name="占地面积",width=15)
	private java.lang.String coverArea;
	/**建筑面积*/
	@Excel(name="建筑面积",width=15)
	private java.lang.String buildingArea;
	/**创建人*/
	@Excel(name="创建人",width=15)
	private java.lang.String createBy;
	/**创建时间*/
	@Excel(name="创建时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	
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
	 *@return: java.lang.String  小区名称
	 */

	@Column(name ="COMM_NAME",nullable=false,length=32)
	public java.lang.String getCommName(){
		return this.commName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  小区名称
	 */
	public void setCommName(java.lang.String commName){
		this.commName = commName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  小区地址
	 */

	@Column(name ="COMM_ADDRESS",nullable=true,length=32)
	public java.lang.String getCommAddress(){
		return this.commAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  小区地址
	 */
	public void setCommAddress(java.lang.String commAddress){
		this.commAddress = commAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  小区负责人
	 */

	@Column(name ="COMM_MAN",nullable=true,length=32)
	public java.lang.String getCommMan(){
		return this.commMan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  小区负责人
	 */
	public void setCommMan(java.lang.String commMan){
		this.commMan = commMan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="COMM_PHONE",nullable=true,length=32)
	public java.lang.String getCommPhone(){
		return this.commPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setCommPhone(java.lang.String commPhone){
		this.commPhone = commPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属管区id
	 */

	@Column(name ="FATHER_ID",nullable=true,length=36)
	public java.lang.String getFatherId(){
		return this.fatherId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属管区id
	 */
	public void setFatherId(java.lang.String fatherId){
		this.fatherId = fatherId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  占地面积
	 */

	@Column(name ="COVER_AREA",nullable=false,length=32)
	public java.lang.String getCoverArea(){
		return this.coverArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  占地面积
	 */
	public void setCoverArea(java.lang.String coverArea){
		this.coverArea = coverArea;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  建筑面积
	 */

	@Column(name ="BUILDING_AREA",nullable=false,length=32)
	public java.lang.String getBuildingArea(){
		return this.buildingArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  建筑面积
	 */
	public void setBuildingArea(java.lang.String buildingArea){
		this.buildingArea = buildingArea;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */

	@Column(name ="CREATE_BY",nullable=true,length=32)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=32)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
}