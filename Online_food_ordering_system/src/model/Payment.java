package model;

import java.io.Serializable;


public class Payment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String email;
	private String paymentMethod;
	private String amount;
	private String date;
	
	public Payment() {
		
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public String getAmount() {
		return amount;
	}
	public String getDate() {
		return date;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
