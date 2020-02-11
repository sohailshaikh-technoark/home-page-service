/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.crimeometer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */
public class CrimeDetails {
    private String Error;
    private Long total_incidents;
    private Long total_pages;
    private List<CrimeIncedents> incidents = new ArrayList<CrimeIncedents>();

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public Long getTotal_incidents() {
        return total_incidents;
    }

    public void setTotal_incidents(Long total_incidents) {
        this.total_incidents = total_incidents;
    }

    public Long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Long total_pages) {
        this.total_pages = total_pages;
    }

    public List<CrimeIncedents> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<CrimeIncedents> incidents) {
        this.incidents = incidents;
    }
}
