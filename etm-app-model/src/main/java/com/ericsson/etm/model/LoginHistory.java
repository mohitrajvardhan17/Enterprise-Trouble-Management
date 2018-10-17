/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.etm.model;

import java.util.Date;
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
class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String sourceIp;
    private Date loginTime;
    private String AuthenticationServiceId;
    private String osPlatform;
    private boolean isSuccessfull;
    @OneToOne
    private Users userid;
    private String agent;
}
