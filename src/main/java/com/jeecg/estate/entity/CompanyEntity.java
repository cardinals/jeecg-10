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
 * @Description: 公司表
 * @author onlineGenerator
 * @date 2019-01-21 15:06:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "company", schema = "")
@SuppressWarnings("serial")
public class CompanyEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**物业公司名称*/
	@Excel(name="物业公司名称",width=15)
	private java.lang.String comName;
	/**公司负责人*/
	@Excel(name="公司负责人",width=15)
	private java.lang.String comContact;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private java.lang.String comPhone;
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
	 *@return: java.lang.String  物业公司名称
	 */

	@Column(name ="COM_NAME",nullable=false,length=32)
	public java.lang.String getComName(){
		return this.comName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物业公司名称
	 */
	public void setComName(java.lang.String comName){
		this.comName = comName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司负责人
	 */

	@Column(name ="COM_CONTACT",nullable=true,length=32)
	public java.lang.String getComContact(){
		return this.comContact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司负责人
	 */
	public void setComContact(java.lang.String comContact){
		this.comContact = comContact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="COM_PHONE",nullable=true,length=32)
	public java.lang.String getComPhone(){
		return this.comPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setComPhone(java.lang.String comPhone){
		this.comPhone = comPhone;
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