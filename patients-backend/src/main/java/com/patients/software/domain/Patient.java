package com.patients.software.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Patient
 */
@Entity
@Table
@DynamicInsert
@DynamicUpdate
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	
	@Column(nullable = false)
    private String pasNumber;
	
	@Column(nullable = false)
    private String forenames;
	
	@Column(nullable = false)
    private String surname;
	
	@Column(nullable = false)
    private String sexCode;
	
	@Column(nullable = false)
    private String homeTelephoneNumber;
	
	@Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth = new Date();

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getPasNumber() {
		return pasNumber;
	}

	public void setPasNumber(String pasNumber) {
		this.pasNumber = pasNumber;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSexCode() {
		return sexCode;
	}

	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}

	public String getHomeTelephoneNumber() {
		return homeTelephoneNumber;
	}

	public void setHomeTelephoneNumber(String homeTelephoneNumber) {
		this.homeTelephoneNumber = homeTelephoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
