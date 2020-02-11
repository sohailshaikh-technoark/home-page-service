/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;

/**
 * @author Admin
 */
public class Tax {
    private int taxYear;
    private int taxAnnualAmount;
    private String id;

    /**
     * @return the taxYear
     */
    public int getTaxYear() {
        return taxYear;
    }

    /**
     * @param taxYear the taxYear to set
     */
    public void setTaxYear(int taxYear) {
        this.taxYear = taxYear;
    }

    /**
     * @return the taxAnnualAmount
     */
    public int getTaxAnnualAmount() {
        return taxAnnualAmount;
    }

    /**
     * @param taxAnnualAmount the taxAnnualAmount to set
     */
    public void setTaxAnnualAmount(int taxAnnualAmount) {
        this.taxAnnualAmount = taxAnnualAmount;
    }

    /**
     * @return the id
     */
    public String getId() {

        return id == null ? "" : id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
