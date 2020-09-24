package com.example.demo.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column (name="name")
	private String name;
	@Column (name="address")
	private String address;
	@Column (name="city")
	private String city;
	@Column (name="state")
	private String state;
	@Column (name="country")
	private String country;
	@Column (name="zipcode")
	private int zip;
	@ManyToOne
    @JoinColumn(name="Updatedby")
    private User Updatedby;
    
	
	
	public User getUpdatedby() {
		return Updatedby;
	}
	public void setUpdatedby(User updatedby) {
		Updatedby = updatedby;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}

	 public Address() {
	    	
	    }
	    
	    public Address(Long id, User Updatedby, String name,String address,String city,String state,String country, int Zipcode) {
	    	this.id=id;
	    	this.Updatedby = Updatedby;
	    	this.name = name;
	    	this.address=address;
	    	this.city=city;
	    	this.state=state;
	    	this.country=country;
	    	this.zip=Zipcode;
	    
	    }

}
