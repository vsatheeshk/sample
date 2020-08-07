/**
 * 
 */
package com.example.domain;

import javax.persistence.Column;

/**
 * @author sateesh
 *
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "ORDER_ITEM")
public class OrderItem {
	
	@Id
	@Column(name = "PRODUCT_CODE")
	private int productCode;
	
	@Column(name = "PRODUCT_NAME")
	private String ProductName;
	
	@Column(name = "PRODUCT_QUANTITY")
	private int productQuantity;
	
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	
}
