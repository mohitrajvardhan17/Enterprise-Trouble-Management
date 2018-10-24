/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.etm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author emorajv
 */
@Entity
@Table(name = "Teams")
class Teams implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4826097677761398838L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "team_name")
    private String name;	
    @OneToMany    
    @JoinTable(
        name="TEAM_USER_RELATION",
        joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    )
    private Users users;
    @OneToMany
    @JoinTable(
        name="TEAM_TICKET_RELATION",
        joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "id")
    )
    private TtTicket Ticket;
    @OneToMany
    @JoinTable(
        name="TEAM_TICKETSOURCE_RELATION",
        joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETSOURCE_ID", referencedColumnName = "id")
    )
    private TtSource source;
    @OneToMany    
    @JoinTable(
        name="TEAM_TICKETOTHERINVOLVEMENT_RELATION",
        joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETOTHERINVOLVEMENT_ID", referencedColumnName = "id")
    )
	private TtOtherInvolvement otherInvolvement;
    @OneToMany    
    @JoinTable(
        name="TEAM_TICKETDELIVERYPLATFORM_RELATION",
        joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETDELIVERYPLATFORM_ID", referencedColumnName = "id")
    )
    private TtDeliveryPlatform DeliveryPlatform;
    @OneToMany    
    @JoinTable(
            name="TEAM_TICKETDELIVERYTOOL_RELATION",
            joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "TICKETDELIVERYTOOL_ID", referencedColumnName = "id")
        )
    private TtDeliveryTool deliveryTool;	    
    @OneToMany    
    @JoinTable(
            name="TEAM_TICKETAFFECTEDREGION_RELATION",
            joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "TICKETAFFECTEDREGION_ID", referencedColumnName = "id")
        )
    private TtAffectedRegion affectedRegion;
    @OneToMany    
    @JoinTable(
            name="TEAM_TICKETAFFECTEDAREA_RELATION",
            joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "TICKETAFFECTEDAREA_ID", referencedColumnName = "id")
        )
    private TtAffectedArea affectedArea;
    @OneToMany
    @JoinTable(
        name="TEAM_TICKETIMPACT_RELATION",
        joinColumns = @JoinColumn(name="TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETIMPACT_ID",referencedColumnName = "id")
    )
    private TtImpact impact;
    @OneToMany
    @JoinTable(
        name="TEAM_TICKETURGENCY_RELATION",
        joinColumns = @JoinColumn(name="TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETURGENCY_ID",referencedColumnName = "id")
    )
    private TtUrgency urgency;
    @OneToMany
    @JoinTable(
        name="TEAM_TICKETPRIORITY_RELATION",
        joinColumns = @JoinColumn(name="TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETPRIORITY_ID",referencedColumnName = "id")
    )
    private TtPriority priority;
    @OneToMany
    @JoinTable(
        name="TEAM_TICKETPRIORITYMATRIX_RELATION",
        joinColumns = @JoinColumn(name="TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETPRIORITYMATRIX_ID",referencedColumnName = "id")
    )
    private TtPriorityMatrix priorityMatrix;
    @OneToMany
    @JoinTable(
        name="TEAM_TICKETSTATUS_RELATION",
        joinColumns = @JoinColumn(name="TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETSTATUS_ID",referencedColumnName = "id")
    )
    private TtStatus status;
    @OneToMany
    @JoinTable(
        name="TEAM_TICKETSTATUSREASON_RELATION",
        joinColumns = @JoinColumn(name="TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETSTATUSREASON_ID",referencedColumnName = "id")
    )
	private TtStatusReason statusReason;  
    @OneToMany
    @JoinTable(
        name="TEAM_TICKETWORKLOG_RELATION",
        joinColumns = @JoinColumn(name="TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETWORKLOG_ID",referencedColumnName = "id")
    )
	private TtWorklog worklog;    
    @OneToMany    
    @JoinTable(
        name="TEAM_TICKETAUDITLOG_RELATION",
        joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETAUDITLOG_ID", referencedColumnName = "id")
    )	
	private TtAuditLog auditLog;
    @OneToMany    
    @JoinTable(
        name="TEAM_TICKETSPOC_RELATION",
        joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETSPOC_ID", referencedColumnName = "id")
    )
    private TtSPOC spoc;    
    @OneToMany    
    @JoinTable(
        name="TEAM_TICKETNOTIFICATIONGROUP_RELATION",
        joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETNOTIFICATIONGROUP_ID", referencedColumnName = "id")
    )	
	private TtNotificationGroup notificationGroup;
	@Column(name = "next_update_interval")
	private TtNextUpdateInterval nextUpdateInterval;

	@Column(name = "working_hours")
	private WorkingHours workingHours;
	
    @OneToMany    
    @JoinTable(
        name="TEAM_ALLOWEDHOLIDAY_RELATION",
        joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ALLOWEDHOLIDAY_ID", referencedColumnName = "id")
    )
    private AllowedHolidays allowedHoliday;    	
	
    @OneToMany    
    @JoinTable(
        name="TEAM_CONTACT_RELATION",
        joinColumns = @JoinColumn(name = "TEAM_ID",referencedColumnName = "id"),
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
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public TtTicket getTicket() {
		return Ticket;
	}
	public void setTicket(TtTicket ticket) {
		Ticket = ticket;
	}
	public TtSource getSource() {
		return source;
	}
	public void setSource(TtSource source) {
		this.source = source;
	}
	public TtOtherInvolvement getOtherInvolvement() {
		return otherInvolvement;
	}
	public void setOtherInvolvement(TtOtherInvolvement otherInvolvement) {
		this.otherInvolvement = otherInvolvement;
	}
	public TtDeliveryPlatform getDeliveryPlatform() {
		return DeliveryPlatform;
	}
	public void setDeliveryPlatform(TtDeliveryPlatform deliveryPlatform) {
		DeliveryPlatform = deliveryPlatform;
	}
	public TtDeliveryTool getDeliveryTool() {
		return deliveryTool;
	}
	public void setDeliveryTool(TtDeliveryTool deliveryTool) {
		this.deliveryTool = deliveryTool;
	}
	public TtAffectedRegion getAffectedRegion() {
		return affectedRegion;
	}
	public void setAffectedRegion(TtAffectedRegion affectedRegion) {
		this.affectedRegion = affectedRegion;
	}
	public TtAffectedArea getAffectedArea() {
		return affectedArea;
	}
	public void setAffectedArea(TtAffectedArea affectedArea) {
		this.affectedArea = affectedArea;
	}
	public TtImpact getImpact() {
		return impact;
	}
	public void setImpact(TtImpact impact) {
		this.impact = impact;
	}
	public TtUrgency getUrgency() {
		return urgency;
	}
	public void setUrgency(TtUrgency urgency) {
		this.urgency = urgency;
	}
	public TtPriority getPriority() {
		return priority;
	}
	public void setPriority(TtPriority priority) {
		this.priority = priority;
	}
	public TtPriorityMatrix getPriorityMatrix() {
		return priorityMatrix;
	}
	public void setPriorityMatrix(TtPriorityMatrix priorityMatrix) {
		this.priorityMatrix = priorityMatrix;
	}
	public TtStatus getStatus() {
		return status;
	}
	public void setStatus(TtStatus status) {
		this.status = status;
	}
	public TtStatusReason getStatusReason() {
		return statusReason;
	}
	public void setStatusReason(TtStatusReason statusReason) {
		this.statusReason = statusReason;
	}
	public TtWorklog getWorklog() {
		return worklog;
	}
	public void setWorklog(TtWorklog worklog) {
		this.worklog = worklog;
	}
	public TtAuditLog getAuditLog() {
		return auditLog;
	}
	public void setAuditLog(TtAuditLog auditLog) {
		this.auditLog = auditLog;
	}
	public TtSPOC getSpoc() {
		return spoc;
	}
	public void setSpoc(TtSPOC spoc) {
		this.spoc = spoc;
	}
	public TtNotificationGroup getNotificationGroup() {
		return notificationGroup;
	}
	public void setNotificationGroup(TtNotificationGroup notificationGroup) {
		this.notificationGroup = notificationGroup;
	}
	public TtNextUpdateInterval getNextUpdateInterval() {
		return nextUpdateInterval;
	}
	public void setNextUpdateInterval(TtNextUpdateInterval nextUpdateInterval) {
		this.nextUpdateInterval = nextUpdateInterval;
	}
	public WorkingHours getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(WorkingHours workingHours) {
		this.workingHours = workingHours;
	}
	public AllowedHolidays getAllowedHoliday() {
		return allowedHoliday;
	}
	public void setAllowedHoliday(AllowedHolidays allowedHoliday) {
		this.allowedHoliday = allowedHoliday;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
