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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author emorajv
 */
@Entity
@Table(name = "Users")
public class Users implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3654112724867147602L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
        name="USER_CONTACT_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "CONTACT_ID", referencedColumnName = "id")
    )
    @OneToOne
    private Authenticator authenticator;
    @OneToOne
    private Locale locale;
    @OneToMany
    @JoinTable(
        name="USER_ACCOUNT_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "id")
    )
    private Account account;
    @OneToMany
    @JoinTable(
        name="USER_DEPARTMENT_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "id")
    )
    private Department department;
    @OneToMany
    @JoinTable(
        name="USER_TEAM_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TEAM_ID", referencedColumnName = "id")
    )
    private Team team;
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
    @Column(name = "is_external")
    private boolean isExternal;
    @UpdateTimestamp    
    @Column(name = "last_modified_date")    
    private Date lastModifiedDate;
    @CreationTimestamp
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
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the lastPasswordReset
	 */
	public Date getLastPasswordReset() {
		return lastPasswordReset;
	}
	/**
	 * @param lastPasswordReset the lastPasswordReset to set
	 */
	public void setLastPasswordReset(Date lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}
	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}
	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	/**
	 * @return the oneTimePassword
	 */
	public String getOneTimePassword() {
		return oneTimePassword;
	}
	/**
	 * @param oneTimePassword the oneTimePassword to set
	 */
	public void setOneTimePassword(String oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}
	/**
	 * @return the attemptFailed
	 */
	public int getAttemptFailed() {
		return attemptFailed;
	}
	/**
	 * @param attemptFailed the attemptFailed to set
	 */
	public void setAttemptFailed(int attemptFailed) {
		this.attemptFailed = attemptFailed;
	}
	/**
	 * @return the loginHistory
	 */
	public LoginHistory getLoginHistory() {
		return loginHistory;
	}
	/**
	 * @param loginHistory the loginHistory to set
	 */
	public void setLoginHistory(LoginHistory loginHistory) {
		this.loginHistory = loginHistory;
	}
	/**
	 * @return the autoLogin
	 */
	public int getAutoLogin() {
		return autoLogin;
	}
	/**
	 * @param autoLogin the autoLogin to set
	 */
	public void setAutoLogin(int autoLogin) {
		this.autoLogin = autoLogin;
	}
	/**
	 * @return the autoLogout
	 */
	public int getAutoLogout() {
		return autoLogout;
	}
	/**
	 * @param autoLogout the autoLogout to set
	 */
	public void setAutoLogout(int autoLogout) {
		this.autoLogout = autoLogout;
	}
	/**
	 * @return the autoRefresh
	 */
	public int getAutoRefresh() {
		return autoRefresh;
	}
	/**
	 * @param autoRefresh the autoRefresh to set
	 */
	public void setAutoRefresh(int autoRefresh) {
		this.autoRefresh = autoRefresh;
	}
	/**
	 * @return the rowPerPage
	 */
	public int getRowPerPage() {
		return rowPerPage;
	}
	/**
	 * @param rowPerPage the rowPerPage to set
	 */
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/**
	 * @return the authenticator
	 */
	public Authenticator getAuthenticator() {
		return authenticator;
	}
	/**
	 * @param authenticator the authenticator to set
	 */
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}
	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	/**
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	/**
	 * @return the policy
	 */
	public Policy getPolicy() {
		return policy;
	}
	/**
	 * @param policy the policy to set
	 */
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the isOnline
	 */
	public boolean isOnline() {
		return isOnline;
	}
	/**
	 * @param isOnline the isOnline to set
	 */
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	/**
	 * @return the isLocked
	 */
	public boolean isLocked() {
		return isLocked;
	}
	/**
	 * @param isLocked the isLocked to set
	 */
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	/**
	 * @return the isExternal
	 */
	public boolean isExternal() {
		return isExternal;
	}
	/**
	 * @param isExternal the isExternal to set
	 */
	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}
	/**
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the lastModifiedBy
	 */
	public Users getLastModifiedBy() {
		return lastModifiedBy;
	}
	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	public void setLastModifiedBy(Users lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	/**
	 * @return the createdBy
	 */
	public Users getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}
}
