package com.ericsson.etm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TtAuditLog")
public class TtAuditLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7480740601581293089L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;	
    @Column(name = "feild_name")
    private String attributeName;	
    @Column(name = "previous_value")
	private String previousValue;
    @Column(name = "next_value")
	private String nextValue;
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "creation_date")     
    private Date creationDate;
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
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getPreviousValue() {
		return previousValue;
	}
	public void setPreviousValue(String previousValue) {
		this.previousValue = previousValue;
	}
	public String getNextValue() {
		return nextValue;
	}
	public void setNextValue(String nextValue) {
		this.nextValue = nextValue;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Users getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}
}
