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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author emorajv
 */
@Entity
@Table(name = "Users")
public class Users implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1071499811562708319L;
	@Id
    @GenericGenerator(
        name = "sequence_usr_id", 
        strategy = "com.ericsson.etm.util.CustomIdentifierGenerator",
        parameters = {@org.hibernate.annotations.Parameter(
            name = "prefix", 
            value = "USR"),
            @org.hibernate.annotations.Parameter(
            name = "tableName", 
            value = "Users"),
            @org.hibernate.annotations.Parameter(
            name = "format", 
            value = "%08d")
        }
    )
    @GeneratedValue(generator = "sequence_user_id") 
    private int id;
    private String description;
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String gender;
    private String email;
    private String password;
    @Column(name = "last_password_reset")
    private Date lastPasswordReset;
    @Column(name = "last_password_reset")
    private Date lastLogin;
    @Column(name = "one_time_password")
    private String oneTimePassword;
    @Column(name = "attempt_failed")
    private int attemptFailed;
    @Column(name = "login_history")
    private LoginHistory loginHistory;
    @Column(name = "auto_login")
    private int autoLogin;
    @Column(name = "auto_logout")
    private int autoLogout;
    @Column(name = "auto_refresh")
    private int autoRefresh;
    @Column(name = "row_per_page")
    private int rowPerPage; 
    @OneToMany
    @JoinTable(
        name="USER_CONTACT_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "CONTACT_ID", referencedColumnName = "id")
    )
    private Contact contact;
    @OneToMany
    @JoinTable(
        name="USER_ROLE_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id")
    )
    private Role role;
    @OneToOne
    private Authenticator authenticator;
    @OneToOne
    private Locale locale;    
    @OneToMany
    @JoinTable(
        name="USER_TICKET_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKET_ID", referencedColumnName = "id")
    )
    private TtTicket Ticket;
    @OneToMany
    @JoinTable(
        name="USER_TICKETSOURCE_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETSOURCE_ID", referencedColumnName = "id")
    )
    private TtSource source;
    @OneToMany    
    @JoinTable(
        name="USER_TICKETOTHERINVOLVEMENT_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETOTHERINVOLVEMENT_ID", referencedColumnName = "id")
    )
	private TtOtherInvolvement otherInvolvement;
    @OneToMany    
    @JoinTable(
        name="USER_TICKETDELIVERYPLATFORM_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETDELIVERYPLATFORM_ID", referencedColumnName = "id")
    )
    private TtDeliveryPlatform DeliveryPlatform;
    @OneToMany    
    @JoinTable(
            name="USER_TICKETDELIVERYTOOL_RELATION",
            joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "TICKETDELIVERYTOOL_ID", referencedColumnName = "id")
        )
    private TtDeliveryTool deliveryTool;	    
    @OneToMany    
    @JoinTable(
            name="USER_TICKETAFFECTEDREGION_RELATION",
            joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "TICKETAFFECTEDREGION_ID", referencedColumnName = "id")
        )
    private TtAffectedRegion affectedRegion;
    @OneToMany    
    @JoinTable(
            name="USER_TICKETAFFECTEDAREA_RELATION",
            joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "TICKETAFFECTEDAREA_ID", referencedColumnName = "id")
        )
    private TtAffectedArea affectedArea;
    @OneToMany
    @JoinTable(
        name="USER_TICKETIMPACT_RELATION",
        joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETIMPACT_ID",referencedColumnName = "id")
    )
    private TtImpact impact;
    @OneToMany
    @JoinTable(
        name="USER_TICKETURGENCY_RELATION",
        joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETURGENCY_ID",referencedColumnName = "id")
    )
    private TtUrgency urgency;
    @OneToMany
    @JoinTable(
        name="USER_TICKETPRIORITY_RELATION",
        joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETPRIORITY_ID",referencedColumnName = "id")
    )
    private TtPriority priority;
    @OneToMany
    @JoinTable(
        name="USER_TICKETPRIORITYMATRIX_RELATION",
        joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETPRIORITYMATRIX_ID",referencedColumnName = "id")
    )
    private TtPriorityMatrix priorityMatrix;
    @OneToMany
    @JoinTable(
        name="USER_TICKETSTATUS_RELATION",
        joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETSTATUS_ID",referencedColumnName = "id")
    )
    private TtStatus status;
    @OneToMany
    @JoinTable(
        name="USER_TICKETSTATUSREASON_RELATION",
        joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETSTATUSREASON_ID",referencedColumnName = "id")
    )
	private TtStatusReason statusReason;  
    @OneToMany
    @JoinTable(
        name="USER_TICKETWORKLOG_RELATION",
        joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="TICKETWORKLOG_ID",referencedColumnName = "id")
    )
	private TtWorklog worklog;    
    @OneToMany    
    @JoinTable(
        name="USER_TICKETAUDITLOG_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETAUDITLOG_ID", referencedColumnName = "id")
    )	
	private TtAuditLog auditLog;
    @OneToMany    
    @JoinTable(
        name="USER_TICKETSPOC_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TICKETSPOC_ID", referencedColumnName = "id")
    )
    private TtSPOC spoc;    
    @OneToMany    
    @JoinTable(
        name="USER_TICKETNOTIFICATIONGROUP_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
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
        name="USER_POLICY_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "POLICY_ID", referencedColumnName = "id")
    )
    private Policy policy;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_online")
    private boolean isOnline;
    @Column(name = "is_locked")
    private boolean isLocked;
    @Column(name = "is_internal")
    private boolean isInternal;
    @Column(name = "is_external")
    private boolean isExternal;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastPasswordReset() {
		return lastPasswordReset;
	}
	public void setLastPasswordReset(Date lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getOneTimePassword() {
		return oneTimePassword;
	}
	public void setOneTimePassword(String oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}
	public int getAttemptFailed() {
		return attemptFailed;
	}
	public void setAttemptFailed(int attemptFailed) {
		this.attemptFailed = attemptFailed;
	}
	public LoginHistory getLoginHistory() {
		return loginHistory;
	}
	public void setLoginHistory(LoginHistory loginHistory) {
		this.loginHistory = loginHistory;
	}
	public int getAutoLogin() {
		return autoLogin;
	}
	public void setAutoLogin(int autoLogin) {
		this.autoLogin = autoLogin;
	}
	public int getAutoLogout() {
		return autoLogout;
	}
	public void setAutoLogout(int autoLogout) {
		this.autoLogout = autoLogout;
	}
	public int getAutoRefresh() {
		return autoRefresh;
	}
	public void setAutoRefresh(int autoRefresh) {
		this.autoRefresh = autoRefresh;
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Authenticator getAuthenticator() {
		return authenticator;
	}
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
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
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	public boolean isInternal() {
		return isInternal;
	}
	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}
	public boolean isExternal() {
		return isExternal;
	}
	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
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
