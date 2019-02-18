package com.jeecg.wuyecbgl.entity;

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
 * @Description: 电表抄表记录
 * @author onlineGenerator
 * @date 2018-03-20 14:11:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_cbgl_dbcbjl", schema = "")
@SuppressWarnings("serial")
public class WuyeCbglDbcbjlEntity implements java.io.Serializable {
	/**id*/
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
	/**管理区id*/
	/*@Excel(name="管理区id",width=15)*/
	private java.lang.String glqid;
	/**房屋主键*/
	/*@Excel(name="房屋主键",width=15)*/
	private java.lang.String fwxxid;
	/**房间id*/
	@Excel(name="房间id",width=15)
	private java.lang.Integer fjid;
	/**房间地址*/
	@Excel(name="房间地址",width=15)
	private java.lang.String fjdz;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String xm;
	/**仪表属性*/
	@Excel(name="仪表属性",width=15,dicCode="ybsx")
	private java.lang.String ybsx;
	/**仪表ID*/
	@Excel(name="仪表ID",width=15)
	private java.lang.String ybid;
	/**仪表编号*/
	@Excel(name="仪表编号",width=15)
	private java.lang.Integer ybbh;
	/**上月指数*/
	@Excel(name="上月指数",width=15)
	private java.lang.Double syzs;
	/**本月指数*/
	@Excel(name="本月指数",width=15)
	private java.lang.Double byzs;
	/**倍率*/
	@Excel(name="倍率",width=15)
	private java.lang.Double bl;
	/**本月流量*/
	@Excel(name="本月流量",width=15)
	private java.lang.Double byyl;
	/**换表用量*/
	@Excel(name="换表用量",width=15)
	private java.lang.Double hbyl;
	/**公摊量*/
	@Excel(name="公摊量",width=15)
	private java.lang.Double gtl;
	/**实际用量*/
	@Excel(name="实际用量",width=15)
	private java.lang.Double sjyl;
	/**抄表人*/
	@Excel(name="抄表人",width=15)
	private java.lang.String cbr;
	/**抄表时间*/
	@Excel(name="抄表时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date cbsj;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String bz;
	/**计费起始日期*/
	/*@Excel(name="计费起始日期",width=15,format = "yyyy-MM-dd")*/
	private java.util.Date jfqsrq;
	/**计费结束日期*/
	/*@Excel(name="计费结束日期",width=15,format = "yyyy-MM-dd")*/
	private java.util.Date jfjsrq;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
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

	@Column(name ="CREATE_DATE",nullable=true)
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

	@Column(name ="UPDATE_DATE",nullable=true)
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
	 *@return: java.lang.String  管理区id
	 */

	@Column(name ="GLQID",nullable=true,length=32)
	public java.lang.String getGlqid(){
		return this.glqid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理区id
	 */
	public void setGlqid(java.lang.String glqid){
		this.glqid = glqid;
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
	 *@return: java.lang.Integer  房间id
	 */

	@Column(name ="FJID",nullable=true,length=10)
	public java.lang.Integer getFjid(){
		return this.fjid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  房间id
	 */
	public void setFjid(java.lang.Integer fjid){
		this.fjid = fjid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  房间地址
	 */

	@Column(name ="FJDZ",nullable=true,length=200)
	public java.lang.String getFjdz(){
		return this.fjdz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房间地址
	 */
	public void setFjdz(java.lang.String fjdz){
		this.fjdz = fjdz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="XM",nullable=true,length=10)
	public java.lang.String getXm(){
		return this.xm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setXm(java.lang.String xm){
		this.xm = xm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仪表属性
	 */

	@Column(name ="YBSX",nullable=true,length=10)
	public java.lang.String getYbsx(){
		return this.ybsx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仪表属性
	 */
	public void setYbsx(java.lang.String ybsx){
		this.ybsx = ybsx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仪表ID
	 */

	@Column(name ="YBID",nullable=true,length=32)
	public java.lang.String getYbid(){
		return this.ybid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仪表ID
	 */
	public void setYbid(java.lang.String ybid){
		this.ybid = ybid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  仪表编号
	 */

	@Column(name ="YBBH",nullable=true,length=10)
	public java.lang.Integer getYbbh(){
		return this.ybbh;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  仪表编号
	 */
	public void setYbbh(java.lang.Integer ybbh){
		this.ybbh = ybbh;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  上月指数
	 */

	@Column(name ="SYZS",nullable=true,length=22)
	public java.lang.Double getSyzs(){
		return this.syzs;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  上月指数
	 */
	public void setSyzs(java.lang.Double syzs){
		this.syzs = syzs;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  本月指数
	 */

	@Column(name ="BYZS",nullable=true,length=22)
	public java.lang.Double getByzs(){
		return this.byzs;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  本月指数
	 */
	public void setByzs(java.lang.Double byzs){
		this.byzs = byzs;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  倍率
	 */

	@Column(name ="BL",nullable=true,length=22)
	public java.lang.Double getBl(){
		return this.bl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  倍率
	 */
	public void setBl(java.lang.Double bl){
		this.bl = bl;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  本月流量
	 */

	@Column(name ="BYYL",nullable=true,length=22)
	public java.lang.Double getByyl(){
		return this.byyl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  本月流量
	 */
	public void setByyl(java.lang.Double byyl){
		this.byyl = byyl;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  换表用量
	 */

	@Column(name ="HBYL",nullable=true,length=22)
	public java.lang.Double getHbyl(){
		return this.hbyl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  换表用量
	 */
	public void setHbyl(java.lang.Double hbyl){
		this.hbyl = hbyl;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公摊量
	 */

	@Column(name ="GTL",nullable=true,length=22)
	public java.lang.Double getGtl(){
		return this.gtl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公摊量
	 */
	public void setGtl(java.lang.Double gtl){
		this.gtl = gtl;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实际用量
	 */

	@Column(name ="SJYL",nullable=true,length=22)
	public java.lang.Double getSjyl(){
		return this.sjyl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际用量
	 */
	public void setSjyl(java.lang.Double sjyl){
		this.sjyl = sjyl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  抄表人
	 */

	@Column(name ="CBR",nullable=true,length=60)
	public java.lang.String getCbr(){
		return this.cbr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  抄表人
	 */
	public void setCbr(java.lang.String cbr){
		this.cbr = cbr;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  抄表时间
	 */

	@Column(name ="CBSJ",nullable=true)
	public java.util.Date getCbsj(){
		return this.cbsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  抄表时间
	 */
	public void setCbsj(java.util.Date cbsj){
		this.cbsj = cbsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="BZ",nullable=true,length=32)
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
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计费起始日期
	 */

	@Column(name ="JFQSRQ",nullable=true)
	public java.util.Date getJfqsrq(){
		return this.jfqsrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计费起始日期
	 */
	public void setJfqsrq(java.util.Date jfqsrq){
		this.jfqsrq = jfqsrq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计费结束日期
	 */

	@Column(name ="JFJSRQ",nullable=true)
	public java.util.Date getJfjsrq(){
		return this.jfjsrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计费结束日期
	 */
	public void setJfjsrq(java.util.Date jfjsrq){
		this.jfjsrq = jfjsrq;
	}
}
