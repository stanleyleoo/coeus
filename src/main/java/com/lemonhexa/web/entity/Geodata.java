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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ploychompoo
 */
@Entity
@Table(name = "geodata", catalog = "lemonhexa", schema = "")

public class Geodata implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recordId")
    private Integer recordId;
    
    @Size(max = 100)
    @Column(name = "country")
    private String country;
    
    @Size(max = 45)
    @Column(name = "createBy")
    private String createBy;
    
    @Column(name = "createDatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDatetime = new Date();
    
    @Column(name = "defaultStatus")
    private Boolean defaultStatus;
    
    @Column(name = "deleteStatus")
    private Boolean deleteStatus;
    
    @Size(max = 100)
    @Column(name = "district")
    private String district;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "globalRecordId")
    private String globalRecordId;
    
    @Size(max = 45)
    @Column(name = "lastModifiedBy")
    private String lastModifiedBy;
    
    @Column(name = "lastModifiedDatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime = new Date();
    
    @Size(max = 200)
    @Column(name = "note")
    private String note;
    
    @Size(max = 100)
    @Column(name = "province")
    private String province;
    
    @Column(name = "recordVersion")
    private Integer recordVersion;
    
    @Size(max = 100)
    @Column(name = "regency")
    private String regency;
    
    @Size(max = 50)
    @Column(name = "voidReason")
    private String voidReason;
    
    @Column(name = "voidStatus")
    private Boolean voidStatus;

    public Geodata() {
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Boolean getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Boolean defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGlobalRecordId() {
        return globalRecordId;
    }

    public void setGlobalRecordId(String globalRecordId) {
        this.globalRecordId = globalRecordId;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(Date lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }

    public String getRegency() {
        return regency;
    }

    public void setRegency(String regency) {
        this.regency = regency;
    }

    public String getVoidReason() {
        return voidReason;
    }

    public void setVoidReason(String voidReason) {
        this.voidReason = voidReason;
    }

    public Boolean getVoidStatus() {
        return voidStatus;
    }

    public void setVoidStatus(Boolean voidStatus) {
        this.voidStatus = voidStatus;
    }

    
}
