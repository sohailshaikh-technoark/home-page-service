/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;

/**
 * @author Admin
 */
public class School {
    private String middleSchool;
    private String highSchool;
    private String elementarySchool;
    private Object district;

    /**
     * @return the middleSchool
     */
    public String getMiddleSchool() {

        return middleSchool == null ? "" : middleSchool;
    }

    /**
     * @param middleSchool the middleSchool to set
     */
    public void setMiddleSchool(String middleSchool) {
        this.middleSchool = middleSchool;
    }

    /**
     * @return the highSchool
     */
    public String getHighSchool() {

        return highSchool == null ? "" : highSchool;
    }

    /**
     * @param highSchool the highSchool to set
     */
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    /**
     * @return the elementarySchool
     */
    public String getElementarySchool() {

        return elementarySchool == null ? "" : elementarySchool;
    }

    /**
     * @param elementarySchool the elementarySchool to set
     */
    public void setElementarySchool(String elementarySchool) {
        this.elementarySchool = elementarySchool;
    }

    /**
     * @return the district
     */
    public Object getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(Object district) {
        this.district = district;
    }
}
