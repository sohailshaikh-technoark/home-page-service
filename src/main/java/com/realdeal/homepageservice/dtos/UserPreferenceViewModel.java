package com.realdeal.homepageservice.dtos;


import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Admin
 */
public class UserPreferenceViewModel {

    public Boolean HasPreference;

    public long Id;

    public BigDecimal MinPrice;

    public String StrMinPrice;

    public BigDecimal MaxPrice;

    public String StrMaxPrice;

    public BigDecimal Discount;

    public BigDecimal DownPaymentPercentage;

    public BigDecimal InterestRatePercentage;

    public BigDecimal HomeOwnerInsurancePercentage;

    public BigDecimal MortageInsurance;

    public String SubType;

    public String Type;

    public Long MinBuiltYear;
    public Long MaxBuiltYear;
    public Long MinSqft;
    public String StrMinSqft;
    public Long MaxSqft;
    public String StrMaxSqft;
    public String Recency;
    public Long MinBeds;
    public String StrMinBeds;
    public Long MaxBeds;
    public String StrMaxBeds;
    public Long MinBaths;
    public String StrMinBaths;
    public Long MaxBaths;
    public String StrMaxBaths;
    public BigDecimal SearchRadius;
    public Long SoldDateMonths;
    public Long AreaSqft;
    public Long YearBuilt;
    public String SimilarStories;
    public Long Bedroom;

    public Boolean getHasPreference() {
        return HasPreference;
    }

