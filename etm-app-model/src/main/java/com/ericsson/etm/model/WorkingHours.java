package com.ericsson.etm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


public class WorkingHours implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 407637121796661886L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "start_time")     
    private String startTime;
    @Column(name = "end_time")     
    private String endTime;
	private Locale locale;
	private String description;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_default")
    private boolean isDefault;
    @UpdateTimestamp    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "creation_date")     
    private Date creationDate;
    //@LastModifiedBy
    @OneToOne
    @Column(name = "last_modified_by")    
    private Users lastModifiedBy;
    //@CreatedBy
    @OneToOne
    @Column(name = "created_by")
    private Users createdBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Users getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(Users lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Users getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}
}
