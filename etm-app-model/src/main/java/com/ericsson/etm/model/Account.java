/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.etm.model;

import java.io.Serializable;
import java.util.Date;
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
class Account  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7296516336510070462L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String description;
    @OneToMany
    @JoinTable(
        name="user_role_relation",
        joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id")
    )
    private Role role;
    @OneToMany
    @JoinTable(
        name="user_permission_relation",
        joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="permission_id",referencedColumnName = "id")
    )
    private Permission permission;
    @JoinTable(
        name="ACCOUNT_DEPARTMENT_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "id")
    )
    private Department account;
    @JoinTable(
        name="ACCOUNT_TEAM_RELATION",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TEAM_ID", referencedColumnName = "id")
    )
    private Team team;
    private boolean isActive;
    private boolean isDefault;
    @UpdateTimestamp    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    //@LastModifiedBy
    @OneToOne
    private Users lastModifiedBy;
    //@CreatedBy
    @OneToOne
    private Users createdBy;    
}
