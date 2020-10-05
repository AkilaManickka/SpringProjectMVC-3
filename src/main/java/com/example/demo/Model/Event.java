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
@Table(name = "event")

public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String desc;

    @Column(name="target_date")
    private Date targetDate;
    
    @Column(name="is_done", columnDefinition="BOOLEAN DEFAULT false") 
    private boolean done;
    
    @ManyToOne
    @JoinColumn(name="created_by")
    private User createdBy;
	@Column(name = "deleted", columnDefinition="BOOLEAN DEFAULT false")
	private Boolean deleted=false;



	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
    
    public Event() {
    	
    }
    
    public Event(Long id, User createdBy, String desc,Date targetDate, Boolean isDone) {
    	this.id=id;
    	this.createdBy = createdBy;
    	this.desc = desc;
    	this.targetDate = targetDate;
    	this.done = isDone;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
