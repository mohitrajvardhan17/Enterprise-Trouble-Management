package com.ericsson.etm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TtWorklog")
public class TtWorklog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7981302949939613722L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "incident_summary")
    private String incidentSummary;
    @Column(name = "status_updates")
    private String statusUpdates;
    @Column(name = "planned_next_step")
    private String plannedNextStep;
    @Column(name = "is_public")
    private boolean isPublic;
    @Column(name = "is_internal")
    private boolean isInternal;
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "creation_date")     
    private Date creationDate;
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
	public String getIncidentSummary() {
		return incidentSummary;
	}
	public void setIncidentSummary(String incidentSummary) {
		this.incidentSummary = incidentSummary;
	}
	public String getStatusUpdates() {
		return statusUpdates;
	}
	public void setStatusUpdates(String statusUpdates) {
		this.statusUpdates = statusUpdates;
	}
	public String getPlannedNextStep() {
		return plannedNextStep;
	}
	public void setPlannedNextStep(String plannedNextStep) {
		this.plannedNextStep = plannedNextStep;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public boolean isInternal() {
		return isInternal;
	}
	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Users getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}
}
