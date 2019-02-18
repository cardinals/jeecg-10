package com.jeecg.wuyeyzgl.entity;

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
 * @Description: 房屋业主信息
 * @author onlineGenerator
 * @date 2018-03-12 16:02:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_yzgl_fwyzxx", schema = "")
@SuppressWarnings("serial")
public class WuyeYzglFwyzxxEntity implements java.io.Serializable {
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
	/**管理区id*/
    @Excel(name="管理区id",width=15)
		
	private java.lang.String glqid;
	/**房屋主键*/
    @Excel(name="房屋主键",width=15)
		
	private java.lang.String fwxxid;
	/**房间ID*/
    @Excel(name="房间ID",width=15)
		
	private java.lang.Integer fjid;
	/**业主编码*/
    @Excel(name="业主编码",width=15)
		
	private java.lang.String yzBm;
	/**业主属性*/
    @Excel(name="业主属性",width=15)
		
	private java.lang.String yzSx;
	/**业主类型*/
    @Excel(name="业主类型",width=15)
		
	private java.lang.String yzLx;
	/**业主名称*/
    @Excel(name="业主名称",width=15)
		
	private java.lang.String yzMc;
	/**联系人*/
    @Excel(name="联系人",width=15)
		
	private java.lang.String yzLxr;
	/**性别*/
    @Excel(name="性别",width=15)
		
