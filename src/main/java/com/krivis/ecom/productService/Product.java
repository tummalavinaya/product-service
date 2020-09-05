package com.krivis.ecom.productService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	int productId;
	String productTitle;
	String productDescription;
	
	public String getTitle() {
		return productTitle;
	}
	public void setTitle(String title) {
		this.productTitle = title;
	}
	public String getDescription() {
		return productDescription;
	}
	public void setDescription(String description) {
		this.productDescription = description;
	}
	public int getId() {
		return productId;
	}
	public void setId(int id) {
		this.productId = id;
	}
	
}
