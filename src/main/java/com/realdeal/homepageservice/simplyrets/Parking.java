/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;

/**
 * @author Admin
 */
public class Parking {
    private Object leased;
    private int spaces;
    private String description;

    /**
     * @return the leased
     */
    public Object getLeased() {
        return leased;
    }

    /**
     * @param leased the leased to set
     */
    public void setLeased(Object leased) {
        this.leased = leased;
    }

    /**
     * @return the spaces
     */
    public int getSpaces() {
        return spaces;
    }

    /**
     * @param spaces the spaces to set
     */
    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    /**
     * @return the description
     */
    public String getDescription() {

        return description == null ? "" : description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
