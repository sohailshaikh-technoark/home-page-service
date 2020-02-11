/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.crimeometer;

/**
 * @author Admin
 */
public class CrimeIncedents {
    private String city_key;
    private String incident_code;
    private String incident_date;
    private String incident_offense;
    private String incident_offense_code;
    private String incident_offense_description;
    private String incident_offense_detail_description;
    private String incident_offense_crime_against;
    private String incident_offense_action;
    private String incident_source_original_type;
    private String incident_source_name;
    private String incident_address;
    private Double incident_latitude;
    private Double incident_longitude;
    private boolean isHome;

    public boolean isIsHome() {
        return isHome;
    }

    public void setIsHome(boolean isHome) {
        this.isHome = isHome;
    }

    public String getCity_key() {
        return city_key;
    }

    public void setCity_key(String city_key) {
        this.city_key = city_key;
    }

    public String getIncident_code() {
        return incident_code;
    }

    public void setIncident_code(String incident_code) {
        this.incident_code = incident_code;
    }

    public String getIncident_date() {
        return incident_date;
    }

    public void setIncident_date(String incident_date) {
        this.incident_date = incident_date;
    }

    public String getIncident_offense() {
        return incident_offense;
    }

    public void setIncident_offense(String incident_offense) {
        this.incident_offense = incident_offense;
    }

    public String getIncident_offense_code() {
        return incident_offense_code;
    }

    public void setIncident_offense_code(String incident_offense_code) {
        this.incident_offense_code = incident_offense_code;
    }

    public String getIncident_offense_description() {
        return incident_offense_description;
    }

    public void setIncident_offense_description(String incident_offense_description) {
        this.incident_offense_description = incident_offense_description;
    }

    public String getIncident_offense_detail_description() {
        return incident_offense_detail_description;
    }

    public void setIncident_offense_detail_description(String incident_offense_detail_description) {
        this.incident_offense_detail_description = incident_offense_detail_description;
    }

    public String getIncident_offense_crime_against() {
        return incident_offense_crime_against;
    }

    public void setIncident_offense_crime_against(String incident_offense_crime_against) {
        this.incident_offense_crime_against = incident_offense_crime_against;
    }

    public String getIncident_offense_action() {
        return incident_offense_action;
    }

    public void setIncident_offense_action(String incident_offense_action) {
        this.incident_offense_action = incident_offense_action;
    }

    public String getIncident_source_original_type() {
        return incident_source_original_type;
    }

    public void setIncident_source_original_type(String incident_source_original_type) {
        this.incident_source_original_type = incident_source_original_type;
    }

    public String getIncident_source_name() {
        return incident_source_name;
    }

    public void setIncident_source_name(String incident_source_name) {
        this.incident_source_name = incident_source_name;
    }

    public String getIncident_address() {
        return incident_address;
    }

    public void setIncident_address(String incident_address) {
        this.incident_address = incident_address;
    }

    public Double getIncident_latitude() {
        return incident_latitude;
    }

    public void setIncident_latitude(Double incident_latitude) {
        this.incident_latitude = incident_latitude;
    }

    public Double getIncident_longitude() {
        return incident_longitude;
    }

    public void setIncident_longitude(Double incident_longitude) {
        this.incident_longitude = incident_longitude;
    }
}
