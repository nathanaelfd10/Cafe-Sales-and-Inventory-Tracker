package com.thetavern.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="date_of_birth")
	private String dateOfBirth;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="home_address")
	private String homeAddress;
	
	@Column(name="pay_hour")
	private String payHour;
	
	@Column(name="role")
	private String role;
	
	@Column(name="permanent_officer")
	private Boolean permanentOfficer;
	
	public Employee() {
		
	}

	public Employee(String name, String dateOfBirth, String sex, String homeAddress, String payHour, String role,
			Boolean permanentOfficer) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.homeAddress = homeAddress;
		this.payHour = payHour;
		this.role = role;
		this.permanentOfficer = permanentOfficer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPayHour() {
		return payHour;
	}

	public void setPayHour(String payHour) {
		this.payHour = payHour;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getPermanentOfficer() {
		return permanentOfficer;
	}

	public void setPermanentOfficer(Boolean permanentOfficer) {
		this.permanentOfficer = permanentOfficer;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex
				+ ", homeAddress=" + homeAddress + ", payHour=" + payHour + ", role=" + role + ", permanentOfficer="
				+ permanentOfficer + "]";
	}
	
	 

	
}
