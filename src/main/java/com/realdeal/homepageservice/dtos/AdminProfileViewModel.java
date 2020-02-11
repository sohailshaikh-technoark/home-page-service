/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Admin
 */
public class AdminProfileViewModel {

    private Long adminid;


    @NotEmpty(message = "Please enter first name.")
    @Size(max = 256, message = "Maximum 256 characters allowed for first name.")
    private String firstname;

    @NotEmpty(message = "Please enter last name.")
    @Size(max = 256, message = "Maximum 256 characters allowed for last name.")
    private String lastname;

    @Size(max = 256, message = "Maximum 256 characters allowed for middle name.")
    private String middlename;

    @NotEmpty(message = "Please enter email")
    @Email(message = "Please enter valid email")
    @Size(max = 256, message = "Maximum 256 characters allowed for email.")
    private String email;

    @NotEmpty(message = "Please enter phone number.")
    @Size(max = 20, message = "Maximum 20 characters allowed for phone number.")
    private String phone;

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
