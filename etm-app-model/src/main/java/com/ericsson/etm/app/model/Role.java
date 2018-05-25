/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.etm.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author emorajv
 */
@Entity
@Table(name = "Role")
class Role implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private Account account;
    private boolean isActive;
    private boolean isDefault;
    private String description;
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
