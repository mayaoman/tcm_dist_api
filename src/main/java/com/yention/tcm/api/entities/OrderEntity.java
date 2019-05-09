package com.yention.tcm.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/** 
 * @Package com.yention.tcm.api.entities
 * @ClassName: OrderEntity
 * @Description: 订单实体类
 * @author 孙刚
 * @date 2019年4月26日 下午2:40:37
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "orderId") 
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer"})
@Table(name="tcm_order")
public class OrderEntity {
	/**
	 * 订单编号
	 */
	@Id
	@Column(length=20)
	private String orderId; 
	/**
	 * 用户ID
	 */
	@Column(length=20)
	private String userId;
	/**
	 * 就诊人ID
	 */
//	@Column(length=20)
//	private String patientId;
	@OneToOne
	@JoinColumn(name = "patientId")
	private PatientEntity patient;
	/**
	 * 诊断信息
	 */
	@Column(length=128)
	private String diagnose;
	/**
	 * 订单状态
	 */
	@Column(length=20)
	private String status;
	/**
	 * 订单名称
	 */
	@Column(length=128)
	private String orderName;
	/**
	 * 问诊医师
	 */
//	@Column(length=20)
//	private String doctorId;
	@ManyToOne
	@JoinColumn(name="doctorId")
	private DoctorEntity doctor;
	/**
	 * 下单时间
	 */
	@Column(length=20)
	private String createTime;
	/**
	 * 商品单价
	 */
	@Column(length=20)
	private String unitPrice;
	/**
	 * 商品数量
	 */
	@Column(length=20)
	private String count;
	/**
	 * 商品总额
	 */
	@Column(length=20)
	private String total;
	/**
	 * 优惠金额
	 */
	@Column(length=20)
	private String discounts;
	/**
	 * 运费
	 */
	@Column(length=20)
	private String freight;
	/**
	 * 实付金额
	 */
	@Column(length=20)
	private String actual;
	
	public PatientEntity getPatient() {
		return patient;
	}
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
//	public String getPatientId() {
//		return patientId;
//	}
//	public void setPatientId(String patientId) {
//		this.patientId = patientId;
//	}
	public String getDiagnose() {
		return diagnose;
	}
	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public DoctorEntity getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getDiscounts() {
		return discounts;
	}
	public void setDiscounts(String discounts) {
		this.discounts = discounts;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
}
