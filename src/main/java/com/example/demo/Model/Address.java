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
	@Column(name="updated_date")
	private Date updatedDate;
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

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
	@JoinColumn(name="updated_by")
	private User updatedBy;
	@Column(name = "deleted", columnDefinition="BOOLEAN DEFAULT false")
	private Boolean deleted=false;



	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Address() {

	}

	public Address(Long id, User Updatedby, String name,String address,String city,String state,String country, int Zipcode,Date updatedDate) {
		this.id=id;
		this.updatedBy = Updatedby;
		this.name = name;
		this.address=address;
		this.city=city;
		this.state=state;
		this.country=country;
		this.zip=Zipcode;
		this.updatedDate=updatedDate;

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

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

}
