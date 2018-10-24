package com.ericsson.etm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class TtNotificationGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3001414394321078396L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "notification_group_name")
    private String name;	
    @OneToMany    
    @JoinTable(
        name="TTNOTIFICATIONGROUP_TTSPOC_RELATION",
        joinColumns = @JoinColumn(name = "TTNOTIFICATIONGROUP_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TTSPOC_ID", referencedColumnName = "id")
    )
    private TtSPOC spocs;
    @OneToMany    
    @JoinTable(
        name="TTNOTIFICATIONGROUP_CONTACT_RELATION",
        joinColumns = @JoinColumn(name = "TTNOTIFICATIONGROUP_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "CONTACT_ID", referencedColumnName = "id")
    )
    private Contact contact;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TtSPOC getSpocs() {
		return spocs;
	}
	public void setSpocs(TtSPOC spocs) {
		this.spocs = spocs;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
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
