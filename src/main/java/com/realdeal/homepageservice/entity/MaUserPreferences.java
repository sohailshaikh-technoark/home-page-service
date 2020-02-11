/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Admin
 */
@Entity
@Table(name = "ma_user_preferences")
@NamedQueries({
        @NamedQuery(name = "MaUserPreferences.findAll", query = "SELECT m FROM MaUserPreferences m")})
@SequenceGenerator(name = "ma_user_preferences_seq", sequenceName = "ma_user_preferences_seq", allocationSize = 1)
public class MaUserPreferences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ma_user_preferences_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Column(name = "minprice")
    private BigDecimal minprice;
    @Column(name = "maxprice")
    private BigDecimal maxprice;
    @Column(name = "downpaymentpercentage")
    private BigDecimal downpaymentpercentage;
    @Column(name = "interestratepercentage  ")
    private BigDecimal interestratepercentage;
    @Column(name = "homeinsurancepercentage")
    private BigDecimal homeinsurancepercentage;
    @Column(name = "mortageinsurance")
    private BigDecimal mortageinsurance;
    @Size(max = 2147483647)
    @Column(name = "subtype")
    private String subtype;

    @Size(max = 2147483647)
    @Column(name = "recency")
    private String recency;
    @Column(name = "createdby")
    private Long createdby;
    @Column(name = "modifiedby")
    private Long modifiedby;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Column(name = "modifieddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifieddate;
    @Size(max = 2147483647)
    @Column(name = "status")
    private String status;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "minsqft")
    private Long minsqft;
    @Column(name = "maxsqft")
    private Long maxsqft;
    @Column(name = "minbuiltyear")
    private Long minbuiltyear;
    @Column(name = "maxbuiltyear")
    private Long maxbuiltyear;
    @Column(name = "minbeds")
    private Long minbeds;
    @Column(name = "maxbeds")
    private Long maxbeds;
    @Column(name = "minbaths")
    private Long minbaths;
    @Column(name = "maxbaths")
    private Long maxbaths;
    @Size(max = 2147483647)
    @Column(name = "type")
    private String type;
    @Column(name = "searchradius")
    private BigDecimal searchradius;
    @Column(name = "solddatemonths")
    private Long solddatemonths;
    @Column(name = "areasqft")
    private Long areasqft;
    @Column(name = "yearbuilt")
    private Long yearbuilt;
    @Column(name = "similarstories")
    private String similarstories;
    @Column(name = "bedroom")
    private Long bedroom;

    public MaUserPreferences() {
    }

    public MaUserPreferences(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMinprice() {
        return minprice;
    }

    public void setMinprice(BigDecimal minprice) {
        this.minprice = minprice;
    }

    public BigDecimal getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(BigDecimal maxprice) {
        this.maxprice = maxprice;
    }

    public BigDecimal getDownpaymentpercentage() {
        return downpaymentpercentage;
    }

    public void setDownpaymentpercentage(BigDecimal downpaymentpercentage) {
        this.downpaymentpercentage = downpaymentpercentage;
    }


    public BigDecimal getHomeinsurancepercentage() {
        return homeinsurancepercentage;
    }

    public void setHomeinsurancepercentage(BigDecimal homeinsurancepercentage) {
        this.homeinsurancepercentage = homeinsurancepercentage;
    }

    public BigDecimal getMortageinsurance() {
        return mortageinsurance;
    }

    public void setMortageinsurance(BigDecimal mortageinsurance) {
        this.mortageinsurance = mortageinsurance;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }


    public String getRecency() {
        return recency;
    }

    public void setRecency(String recency) {
        this.recency = recency;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Long getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Long getMinsqft() {
        return minsqft;
    }

    public void setMinsqft(Long minsqft) {
        this.minsqft = minsqft;
    }

    public Long getMaxsqft() {
        return maxsqft;
    }

    public void setMaxsqft(Long maxsqft) {
        this.maxsqft = maxsqft;
    }

    public Long getMinbuiltyear() {
        return minbuiltyear;
    }

    public void setMinbuiltyear(Long minbuiltyear) {
        this.minbuiltyear = minbuiltyear;
    }

    public Long getMaxbuiltyear() {
        return maxbuiltyear;
    }

    public void setMaxbuiltyear(Long maxbuiltyear) {
        this.maxbuiltyear = maxbuiltyear;
    }

    public Long getMinbeds() {
        return minbeds;
    }

    public void setMinbeds(Long minbeds) {
        this.minbeds = minbeds;
    }

    public Long getMaxbeds() {
        return maxbeds;
    }

    public void setMaxbeds(Long maxbeds) {
        this.maxbeds = maxbeds;
    }

    public Long getMinbaths() {
        return minbaths;
    }

    public void setMinbaths(Long minbaths) {
        this.minbaths = minbaths;
    }

    public Long getMaxbaths() {
        return maxbaths;
    }

    public void setMaxbaths(Long maxbaths) {
        this.maxbaths = maxbaths;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaUserPreferences)) {
            return false;
        }
        MaUserPreferences other = (MaUserPreferences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.realdeal.entity.MaUserPreferences[ id=" + id + " ]";
    }

    /**
     * @return the searchradius
     */
    public BigDecimal getSearchradius() {
        return searchradius;
    }

    /**
     * @param searchradius the searchradius to set
     */
    public void setSearchradius(BigDecimal searchradius) {
        this.searchradius = searchradius;
    }

    /**
     * @return the solddatemonths
     */
    public Long getSolddatemonths() {
        return solddatemonths;
    }

    /**
     * @param solddatemonths the solddatemonths to set
     */
    public void setSolddatemonths(Long solddatemonths) {
        this.solddatemonths = solddatemonths;
    }

    /**
     * @return the areasqft
     */
    public Long getAreasqft() {
        return areasqft;
    }

    /**
     * @param areasqft the areasqft to set
     */
    public void setAreasqft(Long areasqft) {
        this.areasqft = areasqft;
    }

    /**
     * @return the yearbuilt
     */
    public Long getYearbuilt() {
        return yearbuilt;
    }

    /**
     * @param yearbuilt the yearbuilt to set
     */
    public void setYearbuilt(Long yearbuilt) {
        this.yearbuilt = yearbuilt;
    }

    /**
     * @return the similarstories
     */
    public String getSimilarstories() {
        return similarstories;
    }

    /**
     * @param similarstories the similarstories to set
     */
    public void setSimilarstories(String similarstories) {
        this.similarstories = similarstories;
    }

    /**
     * @return the bedroom
     */
    public Long getBedroom() {
        return bedroom;
    }

    /**
     * @param bedroom the bedroom to set
     */
    public void setBedroom(Long bedroom) {
        this.bedroom = bedroom;
    }

    /**
     * @return the interestratepercentage
     */
    public BigDecimal getInterestratepercentage() {
        return interestratepercentage;
    }

    /**
     * @param interestratepercentage the interestratepercentage to set
     */
    public void setInterestratepercentage(BigDecimal interestratepercentage) {
        this.interestratepercentage = interestratepercentage;
    }

}
