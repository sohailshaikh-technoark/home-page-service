/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;

/**
 * @author Admin
 */
public class Mls {
    private String status;
    private String area;
    private int daysOnMarket;
    private Object originatingSystemName;

    private transient String statusText;
    private Object areaMinor;

    /**
     * @return the status
     */
    public String getStatus() {

        return status == null ? "" : status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the area
     */
    public String getArea() {

        return area == null ? "" : area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the daysOnMarket
     */
    public int getDaysOnMarket() {
        return daysOnMarket;
    }

    /**
     * @param daysOnMarket the daysOnMarket to set
     */
    public void setDaysOnMarket(int daysOnMarket) {
        this.daysOnMarket = daysOnMarket;
    }

    /**
     * @return the originatingSystemName
     */
    public Object getOriginatingSystemName() {
        return originatingSystemName;
    }

    /**
     * @param originatingSystemName the originatingSystemName to set
     */
    public void setOriginatingSystemName(Object originatingSystemName) {
        this.originatingSystemName = originatingSystemName;
    }

    /**
     * @return the statusText
     */
    public String getStatusText() {

        return statusText == null ? "" : statusText;
    }

    /**
     * @param statusText the statusText to set
     */
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    /**
     * @return the areaMinor
     */
    public Object getAreaMinor() {
        return areaMinor;
    }

    /**
     * @param areaMinor the areaMinor to set
     */
    public void setAreaMinor(Object areaMinor) {
        this.areaMinor = areaMinor;
    }
}
