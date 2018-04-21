package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="branches")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "ifsc") })
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ifsc", scope = String.class)
public class Branches {

	@ManyToOne
	@JoinColumn(name = "bank_id")
	private Banks bankId;
	
	@Id
	@Column( nullable = false)
	private String ifsc;
	
	private String branch;
	
	private String address;
	
	private String city;

	private String district;
	
	private String state;

	public Banks getBankId() {
		return bankId;
	}

	public void setBankId(Banks bankId) {
		this.bankId = bankId;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
