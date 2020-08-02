/**
 * 
 */
package com.example.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author sateesh
 *
 */

@Entity
@Table(name = "ORDER")
public class Order {
	
	private String customerName;
	private Date orderDate;
	private String shippingAddress;
	private List<OrderItem> orderItems;
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
