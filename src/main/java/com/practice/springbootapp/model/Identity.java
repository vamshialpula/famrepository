package com.practice.springbootapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Identity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//@ManyToOne
	//@JoinColumn(name="userId")
	//@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Family family;
	
    @Column(name = "id_Name")
	private String idName;
	
    @Column(name="id_number")
	private String idNumber;
	
    @Column(name="expiry_date")
	private Date expiryDate;
	
    @Column(name="status")
	private String status;    

	public Identity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Identity(Long id, Family family, String idName, String idNumber, Date expiryDate, String status) {
		this.id = id;
		this.family = family;
		this.idName = idName;
		this.idNumber = idNumber;
		this.expiryDate = expiryDate;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Identity [id=" + id + ", family=" + family + ", idName=" + idName + ", idNumber=" + idNumber
				+ ", expiryDate=" + expiryDate + ", status=" + status + "]";
	}

}
