/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Ploychompoo
 */
@Entity
@Table(name = "accountgroup", catalog = "lemonhexa", schema = "")

public class Accountgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recordId")
    private Integer recordId;
    
    @Column(name = "groupName")
    private Integer groupName;
    @Size(max = 100)
    
    @Column(name = "subGroup")
    private String subGroup;
    
    @Column(name = "needBySystem")
    private Boolean needBySystem;
    
    @Size(max = 200)
    @Column(name = "note")
    private String note;
    
    @Column(name = "recordVersion")
    private Integer recordVersion;
    
    @Column(name = "defaultStatus")
    private Boolean defaultStatus;
    
    @Column(name = "voidStatus")
    private Boolean voidStatus;
    
    @Size(max = 50)
    @Column(name = "voidReason")
    private String voidReason;
    
    @Column(name = "createDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateTime;
    
    @Column(name = "createBy")
    private Integer createBy;
    
    @Column(name = "lastModifiedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;
    
    @Column(name = "lastModifiedBy")
    private Integer lastModifiedBy;
    
    @Column(name = "deleteStatus")
    private Boolean deleteStatus;

    public Accountgroup() {
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getGroupName() {
        return groupName;
    }

    public void setGroupName(Integer groupName) {
        this.groupName = groupName;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public Boolean getNeedBySystem() {
        return needBySystem;
    }

    public void setNeedBySystem(Boolean needBySystem) {
        this.needBySystem = needBySystem;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }

    public Boolean getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Boolean defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public Boolean getVoidStatus() {
        return voidStatus;
    }

    public void setVoidStatus(Boolean voidStatus) {
        this.voidStatus = voidStatus;
    }

    public String getVoidReason() {
        return voidReason;
    }

    public void setVoidReason(String voidReason) {
        this.voidReason = voidReason;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(Date lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
    
}
