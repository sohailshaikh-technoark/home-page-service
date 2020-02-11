/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;

/**
 * @author Admin
 */
public class CoAgent {
    private Object lastName;
    private Contact contact;
    private Object firstName;
    private String id;

    /**
     * @return the lastName
     */
    public Object getLastName() {

        return lastName == null ? "" : lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

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
     * @return the firstName
     */
    public Object getFirstName() {

        return firstName == null ? "" : firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(Object firstName) {
        this.firstName = firstName;
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
