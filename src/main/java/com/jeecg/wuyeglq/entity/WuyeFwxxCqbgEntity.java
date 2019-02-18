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
 * @Description: 房屋产权变更表
 * @author onlineGenerator
 * @date 2018-03-09 15:03:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_fwxx_cqbg", schema = "")
@SuppressWarnings("serial")
public class WuyeFwxxCqbgEntity implements java.io.Serializable {
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
	/**房屋主键*/

	private java.lang.String fwxxid;
	/**房屋所有权人_现*/
    @Excel(name="房屋所有权人_现",width=15)
		
	private java.lang.String fwsyqrXz;
	/**证件类型_现*/
    @Excel(name="证件类型_现",width=15,dicCode="zjlx")
		
	private java.lang.String zjmcXz;
	/**证件号码_现*/
    @Excel(name="证件号码_现",width=15)
		
	private java.lang.String zjhmXz;
	/**房屋所有权人_原*/
    @Excel(name="房屋所有权人_原",width=15)
		
	private java.lang.String fwsyqrYl;
	/**证件类型_原*/
    @Excel(name="证件类型_原",width=15,dicCode="zjlx")
		
	private java.lang.String zjmcYl;
	/**证件号码_原*/
    @Excel(name="证件号码_原",width=15)
		
	private java.lang.String zjhmYl;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋所有权人_现
	 */
	@Column(name ="FWSYQR_XZ",nullable=true,length=60)
	public java.lang.String getFwsyqrXz(){
		return this.fwsyqrXz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋所有权人_现
	 */
	public void setFwsyqrXz(java.lang.String fwsyqrXz){
		this.fwsyqrXz = fwsyqrXz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件类型_现
	 */
	@Column(name ="ZJMC_XZ",nullable=true,length=10)
	public java.lang.String getZjmcXz(){
		return this.zjmcXz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件类型_现
	 */
	public void setZjmcXz(java.lang.String zjmcXz){
		this.zjmcXz = zjmcXz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号码_现
	 */
	@Column(name ="ZJHM_XZ",nullable=true,length=20)
	public java.lang.String getZjhmXz(){
		return this.zjhmXz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码_现
	 */
	public void setZjhmXz(java.lang.String zjhmXz){
		this.zjhmXz = zjhmXz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房屋所有权人_原
	 */
	@Column(name ="FWSYQR_YL",nullable=true,length=60)
	public java.lang.String getFwsyqrYl(){
		return this.fwsyqrYl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋所有权人_原
	 */
	public void setFwsyqrYl(java.lang.String fwsyqrYl){
		this.fwsyqrYl = fwsyqrYl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件类型_原
	 */
	@Column(name ="ZJMC_YL",nullable=true,length=10)
	public java.lang.String getZjmcYl(){
		return this.zjmcYl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件类型_原
	 */
	public void setZjmcYl(java.lang.String zjmcYl){
		this.zjmcYl = zjmcYl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号码_原
	 */
	@Column(name ="ZJHM_YL",nullable=true,length=20)
	public java.lang.String getZjhmYl(){
		return this.zjhmYl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码_原
	 */
	public void setZjhmYl(java.lang.String zjhmYl){
		this.zjhmYl = zjhmYl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BZ",nullable=true,length=300)
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
		return "WuyeFwxxCqbgEntity [id=" + id + ", createName=" + createName + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", updateName=" + updateName + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + ", sysOrgCode=" + sysOrgCode + ", sysCompanyCode=" + sysCompanyCode
				+ ", bpmStatus=" + bpmStatus + ", fwxxid=" + fwxxid + ", fwsyqrXz=" + fwsyqrXz + ", zjmcXz=" + zjmcXz
				+ ", zjhmXz=" + zjhmXz + ", fwsyqrYl=" + fwsyqrYl + ", zjmcYl=" + zjmcYl + ", zjhmYl=" + zjhmYl
				+ ", bz=" + bz + "]";
	}
	
}
