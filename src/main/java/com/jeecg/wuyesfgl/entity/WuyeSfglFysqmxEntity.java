package com.jeecg.wuyesfgl.entity;


import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 费用收取明细
 * @author onlineGenerator
 * @date 2018-04-10 16:52:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_sfgl_fysqmx", schema = "")
@SuppressWarnings("serial")
public class WuyeSfglFysqmxEntity implements java.io.Serializable {
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
	/**收费主表id*/
    @Excel(name="收费主表id",width=15)
		
	private java.lang.String sfzbid;
	/**应收费用记录id*/
    @Excel(name="应收费用记录id",width=15)
		
	private java.lang.String ysfyjlid;
	/**应收类型*/
    @Excel(name="应收类型",width=15,dicCode="yslx")
		
	private java.lang.String sflx;
	/**收费状态*/
    @Excel(name="收费状态",width=15,dicCode="sfzt")
		
	private java.lang.String sfzt;
	/**收费项目代码*/
    @Excel(name="收费项目代码",width=15)
		
	private java.lang.String sfxmdm;
	/**收费项目名称*/
    @Excel(name="收费项目名称",width=15)
		
	private java.lang.String sfxmmc;
	/**计费起始时间*/
    @Excel(name="计费起始时间",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date jfqssj;
	/**计费截止时间*/
    @Excel(name="计费截止时间",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date jfjzsj;
	/**数量*/
    @Excel(name="数量",width=15)
		
	private java.lang.Double sl;
	/**价格*/
    @Excel(name="价格",width=15)
		
	private java.lang.Double jg;
	/**应收金额*/
    @Excel(name="应收金额",width=15)
		
	private java.lang.Double ysje;
	/**实收金额*/
    @Excel(name="实收金额",width=15)
		
	private java.lang.Double ssje;
	/**滞纳金*/
    @Excel(name="滞纳金",width=15)
		
	private java.lang.Double znj;
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
	@Column(name ="GLQID",nullable=true,length=36)
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
	 *@return: java.lang.String  收费主表id
	 */
	@Column(name ="SFZBID",nullable=true,length=36)
	public java.lang.String getSfzbid(){
		return this.sfzbid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费主表id
	 */
	public void setSfzbid(java.lang.String sfzbid){
		this.sfzbid = sfzbid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应收费用记录id
	 */
	@Column(name ="YSFYJLID",nullable=true,length=36)
	public java.lang.String getYsfyjlid(){
		return this.ysfyjlid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应收费用记录id
	 */
	public void setYsfyjlid(java.lang.String ysfyjlid){
		this.ysfyjlid = ysfyjlid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应收类型
	 */
	@Column(name ="SFLX",nullable=true,length=10)
	public java.lang.String getSflx(){
		return this.sflx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应收类型
	 */
	public void setSflx(java.lang.String sflx){
		this.sflx = sflx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费状态
	 */
	@Column(name ="SFZT",nullable=true,length=10)
	public java.lang.String getSfzt(){
		return this.sfzt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费状态
	 */
	public void setSfzt(java.lang.String sfzt){
		this.sfzt = sfzt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费项目代码
	 */
	@Column(name ="SFXMDM",nullable=true,length=10)
	public java.lang.String getSfxmdm(){
		return this.sfxmdm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费项目代码
	 */
	public void setSfxmdm(java.lang.String sfxmdm){
		this.sfxmdm = sfxmdm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费项目名称
	 */
	@Column(name ="SFXMMC",nullable=true,length=30)
	public java.lang.String getSfxmmc(){
		return this.sfxmmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费项目名称
	 */
	public void setSfxmmc(java.lang.String sfxmmc){
		this.sfxmmc = sfxmmc;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计费起始时间
	 */
	@Column(name ="JFQSSJ",nullable=true,length=32)
	public java.util.Date getJfqssj(){
		return this.jfqssj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计费起始时间
	 */
	public void setJfqssj(java.util.Date jfqssj){
		this.jfqssj = jfqssj;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  计费截止时间
	 */
	@Column(name ="JFJZSJ",nullable=true,length=32)
	public java.util.Date getJfjzsj(){
		return this.jfjzsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  计费截止时间
	 */
	public void setJfjzsj(java.util.Date jfjzsj){
		this.jfjzsj = jfjzsj;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  数量
	 */
	@Column(name ="SL",nullable=true,length=32)
	public java.lang.Double getSl(){
		return this.sl;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  数量
	 */
	public void setSl(java.lang.Double sl){
		this.sl = sl;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  价格
	 */
	@Column(name ="JG",nullable=true,length=32)
	public java.lang.Double getJg(){
		return this.jg;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  价格
	 */
	public void setJg(java.lang.Double jg){
		this.jg = jg;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  应收金额
	 */
	@Column(name ="YSJE",nullable=true,length=32)
	public java.lang.Double getYsje(){
		return this.ysje;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  应收金额
	 */
	public void setYsje(java.lang.Double ysje){
		this.ysje = ysje;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实收金额
	 */
	@Column(name ="SSJE",nullable=true,length=32)
	public java.lang.Double getSsje(){
		return this.ssje;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实收金额
	 */
	public void setSsje(java.lang.Double ssje){
		this.ssje = ssje;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  滞纳金
	 */
	@Column(name ="ZNJ",nullable=true,length=32)
	public java.lang.Double getZnj(){
		return this.znj;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  滞纳金
	 */
	public void setZnj(java.lang.Double znj){
		this.znj = znj;
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

}
