package com.vijay.user.UserEntity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;


@Entity
public class User {

	@Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
	int Id;
	private String firstname;
	private String middlename;
	private String lastname;
	private String mobno;
	private String email;
	@Transient
	private List<RatingEntity> ratings;
	
	
	
	public User(int id, String firstname, String middlename, String lastname, String mobno, String email,
			List<RatingEntity> ratings) {
		super();
		Id = id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.mobno = mobno;
		this.email = email;
		this.ratings =  ratings;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	public List<RatingEntity> getRatings() {
		return ratings;
	}
	public void setRatings(List<RatingEntity> userRating) {
		this.ratings = userRating;
	}
	
	public User() {
		
	}
}