	private java.lang.String yzXb;
	/**出生日期*/
    @Excel(name="出生日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date yzCsrq;
	/**身份证号*/
    @Excel(name="身份证号",width=15)
		
	private java.lang.String yzSfzh;
	/**工作单位*/
    @Excel(name="工作单位",width=15)
		
	private java.lang.String yzGzdw;
	/**座机号*/
    @Excel(name="座机号",width=15)
		
	private java.lang.String yzZuoj;
	/**手机号*/
    @Excel(name="手机号",width=15)
		
	private java.lang.String yzShouj;
	/**传真号*/
    @Excel(name="传真号",width=15)
		
	private java.lang.String yzChuanz;
	/**业主现状*/
    @Excel(name="业主现状",width=15)
		
	private java.lang.String yzXz;
	/**代扣人姓名*/
    @Excel(name="代扣人姓名",width=15)
		
	private java.lang.String dkrXm;
	/**代扣人工作单位*/
    @Excel(name="代扣人工作单位",width=15)
		
	private java.lang.String dkrGzdw;
	/**代扣方式*/
    @Excel(name="代扣方式",width=15)
		
	private java.lang.String dkrDkfs;
	/**代扣银行*/
    @Excel(name="代扣银行",width=15)
		
	private java.lang.String dkrDkyh;
	/**代扣银行账号*/
    @Excel(name="代扣银行账号",width=15)
		
	private java.lang.String dkrDkyhzh;
	/**代扣单位*/
    @Excel(name="代扣单位",width=15)
		
	private java.lang.String dkrDkdw;
	/**代扣单位工号*/
    @Excel(name="代扣单位工号",width=15)
		
	private java.lang.String dkrDkdwgh;
	/**代扣人联系电话*/
    @Excel(name="代扣人联系电话",width=15)
		
	private java.lang.String dkrLxdh;
	/**代扣人现状*/
    @Excel(name="代扣人现状",width=15)
		
	private java.lang.String dkrXz;
	/**担保人姓名*/
    @Excel(name="担保人姓名",width=15)
		
	private java.lang.String dbrXm;
	/**担保人单位*/
    @Excel(name="担保人单位",width=15)
		
	private java.lang.String dbrDw;
	/**担保人工号*/
    @Excel(name="担保人工号",width=15)
		
	private java.lang.String dbrGh;
	/**担保人联系电话*/
    @Excel(name="担保人联系电话",width=15)
		
	private java.lang.String dbrLxdh;
	/**是否减免*/
    @Excel(name="是否减免",width=15)
		
	private java.lang.String sfjm;
	/**减免原因*/
    @Excel(name="减免原因",width=15)
		
	private java.lang.String jmyy;
	/**收费开始日期*/
    @Excel(name="收费开始日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date sfksrq;
	/**收费截止日期*/
    @Excel(name="收费截止日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date sfjzrq;
	/**备注*/
    @Excel(name="备注",width=15)
		
	private java.lang.String bz;
	/**有效标志*/
    @Excel(name="有效标志",width=15)
		
	private java.lang.String yxbz;
    /**租赁费*/
		
	private java.lang.String zlf;
	
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
	 *@return: java.lang.Integer  房间ID
	 */
	@Column(name ="FJID",nullable=true)
	public java.lang.Integer getFjid(){
		return this.fjid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  房间ID
	 */
	public void setFjid(java.lang.Integer fjid){
		this.fjid = fjid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业主编码
	 */
	@Column(name ="YZ_BM",nullable=true,length=32)
	public java.lang.String getYzBm(){
		return this.yzBm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业主编码
	 */
	public void setYzBm(java.lang.String yzBm){
		this.yzBm = yzBm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业主属性
	 */
	@Column(name ="YZ_SX",nullable=true,length=32)
	public java.lang.String getYzSx(){
		return this.yzSx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业主属性
	 */
	public void setYzSx(java.lang.String yzSx){
		this.yzSx = yzSx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业主类型
	 */
	@Column(name ="YZ_LX",nullable=true,length=32)
	public java.lang.String getYzLx(){
		return this.yzLx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业主类型
	 */
	public void setYzLx(java.lang.String yzLx){
		this.yzLx = yzLx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业主名称
	 */
	@Column(name ="YZ_MC",nullable=true,length=32)
	public java.lang.String getYzMc(){
		return this.yzMc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业主名称
	 */
	public void setYzMc(java.lang.String yzMc){
		this.yzMc = yzMc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */
	@Column(name ="YZ_LXR",nullable=true,length=32)
	public java.lang.String getYzLxr(){
		return this.yzLxr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setYzLxr(java.lang.String yzLxr){
		this.yzLxr = yzLxr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="YZ_XB",nullable=true,length=32)
	public java.lang.String getYzXb(){
		return this.yzXb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setYzXb(java.lang.String yzXb){
		this.yzXb = yzXb;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生日期
	 */
	@Column(name ="YZ_CSRQ",nullable=true)
	public java.util.Date getYzCsrq(){
		return this.yzCsrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生日期
	 */
	public void setYzCsrq(java.util.Date yzCsrq){
		this.yzCsrq = yzCsrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="YZ_SFZH",nullable=true,length=32)
	public java.lang.String getYzSfzh(){
		return this.yzSfzh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setYzSfzh(java.lang.String yzSfzh){
		this.yzSfzh = yzSfzh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作单位
	 */
	@Column(name ="YZ_GZDW",nullable=true,length=32)
	public java.lang.String getYzGzdw(){
		return this.yzGzdw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作单位
	 */
	public void setYzGzdw(java.lang.String yzGzdw){
		this.yzGzdw = yzGzdw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  座机号
	 */
	@Column(name ="YZ_ZUOJ",nullable=true,length=32)
	public java.lang.String getYzZuoj(){
		return this.yzZuoj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  座机号
	 */
	public void setYzZuoj(java.lang.String yzZuoj){
		this.yzZuoj = yzZuoj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号
	 */
	@Column(name ="YZ_SHOUJ",nullable=true,length=32)
	public java.lang.String getYzShouj(){
		return this.yzShouj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号
	 */
	public void setYzShouj(java.lang.String yzShouj){
		this.yzShouj = yzShouj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  传真号
	 */
	@Column(name ="YZ_CHUANZ",nullable=true,length=32)
	public java.lang.String getYzChuanz(){
		return this.yzChuanz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  传真号
	 */
	public void setYzChuanz(java.lang.String yzChuanz){
		this.yzChuanz = yzChuanz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业主现状
	 */
	@Column(name ="YZ_XZ",nullable=true,length=32)
	public java.lang.String getYzXz(){
		return this.yzXz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业主现状
	 */
	public void setYzXz(java.lang.String yzXz){
		this.yzXz = yzXz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣人姓名
	 */
	@Column(name ="DKR_XM",nullable=true,length=62)
	public java.lang.String getDkrXm(){
		return this.dkrXm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣人姓名
	 */
	public void setDkrXm(java.lang.String dkrXm){
		this.dkrXm = dkrXm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣人工作单位
	 */
	@Column(name ="DKR_GZDW",nullable=true,length=62)
	public java.lang.String getDkrGzdw(){
		return this.dkrGzdw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣人工作单位
	 */
	public void setDkrGzdw(java.lang.String dkrGzdw){
		this.dkrGzdw = dkrGzdw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣方式
	 */
	@Column(name ="DKR_DKFS",nullable=true,length=32)
	public java.lang.String getDkrDkfs(){
		return this.dkrDkfs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣方式
	 */
	public void setDkrDkfs(java.lang.String dkrDkfs){
		this.dkrDkfs = dkrDkfs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣银行
	 */
	@Column(name ="DKR_DKYH",nullable=true,length=32)
	public java.lang.String getDkrDkyh(){
		return this.dkrDkyh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣银行
	 */
	public void setDkrDkyh(java.lang.String dkrDkyh){
		this.dkrDkyh = dkrDkyh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣银行账号
	 */
	@Column(name ="DKR_DKYHZH",nullable=true,length=32)
	public java.lang.String getDkrDkyhzh(){
		return this.dkrDkyhzh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣银行账号
	 */
	public void setDkrDkyhzh(java.lang.String dkrDkyhzh){
		this.dkrDkyhzh = dkrDkyhzh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣单位
	 */
	@Column(name ="DKR_DKDW",nullable=true,length=32)
	public java.lang.String getDkrDkdw(){
		return this.dkrDkdw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣单位
	 */
	public void setDkrDkdw(java.lang.String dkrDkdw){
		this.dkrDkdw = dkrDkdw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣单位工号
	 */
	@Column(name ="DKR_DKDWGH",nullable=true,length=32)
	public java.lang.String getDkrDkdwgh(){
		return this.dkrDkdwgh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣单位工号
	 */
	public void setDkrDkdwgh(java.lang.String dkrDkdwgh){
		this.dkrDkdwgh = dkrDkdwgh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣人联系电话
	 */
	@Column(name ="DKR_LXDH",nullable=true,length=32)
	public java.lang.String getDkrLxdh(){
		return this.dkrLxdh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣人联系电话
	 */
	public void setDkrLxdh(java.lang.String dkrLxdh){
		this.dkrLxdh = dkrLxdh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代扣人现状
	 */
	@Column(name ="DKR_XZ",nullable=true,length=32)
	public java.lang.String getDkrXz(){
		return this.dkrXz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代扣人现状
	 */
	public void setDkrXz(java.lang.String dkrXz){
		this.dkrXz = dkrXz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  担保人姓名
	 */
	@Column(name ="DBR_XM",nullable=true,length=32)
	public java.lang.String getDbrXm(){
		return this.dbrXm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  担保人姓名
	 */
	public void setDbrXm(java.lang.String dbrXm){
		this.dbrXm = dbrXm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  担保人单位
	 */
	@Column(name ="DBR_DW",nullable=true,length=32)
	public java.lang.String getDbrDw(){
		return this.dbrDw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  担保人单位
	 */
	public void setDbrDw(java.lang.String dbrDw){
		this.dbrDw = dbrDw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  担保人工号
	 */
	@Column(name ="DBR_GH",nullable=true,length=32)
	public java.lang.String getDbrGh(){
		return this.dbrGh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  担保人工号
	 */
	public void setDbrGh(java.lang.String dbrGh){
		this.dbrGh = dbrGh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  担保人联系电话
	 */
	@Column(name ="DBR_LXDH",nullable=true,length=32)
	public java.lang.String getDbrLxdh(){
		return this.dbrLxdh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  担保人联系电话
	 */
	public void setDbrLxdh(java.lang.String dbrLxdh){
		this.dbrLxdh = dbrLxdh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否减免
	 */
	@Column(name ="SFJM",nullable=true,length=32)
	public java.lang.String getSfjm(){
		return this.sfjm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否减免
	 */
	public void setSfjm(java.lang.String sfjm){
		this.sfjm = sfjm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  减免原因
	 */
	@Column(name ="JMYY",nullable=true,length=320)
	public java.lang.String getJmyy(){
		return this.jmyy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  减免原因
	 */
	public void setJmyy(java.lang.String jmyy){
		this.jmyy = jmyy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收费开始日期
	 */
	@Column(name ="SFKSRQ",nullable=true)
	public java.util.Date getSfksrq(){
		return this.sfksrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收费开始日期
	 */
	public void setSfksrq(java.util.Date sfksrq){
		this.sfksrq = sfksrq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收费截止日期
	 */
	@Column(name ="SFJZRQ",nullable=true)
	public java.util.Date getSfjzrq(){
		return this.sfjzrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收费截止日期
	 */
	public void setSfjzrq(java.util.Date sfjzrq){
		this.sfjzrq = sfjzrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BZ",nullable=true,length=320)
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
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  租赁费
	 */
	public java.lang.String getZlf() {
		return zlf;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  租赁费
	 */
	public void setZlf(java.lang.String zlf) {
		this.zlf = zlf;
	}
	
	
}
