package ru.st.selenium.model;

import java.util.ArrayList;

public class User {

	private String login;
	private String password;
	private String name;
	private String lastName;
	private String nickName;
	private String passwordConfirmation;
	private String club;
	private Address shippingAddress;
	private Address billingAddress;

	public User(String name, String lastName, String nickName, String login, String password,  String passwordConfirmation, String club, Address shippingAddress, Address billingAddress) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.nickName = nickName;
		this.passwordConfirmation = passwordConfirmation;
		this.club = club;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getLogin() {
		return login;
	}
	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}

}
