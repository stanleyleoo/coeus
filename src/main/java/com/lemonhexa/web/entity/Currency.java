/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lemonhexa.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 *
 * @author Ploychompoo
 */
@Entity
@Table(name = "currency", catalog = "lemonhexa", schema = "")

public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recordId")
    private Integer recordId;
    
    @Size(max = 100)
    @Column(name = "country")
    private String country;
    
    @Size(max = 5)
    @Column(name = "currency")
    private String currency;
    
    @Digits(integer = 23, fraction = 6)
    @Column(name = "rate")
    private BigDecimal rate;
    
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
    
    @Size(max = 45)
    @Column(name = "createBy")
    private String createBy;
    
    @Column(name = "lastModifiedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;
    
    @Size(max = 45)
    @Column(name = "lastModifiedBy")
    private String lastModifiedBy;
    
    @Column(name = "deleteStatus")
    private Boolean deleteStatus;

    public Currency() {
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(Date lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
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
