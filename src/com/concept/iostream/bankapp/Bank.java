package com.concept.iostream.bankapp;

import java.io.Serializable;

public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;
	static double minBalance = 2000;
	
	private long accNo;
	private String accHName;
	private String userName;
	private transient String password;
	private transient double balance;
	public static double getMinBalance() {
		return minBalance;
	}
	public static void setMinBalance(double minBalance) {
		Bank.minBalance = minBalance;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getAccHName() {
		return accHName;
	}
	public void setAccHName(String accHName) {
		this.accHName = accHName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Bank [accNo=" + accNo + ", accHName=" + accHName
				+ ", userName=" + userName + ", password=" + password
				+ ", balance=" + balance + "]";
	}

	
}
