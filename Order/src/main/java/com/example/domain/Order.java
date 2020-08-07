/**
 * 
 */
package com.example.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author sateesh
 *
 */

@Entity
@Table(name = "ORDER1")
public class Order {
	
	@Id
	@Column(name = "ORDER_ID")
	private int orderId;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	@Column(name = "SHIPPING_ADDRESS")
	private String shippingAddress;
	
	@Transient
	private List<OrderItem> orderItems;
	
	@Column(name = "TOTAL_AMT")
	private int totalAmt;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public int getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}

	
}
