/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;

/**
 * @author Admin
 */
public class Address {
    private String crossStreet;
    private String state;
    private String country;
    private String postalCode;
    private String streetName;
    private String streetNumberText;
    private String city;
    private int streetNumber;
    private String full;
    private String unit;

    /**
     * @return the crossStreet
     */
    public String getCrossStreet() {
        return crossStreet == null ? "" : crossStreet;

    }

    /**
     * @param crossStreet the crossStreet to set
     */
    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    /**
     * @return the state
     */
    public String getState() {

        return state == null ? "" : state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the country
     */
    public String getCountry() {

        return country == null ? "" : country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {

        return postalCode == null ? "" : postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName == null ? "" : streetName;

    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return the streetNumberText
     */
    public String getStreetNumberText() {

        return streetNumberText == null ? "" : streetNumberText;
    }

    /**
     * @param streetNumberText the streetNumberText to set
     */
    public void setStreetNumberText(String streetNumberText) {
        this.streetNumberText = streetNumberText;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city == null ? "" : city;

    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the streetNumber
     */
    public int getStreetNumber() {
        return streetNumber;

    }

    /**
     * @param streetNumber the streetNumber to set
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * @return the full
     */
    public String getFull() {

        return full == null ? "" : full;
    }

    /**
     * @param full the full to set
     */
    public void setFull(String full) {
        this.full = full;
    }

    /**
     * @return the unit
     */
    public String getUnit() {

        return unit == null ? "" : unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
