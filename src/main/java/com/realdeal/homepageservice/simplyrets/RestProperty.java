/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author Admin
 */
public class RestProperty {


    private String privateRemarks;
    private Object showingContactName;
    private Property property;
    private int mlsId;
    private Object showingContactPhone;
    private String terms;
    private String showingInstructions;
    private Office office;
    private Object leaseTerm;
    private String disclaimer;
    private Address address;
    private String agreement;
    private Date listDate;
    private Agent agent;
    private Date modified;
    private School school;
    private List<String> photos;
    private int listPrice;
    private String listingId;
    private Mls mls;
    private Geo geo;
    private Tax tax;
    private CoAgent coAgent;
    private Sales sales;
    private String leaseType;
    private Object virtualTourUrl;
    private String remarks;
    private Association association;
    private Date lastUpdate;
    private BigDecimal listPricePerArea;
    private BigDecimal closePricePerArea;
    private boolean isActive;
    private boolean isError;
    private String Error;
    private BigDecimal Distance;
    private String formattedPrice;
    private String formattedRentPrice;
    private String formattedSqftPrice;
    private BigDecimal dealPercentage;
    private BigDecimal rentPrice;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public BigDecimal getClosePricePerArea() {
        return closePricePerArea;
    }

    public void setClosePricePerArea(BigDecimal closePricePerArea) {
        this.closePricePerArea = closePricePerArea;
    }

    public BigDecimal getListPricePerArea() {
        return listPricePerArea;
    }

