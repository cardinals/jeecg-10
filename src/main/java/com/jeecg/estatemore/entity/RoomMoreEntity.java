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
 * @Description: 房间扩展信息表
 * @author onlineGenerator
 * @date 2019-01-18 15:28:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "room_more", schema = "")
@SuppressWarnings("serial")
public class RoomMoreEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**房间id*/
	@Excel(name="房间id",width=15)
	private java.lang.String roomId;
	/**产权人*/
	@Excel(name="产权人",width=15)
	private java.lang.String propertyRight;
	/**产权人证件号*/
	@Excel(name="产权人证件号",width=15)
	private java.lang.String propertyIdcard;
	/**入住时间*/
	@Excel(name="入住时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date liveDate;
	/**是否为减免户*/
	@Excel(name="是否为减免户",width=15)
	private java.lang.Integer isoff;
	/**减免原因*/
	@Excel(name="减免原因",width=15)
	private java.lang.String offReason;
	
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

	@Column(name ="ROOM_ID",nullable=false,length=36)
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
	 *@return: java.lang.String  产权人
	 */

	@Column(name ="PROPERTY_RIGHT",nullable=true,length=32)
	public java.lang.String getPropertyRight(){
		return this.propertyRight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产权人
	 */
	public void setPropertyRight(java.lang.String propertyRight){
		this.propertyRight = propertyRight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产权人证件号
	 */

	@Column(name ="PROPERTY_IDCARD",nullable=true,length=32)
	public java.lang.String getPropertyIdcard(){
		return this.propertyIdcard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产权人证件号
	 */
	public void setPropertyIdcard(java.lang.String propertyIdcard){
		this.propertyIdcard = propertyIdcard;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入住时间
	 */

	@Column(name ="LIVE_DATE",nullable=true,length=32)
	public java.util.Date getLiveDate(){
		return this.liveDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入住时间
	 */
	public void setLiveDate(java.util.Date liveDate){
		this.liveDate = liveDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否为减免户
	 */

	@Column(name ="ISOFF",nullable=true,length=32)
	public java.lang.Integer getIsoff(){
		return this.isoff;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否为减免户
	 */
	public void setIsoff(java.lang.Integer isoff){
		this.isoff = isoff;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  减免原因
	 */

	@Column(name ="OFF_REASON",nullable=true,length=32)
	public java.lang.String getOffReason(){
		return this.offReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  减免原因
	 */
	public void setOffReason(java.lang.String offReason){
		this.offReason = offReason;
	}
}