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
 * @Description: 房间表
 * @author onlineGenerator
 * @date 2019-01-18 15:25:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "room", schema = "")
@SuppressWarnings("serial")
public class RoomEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**房间编号*/
	@Excel(name="房间编号",width=15)
	private java.lang.String roomNo;
	/**管区id*/
	@Excel(name="管区id",width=15)
	private java.lang.String managerId;
	/**小区id*/
	@Excel(name="小区id",width=15)
	private java.lang.String commId;
	/**楼宇id*/
	@Excel(name="楼宇id",width=15)
	private java.lang.String buildingId;
	/**房间类型*/
	@Excel(name="房间类型",width=15)
	private java.lang.String roomType;
	/**房间状态*/
	@Excel(name="房间状态",width=15)
	private java.lang.String roomStatus;
	/**装修情况*/
	@Excel(name="装修情况",width=15)
	private java.lang.String decorateStatus;
	/**建筑面积*/
	@Excel(name="建筑面积",width=15)
	private java.lang.String buildArea;
	/**套内面积*/
	@Excel(name="套内面积",width=15)
	private java.lang.String roomArea;
	/**收费服务对象*/
	@Excel(name="收费服务对象",width=15)
	private java.lang.String chargeFor;
	/**公摊面积*/
	@Excel(name="公摊面积",width=15)
	private java.lang.String publicArea;
	/**房间顺序号*/
	@Excel(name="房间顺序号",width=15)
	private java.lang.String roomNum;
	/**房间用途*/
	@Excel(name="房间用途",width=15)
	private java.lang.String roomUseful;
	/**楼层数*/
	@Excel(name="楼层数",width=15)
	private java.lang.String roomFloor;
	/**权属类型*/
	@Excel(name="权属类型",width=15)
	private java.lang.String rightType;
	/**地址*/
	@Excel(name="地址",width=15)
	private java.lang.String roomAddress;
	/**单元号*/
	@Excel(name="单元号",width=15)
	private java.lang.String roomUnity;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String note;
	/**朝向*/
	@Excel(name="朝向",width=15)
	private java.lang.String roomToward;
	
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
	 *@return: java.lang.String  房间编号
	 */

	@Column(name ="ROOM_NO",nullable=false,length=32)
	public java.lang.String getRoomNo(){
		return this.roomNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间编号
	 */
	public void setRoomNo(java.lang.String roomNo){
		this.roomNo = roomNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管区id
	 */

	@Column(name ="MANAGER_ID",nullable=true,length=36)
	public java.lang.String getManagerId(){
		return this.managerId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管区id
	 */
	public void setManagerId(java.lang.String managerId){
		this.managerId = managerId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  小区id
	 */

	@Column(name ="COMM_ID",nullable=true,length=36)
	public java.lang.String getCommId(){
		return this.commId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  小区id
	 */
	public void setCommId(java.lang.String commId){
		this.commId = commId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼宇id
	 */

	@Column(name ="BUILDING_ID",nullable=true,length=36)
	public java.lang.String getBuildingId(){
		return this.buildingId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇id
	 */
	public void setBuildingId(java.lang.String buildingId){
		this.buildingId = buildingId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间类型
	 */

	@Column(name ="ROOM_TYPE",nullable=true,length=32)
	public java.lang.String getRoomType(){
		return this.roomType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间类型
	 */
	public void setRoomType(java.lang.String roomType){
		this.roomType = roomType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间状态
	 */

	@Column(name ="ROOM_STATUS",nullable=true,length=32)
	public java.lang.String getRoomStatus(){
		return this.roomStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间状态
	 */
	public void setRoomStatus(java.lang.String roomStatus){
		this.roomStatus = roomStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装修情况
	 */

	@Column(name ="DECORATE_STATUS",nullable=true,length=32)
	public java.lang.String getDecorateStatus(){
		return this.decorateStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装修情况
	 */
	public void setDecorateStatus(java.lang.String decorateStatus){
		this.decorateStatus = decorateStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  建筑面积
	 */

	@Column(name ="BUILD_AREA",nullable=true,length=32)
	public java.lang.String getBuildArea(){
		return this.buildArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  建筑面积
	 */
	public void setBuildArea(java.lang.String buildArea){
		this.buildArea = buildArea;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  套内面积
	 */

	@Column(name ="ROOM_AREA",nullable=true,length=32)
	public java.lang.String getRoomArea(){
		return this.roomArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套内面积
	 */
	public void setRoomArea(java.lang.String roomArea){
		this.roomArea = roomArea;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费服务对象
	 */

	@Column(name ="CHARGE_FOR",nullable=true,length=32)
	public java.lang.String getChargeFor(){
		return this.chargeFor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费服务对象
	 */
	public void setChargeFor(java.lang.String chargeFor){
		this.chargeFor = chargeFor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公摊面积
	 */

	@Column(name ="PUBLIC_AREA",nullable=true,length=32)
	public java.lang.String getPublicArea(){
		return this.publicArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公摊面积
	 */
	public void setPublicArea(java.lang.String publicArea){
		this.publicArea = publicArea;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间顺序号
	 */

	@Column(name ="ROOM_NUM",nullable=true,length=32)
	public java.lang.String getRoomNum(){
		return this.roomNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间顺序号
	 */
	public void setRoomNum(java.lang.String roomNum){
		this.roomNum = roomNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间用途
	 */

	@Column(name ="ROOM_USEFUL",nullable=true,length=32)
	public java.lang.String getRoomUseful(){
		return this.roomUseful;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间用途
	 */
	public void setRoomUseful(java.lang.String roomUseful){
		this.roomUseful = roomUseful;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼层数
	 */

	@Column(name ="ROOM_FLOOR",nullable=true,length=32)
	public java.lang.String getRoomFloor(){
		return this.roomFloor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼层数
	 */
	public void setRoomFloor(java.lang.String roomFloor){
		this.roomFloor = roomFloor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  权属类型
	 */

	@Column(name ="RIGHT_TYPE",nullable=true,length=32)
	public java.lang.String getRightType(){
		return this.rightType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  权属类型
	 */
	public void setRightType(java.lang.String rightType){
		this.rightType = rightType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */

	@Column(name ="ROOM_ADDRESS",nullable=true,length=32)
	public java.lang.String getRoomAddress(){
		return this.roomAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setRoomAddress(java.lang.String roomAddress){
		this.roomAddress = roomAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单元号
	 */

	@Column(name ="ROOM_UNITY",nullable=true,length=32)
	public java.lang.String getRoomUnity(){
		return this.roomUnity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单元号
	 */
	public void setRoomUnity(java.lang.String roomUnity){
		this.roomUnity = roomUnity;
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
	 *@return: java.lang.String  朝向
	 */

	@Column(name ="ROOM_TOWARD",nullable=true,length=32)
	public java.lang.String getRoomToward(){
		return this.roomToward;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  朝向
	 */
	public void setRoomToward(java.lang.String roomToward){
		this.roomToward = roomToward;
	}
}