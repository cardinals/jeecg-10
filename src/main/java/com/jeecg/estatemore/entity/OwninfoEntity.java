package com.jeecg.estatemore.entity;

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
 * @Description: 业主租户信息
 * @author onlineGenerator
 * @date 2019-01-18 15:28:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "ownInfo", schema = "")
@SuppressWarnings("serial")
public class OwninfoEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**房间id*/
	@Excel(name="房间id",width=15)
	private java.lang.String roomId;
	/**业主租户名称*/
	@Excel(name="业主租户名称",width=15)
	private java.lang.String ownerName;
	/**客户属性*/
	@Excel(name="客户属性",width=15)
	private java.lang.String ownerAttribute;
	/**联系人*/
	@Excel(name="联系人",width=15)
	private java.lang.String ownerContact;
	/**座机*/
	@Excel(name="座机",width=15)
	private java.lang.String ownerLandline;
	/**手机号*/
	@Excel(name="手机号",width=15)
	private java.lang.String ownerPhone;
	/**传真*/
	@Excel(name="传真",width=15)
	private java.lang.String ownerFax;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String ownerIdcard;
	/**生日*/
	@Excel(name="生日",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date ownerBirthday;
	/**其他联系方式*/
	@Excel(name="其他联系方式",width=15)
	private java.lang.String otherContact;
	/**交房日期*/
	@Excel(name="交房日期",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date datePayment;
	/**入住日期*/
	@Excel(name="入住日期",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date liveinDate;
	/**住户卡号*/
	@Excel(name="住户卡号",width=15)
	private java.lang.String ownerBankid;
	/**装修日期*/
	@Excel(name="装修日期",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date decorateDate;
	/**收费开始日期*/
	@Excel(name="收费开始日期",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date payStart;
	/**收费截止日期*/
	@Excel(name="收费截止日期",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date payEnd;
	/**创建人*/
	@Excel(name="创建人",width=15)
	private java.lang.String createBy;
	/**创建时间*/
	@Excel(name="创建时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;
	
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
	 *@return: java.lang.String  房间id
	 */

	@Column(name ="ROOM_ID",nullable=true,length=36)
	public java.lang.String getRoomId(){
		return this.roomId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间id
	 */
	public void setRoomId(java.lang.String roomId){
		this.roomId = roomId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业主租户名称
	 */

	@Column(name ="OWNER_NAME",nullable=true,length=32)
	public java.lang.String getOwnerName(){
		return this.ownerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业主租户名称
	 */
	public void setOwnerName(java.lang.String ownerName){
		this.ownerName = ownerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户属性
	 */

	@Column(name ="OWNER_ATTRIBUTE",nullable=true,length=32)
	public java.lang.String getOwnerAttribute(){
		return this.ownerAttribute;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户属性
	 */
	public void setOwnerAttribute(java.lang.String ownerAttribute){
		this.ownerAttribute = ownerAttribute;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */

	@Column(name ="OWNER_CONTACT",nullable=true,length=32)
	public java.lang.String getOwnerContact(){
		return this.ownerContact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setOwnerContact(java.lang.String ownerContact){
		this.ownerContact = ownerContact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  座机
	 */

	@Column(name ="OWNER_LANDLINE",nullable=true,length=32)
	public java.lang.String getOwnerLandline(){
		return this.ownerLandline;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  座机
	 */
	public void setOwnerLandline(java.lang.String ownerLandline){
		this.ownerLandline = ownerLandline;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号
	 */

	@Column(name ="OWNER_PHONE",nullable=true,length=32)
	public java.lang.String getOwnerPhone(){
		return this.ownerPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号
	 */
	public void setOwnerPhone(java.lang.String ownerPhone){
		this.ownerPhone = ownerPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  传真
	 */

	@Column(name ="OWNER_FAX",nullable=true,length=32)
	public java.lang.String getOwnerFax(){
		return this.ownerFax;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  传真
	 */
	public void setOwnerFax(java.lang.String ownerFax){
		this.ownerFax = ownerFax;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="OWNER_IDCARD",nullable=true,length=32)
	public java.lang.String getOwnerIdcard(){
		return this.ownerIdcard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setOwnerIdcard(java.lang.String ownerIdcard){
		this.ownerIdcard = ownerIdcard;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生日
	 */

	@Column(name ="OWNER_BIRTHDAY",nullable=true,length=32)
	public java.util.Date getOwnerBirthday(){
		return this.ownerBirthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生日
	 */
	public void setOwnerBirthday(java.util.Date ownerBirthday){
		this.ownerBirthday = ownerBirthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他联系方式
	 */

	@Column(name ="OTHER_CONTACT",nullable=true,length=32)
	public java.lang.String getOtherContact(){
		return this.otherContact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他联系方式
	 */
	public void setOtherContact(java.lang.String otherContact){
		this.otherContact = otherContact;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  交房日期
	 */

	@Column(name ="DATE_PAYMENT",nullable=true,length=32)
	public java.util.Date getDatePayment(){
		return this.datePayment;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  交房日期
	 */
	public void setDatePayment(java.util.Date datePayment){
		this.datePayment = datePayment;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入住日期
	 */

	@Column(name ="LIVEIN_DATE",nullable=true,length=32)
	public java.util.Date getLiveinDate(){
		return this.liveinDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入住日期
	 */
	public void setLiveinDate(java.util.Date liveinDate){
		this.liveinDate = liveinDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住户卡号
	 */

	@Column(name ="OWNER_BANKID",nullable=true,length=32)
	public java.lang.String getOwnerBankid(){
		return this.ownerBankid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住户卡号
	 */
	public void setOwnerBankid(java.lang.String ownerBankid){
		this.ownerBankid = ownerBankid;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  装修日期
	 */

	@Column(name ="DECORATE_DATE",nullable=true,length=32)
	public java.util.Date getDecorateDate(){
		return this.decorateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  装修日期
	 */
	public void setDecorateDate(java.util.Date decorateDate){
		this.decorateDate = decorateDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收费开始日期
	 */

	@Column(name ="PAY_START",nullable=true,length=32)
	public java.util.Date getPayStart(){
		return this.payStart;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收费开始日期
	 */
	public void setPayStart(java.util.Date payStart){
		this.payStart = payStart;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收费截止日期
	 */

	@Column(name ="PAY_END",nullable=true,length=32)
	public java.util.Date getPayEnd(){
		return this.payEnd;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收费截止日期
	 */
	public void setPayEnd(java.util.Date payEnd){
		this.payEnd = payEnd;
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

	@Column(name ="CREATE_TIME",nullable=true,length=32)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
}