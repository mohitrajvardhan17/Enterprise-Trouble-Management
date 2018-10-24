package com.ericsson.etm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class TtSPOC implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private Users user;
	private Role role;
    @OneToMany
    @JoinTable(
        name="TTSPOC_POLICY_RELATION",
        joinColumns = @JoinColumn(name = "TTSPOC_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "POLICY_ID", referencedColumnName = "id")
    )
    private Policy policy;	
    @OneToMany
    @JoinTable(
        name="TTSPOC_TTDELIVERYPLATFORM_RELATION",
        joinColumns = @JoinColumn(name = "TTSPOC_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TTDELIVERYPLATFORM_ID", referencedColumnName = "id")
    )
	private TtDeliveryPlatform deliveryPlatform;
    @OneToMany
    @JoinTable(
        name="TTSPOC_TTDELIVERYTOOL_RELATION",
        joinColumns = @JoinColumn(name = "TTSPOC_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TTDELIVERYTOOL_ID", referencedColumnName = "id")
    )
    private TtDeliveryTool deliveryTool;
    @OneToMany
    @JoinTable(
        name="TTSPOC_TTAFFECTEDREGION_RELATION",
        joinColumns = @JoinColumn(name = "TTSPOC_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TTAFFECTEDREGION_ID", referencedColumnName = "id")
    )
    private TtAffectedRegion affectedRegion;
    @OneToMany
    @JoinTable(
        name="TTSPOC_TTAFFECTEDAREA_RELATION",
        joinColumns = @JoinColumn(name = "TTSPOC_ID",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "TTAFFECTEDAREA_ID", referencedColumnName = "id")
    )
    private TtAffectedArea affectedArea;  	
    @Column(name = "enable_sms_publish_notification")
    private boolean smsPublish;	
    @Column(name = "enable_sms_update_notification")
    private boolean smsUpdate;	
    @Column(name = "enable_email_publish_notification")
    private boolean emailPublish;	
    @Column(name = "enable_email_update_notification")
    private boolean emailUpdate;	
    @Column(name = "is_external")
    private boolean isExternal;	
    @Column(name = "is_internal")
    private boolean isInternal;	
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
}