    public void setListPricePerArea(BigDecimal listPricePerArea) {
        this.listPricePerArea = listPricePerArea;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @return the privateRemarks
     */
    public String getPrivateRemarks() {
        return privateRemarks == null ? "" : privateRemarks;
    }

    /**
     * @param privateRemarks the privateRemarks to set
     */
    public void setPrivateRemarks(String privateRemarks) {
        this.privateRemarks = privateRemarks;
    }

    /**
     * @return the showingContactName
     */
    public Object getShowingContactName() {
        return showingContactName;
    }

    /**
     * @param showingContactName the showingContactName to set
     */
    public void setShowingContactName(Object showingContactName) {
        this.showingContactName = showingContactName;
    }

    /**
     * @return the property
     */
    public Property getProperty() {
        return property;
    }

    /**
     * @param property the property to set
     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * @return the mlsId
     */
    public int getMlsId() {
        return mlsId;
    }

    /**
     * @param mlsId the mlsId to set
     */
    public void setMlsId(int mlsId) {
        this.mlsId = mlsId;
    }

    /**
     * @return the showingContactPhone
     */
    public Object getShowingContactPhone() {
        return showingContactPhone;
    }

    /**
     * @param showingContactPhone the showingContactPhone to set
     */
    public void setShowingContactPhone(Object showingContactPhone) {
        this.showingContactPhone = showingContactPhone;
    }

    /**
     * @return the terms
     */
    public String getTerms() {
        return terms == null ? "" : terms;
    }

    /**
     * @param terms the terms to set
     */
    public void setTerms(String terms) {
        this.terms = terms;
    }

    /**
     * @return the showingInstructions
     */
    public String getShowingInstructions() {

        return showingInstructions == null ? "" : showingInstructions;
    }

    /**
     * @param showingInstructions the showingInstructions to set
     */
    public void setShowingInstructions(String showingInstructions) {
        this.showingInstructions = showingInstructions;
    }

    /**
     * @return the office
     */
    public Office getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(Office office) {
        this.office = office;
    }

    /**
     * @return the leaseTerm
     */
    public Object getLeaseTerm() {
        return leaseTerm;
    }

    /**
     * @param leaseTerm the leaseTerm to set
     */
    public void setLeaseTerm(Object leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    /**
     * @return the disclaimer
     */
    public String getDisclaimer() {

        return disclaimer == null ? "" : disclaimer;
    }

    /**
     * @param disclaimer the disclaimer to set
     */
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the agreement
     */
    public String getAgreement() {
        return agreement == null ? "" : agreement;

    }

    /**
     * @param agreement the agreement to set
     */
    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    /**
     * @return the listDate
     */
    public Date getListDate() {
        return listDate;
    }

    /**
     * @param listDate the listDate to set
     */
    public void setListDate(Date listDate) {
        this.listDate = listDate;
    }

    /**
     * @return the agent
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * @param agent the agent to set
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    /**
     * @return the modified
     */
    public Date getModified() {
        return modified;
    }

    /**
     * @param modified the modified to set
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * @return the school
     */
    public School getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(School school) {
        this.school = school;
    }

    /**
     * @return the photos
     */
    public List<String> getPhotos() {
        return photos;
    }

    /**
     * @param photos the photos to set
     */
    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    /**
     * @return the listPrice
     */
    public int getListPrice() {
        return listPrice;
    }

    /**
     * @param listPrice the listPrice to set
     */
    public void setListPrice(int listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * @return the listingId
     */
    public String getListingId() {
        return listingId == null ? "" : listingId;

    }

    /**
     * @param listingId the listingId to set
     */
    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    /**
     * @return the mls
     */
    public Mls getMls() {
        return mls;
    }

    /**
     * @param mls the mls to set
     */
    public void setMls(Mls mls) {
        this.mls = mls;
    }

    /**
     * @return the geo
     */
    public Geo getGeo() {
        return geo;
    }

    /**
     * @param geo the geo to set
     */
    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    /**
     * @return the tax
     */
    public Tax getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(Tax tax) {
        this.tax = tax;
    }

    /**
     * @return the coAgent
     */
    public CoAgent getCoAgent() {
        return coAgent;
    }

    /**
     * @param coAgent the coAgent to set
     */
    public void setCoAgent(CoAgent coAgent) {
        this.coAgent = coAgent;
    }

    /**
     * @return the sales
     */
    public Sales getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(Sales sales) {
        this.sales = sales;
    }

    /**
     * @return the leaseType
     */
    public String getLeaseType() {
        return leaseType == null ? "" : leaseType;

    }

    /**
     * @param leaseType the leaseType to set
     */
    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    /**
     * @return the virtualTourUrl
     */
    public Object getVirtualTourUrl() {
        return virtualTourUrl;
    }

    /**
     * @param virtualTourUrl the virtualTourUrl to set
     */
    public void setVirtualTourUrl(Object virtualTourUrl) {
        this.virtualTourUrl = virtualTourUrl;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {

        return remarks == null ? "" : remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;

    }

    /**
     * @return the association
     */
    public Association getAssociation() {
        return association;
    }

    /**
     * @param association the association to set
     */
    public void setAssociation(Association association) {
        this.association = association;
    }

    /**
     * @return the Distance
     */
    public BigDecimal getDistance() {
        return Distance;
    }

    /**
     * @param Distance the Distance to set
     */
    public void setDistance(BigDecimal Distance) {
        this.Distance = Distance;
    }

    /**
     * @return the formattedPrice
     */
    public String getFormattedPrice() {
        return formattedPrice == null ? "" : formattedPrice;

    }

    /**
     * @param formattedPrice the formattedPrice to set
     */
    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    /**
     * @return the formattedRentPrice
     */
    public String getFormattedRentPrice() {
        return formattedRentPrice == null ? "" : formattedRentPrice;

    }

    /**
     * @param formattedRentPrice the formattedRentPrice to set
     */
    public void setFormattedRentPrice(String formattedRentPrice) {
        this.formattedRentPrice = formattedRentPrice;
    }

    /**
     * @return the dealPercentage
     */
    public BigDecimal getDealPercentage() {
        return dealPercentage;
    }

    /**
     * @param dealPercentage the dealPercentage to set
     */
    public void setDealPercentage(BigDecimal dealPercentage) {
        this.dealPercentage = dealPercentage;
    }

    /**
     * @return the rentPrice
     */
    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    /**
     * @param rentPrice the rentPrice to set
     */
    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    /**
     * @return the formattedSqftPrice
     */
    public String getFormattedSqftPrice() {
        return formattedSqftPrice == null ? "" : formattedSqftPrice;

    }

    /**
     * @param formattedSqftPrice the formattedSqftPrice to set
     */
    public void setFormattedSqftPrice(String formattedSqftPrice) {
        this.formattedSqftPrice = formattedSqftPrice;
    }
}
