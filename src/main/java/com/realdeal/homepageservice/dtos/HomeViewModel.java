/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.dtos;

import com.realdeal.homepageservice.crimeometer.CrimeIncedents;
import com.realdeal.homepageservice.simplyrets.Location;
import com.realdeal.homepageservice.simplyrets.RestProperty;
import org.apache.commons.text.StringEscapeUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Admin
 */
public class HomeViewModel {

    private List<HomeViewModel> savedlist = new ArrayList<HomeViewModel>();

    private int TotalProperties;

    private String Error;

    private String CrimeApiError;
    private boolean hasError;
    private String Search;
    private String ZipCode;
    private String PropertyType;
    private String PropertySubType;
    private BigDecimal MinPrice;
    private String StrMinPrice;
    private Boolean bFilter;
    private BigDecimal MaxPrice;
    private String StrMaxPrice;
    private Long MinBeds;
    private Long Distance;
    private Long MinYear;
    private Long PageNumber;
    private Long MaxYear;
    private Long MinSqft;
    private Long MaxSqft;
    private String StrMinBeds;
    private String StrMinSqft;
    private String StrMaxSqft;
    private String Recency;
    private Long MaxBeds;
    private String StrMaxBeds;
    private Long MinBaths;
    private String StrMinBaths;
    private String StrDistance;
    private Long MaxBaths;
    private BigDecimal MaxHoaFees;
    private String StrMaxHoaFees;
    private Long MinLotSize;
    private String StrMinLotSize;
    private String PropertyStatus;
    private String FixerUpper;
    private String DealPercentage;
    private Long MaxLotSize;
    private String StrMaxLotSize;
    private String StrMaxBaths;
    private List<RestProperty> list = new ArrayList<RestProperty>();
    private List<RestProperty> dealPropertylist = new ArrayList<RestProperty>();
    private List<RestProperty> monthlyRentPropertylist = new ArrayList<RestProperty>();
    private String view;
    private String jsonlist;
    private String monthlyrentjsonlist;
    private String crimejsonlist;
    private RestProperty PropertyDetails = new RestProperty();
    private List<RestProperty> properties = new ArrayList<RestProperty>();
    private BigDecimal Average;
    private BigDecimal AverageRent;
    private String Deal;
    private String locationjson;
    private List<Location> locations;
    private BigDecimal HomePrice;
    private BigDecimal DownPayment;
    private BigDecimal DownPaymentPercentage;
    private BigDecimal InterestRate;
    private Long LoanType;
    private BigDecimal PropertyTax;
    private BigDecimal PropertyTaxPercentage;
    private BigDecimal HomeInsurance;
    private BigDecimal HomeInsurancePercentage;
    private BigDecimal HoaDues;
    private BigDecimal MortageInsurance;
    private BigDecimal MonthlyRent;
    private BigDecimal RehabCost;
    private BigDecimal AfterRepairValue;
    private BigDecimal PurchasePrice;
    private BigDecimal PurchasePricePercentage;
    private BigDecimal MonthlyCapReserv;
    private BigDecimal MonthlyCapReservPercentage;
    private BigDecimal Maintainance;
    private BigDecimal MaintainancePercentage;
    private BigDecimal PropertyManagement;
    private BigDecimal Vacancyrate;
    private BigDecimal OtherMonthlyCost;
    private BigDecimal PrincipalAmount;
    private BigDecimal InterestAmount;
    private BigDecimal NoOfPayments;
    private BigDecimal MonthlyPayment;
    private Long CreditScore;
    private Long AreaSqft;
    private BigDecimal CashNeeded;
    private BigDecimal CurrentPrice;
    private BigDecimal AfterRepairPrice;
    private BigDecimal OperatingIncome;
    private BigDecimal NetOperatingIncome;
    private BigDecimal OperatingExpenses;
    private BigDecimal CashFlow;
    private BigDecimal PurchasePriceCapRate;
    private BigDecimal MarketValueCapRate;
    private BigDecimal CashOnCash;
    private BigDecimal RentToValue;
    private BigDecimal GrossRentMultiplier;
    private BigDecimal DebtCoverageRatio;
    private Long ID;
    private Long CreatedBy;
    private Date CreatedDate;
    private Date ModifiedDate;
    private Long ModifiedBy;
    private Boolean Status;
    private Long PropertyID;
    private Long Baths;
    private Long Beds;
    private BigDecimal Price;
    private String Address;
    private String EncryptedID;


