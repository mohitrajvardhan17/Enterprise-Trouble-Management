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
@Table(name = "Account")
class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7044155899839626911L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "account_name")
    private String name;
	/* GROUP 1 = [MULTITENANT Parameter Details] */
    @OneToMany    
    @JoinTable(
        name="ACCOUNT_DEPARTMENT_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "id")
    )
    private Department department;
    @OneToMany    
    @JoinTable(
        name="ACCOUNT_TEAM_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TEAM_ID", referencedColumnName = "id")
    )
    private Teams teams;
    @OneToMany    
    @JoinTable(
        name="ACCOUNT_USER_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    )
    private Users users;
    @OneToMany
    @JoinTable(
        name="ACCOUNT_ROLE_RELATION",
        joinColumns = @JoinColumn(name="ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="ROLE_ID",referencedColumnName = "id")
    )
    private Role role;
	/* GROUP 2 = [Tickets Details] */
    @OneToMany
    @JoinTable(
        name="ACCOUNT_TICKET_RELATION",
        joinColumns = @JoinColumn(name="ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKET_ID",referencedColumnName = "id")
    )
    private TtTicket ticket;
    @OneToMany
    @JoinTable(
        name="ACCOUNT_TICKETSOURCE_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETSOURCE_ID", referencedColumnName = "id")
    )
    private TtSource source;
    @OneToMany    
    @JoinTable(
        name="ACCOUNT_TICKETOTHERINVOLVEMENT_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETOTHERINVOLVEMENT_ID", referencedColumnName = "id")
    )
	private TtOtherInvolvement otherInvolvement;
    @OneToMany    
    @JoinTable(
        name="ACCOUNT_TICKETDELIVERYPLATFORM_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETDELIVERYPLATFORM_ID", referencedColumnName = "id")
    )
    private TtDeliveryPlatform DeliveryPlatform;
    @OneToMany    
    @JoinTable(
            name="ACCOUNT_TICKETDELIVERYTOOL_RELATION",
            joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "TICKETDELIVERYTOOL_ID", referencedColumnName = "id")
        )
    private TtDeliveryTool deliveryTool;	    
    @OneToMany    
    @JoinTable(
            name="ACCOUNT_TICKETAFFECTEDREGION_RELATION",
            joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "TICKETAFFECTEDREGION_ID", referencedColumnName = "id")
        )
    private TtAffectedRegion affectedRegion;
    @OneToMany    
    @JoinTable(
            name="ACCOUNT_TICKETAFFECTEDAREA_RELATION",
            joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "TICKETAFFECTEDAREA_ID", referencedColumnName = "id")
        )
    private TtAffectedArea affectedArea;
    @OneToMany
    @JoinTable(
        name="ACCOUNT_TICKETIMPACT_RELATION",
        joinColumns = @JoinColumn(name="ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETIMPACT_ID",referencedColumnName = "id")
    )
    private TtImpact impact;
    @OneToMany
    @JoinTable(
        name="ACCOUNT_TICKETURGENCY_RELATION",
        joinColumns = @JoinColumn(name="ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETURGENCY_ID",referencedColumnName = "id")
    )
    private TtUrgency urgency;
    @OneToMany
    @JoinTable(
        name="ACCOUNT_TICKETPRIORITY_RELATION",
        joinColumns = @JoinColumn(name="ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETPRIORITY_ID",referencedColumnName = "id")
    )
    private TtPriority priority;
    @OneToMany
    @JoinTable(
        name="ACCOUNT_TICKETPRIORITYMATRIX_RELATION",
        joinColumns = @JoinColumn(name="ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETPRIORITYMATRIX_ID",referencedColumnName = "id")
    )
    private TtPriorityMatrix priorityMatrix;
    @OneToMany
    @JoinTable(
        name="ACCOUNT_TICKETSTATUS_RELATION",
        joinColumns = @JoinColumn(name="ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETSTATUS_ID",referencedColumnName = "id")
    )
    private TtStatus status;    
    @OneToMany
    @JoinTable(
        name="ACCOUNT_TICKETSTATUSREASON_RELATION",
        joinColumns = @JoinColumn(name="ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETSTATUSREASON_ID",referencedColumnName = "id")
    )
	private TtStatusReason statusReason;  
    @OneToMany
    @JoinTable(
        name="ACCOUNT_TICKETWORKLOG_RELATION",
        joinColumns = @JoinColumn(name="ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETWORKLOG_ID",referencedColumnName = "id")
    )
	private TtWorklog worklog;    
    @OneToMany    
    @JoinTable(
        name="ACCOUNT_TICKETAUDITLOG_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETAUDITLOG_ID", referencedColumnName = "id")
    )	
	private TtAuditLog auditLog;
    @OneToMany    
    @JoinTable(
        name="ACCOUNT_TICKETSPOC_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETSPOC_ID", referencedColumnName = "id")
    )
    private TtSPOC spoc;    
    @OneToMany    
    @JoinTable(
        name="ACCOUNT_TICKETNOTIFICATIONGROUP_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETNOTIFICATIONGROUP_ID", referencedColumnName = "id")
    )	
	private TtNotificationGroup notificationGroup;
	@Column(name = "next_update_interval")
	private TtNextUpdateInterval nextUpdateInterval;

	@Column(name = "working_hours")
	private WorkingHours workingHours;

    @OneToMany    
    @JoinTable(
        name="ACCOUNT_ALLOWEDHOLIDAY_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ALLOWEDHOLIDAY_ID", referencedColumnName = "id")
    )
    private AllowedHolidays allowedHoliday;    
	
	
	@OneToMany    
    @JoinTable(
        name="ACCOUNT_CONTACT_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Teams getTeams() {
		return teams;
	}
	public void setTeams(Teams teams) {
		this.teams = teams;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public TtTicket getTicket() {
		return ticket;
	}
	public void setTicket(TtTicket ticket) {
		this.ticket = ticket;
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
