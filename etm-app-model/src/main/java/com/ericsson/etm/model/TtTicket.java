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

@Entity
@Table(name = "TtTicket")
public class TtTicket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 573558811316078858L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    /* GROUP 1 = [CASE details] */
	private String incidentId;
	private TtSource source;
	@Column(name = "problem_statement")
	private String problemStatement;
	@Column(name = "other_involvement")
	private TtOtherInvolvement otherInvolvement;
    /* GROUP 2 = [Delivery-Platform and Delivery-Tool details] */
	@OneToOne
	@Column(name = "delivery_platform")
	private TtDeliveryPlatform deliveryPlatform;
    @OneToMany    
    @JoinTable(
            name="TICKET_DELIVERYTOOL_RELATION",
            joinColumns = @JoinColumn(name = "TICKET_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "DELIVERYTOOL_ID", referencedColumnName = "id")
        )
    private TtDeliveryTool deliveryTool;
    /* GROUP 3 = [Affected-Region and Affected-Area details] */
	@OneToOne
    @Column(name = "affected_region")
    private TtAffectedRegion affectedRegion;
    @OneToMany    
    @JoinTable(
            name="TICKET_AFFECTEDAREA_RELATION",
            joinColumns = @JoinColumn(name = "TICKET_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "AFFECTEDAREA_ID", referencedColumnName = "id")
        )
    private TtAffectedArea affectedArea;    
    /* GROUP 4 = [Ticket-Priority and Ticket-Status Details] */
	private TtImpact impact;
	private TtUrgency urgency;
	private TtPriority priority;
	private TtStatus status;
	@Column(name = "status_reason")
	private TtStatusReason statusReason;
    /* GROUP 5 = [Ticket-Owner and Ticket-Assignee Details] */
	@Column(name = "owner_account")
	private Account ownerAccount;
	@Column(name = "owner_department")
	private Department ownerDepartment;
	@Column(name = "owner_name")
	private Users ownerName;
	@Column(name = "assignee_account")
	private Account assigneeAccount;
	@Column(name = "assignee_department")
	private Department assigneeDepartment;
	@Column(name = "assignee_name")
	private Users assigneeName;
    /* GROUP 6 = [Ticket-Log Details] */
    @OneToMany    
    @JoinTable(
        name="TICKET_WORKLOG_RELATION",
        joinColumns = @JoinColumn(name = "TICKET_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "WORKLOG_ID", referencedColumnName = "id")
    )
	private TtWorklog worklog;
    @OneToMany    
    @JoinTable(
        name="TICKET_AUDITLOG_RELATION",
        joinColumns = @JoinColumn(name = "TICKET_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "AUDITLOG_ID", referencedColumnName = "id")
    )	
	private TtAuditLog auditLog;
    /* GROUP 7 = []Ticket-SPOC and Ticket-Notification Details */
    @OneToMany    
    @JoinTable(
        name="TICKET_SPOC_RELATION",
        joinColumns = @JoinColumn(name = "TICKET_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "SPOC_ID", referencedColumnName = "id")
    )
    private TtSPOC spoc;	
    @OneToMany    
    @JoinTable(
        name="TICKET_ADDITIONALRECIPIENTS_RELATION",
        joinColumns = @JoinColumn(name = "TICKET_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ADDITIONALRECIPIENTS_ID", referencedColumnName = "id")
    )
    private Users additionalRecipients;	    
    @OneToMany    
    @JoinTable(
        name="TICKET_NOTIFICATIONGROUP_RELATION",
        joinColumns = @JoinColumn(name = "TICKET_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "NOTIFICATIONGROUP_ID", referencedColumnName = "id")
    )	
	private TtNotificationGroup notificationGroup;
    /* GROUP 8 = [Ticket-KPI Details] */
	@Column(name = "next_update_interval")
	private TtNextUpdateInterval nextUpdateInterval;
    @Column(name = "outage_start_time")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date outageStartTime;
    @Column(name = "outage_end_time")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date outageEndTime;
    @Column(name = "outage_exclude_time")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date outageExcludeTime;
    @Column(name = "outage_etr_time")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date outageETRTime;
    /* GROUP 9 = [Ticket-Information Details] */
    @Column(name = "is_reopened")
    private boolean isReopened;
    @Column(name = "is_closed")
    private boolean isClosed;
    @Column(name = "impact_statement")
	private String impactStatement; 
	private String description; 
    @Column(name = "is_active")
    private boolean isActive;
    /* GROUP 10 = [Ticket-Security Details] */
   @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "actual_occurence_date")
    private Date actualOccurenceDate;
    @UpdateTimestamp    
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
	public String getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}
	public TtSource getSource() {
		return source;
	}
	public void setSource(TtSource source) {
		this.source = source;
	}
	public String getProblemStatement() {
		return problemStatement;
	}
	public void setProblemStatement(String problemStatement) {
		this.problemStatement = problemStatement;
	}
	public TtOtherInvolvement getOtherInvolvement() {
		return otherInvolvement;
	}
	public void setOtherInvolvement(TtOtherInvolvement otherInvolvement) {
		this.otherInvolvement = otherInvolvement;
	}
	public TtDeliveryPlatform getDeliveryPlatform() {
		return deliveryPlatform;
	}
	public void setDeliveryPlatform(TtDeliveryPlatform deliveryPlatform) {
		this.deliveryPlatform = deliveryPlatform;
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
	public Account getOwnerAccount() {
		return ownerAccount;
	}
	public void setOwnerAccount(Account ownerAccount) {
		this.ownerAccount = ownerAccount;
	}
	public Department getOwnerDepartment() {
		return ownerDepartment;
	}
	public void setOwnerDepartment(Department ownerDepartment) {
		this.ownerDepartment = ownerDepartment;
	}
	public Users getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(Users ownerName) {
		this.ownerName = ownerName;
	}
	public Account getAssigneeAccount() {
		return assigneeAccount;
	}
	public void setAssigneeAccount(Account assigneeAccount) {
		this.assigneeAccount = assigneeAccount;
	}
	public Department getAssigneeDepartment() {
		return assigneeDepartment;
	}
	public void setAssigneeDepartment(Department assigneeDepartment) {
		this.assigneeDepartment = assigneeDepartment;
	}
	public Users getAssigneeName() {
		return assigneeName;
	}
	public void setAssigneeName(Users assigneeName) {
		this.assigneeName = assigneeName;
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
	public Users getAdditionalRecipients() {
		return additionalRecipients;
	}
	public void setAdditionalRecipients(Users additionalRecipients) {
		this.additionalRecipients = additionalRecipients;
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
	public Date getOutageStartTime() {
		return outageStartTime;
	}
	public void setOutageStartTime(Date outageStartTime) {
		this.outageStartTime = outageStartTime;
	}
	public Date getOutageEndTime() {
		return outageEndTime;
	}
	public void setOutageEndTime(Date outageEndTime) {
		this.outageEndTime = outageEndTime;
	}
	public Date getOutageExcludeTime() {
		return outageExcludeTime;
	}
	public void setOutageExcludeTime(Date outageExcludeTime) {
		this.outageExcludeTime = outageExcludeTime;
	}
	public Date getOutageETRTime() {
		return outageETRTime;
	}
	public void setOutageETRTime(Date outageETRTime) {
		this.outageETRTime = outageETRTime;
	}
	public boolean isReopened() {
		return isReopened;
	}
	public void setReopened(boolean isReopened) {
		this.isReopened = isReopened;
	}
	public boolean isClosed() {
		return isClosed;
	}
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	public String getImpactStatement() {
		return impactStatement;
	}
	public void setImpactStatement(String impactStatement) {
		this.impactStatement = impactStatement;
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
	public Date getActualOccurenceDate() {
		return actualOccurenceDate;
	}
	public void setActualOccurenceDate(Date actualOccurenceDate) {
		this.actualOccurenceDate = actualOccurenceDate;
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
