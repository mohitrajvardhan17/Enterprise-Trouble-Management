/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.etm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author emorajv
 */
class LoginHistory implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8153145687968513257L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private Account account;
    @Column(name = "source_ip")
    private String sourceIp;
    @Column(name = "login_type")
    private Date loginTime;
    @Column(name = "authentication_type")
    @OneToOne
    private Authenticator authenticationType;
    @Column(name = "os_platform")
    private String osPlatform;
    @Column(name = "is_success")
    private boolean isSuccessfull;
    @OneToOne
    @Column(name = "username")
    private Users userId;
    @Column(name = "agent")
    private String agent;
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
	 * @return the sourceIp
	 */
	public String getSourceIp() {
		return sourceIp;
	}
	/**
	 * @param sourceIp the sourceIp to set
	 */
	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}
	/**
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}
	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * @return the authenticationType
	 */
	public Authenticator getAuthenticationType() {
		return authenticationType;
	}
	/**
	 * @param authenticationType the authenticationType to set
	 */
	public void setAuthenticationType(Authenticator authenticationType) {
		this.authenticationType = authenticationType;
	}
	/**
	 * @return the osPlatform
	 */
	public String getOsPlatform() {
		return osPlatform;
	}
	/**
	 * @param osPlatform the osPlatform to set
	 */
	public void setOsPlatform(String osPlatform) {
		this.osPlatform = osPlatform;
	}
	/**
	 * @return the isSuccessfull
	 */
	public boolean isSuccessfull() {
		return isSuccessfull;
	}
	/**
	 * @param isSuccessfull the isSuccessfull to set
	 */
	public void setSuccessfull(boolean isSuccessfull) {
		this.isSuccessfull = isSuccessfull;
	}
	/**
	 * @return the userId
	 */
	public Users getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	/**
	 * @return the agent
	 */
	public String getAgent() {
		return agent;
	}
	/**
	 * @param agent the agent to set
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
