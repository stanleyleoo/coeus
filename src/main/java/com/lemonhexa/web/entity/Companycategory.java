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
@Table(name = "companycategory", catalog = "lemonhexa", schema = "")

public class Companycategory implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordId")
    private Integer recordId;
    
    @Size(max = 100)
    @Column(name = "category")
    private String category;
    
    @Size(max = 100)
    @Column(name = "sub1")
    private String sub1;
    
    @Size(max = 100)
    @Column(name = "sub2")
    private String sub2;
    
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
    
    @Column(name = "createDatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDatetime;
    
    @Size(max = 45)
    @Column(name = "createBy")
    private String createBy;
    
    @Column(name = "lastModifiedDatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    
    @Size(max = 45)
    @Column(name = "lastModifiedBy")
    private String lastModifiedBy;
    
    @Column(name = "deleteStatus")
    private Boolean deleteStatus;

    public Companycategory() {
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSub1() {
        return sub1;
    }

    public void setSub1(String sub1) {
        this.sub1 = sub1;
    }

    public String getSub2() {
        return sub2;
    }

    public void setSub2(String sub2) {
        this.sub2 = sub2;
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

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(Date lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

       
}
