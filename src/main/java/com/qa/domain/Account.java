package com.qa.domain;

import javax.persistence.*;

@Entity
public class Account {

	@GeneratedValue @Id
	private Long id;
	@Column(length=16)
	private String firstName;
	@Column(length=16)
	private String secondName;
	@Column(length=6)
	private String accountNumber;
	

	public Account(String firstName, String secondName, String accountNumber) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
