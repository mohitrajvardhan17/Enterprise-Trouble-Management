/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.etm.app.model;

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
    private String lastPasswordReset;
    private String oneTimePassword;
    @Column(name = "attempt_failed")
    private int attemptFailed;
    @Column(name = "login_ip")
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
    @JoinTable(
        name="USER_DEPARTMENT_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "id")
    )
    private Department department;
    @JoinTable(
        name="USER_TEAM_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TEAM_ID", referencedColumnName = "id")
    )
    private Team team;
    @JoinTable(
        name="USER_POLICY_RELATION",
        joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "POLICY_ID", referencedColumnName = "id")
    )
    private Policy policy;
    private boolean isActive;
    private boolean isOnline;
    private boolean isLocked;
    @UpdateTimestamp    
    private Date lastModifiedDate;
    @CreationTimestamp
    private Date creationDate;
    //@LastModifiedBy
    @OneToOne
    private Users lastModifiedBy;
    //@CreatedBy
    @OneToOne
    private Users createdBy;
}