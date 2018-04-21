package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "bank_details")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "bank_ifsc")})
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bank_id", scope = Long.class)
public class BankDetails {

	@Id
	private long bank_id;

	@Column(name = "bank_name")
	private String bank_name;

	@Column(name = "bank_ifsc", nullable = false, unique = true)
	private String bank_ifsc;

	@Column(name = "bank_branch")
	private String bank_branch;

	@Column(name = "bank_address")
	private String bank_address;

	@Column(name = "bank_city")
	private String bank_city;

	@Column(name = "bank_district")
	private String bank_district;

	@Column(name = "bank_state")
	private String bank_state;

	public long getBank_id() {
		return bank_id;
	}

	public void setBank_id(long bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_ifsc() {
		return bank_ifsc;
	}

	public void setBank_ifsc(String bank_ifsc) {
		this.bank_ifsc = bank_ifsc;
	}

	public String getBank_branch() {
		return bank_branch;
	}

	public void setBank_branch(String bank_branch) {
		this.bank_branch = bank_branch;
	}

	public String getBank_address() {
		return bank_address;
	}

	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}

	public String getBank_city() {
		return bank_city;
	}

	public void setBank_city(String bank_city) {
		this.bank_city = bank_city;
	}

	public String getBank_district() {
		return bank_district;
	}

	public void setBank_district(String bank_district) {
		this.bank_district = bank_district;
	}

	public String getBank_state() {
		return bank_state;
	}

	public void setBank_state(String bank_state) {
		this.bank_state = bank_state;
	}

}
