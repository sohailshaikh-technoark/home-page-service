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
@Table(name = "ma_deal_calculation")
@NamedQueries({
        @NamedQuery(name = "MaDealCalculation.findAll", query = "SELECT m FROM MaDealCalculation m")})
@SequenceGenerator(name = "ma_deal_calculation_seq", sequenceName = "ma_deal_calculation_seq", allocationSize = 1)
public class MaDealCalculation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ma_deal_calculation_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "homeprice")
    private BigDecimal homeprice;
    @Column(name = "downpayment")
    private BigDecimal downpayment;
    @Column(name = "downpaymentpercentage")
    private BigDecimal downpaymentpercentage;
    @Column(name = "interestrate")
    private BigDecimal interestrate;
    @Column(name = "loantype")
    private Long loantype;
    @Column(name = "propertytax")
    private BigDecimal propertytax;
    @Column(name = "propertytaxpercentage")
    private BigDecimal propertytaxpercentage;
    @Column(name = "homeinsurance")
    private BigDecimal homeinsurance;
    @Column(name = "homeinsurancepercentage")
    private BigDecimal homeinsurancepercentage;
    @Column(name = "hoadues")
    private BigDecimal hoadues;
    @Column(name = "mortageinsurance")
    private BigDecimal mortageinsurance;
    @Column(name = "monthlyrent")
    private BigDecimal monthlyrent;
    @Column(name = "rehabcost")
    private BigDecimal rehabcost;
    @Column(name = "afterrepairvalue")
    private BigDecimal afterrepairvalue;
    @Column(name = "purchaseprice")
    private BigDecimal purchaseprice;
    @Column(name = "purchasepricepercentage")
    private BigDecimal purchasepricepercentage;
    @Column(name = "monthlycapreserv")
    private BigDecimal monthlycapreserv;
    @Column(name = "monthlycapreservpercentage")
    private BigDecimal monthlycapreservpercentage;
    @Column(name = "maintainance")
    private BigDecimal maintainance;
    @Column(name = "propertymanagement")
    private BigDecimal propertymanagement;
    @Column(name = "vacancyrate")
    private BigDecimal vacancyrate;
    @Column(name = "othermonthlycost")
    private BigDecimal othermonthlycost;
    @Column(name = "principalamount")
    private BigDecimal principalamount;
    @Column(name = "interestamount")
    private BigDecimal interestamount;
    @Column(name = "noofpayments")
    private BigDecimal noofpayments;
    @Column(name = "monthlypayment")
    private BigDecimal monthlypayment;
    @Column(name = "creditscore")
    private Long creditscore;
    @Column(name = "areasqft")
    private Long areasqft;
    @Column(name = "cashneeded")
    private BigDecimal cashneeded;
    @Column(name = "afterrepairprice")
    private BigDecimal afterrepairprice;
    @Column(name = "currentprice")
    private BigDecimal currentprice;
    @Column(name = "operatingincome")
    private BigDecimal operatingincome;
    @Column(name = "netoperatingincome")
    private BigDecimal netoperatingincome;
    @Column(name = "operatingexpenses")
    private BigDecimal operatingexpenses;
    @Column(name = "cashflow")
    private BigDecimal cashflow;
    @Column(name = "purchasepricecaprate")
    private BigDecimal purchasepricecaprate;
    @Column(name = "marketvaluecaprate")
    private BigDecimal marketvaluecaprate;
    @Column(name = "cashoncash")
    private BigDecimal cashoncash;
    @Column(name = "renttovalue")
    private BigDecimal renttovalue;
    @Column(name = "grossrentmultiplier")
    private BigDecimal grossrentmultiplier;
    @Column(name = "debtcoverageratio")
    private BigDecimal debtcoverageratio;
    @Column(name = "propertyid")
    private Long propertyid;
    @Column(name = "createdby")
    private Long createdby;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Column(name = "modifiedby")
    private Long modifiedby;
    @Column(name = "modifieddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifieddate;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @Column(name = "maintainancepercentage")
    private BigDecimal maintainancepercentage;
    @Size(max = 2147483647)
    @Column(name = "address")
    private String address;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "beds")
    private Long beds;
    @Column(name = "baths")
    private Long baths;

    public MaDealCalculation() {
    }

    public MaDealCalculation(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getHomeprice() {
        return homeprice;
    }

    public void setHomeprice(BigDecimal homeprice) {
        this.homeprice = homeprice;
    }

    public BigDecimal getDownpayment() {
        return downpayment;
    }

    public void setDownpayment(BigDecimal downpayment) {
        this.downpayment = downpayment;
    }

    public BigDecimal getDownpaymentpercentage() {
        return downpaymentpercentage;
    }

    public void setDownpaymentpercentage(BigDecimal downpaymentpercentage) {
        this.downpaymentpercentage = downpaymentpercentage;
    }

    public BigDecimal getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(BigDecimal interestrate) {
        this.interestrate = interestrate;
    }

    public Long getLoantype() {
        return loantype;
    }

    public void setLoantype(Long loantype) {
        this.loantype = loantype;
    }

    public BigDecimal getPropertytax() {
        return propertytax;
    }

    public void setPropertytax(BigDecimal propertytax) {
        this.propertytax = propertytax;
    }

    public BigDecimal getPropertytaxpercentage() {
        return propertytaxpercentage;
    }

    public void setPropertytaxpercentage(BigDecimal propertytaxpercentage) {
        this.propertytaxpercentage = propertytaxpercentage;
    }

    public BigDecimal getHomeinsurance() {
        return homeinsurance;
    }

    public void setHomeinsurance(BigDecimal homeinsurance) {
        this.homeinsurance = homeinsurance;
    }

    public BigDecimal getHomeinsurancepercentage() {
        return homeinsurancepercentage;
    }

    public void setHomeinsurancepercentage(BigDecimal homeinsurancepercentage) {
        this.homeinsurancepercentage = homeinsurancepercentage;
    }

    public BigDecimal getHoadues() {
        return hoadues;
    }

    public void setHoadues(BigDecimal hoadues) {
        this.hoadues = hoadues;
    }

    public BigDecimal getMortageinsurance() {
        return mortageinsurance;
    }

    public void setMortageinsurance(BigDecimal mortageinsurance) {
        this.mortageinsurance = mortageinsurance;
    }

    public BigDecimal getMonthlyrent() {
        return monthlyrent;
    }

    public void setMonthlyrent(BigDecimal monthlyrent) {
        this.monthlyrent = monthlyrent;
    }

    public BigDecimal getRehabcost() {
        return rehabcost;
    }

    public void setRehabcost(BigDecimal rehabcost) {
        this.rehabcost = rehabcost;
    }

    public BigDecimal getAfterrepairvalue() {
        return afterrepairvalue;
    }

    public void setAfterrepairvalue(BigDecimal afterrepairvalue) {
        this.afterrepairvalue = afterrepairvalue;
    }

    public BigDecimal getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(BigDecimal purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public BigDecimal getPurchasepricepercentage() {
        return purchasepricepercentage;
    }

    public void setPurchasepricepercentage(BigDecimal purchasepricepercentage) {
        this.purchasepricepercentage = purchasepricepercentage;
    }

    public BigDecimal getMonthlycapreserv() {
        return monthlycapreserv;
    }

    public void setMonthlycapreserv(BigDecimal monthlycapreserv) {
        this.monthlycapreserv = monthlycapreserv;
    }

    public BigDecimal getMonthlycapreservpercentage() {
        return monthlycapreservpercentage;
    }

    public void setMonthlycapreservpercentage(BigDecimal monthlycapreservpercentage) {
        this.monthlycapreservpercentage = monthlycapreservpercentage;
    }

    public BigDecimal getMaintainance() {
        return maintainance;
    }

    public void setMaintainance(BigDecimal maintainance) {
        this.maintainance = maintainance;
    }

    public BigDecimal getPropertymanagement() {
        return propertymanagement;
    }

    public void setPropertymanagement(BigDecimal propertymanagement) {
        this.propertymanagement = propertymanagement;
    }

    public BigDecimal getVacancyrate() {
        return vacancyrate;
    }

    public void setVacancyrate(BigDecimal vacancyrate) {
        this.vacancyrate = vacancyrate;
    }

    public BigDecimal getOthermonthlycost() {
        return othermonthlycost;
    }

    public void setOthermonthlycost(BigDecimal othermonthlycost) {
        this.othermonthlycost = othermonthlycost;
    }

    public BigDecimal getPrincipalamount() {
        return principalamount;
    }

    public void setPrincipalamount(BigDecimal principalamount) {
        this.principalamount = principalamount;
    }

    public BigDecimal getInterestamount() {
        return interestamount;
    }

    public void setInterestamount(BigDecimal interestamount) {
        this.interestamount = interestamount;
    }

    public BigDecimal getNoofpayments() {
        return noofpayments;
    }

    public void setNoofpayments(BigDecimal noofpayments) {
        this.noofpayments = noofpayments;
    }

    public BigDecimal getMonthlypayment() {
        return monthlypayment;
    }

    public void setMonthlypayment(BigDecimal monthlypayment) {
        this.monthlypayment = monthlypayment;
    }

    public Long getCreditscore() {
        return creditscore;
    }

    public void setCreditscore(Long creditscore) {
        this.creditscore = creditscore;
    }

    public Long getAreasqft() {
        return areasqft;
    }

    public void setAreasqft(Long areasqft) {
        this.areasqft = areasqft;
    }

    public BigDecimal getCashneeded() {
        return cashneeded;
    }

    public void setCashneeded(BigDecimal cashneeded) {
        this.cashneeded = cashneeded;
    }

    public BigDecimal getAfterrepairprice() {
        return afterrepairprice;
    }

    public void setAfterrepairprice(BigDecimal afterrepairprice) {
        this.afterrepairprice = afterrepairprice;
    }

    public BigDecimal getCurrentprice() {
        return currentprice;
    }

    public void setCurrentprice(BigDecimal currentprice) {
        this.currentprice = currentprice;
    }

    public BigDecimal getOperatingincome() {
        return operatingincome;
    }

    public void setOperatingincome(BigDecimal operatingincome) {
        this.operatingincome = operatingincome;
    }

    public BigDecimal getNetoperatingincome() {
        return netoperatingincome;
    }

    public void setNetoperatingincome(BigDecimal netoperatingincome) {
        this.netoperatingincome = netoperatingincome;
    }

    public BigDecimal getOperatingexpenses() {
        return operatingexpenses;
    }

    public void setOperatingexpenses(BigDecimal operatingexpenses) {
        this.operatingexpenses = operatingexpenses;
    }

    public BigDecimal getCashflow() {
        return cashflow;
    }

    public void setCashflow(BigDecimal cashflow) {
        this.cashflow = cashflow;
    }

    public BigDecimal getPurchasepricecaprate() {
        return purchasepricecaprate;
    }

    public void setPurchasepricecaprate(BigDecimal purchasepricecaprate) {
        this.purchasepricecaprate = purchasepricecaprate;
    }

    public BigDecimal getMarketvaluecaprate() {
        return marketvaluecaprate;
    }

    public void setMarketvaluecaprate(BigDecimal marketvaluecaprate) {
        this.marketvaluecaprate = marketvaluecaprate;
    }

    public BigDecimal getCashoncash() {
        return cashoncash;
    }

    public void setCashoncash(BigDecimal cashoncash) {
        this.cashoncash = cashoncash;
    }

    public BigDecimal getRenttovalue() {
        return renttovalue;
    }

    public void setRenttovalue(BigDecimal renttovalue) {
        this.renttovalue = renttovalue;
    }

    public BigDecimal getGrossrentmultiplier() {
        return grossrentmultiplier;
    }

    public void setGrossrentmultiplier(BigDecimal grossrentmultiplier) {
        this.grossrentmultiplier = grossrentmultiplier;
    }

    public BigDecimal getDebtcoverageratio() {
        return debtcoverageratio;
    }

    public void setDebtcoverageratio(BigDecimal debtcoverageratio) {
        this.debtcoverageratio = debtcoverageratio;
    }

    public Long getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(Long propertyid) {
        this.propertyid = propertyid;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Long getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
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

    public BigDecimal getMaintainancepercentage() {
        return maintainancepercentage;
    }

    public void setMaintainancepercentage(BigDecimal maintainancepercentage) {
        this.maintainancepercentage = maintainancepercentage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getBeds() {
        return beds;
    }

    public void setBeds(Long beds) {
        this.beds = beds;
    }

    public Long getBaths() {
        return baths;
    }

    public void setBaths(Long baths) {
        this.baths = baths;
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
        if (!(object instanceof MaDealCalculation)) {
            return false;
        }
        MaDealCalculation other = (MaDealCalculation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.realdeal.entity.MaDealCalculation[ id=" + id + " ]";
    }

}
