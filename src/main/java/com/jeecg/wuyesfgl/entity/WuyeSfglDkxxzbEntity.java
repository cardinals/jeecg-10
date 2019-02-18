package com.jeecg.wuyesfgl.entity;

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
 * @Description: 代扣信息主表
 * @author onlineGenerator
 * @date 2018-04-07 21:10:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wuye_sfgl_dkxxzb", schema = "")
@SuppressWarnings("serial")
public class WuyeSfglDkxxzbEntity implements java.io.Serializable {
	/**主键*/

	private java.lang.String id;
	
	/**年份*/
    @Excel(name="年份",width=15)
		
	private java.lang.String year;
	/**月份*/
    @Excel(name="月份",width=15)
		
	private java.lang.String month;
	/**银行编码*/
    @Excel(name="银行编码",width=15)
		
	private java.lang.String yhbm;
	
    /**是否已经导入*/
    private String sfyjdr;
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
	 *@return: java.lang.String  年份
	 */
	@Column(name ="YEAR",nullable=true,length=22)
	public java.lang.String getYear(){
		return this.year;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年份
	 */
	public void setYear(java.lang.String year){
		this.year = year;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  月份
	 */
	@Column(name ="MONTH",nullable=true,length=22)
	public java.lang.String getMonth(){
		return this.month;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  月份
	 */
	public void setMonth(java.lang.String month){
		this.month = month;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  银行编码
	 */
	@Column(name ="YHBM",nullable=true,length=22)
	public java.lang.String getYhbm(){
		return this.yhbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  银行编码
	 */
	public void setYhbm(java.lang.String yhbm){
		this.yhbm = yhbm;
	}

	public String getSfyjdr() {
		return sfyjdr;
	}

	public void setSfyjdr(String sfyjdr) {
		this.sfyjdr = sfyjdr;
	}

	@Override
	public String toString() {
		return "WuyeSfglDkxxzbEntity [id=" + id + ", year=" + year + ", month=" + month + ", yhbm=" + yhbm + ", sfyjdr="
				+ sfyjdr + "]";
	}
	
}
