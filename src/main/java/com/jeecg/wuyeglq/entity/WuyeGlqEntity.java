package com.jeecg.wuyeglq.entity;

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
 * @Description: 物业_管理区表
 * @author onlineGenerator
 * @date 2018-03-07 15:58:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_glq", schema = "")
@SuppressWarnings("serial")
public class WuyeGlqEntity implements java.io.Serializable {
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
	/**管理区名称*/
    @Excel(name="管理区名称",width=15)
		
	private java.lang.String glqmc;
	/**描述*/
    @Excel(name="描述",width=15)
		
	private java.lang.String glqms;
	/**父级id*/

	private java.lang.String fid;
	/**管理区类型*/
    @Excel(name="管理区类型",width=15,dicCode="wuye_glqlx")
		
	private java.lang.String glqlx;
	/**排序号*/
    @Excel(name="排序号",width=15)
		
	private java.lang.String pxh;
	/**有效标志*/
    @Excel(name="有效标志",width=15)
		
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
	 *@return: java.lang.String  管理区名称
	 */
	@Column(name ="GLQMC",nullable=true,length=32)
	public java.lang.String getGlqmc(){
		return this.glqmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理区名称
	 */
	public void setGlqmc(java.lang.String glqmc){
		this.glqmc = glqmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="GLQMS",nullable=true,length=32)
	public java.lang.String getGlqms(){
		return this.glqms;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setGlqms(java.lang.String glqms){
		this.glqms = glqms;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  父级id
	 */
	@Column(name ="FID",nullable=true,length=32)
	public java.lang.String getFid(){
		return this.fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父级id
	 */
	public void setFid(java.lang.String fid){
		this.fid = fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管理区类型
	 */
	@Column(name ="GLQLX",nullable=true,length=32)
	public java.lang.String getGlqlx(){
		return this.glqlx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理区类型
	 */
	public void setGlqlx(java.lang.String glqlx){
		this.glqlx = glqlx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  排序号
	 */
	@Column(name ="PXH",nullable=true,length=32)
	public java.lang.String getPxh(){
		return this.pxh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  排序号
	 */
	public void setPxh(java.lang.String pxh){
		this.pxh = pxh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  有效标志
	 */
	@Column(name ="YXBZ",nullable=true,length=32)
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

	@Override
	public String toString() {
		return "WuyeGlqEntity [id=" + id + ", glqmc=" + glqmc + ", glqms=" + glqms + ", fid=" + fid + ", glqlx=" + glqlx
				+ ", pxh=" + pxh + ", yxbz=" + yxbz + "]";
	}
	
}