    private List<CrimeIncedents> crimeIncedents;

    public List<CrimeIncedents> getCrimeIncedents() {
        return crimeIncedents;
    }

    public void setCrimeIncedents(List<CrimeIncedents> crimeIncedents) {
        this.crimeIncedents = crimeIncedents;
    }

    public String getCrimeApiError() {
        return CrimeApiError;
    }

    public void setCrimeApiError(String CrimeApiError) {
        this.CrimeApiError = CrimeApiError;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public int getTotalProperties() {
        return TotalProperties;
    }

    public void setTotalProperties(int TotalProperties) {
        this.TotalProperties = TotalProperties;
    }

    public Long getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(Long PageNumber) {
        this.PageNumber = PageNumber;
    }

    public String getDealPercentage() {
        return DealPercentage;
    }

    public void setDealPercentage(String DealPercentage) {
        this.DealPercentage = DealPercentage;
    }

    public String getPropertyStatus() {
        return PropertyStatus;
    }

    public void setPropertyStatus(String PropertyStatus) {
        this.PropertyStatus = PropertyStatus;
    }

    public String getFixerUpper() {
        return FixerUpper;
    }

    public void setFixerUpper(String FixerUpper) {
        this.FixerUpper = FixerUpper;
    }

    public BigDecimal getMaxHoaFees() {
        return MaxHoaFees;
    }

    public void setMaxHoaFees(BigDecimal MaxHoaFees) {
        this.MaxHoaFees = MaxHoaFees;
    }

    public String getStrMaxHoaFees() {
        return StrMaxHoaFees;
    }

    public void setStrMaxHoaFees(String StrMaxHoaFees) {
        this.StrMaxHoaFees = StrMaxHoaFees;
    }

    public Long getMinLotSize() {
        return MinLotSize;
    }

    public void setMinLotSize(Long MinLotSize) {
        this.MinLotSize = MinLotSize;
    }

    public String getStrMinLotSize() {
        return StrMinLotSize;
    }

    public void setStrMinLotSize(String StrMinLotSize) {
        this.StrMinLotSize = StrMinLotSize;
    }

    public Long getMaxLotSize() {
        return MaxLotSize;
    }

    public void setMaxLotSize(Long MaxLotSize) {
        this.MaxLotSize = MaxLotSize;
    }

    public String getStrMaxLotSize() {
        return StrMaxLotSize;
    }

    public void setStrMaxLotSize(String StrMaxLotSize) {
        this.StrMaxLotSize = StrMaxLotSize;
    }

    public List<HomeViewModel> getSavedlist() {
        return savedlist;
    }

    public void setSavedlist(List<HomeViewModel> savedlist) {
        this.savedlist = savedlist;
    }

    public String getSearch() {
        return Search;
    }

    public void setSearch(String Search) {
        this.Search = Search;
    }

    public String getPropertyType() {
        return PropertyType;
    }

    public void setPropertyType(String PropertyType) {
        this.PropertyType = PropertyType;
    }

    public String getPropertySubType() {
        return PropertySubType;
    }

    public void setPropertySubType(String PropertySubType) {
        this.PropertySubType = PropertySubType;
    }

    public BigDecimal getMinPrice() {
        return MinPrice;
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

    public Boolean getbFilter() {
        return bFilter;
    }

    public void setbFilter(Boolean bFilter) {
        this.bFilter = bFilter;
    }

    public BigDecimal getMaxPrice() {
        return MaxPrice;
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

    public Long getMinBeds() {
        return MinBeds;
    }

    public void setMinBeds(Long MinBeds) {
        this.MinBeds = MinBeds;
    }

    public Long getDistance() {
        return Distance;
    }

    public void setDistance(Long Distance) {
        this.Distance = Distance;
    }

    public Long getMinYear() {
        return MinYear;
    }

    public void setMinYear(Long MinYear) {
        this.MinYear = MinYear;
    }

    public Long getMaxYear() {
        return MaxYear;
    }

    public void setMaxYear(Long MaxYear) {
        this.MaxYear = MaxYear;
    }

    public Long getMinSqft() {
        return MinSqft;
    }

    public void setMinSqft(Long MinSqft) {
        this.MinSqft = MinSqft;
    }

    public Long getMaxSqft() {
        return MaxSqft;
    }

    public void setMaxSqft(Long MaxSqft) {
        this.MaxSqft = MaxSqft;
    }

    public String getStrMinBeds() {
        return StrMinBeds;
    }

    public void setStrMinBeds(String StrMinBeds) {
        this.StrMinBeds = StrMinBeds;
    }

    public String getStrMinSqft() {
        return StrMinSqft;
    }

    public void setStrMinSqft(String StrMinSqft) {
        this.StrMinSqft = StrMinSqft;
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

    public Long getMaxBeds() {
        return MaxBeds;
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
        return MinBaths;
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

    public String getStrDistance() {
        return StrDistance;
    }

    public void setStrDistance(String StrDistance) {
        this.StrDistance = StrDistance;
    }

    public Long getMaxBaths() {
        return MaxBaths;
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

    public List<RestProperty> getList() {
        return list;
    }

    public void setList(List<RestProperty> list) {
        this.list = list;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getJsonlist() {
        return jsonlist == null ? "" : StringEscapeUtils.escapeJson(jsonlist);

    }

    public void setJsonlist(String jsonlist) {
        this.jsonlist = jsonlist;
    }

    public String getOrgJsonlist() {
        return jsonlist == null ? "" : jsonlist;

    }

    public RestProperty getPropertyDetails() {
        return PropertyDetails;
    }

    public void setPropertyDetails(RestProperty PropertyDetails) {
        this.PropertyDetails = PropertyDetails;
    }

    public List<RestProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<RestProperty> properties) {
        this.properties = properties;
    }

    public BigDecimal getAverage() {
        return Average;
    }

    public void setAverage(BigDecimal Average) {
        this.Average = Average;
    }

    public BigDecimal getAverageRent() {
        return AverageRent;
    }

    public void setAverageRent(BigDecimal AverageRent) {
        this.AverageRent = AverageRent;
    }

    public String getDeal() {
        return Deal;
    }

    public void setDeal(String Deal) {
        this.Deal = Deal;
    }

    public String getLocationjson() {

        return locationjson == null ? "" : StringEscapeUtils.escapeJson(locationjson);
    }

    public void setLocationjson(String locationjson) {
        this.locationjson = locationjson;
    }

    public BigDecimal getHomePrice() {
        return HomePrice;
    }

    public void setHomePrice(BigDecimal HomePrice) {
        this.HomePrice = HomePrice;
    }

    public BigDecimal getDownPayment() {
        return DownPayment;
    }

    public void setDownPayment(BigDecimal DownPayment) {
        this.DownPayment = DownPayment;
    }

    public BigDecimal getDownPaymentPercentage() {
        return DownPaymentPercentage;
    }

    public void setDownPaymentPercentage(BigDecimal DownPaymentPercentage) {
        this.DownPaymentPercentage = DownPaymentPercentage;
    }

    public BigDecimal getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(BigDecimal InterestRate) {
        this.InterestRate = InterestRate;
    }

    public Long getLoanType() {
        return LoanType;
    }

    public void setLoanType(Long LoanType) {
        this.LoanType = LoanType;
    }

    public BigDecimal getPropertyTax() {
        return PropertyTax;
    }

    public void setPropertyTax(BigDecimal PropertyTax) {
        this.PropertyTax = PropertyTax;
    }

    public BigDecimal getPropertyTaxPercentage() {
        return PropertyTaxPercentage;
    }

    public void setPropertyTaxPercentage(BigDecimal PropertyTaxPercentage) {
        this.PropertyTaxPercentage = PropertyTaxPercentage;
    }

    public BigDecimal getHomeInsurance() {
        return HomeInsurance;
    }

    public void setHomeInsurance(BigDecimal HomeInsurance) {
        this.HomeInsurance = HomeInsurance;
    }

    public BigDecimal getHomeInsurancePercentage() {
        return HomeInsurancePercentage;
    }

    public void setHomeInsurancePercentage(BigDecimal HomeInsurancePercentage) {
        this.HomeInsurancePercentage = HomeInsurancePercentage;
    }

    public BigDecimal getHoaDues() {
        return HoaDues;
    }

    public void setHoaDues(BigDecimal HoaDues) {
        this.HoaDues = HoaDues;
    }

    public BigDecimal getMortageInsurance() {
        return MortageInsurance;
    }

    public void setMortageInsurance(BigDecimal MortageInsurance) {
        this.MortageInsurance = MortageInsurance;
    }

    public BigDecimal getMonthlyRent() {
        return MonthlyRent;
    }

    public void setMonthlyRent(BigDecimal MonthlyRent) {
        this.MonthlyRent = MonthlyRent;
    }

    public BigDecimal getRehabCost() {
        return RehabCost;
    }

    public void setRehabCost(BigDecimal RehabCost) {
        this.RehabCost = RehabCost;
    }

    public BigDecimal getAfterRepairValue() {
        return AfterRepairValue;
    }

    public void setAfterRepairValue(BigDecimal AfterRepairValue) {
        this.AfterRepairValue = AfterRepairValue;
    }

    public BigDecimal getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(BigDecimal PurchasePrice) {
        this.PurchasePrice = PurchasePrice;
    }

    public BigDecimal getPurchasePricePercentage() {
        return PurchasePricePercentage;
    }

    public void setPurchasePricePercentage(BigDecimal PurchasePricePercentage) {
        this.PurchasePricePercentage = PurchasePricePercentage;
    }

    public BigDecimal getMonthlyCapReserv() {
        return MonthlyCapReserv;
    }

    public void setMonthlyCapReserv(BigDecimal MonthlyCapReserv) {
        this.MonthlyCapReserv = MonthlyCapReserv;
    }

    public BigDecimal getMonthlyCapReservPercentage() {
        return MonthlyCapReservPercentage;
    }

    public void setMonthlyCapReservPercentage(BigDecimal MonthlyCapReservPercentage) {
        this.MonthlyCapReservPercentage = MonthlyCapReservPercentage;
    }

    public BigDecimal getMaintainance() {
        return Maintainance;
    }

    public void setMaintainance(BigDecimal Maintainance) {
        this.Maintainance = Maintainance;
    }

    public BigDecimal getMaintainancePercentage() {
        return MaintainancePercentage;
    }

    public void setMaintainancePercentage(BigDecimal MaintainancePercentage) {
        this.MaintainancePercentage = MaintainancePercentage;
    }

    public BigDecimal getPropertyManagement() {
        return PropertyManagement;
    }

    public void setPropertyManagement(BigDecimal PropertyManagement) {
        this.PropertyManagement = PropertyManagement;
    }

    public BigDecimal getVacancyrate() {
        return Vacancyrate;
    }

    public void setVacancyrate(BigDecimal Vacancyrate) {
        this.Vacancyrate = Vacancyrate;
    }

    public BigDecimal getOtherMonthlyCost() {
        return OtherMonthlyCost;
    }

    public void setOtherMonthlyCost(BigDecimal OtherMonthlyCost) {
        this.OtherMonthlyCost = OtherMonthlyCost;
    }

    public BigDecimal getPrincipalAmount() {
        return PrincipalAmount;
    }

    public void setPrincipalAmount(BigDecimal PrincipalAmount) {
        this.PrincipalAmount = PrincipalAmount;
    }

    public BigDecimal getInterestAmount() {
        return InterestAmount;
    }

    public void setInterestAmount(BigDecimal InterestAmount) {
        this.InterestAmount = InterestAmount;
    }

    public BigDecimal getNoOfPayments() {
        return NoOfPayments;
    }

    public void setNoOfPayments(BigDecimal NoOfPayments) {
        this.NoOfPayments = NoOfPayments;
    }

    public BigDecimal getMonthlyPayment() {
        return MonthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal MonthlyPayment) {
        this.MonthlyPayment = MonthlyPayment;
    }

    public Long getCreditScore() {
        return CreditScore;
    }

    public void setCreditScore(Long CreditScore) {
        this.CreditScore = CreditScore;
    }

    public Long getAreaSqft() {
        return AreaSqft;
    }

    public void setAreaSqft(Long AreaSqft) {
        this.AreaSqft = AreaSqft;
    }

    public BigDecimal getCashNeeded() {
        return CashNeeded;
    }

    public void setCashNeeded(BigDecimal CashNeeded) {
        this.CashNeeded = CashNeeded;
    }

    public BigDecimal getCurrentPrice() {
        return CurrentPrice;
    }

    public void setCurrentPrice(BigDecimal CurrentPrice) {
        this.CurrentPrice = CurrentPrice;
    }

    public BigDecimal getAfterRepairPrice() {
        return AfterRepairPrice;
    }

    public void setAfterRepairPrice(BigDecimal AfterRepairPrice) {
        this.AfterRepairPrice = AfterRepairPrice;
    }

    public BigDecimal getOperatingIncome() {
        return OperatingIncome;
    }

    public void setOperatingIncome(BigDecimal OperatingIncome) {
        this.OperatingIncome = OperatingIncome;
    }

    public BigDecimal getNetOperatingIncome() {
        return NetOperatingIncome;
    }

    public void setNetOperatingIncome(BigDecimal NetOperatingIncome) {
        this.NetOperatingIncome = NetOperatingIncome;
    }

    public BigDecimal getOperatingExpenses() {
        return OperatingExpenses;
    }

    public void setOperatingExpenses(BigDecimal OperatingExpenses) {
        this.OperatingExpenses = OperatingExpenses;
    }

    public BigDecimal getCashFlow() {
        return CashFlow;
    }

    public void setCashFlow(BigDecimal CashFlow) {
        this.CashFlow = CashFlow;
    }

    public BigDecimal getPurchasePriceCapRate() {
        return PurchasePriceCapRate;
    }

    public void setPurchasePriceCapRate(BigDecimal PurchasePriceCapRate) {
        this.PurchasePriceCapRate = PurchasePriceCapRate;
    }

    public BigDecimal getMarketValueCapRate() {
        return MarketValueCapRate;
    }

    public void setMarketValueCapRate(BigDecimal MarketValueCapRate) {
        this.MarketValueCapRate = MarketValueCapRate;
    }

    public BigDecimal getCashOnCash() {
        return CashOnCash;
    }

    public void setCashOnCash(BigDecimal CashOnCash) {
        this.CashOnCash = CashOnCash;
    }

    public BigDecimal getRentToValue() {
        return RentToValue;
    }

    public void setRentToValue(BigDecimal RentToValue) {
        this.RentToValue = RentToValue;
    }

    public BigDecimal getGrossRentMultiplier() {
        return GrossRentMultiplier;
    }

    public void setGrossRentMultiplier(BigDecimal GrossRentMultiplier) {
        this.GrossRentMultiplier = GrossRentMultiplier;
    }

    public BigDecimal getDebtCoverageRatio() {
        return DebtCoverageRatio;
    }

    public void setDebtCoverageRatio(BigDecimal DebtCoverageRatio) {
        this.DebtCoverageRatio = DebtCoverageRatio;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(Long CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(Date ModifiedDate) {
        this.ModifiedDate = ModifiedDate;
    }

    public Long getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(Long ModifiedBy) {
        this.ModifiedBy = ModifiedBy;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public Long getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(Long PropertyID) {
        this.PropertyID = PropertyID;
    }

    public Long getBaths() {
        return Baths;
    }

    public void setBaths(Long Baths) {
        this.Baths = Baths;
    }

    public Long getBeds() {
        return Beds;
    }

    public void setBeds(Long Beds) {
        this.Beds = Beds;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEncryptedID() {
        return EncryptedID;
    }

    public void setEncryptedID(String EncryptedID) {
        this.EncryptedID = EncryptedID;
    }

    public List<RestProperty> getMonthlyRentPropertylist() {
        return monthlyRentPropertylist;
    }

    public void setMonthlyRentPropertylist(List<RestProperty> monthlyRentPropertylist) {
        this.monthlyRentPropertylist = monthlyRentPropertylist;
    }

    public List<RestProperty> getDealPropertylist() {
        return dealPropertylist;
    }

    public void setDealPropertylist(List<RestProperty> dealPropertylist) {
        this.dealPropertylist = dealPropertylist;
    }

    public String getCrimejsonlist() {
        return crimejsonlist == null ? "" : StringEscapeUtils.escapeJson(crimejsonlist);
    }

    public void setCrimejsonlist(String crimejsonlist) {
        this.crimejsonlist = crimejsonlist;
    }

    public String getMonthlyrentjsonlist() {
        return monthlyrentjsonlist == null ? "" : StringEscapeUtils.escapeJson(monthlyrentjsonlist);
    }

    public void setMonthlyrentjsonlist(String monthlyrentjsonlist) {
        this.monthlyrentjsonlist = monthlyrentjsonlist;
    }

    /**
     * @return the ZipCode
     */
    public String getZipCode() {
        return ZipCode;
    }

    /**
     * @param ZipCode the ZipCode to set
     */
    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
