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
 * @Description: 房屋迁入管理
 * @author onlineGenerator
 * @date 2018-03-14 16:35:06
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_yzgl_fwqrgl", schema = "")
@SuppressWarnings("serial")
public class WuyeYzglFwqrglEntity implements java.io.Serializable {
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
	/**楼宇id*/
    @Excel(name="楼宇id",width=15)
		
	private java.lang.String lyid;
	/**房屋主键*/
    @Excel(name="房屋主键",width=15)
		
	private java.lang.String fwxxid;
	/**迁入房间id*/
    @Excel(name="迁入房间id",width=15)
		
	private java.lang.Integer fjid;
	/**迁入房间编号*/
    @Excel(name="迁入房间编号",width=15)
		
	private java.lang.String fjbh;
	/**入住日期*/
    @Excel(name="入住日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date rzrq;
	/**收费服务对象*/
    @Excel(name="收费服务对象",width=15,dicCode="sfdx")
		
	private java.lang.String sffwdx;
	/**客户ID*/
    @Excel(name="客户ID",width=15)
		
	private java.lang.String khid;
	/**客户姓名*/
    @Excel(name="客户姓名",width=15)
		
	private java.lang.String khxm;
	/**联系电话*/
    @Excel(name="联系电话",width=15)
		
	private java.lang.String lxdh;
	/**迁入后房间状态*/
    @Excel(name="迁入后房间状态",width=15,dicCode="fwzt")
		
	private java.lang.String qrhfjzt;
	/**收费开始日期*/
    @Excel(name="收费开始日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date sfksrq;
	/**收费结束日期*/
    @Excel(name="收费结束日期",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date sfjsrq;
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
	 *@return: java.lang.String  楼宇id
	 */
	@Column(name ="LYID",nullable=true,length=32)
	public java.lang.String getLyid(){
		return this.lyid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼宇id
	 */
	public void setLyid(java.lang.String lyid){
		this.lyid = lyid;
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
	 *@return: java.lang.Integer  迁入房间id
	 */
	@Column(name ="FJID",nullable=true,length=32)
	public java.lang.Integer getFjid(){
		return this.fjid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  迁入房间id
	 */
	public void setFjid(java.lang.Integer fjid){
		this.fjid = fjid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  迁入房间编号
	 */
	@Column(name ="FJBH",nullable=true,length=32)
	public java.lang.String getFjbh(){
		return this.fjbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  迁入房间编号
	 */
	public void setFjbh(java.lang.String fjbh){
		this.fjbh = fjbh;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入住日期
	 */
	@Column(name ="RZRQ",nullable=true,length=32)
	public java.util.Date getRzrq(){
		return this.rzrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入住日期
	 */
	public void setRzrq(java.util.Date rzrq){
		this.rzrq = rzrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费服务对象
	 */
	@Column(name ="SFFWDX",nullable=true,length=10)
	public java.lang.String getSffwdx(){
		return this.sffwdx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费服务对象
	 */
	public void setSffwdx(java.lang.String sffwdx){
		this.sffwdx = sffwdx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户ID
	 */
	@Column(name ="KHID",nullable=true,length=32)
	public java.lang.String getKhid(){
		return this.khid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户ID
	 */
	public void setKhid(java.lang.String khid){
		this.khid = khid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户姓名
	 */
	@Column(name ="KHXM",nullable=true,length=100)
	public java.lang.String getKhxm(){
		return this.khxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户姓名
	 */
	public void setKhxm(java.lang.String khxm){
		this.khxm = khxm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="LXDH",nullable=true,length=20)
	public java.lang.String getLxdh(){
		return this.lxdh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setLxdh(java.lang.String lxdh){
		this.lxdh = lxdh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  迁入后房间状态
	 */
	@Column(name ="QRHFJZT",nullable=true,length=10)
	public java.lang.String getQrhfjzt(){
		return this.qrhfjzt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  迁入后房间状态
	 */
	public void setQrhfjzt(java.lang.String qrhfjzt){
		this.qrhfjzt = qrhfjzt;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收费开始日期
	 */
	@Column(name ="SFKSRQ",nullable=true,length=20)
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
	 *@return: java.util.Date  收费结束日期
	 */
	@Column(name ="SFJSRQ",nullable=true,length=20)
	public java.util.Date getSfjsrq(){
		return this.sfjsrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收费结束日期
	 */
	public void setSfjsrq(java.util.Date sfjsrq){
		this.sfjsrq = sfjsrq;
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
		return "WuyeYzglFwqrglEntity [id=" + id + ", createName=" + createName + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", updateName=" + updateName + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + ", sysOrgCode=" + sysOrgCode + ", sysCompanyCode=" + sysCompanyCode
				+ ", bpmStatus=" + bpmStatus + ", glqid=" + glqid + ", lyid=" + lyid + ", fwxxid=" + fwxxid + ", fjid="
				+ fjid + ", fjbh=" + fjbh + ", rzrq=" + rzrq + ", sffwdx=" + sffwdx + ", khid=" + khid + ", khxm="
				+ khxm + ", lxdh=" + lxdh + ", qrhfjzt=" + qrhfjzt + ", sfksrq=" + sfksrq + ", sfjsrq=" + sfjsrq
				+ ", bz=" + bz + "]";
	}
	
	
}
