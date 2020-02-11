/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;

/**
 * @author Admin
 */
public class Office {
    private Contact contact;
    private String name;
    private String servingName;
    private String brokerid;

    /**
     * @return the contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * @return the name
     */
    public String getName() {

        return name == null ? "" : name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the servingName
     */
    public String getServingName() {

        return servingName == null ? "" : servingName;
    }

    /**
     * @param servingName the servingName to set
     */
    public void setServingName(String servingName) {
        this.servingName = servingName;
    }

    /**
     * @return the brokerid
     */
    public String getBrokerid() {

        return brokerid == null ? "" : brokerid;
    }

    /**
     * @param brokerid the brokerid to set
     */
    public void setBrokerid(String brokerid) {
        this.brokerid = brokerid;
    }
}
