/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.etm.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author emorajv
 */
class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "team_name")
    private String name;
    private String description;
    private Department department;
    private Account account;
    private boolean isActive;
    private boolean isDefault;
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
