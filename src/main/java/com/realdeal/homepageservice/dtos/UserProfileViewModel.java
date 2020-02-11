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
public class UserProfileViewModel {

    private Long userid;

    @NotEmpty(message = "Please enter title")
    @Size(max = 256, message = "Maximum 256 characters allowed for title.")
    private String title;
    @NotEmpty(message = "Please enter automatic reference number.")
    @Size(max = 256, message = "Maximum 256 characters allowed for automatic reference number.")
    private String automaticreferencenumber;
    @NotEmpty(message = "Please enter first name.")
    @Size(max = 256, message = "Maximum 256 characters allowed for first name.")
    private String firstname;
    @NotEmpty(message = "Please enter last name.")
    @Size(max = 256, message = "Maximum 256 characters allowed for last name.")
    private String lastname;
    @Size(max = 256, message = "Maximum 256 characters allowed for middle name.")
    private String middlename;
    @NotEmpty(message = "Please enter company.")
    @Size(max = 256, message = "Maximum 256 characters allowed for company.")
    private String company;
    @NotEmpty(message = "Please enter postcode.")
    @Size(max = 20, message = "Maximum 20 characters allowed for postcode.")
    private String postcode;
    @Size(max = 256, message = "Maximum 256 characters allowed for address1.")
    private String address1;
    @Size(max = 256, message = "Maximum 256 characters allowed for address2.")
    private String address2;
    @Size(max = 256, message = "Maximum 256 characters allowed for address3.")
    private String address3;
    @Size(max = 256, message = "Maximum 256 characters allowed for county.")
    private String county;
    @Size(max = 256, message = "Maximum 256 characters allowed for city.")
    private String city;
    @Size(max = 256, message = "Maximum 256 characters allowed for country.")
    private String country;
    @NotEmpty(message = "Please enter email")
    @Email(message = "Please enter valid email")
    @Size(max = 256, message = "Maximum 256 characters allowed for email.")
    private String email;
    @NotEmpty(message = "Please enter phone number.")
    @Size(max = 20, message = "Maximum 20 characters allowed for phone number.")
    private String phonenumber;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutomaticreferencenumber() {
        return automaticreferencenumber;
    }

    public void setAutomaticreferencenumber(String automaticreferencenumber) {
        this.automaticreferencenumber = automaticreferencenumber;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


}