    public void setHasPreference(Boolean HasPreference) {
        this.HasPreference = HasPreference;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public BigDecimal getMinPrice() {
        return (MinPrice == null) ? BigDecimal.ZERO : MinPrice;
    }

    public void setMinPrice(BigDecimal MinPrice) {
        this.MinPrice = MinPrice;
    }

    public String getStrMinPrice() {
        return StrMinPrice;
    }

    public void setStrMinPrice(String StrMinPrice) {
        this.StrMinPrice = StrMinPrice;
    }

    public BigDecimal getMaxPrice() {

        return (MaxPrice == null) ? BigDecimal.ZERO : MaxPrice;
    }

    public void setMaxPrice(BigDecimal MaxPrice) {
        this.MaxPrice = MaxPrice;
    }

    public String getStrMaxPrice() {
        return StrMaxPrice;
    }

    public void setStrMaxPrice(String StrMaxPrice) {
        this.StrMaxPrice = StrMaxPrice;
    }

    public BigDecimal getDiscount() {
        return Discount;
    }

    public void setDiscount(BigDecimal Discount) {
        this.Discount = Discount;
    }

    public BigDecimal getDownPaymentPercentage() {
        return DownPaymentPercentage;
    }

    public void setDownPaymentPercentage(BigDecimal DownPaymentPercentage) {
        this.DownPaymentPercentage = DownPaymentPercentage;
    }

    public BigDecimal getInterestRatePercentage() {
        return InterestRatePercentage;
    }

    public void setInterestRatePercentage(BigDecimal InterestRatePercentage) {
        this.InterestRatePercentage = InterestRatePercentage;
    }

    public BigDecimal getHomeOwnerInsurancePercentage() {
        return HomeOwnerInsurancePercentage;
    }

    public void setHomeOwnerInsurancePercentage(BigDecimal HomeOwnerInsurancePercentage) {
        this.HomeOwnerInsurancePercentage = HomeOwnerInsurancePercentage;
    }

    public BigDecimal getMortageInsurance() {
        return MortageInsurance;
    }

    public void setMortageInsurance(BigDecimal MortageInsurance) {
        this.MortageInsurance = MortageInsurance;
    }

    public String getSubType() {
        return SubType;
    }

    public void setSubType(String SubType) {
        this.SubType = SubType;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public Long getMinBuiltYear() {
        return MinBuiltYear;
    }

    public void setMinBuiltYear(Long MinBuiltYear) {
        this.MinBuiltYear = MinBuiltYear;
    }

    public Long getMaxBuiltYear() {
        return MaxBuiltYear;
    }

    public void setMaxBuiltYear(Long MaxBuiltYear) {
        this.MaxBuiltYear = MaxBuiltYear;
    }

    public Long getMinSqft() {
        return (MinSqft == null) ? 0 : MinSqft;
    }

    public void setMinSqft(Long MinSqft) {
        this.MinSqft = MinSqft;
    }

    public String getStrMinSqft() {
        return StrMinSqft;
    }

    public void setStrMinSqft(String StrMinSqft) {
        this.StrMinSqft = StrMinSqft;
    }

    public Long getMaxSqft() {
        return (MaxSqft == null) ? 0 : MaxSqft;
    }

    public void setMaxSqft(Long MaxSqft) {
        this.MaxSqft = MaxSqft;
    }

    public String getStrMaxSqft() {
        return StrMaxSqft;
    }

    public void setStrMaxSqft(String StrMaxSqft) {
        this.StrMaxSqft = StrMaxSqft;
    }

    public String getRecency() {
        return Recency;
    }

    public void setRecency(String Recency) {
        this.Recency = Recency;
    }

    public Long getMinBeds() {
        return (MinBeds == null) ? 0 : MinBeds;
    }

    public void setMinBeds(Long MinBeds) {
        this.MinBeds = MinBeds;
    }

    public String getStrMinBeds() {
        return StrMinBeds;
    }

    public void setStrMinBeds(String StrMinBeds) {
        this.StrMinBeds = StrMinBeds;
    }

    public Long getMaxBeds() {
        return (MaxBeds == null) ? 0 : MaxBeds;

    }

    public void setMaxBeds(Long MaxBeds) {
        this.MaxBeds = MaxBeds;
    }

    public String getStrMaxBeds() {
        return StrMaxBeds;
    }

    public void setStrMaxBeds(String StrMaxBeds) {
        this.StrMaxBeds = StrMaxBeds;
    }

    public Long getMinBaths() {
        return (MinBaths == null) ? 0 : MinBaths;
    }

    public void setMinBaths(Long MinBaths) {
        this.MinBaths = MinBaths;
    }

    public String getStrMinBaths() {
        return StrMinBaths;
    }

    public void setStrMinBaths(String StrMinBaths) {
        this.StrMinBaths = StrMinBaths;
    }

    public Long getMaxBaths() {
        return (MaxBaths == null) ? 0 : MaxBaths;
    }

    public void setMaxBaths(Long MaxBaths) {
        this.MaxBaths = MaxBaths;
    }

    public String getStrMaxBaths() {
        return StrMaxBaths;
    }

    public void setStrMaxBaths(String StrMaxBaths) {
        this.StrMaxBaths = StrMaxBaths;
    }

    public BigDecimal getSearchRadius() {
        return SearchRadius;
    }

    public void setSearchRadius(BigDecimal SearchRadius) {
        this.SearchRadius = SearchRadius;
    }

    public Long getSoldDateMonths() {
        return SoldDateMonths;
    }

    public void setSoldDateMonths(Long SoldDateMonths) {
        this.SoldDateMonths = SoldDateMonths;
    }

    public Long getAreaSqft() {
        return AreaSqft;
    }

    public void setAreaSqft(Long AreaSqft) {
        this.AreaSqft = AreaSqft;
    }

    public Long getYearBuilt() {
        return YearBuilt;
    }

    public void setYearBuilt(Long YearBuilt) {
        this.YearBuilt = YearBuilt;
    }

    public String getSimilarStories() {
        return SimilarStories;
    }

    public void setSimilarStories(String SimilarStories) {
        this.SimilarStories = SimilarStories;
    }

    public Long getBedroom() {
        return Bedroom;
    }

    public void setBedroom(Long Bedroom) {
        this.Bedroom = Bedroom;
    }
}
