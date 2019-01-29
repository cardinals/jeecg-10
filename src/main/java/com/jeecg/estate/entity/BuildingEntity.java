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
 * @Description: 楼宇表
 * @author onlineGenerator
 * @date 2019-01-18 15:27:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "building", schema = "")
@SuppressWarnings("serial")
public class BuildingEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**楼宇编号*/
	@Excel(name="楼宇编号",width=15)
	private java.lang.String buildNum;
	/**楼宇名称*/
	@Excel(name="楼宇名称",width=15)
	private java.lang.String buildName;
	/**楼宇地址*/
	@Excel(name="楼宇地址",width=15)
	private java.lang.String buildAddress;
	/**楼宇类型*/
	@Excel(name="楼宇类型",width=15)
	private java.lang.String buildType;
	/**楼宇结构*/
	@Excel(name="楼宇结构",width=15)
	private java.lang.String buildStru;
	/**楼宇朝向*/
	@Excel(name="楼宇朝向",width=15)
	private java.lang.String buildToward;
	/**楼层数*/
	@Excel(name="楼层数",width=15)
	private Integer buildFloor;
	
	@Column(name ="BUILD_FLOOR",nullable=true,length=32)
	public Integer getBuildFloor() {
		return buildFloor;
	}

	public void setBuildFloor(Integer buildFloor) {
		this.buildFloor = buildFloor;
	}

	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String note;
	/**所属小区id*/
	@Excel(name="所属小区id",width=15)
	private java.lang.String commId;
	/**所属管区id*/
	@Excel(name="所属管区id",width=15)
	private java.lang.String manaId;
	/**所属公司id*/
	@Excel(name="所属公司id",width=15)
	private java.lang.String comId;
	/**创建人*/
	@Excel(name="创建人",width=15)
	private java.lang.String createBy;
	/**创建时间*/
	@Excel(name="创建时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
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
	 *@return: java.lang.String  楼宇编号
	 */

	@Column(name ="BUILD_NUM",nullable=false,length=32)
	public java.lang.String getBuildNum(){
		return this.buildNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇编号
	 */
	public void setBuildNum(java.lang.String buildNum){
		this.buildNum = buildNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇名称
	 */

	@Column(name ="BUILD_NAME",nullable=false,length=32)
	public java.lang.String getBuildName(){
		return this.buildName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇名称
	 */
	public void setBuildName(java.lang.String buildName){
		this.buildName = buildName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇地址
	 */

	@Column(name ="BUILD_ADDRESS",nullable=true,length=32)
	public java.lang.String getBuildAddress(){
		return this.buildAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇地址
	 */
	public void setBuildAddress(java.lang.String buildAddress){
		this.buildAddress = buildAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇类型
	 */

	@Column(name ="BUILD_TYPE",nullable=true,length=32)
	public java.lang.String getBuildType(){
		return this.buildType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇类型
	 */
	public void setBuildType(java.lang.String buildType){
		this.buildType = buildType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇结构
	 */

	@Column(name ="BUILD_STRU",nullable=true,length=32)
	public java.lang.String getBuildStru(){
		return this.buildStru;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇结构
	 */
	public void setBuildStru(java.lang.String buildStru){
		this.buildStru = buildStru;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇朝向
	 */

	@Column(name ="BUILD_TOWARD",nullable=true,length=32)
	public java.lang.String getBuildToward(){
		return this.buildToward;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇朝向
	 */
	public void setBuildToward(java.lang.String buildToward){
		this.buildToward = buildToward;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="NOTE",nullable=true,length=32)
	public java.lang.String getNote(){
		return this.note;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setNote(java.lang.String note){
		this.note = note;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属小区id
	 */

	@Column(name ="COMM_ID",nullable=false,length=36)
	public java.lang.String getCommId(){
		return this.commId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属小区id
	 */
	public void setCommId(java.lang.String commId){
		this.commId = commId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属管区id
	 */

	@Column(name ="MANA_ID",nullable=true,length=36)
	public java.lang.String getManaId(){
		return this.manaId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属管区id
	 */
	public void setManaId(java.lang.String manaId){
		this.manaId = manaId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司id
	 */

	@Column(name ="COM_ID",nullable=true,length=36)
	public java.lang.String getComId(){
		return this.comId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司id
	 */
	public void setComId(java.lang.String comId){
		this.comId = comId;
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