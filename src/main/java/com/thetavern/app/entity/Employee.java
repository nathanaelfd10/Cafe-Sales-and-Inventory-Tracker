package com.thetavern.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.thymeleaf.util.StringUtils;

/**
 * @author Fernando Nathanael
 *
 */
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "sex")
	private String sex;

	@Column(name = "email")
	private String email;

	@Column(name = "home_address")
	private String homeAddress;

	@Column(name = "pay_hour")
	private String payHour;

	@Column(name = "role")
	private String role;

	@Column(name = "permanent_officer")
	private Boolean permanentOfficer;

	public Employee() {

	}

	/*
	 * To-dos: [DONE] Add email field
	 */

	public Employee(String name, String dateOfBirth, String sex, String email, String homeAddress, String payHour,
			String role, Boolean permanentOfficer) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.email = email;
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

		String capitalizedName = StringUtils.capitalizeWords(name);

		this.name = capitalizedName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		
		try {
			
			String capitalizedHomeAddress = StringUtils.capitalizeWords(homeAddress);
			this.homeAddress = capitalizedHomeAddress;
			
		} catch (Exception e) {
			
			System.err.println("[Employee] Failed to convert Home Address to uppercase.");
			this.homeAddress = homeAddress;
			
		}
		
		
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
		
		try {
			
			String capitalizedRole = role.toUpperCase();
			this.role = capitalizedRole;
			
		} catch (Exception e) {
			
			System.err.println("[Employee] Failed to convert role to uppercase.");
			this.role = role;
			
		}
		
		
	}

	public Boolean getPermanentOfficer() {
		return permanentOfficer;
	}

	public void setPermanentOfficer(Boolean permanentOfficer) {
		this.permanentOfficer = permanentOfficer;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", email="
				+ email + ", homeAddress=" + homeAddress + ", payHour=" + payHour + ", role=" + role
				+ ", permanentOfficer=" + permanentOfficer + "]";
	}

}
