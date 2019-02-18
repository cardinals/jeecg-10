package com.jeecg.wuyesfgl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 费用收取主表
 * @author onlineGenerator
 * @date 2018-04-10 10:01:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_sfgl_fysqzb", schema = "")
@SuppressWarnings("serial")
public class WuyeSfglFysqzbEntity implements java.io.Serializable {
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
		
	private java.lang.String fwwxxid;
	/**房间id*/
    @Excel(name="房间id",width=15)
		
	private java.lang.Long fjid;
	/**业主主键*/
    @Excel(name="业主主键",width=15)
		
	private java.lang.String fwyzxxid;
	/**业主名称*/
    @Excel(name="业主名称",width=15)
		
	private java.lang.String yzmc;
	/**计费年度*/
    @Excel(name="计费年度",width=15)
		
	private java.lang.String jfnd;
	/**计费月份*/
    @Excel(name="计费月份",width=15)
		
	private java.lang.String jfyf;
	/**收据号*/
    @Excel(name="收据号",width=15)
		
	private java.lang.String sjh;
	/**费用类型*/
    @Excel(name="费用类型",width=15,dicCode="fylx")
		
	private java.lang.String fylx;
	/**交费方式*/
    @Excel(name="交费方式",width=15,dicCode="skfs")
		
	private java.lang.String jffs;
	/**应收金额*/
    @Excel(name="应收金额",width=15)
		
	private java.lang.Double ysje;
	/**抹零金额*/
    @Excel(name="抹零金额",width=15)
		
	private java.lang.Double mlje;
	/**滞纳金*/
    @Excel(name="滞纳金",width=15)
		
	private java.lang.Double znj;
	/**实收金额*/
    @Excel(name="实收金额",width=15)
		
	private java.lang.Double ssje;
	/**客付金额*/
    @Excel(name="客付金额",width=15)
		
	private java.lang.Double skje;
	/**找零金额*/
    @Excel(name="找零金额",width=15)
		
	private java.lang.Double zlje;
	/**收费人员*/
    @Excel(name="收费人员",width=15)
		
	private java.lang.String sfry;
	/**收费时间*/
    @Excel(name="收费时间",width=15,format = "yyyy-MM-dd")
		
	private java.util.Date sfsj;
	/**开票方式*/
    @Excel(name="开票方式",width=15)
		
	private java.lang.String kpfs;
	/**备注*/
    @Excel(name="备注",width=15)
		
	private java.lang.String bz;
    
    /**交易号*/
    @Excel(name="交易号",width=15)
		
	private java.lang.String jyh;
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
	@Column(name ="FWWXXID",nullable=true,length=36)
	public java.lang.String getFwwxxid(){
		return this.fwwxxid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  房屋主键
	 */
	public void setFwwxxid(java.lang.String fwwxxid){
		this.fwwxxid = fwwxxid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  房间id
	 */
	@Column(name ="FJID",nullable=true,length=20)
	public java.lang.Long getFjid(){
		return this.fjid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  房间id
	 */
	public void setFjid(java.lang.Long fjid){
		this.fjid = fjid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业主主键
	 */
	@Column(name ="FWYZXXID",nullable=true,length=36)
	public java.lang.String getFwyzxxid(){
		return this.fwyzxxid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业主主键
	 */
	public void setFwyzxxid(java.lang.String fwyzxxid){
		this.fwyzxxid = fwyzxxid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业主名称
	 */
	@Column(name ="YZMC",nullable=true,length=100)
	public java.lang.String getYzmc(){
		return this.yzmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业主名称
	 */
	public void setYzmc(java.lang.String yzmc){
		this.yzmc = yzmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费年度
	 */
	@Column(name ="JFND",nullable=true,length=10)
	public java.lang.String getJfnd(){
		return this.jfnd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费年度
	 */
	public void setJfnd(java.lang.String jfnd){
		this.jfnd = jfnd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费月份
	 */
	@Column(name ="JFYF",nullable=true,length=10)
	public java.lang.String getJfyf(){
		return this.jfyf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费月份
	 */
	public void setJfyf(java.lang.String jfyf){
		this.jfyf = jfyf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收据号
	 */
	@Column(name ="SJH",nullable=true,length=10)
	public java.lang.String getSjh(){
		return this.sjh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收据号
	 */
	public void setSjh(java.lang.String sjh){
		this.sjh = sjh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用类型
	 */
	@Column(name ="FYLX",nullable=true,length=32)
	public java.lang.String getFylx(){
		return this.fylx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用类型
	 */
	public void setFylx(java.lang.String fylx){
		this.fylx = fylx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交费方式
	 */
	@Column(name ="JFFS",nullable=true,length=10)
	public java.lang.String getJffs(){
		return this.jffs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交费方式
	 */
	public void setJffs(java.lang.String jffs){
		this.jffs = jffs;
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
	 *@return: java.lang.Double  抹零金额
	 */
	@Column(name ="MLJE",nullable=true,length=32)
	public java.lang.Double getMlje(){
		return this.mlje;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  抹零金额
	 */
	public void setMlje(java.lang.Double mlje){
		this.mlje = mlje;
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
	 *@return: java.lang.Double  客付金额
	 */
	@Column(name ="SKJE",nullable=true,length=32)
	public java.lang.Double getSkje(){
		return this.skje;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  客付金额
	 */
	public void setSkje(java.lang.Double skje){
		this.skje = skje;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  找零金额
	 */
	@Column(name ="ZLJE",nullable=true,length=32)
	public java.lang.Double getZlje(){
		return this.zlje;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  找零金额
	 */
	public void setZlje(java.lang.Double zlje){
		this.zlje = zlje;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收费人员
	 */
	@Column(name ="SFRY",nullable=true,length=32)
	public java.lang.String getSfry(){
		return this.sfry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收费人员
	 */
	public void setSfry(java.lang.String sfry){
		this.sfry = sfry;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收费时间
	 */
	@Column(name ="SFSJ",nullable=true,length=20)
	public java.util.Date getSfsj(){
		return this.sfsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收费时间
	 */
	public void setSfsj(java.util.Date sfsj){
		this.sfsj = sfsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开票方式
	 */
	@Column(name ="KPFS",nullable=true,length=300)
	public java.lang.String getKpfs(){
		return this.kpfs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开票方式
	 */
	public void setKpfs(java.lang.String kpfs){
		this.kpfs = kpfs;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交易号
	 */
	@Column(name ="JYH",nullable=true,length=32)
	public java.lang.String getJyh(){
		return this.jyh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交易号
	 */
	public void setJyh(java.lang.String jyh){
		this.jyh = jyh;
	}
}
