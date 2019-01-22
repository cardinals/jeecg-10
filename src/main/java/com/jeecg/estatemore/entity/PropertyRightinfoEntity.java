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
 * @Description: 房间产权信息表
 * @author onlineGenerator
 * @date 2019-01-18 15:28:50
 * @version V1.0   
 *
 */
@Entity
@Table(name = "property_rightInfo", schema = "")
@SuppressWarnings("serial")
public class PropertyRightinfoEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**房间id*/
	@Excel(name="房间id",width=15)
	private java.lang.String roomId;
	/**房屋所有权人 现*/
	@Excel(name="房屋所有权人 现",width=15)
	private java.lang.String nowRight;
	/**证件名称 现*/
	@Excel(name="证件名称 现",width=15)
	private java.lang.String nowCertificate;
	/**证件号码 现*/
	@Excel(name="证件号码 现",width=15)
	private java.lang.String nowCardnum;
	/**房屋所有权人 原*/
	@Excel(name="房屋所有权人 原",width=15)
	private java.lang.String oldRight;
	/**证件名称 原*/
	@Excel(name="证件名称 原",width=15)
	private java.lang.String oldCertificate;
	/**证件号码 原*/
	@Excel(name="证件号码 原",width=15)
	private java.lang.String oldCardnum;
	/**变更人*/
	@Excel(name="变更人",width=15)
	private java.lang.String changeBy;
	/**变更日期*/
	@Excel(name="变更日期",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date changeDate;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String note;
	
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
	 *@return: java.lang.String  房屋所有权人 现
	 */

	@Column(name ="NOW_RIGHT",nullable=true,length=32)
	public java.lang.String getNowRight(){
		return this.nowRight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋所有权人 现
	 */
	public void setNowRight(java.lang.String nowRight){
		this.nowRight = nowRight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件名称 现
	 */

	@Column(name ="NOW_CERTIFICATE",nullable=true,length=32)
	public java.lang.String getNowCertificate(){
		return this.nowCertificate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件名称 现
	 */
	public void setNowCertificate(java.lang.String nowCertificate){
		this.nowCertificate = nowCertificate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号码 现
	 */

	@Column(name ="NOW_CARDNUM",nullable=true,length=32)
	public java.lang.String getNowCardnum(){
		return this.nowCardnum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码 现
	 */
	public void setNowCardnum(java.lang.String nowCardnum){
		this.nowCardnum = nowCardnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋所有权人 原
	 */

	@Column(name ="OLD_RIGHT",nullable=true,length=32)
	public java.lang.String getOldRight(){
		return this.oldRight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋所有权人 原
	 */
	public void setOldRight(java.lang.String oldRight){
		this.oldRight = oldRight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件名称 原
	 */

	@Column(name ="OLD_CERTIFICATE",nullable=true,length=32)
	public java.lang.String getOldCertificate(){
		return this.oldCertificate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件名称 原
	 */
	public void setOldCertificate(java.lang.String oldCertificate){
		this.oldCertificate = oldCertificate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号码 原
	 */

	@Column(name ="OLD_CARDNUM",nullable=true,length=32)
	public java.lang.String getOldCardnum(){
		return this.oldCardnum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码 原
	 */
	public void setOldCardnum(java.lang.String oldCardnum){
		this.oldCardnum = oldCardnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变更人
	 */

	@Column(name ="CHANGE_BY",nullable=true,length=32)
	public java.lang.String getChangeBy(){
		return this.changeBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变更人
	 */
	public void setChangeBy(java.lang.String changeBy){
		this.changeBy = changeBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  变更日期
	 */

	@Column(name ="CHANGE_DATE",nullable=true,length=32)
	public java.util.Date getChangeDate(){
		return this.changeDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  变更日期
	 */
	public void setChangeDate(java.util.Date changeDate){
		this.changeDate = changeDate;
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
}