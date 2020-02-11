/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Admin
 */
@Entity
@Table(name = "ma_user_details")
@NamedQueries({
        @NamedQuery(name = "MaUserDetails.findAll", query = "SELECT m FROM MaUserDetails m")})
@SequenceGenerator(name = "ma_user_details_seq", sequenceName = "ma_user_details_seq", allocationSize = 1)
public class MaUserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ma_user_details_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
    private Long userid;
    @Size(max = 256)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 256)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 256)
    @Column(name = "middlename")
    private String middlename;
    @Size(max = 256)
    @Column(name = "title")
    private String title;
    @Size(max = 2147483647)
    @Column(name = "automaticrefrencenumber")
    private String automaticrefrencenumber;
    @Size(max = 2147483647)
    @Column(name = "company")
    private String company;
    @Size(max = 50)
    @Column(name = "postcode")
    private String postcode;
    @Size(max = 2147483647)
    @Column(name = "address1")
    private String address1;
    @Size(max = 2147483647)
    @Column(name = "address2")
    private String address2;
    @Size(max = 2147483647)
    @Column(name = "address3")
    private String address3;
    @Size(max = 2147483647)
    @Column(name = "county")
    private String county;
    @Size(max = 2147483647)
    @Column(name = "city")
    private String city;
    @Size(max = 2147483647)
    @Column(name = "country")
    private String country;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "password")
    private String password;
    @Size(max = 2147483647)
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Column(name = "modifieddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifieddate;
    @Column(name = "createdbyadmin")
    private Long createdbyadmin;
    @Column(name = "modifiedby")
    private Long modifiedby;
    @Column(name = "modifiedbyadmin")
    private Long modifiedbyadmin;
    @Column(name = "modifiedbyadmindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedbyadmindate;
    @Size(max = 2147483647)
    @Column(name = "status")
    private String status;

    public MaUserDetails() {
    }

    public MaUserDetails(Long userid) {
        this.userid = userid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutomaticrefrencenumber() {
        return automaticrefrencenumber;
    }

    public void setAutomaticrefrencenumber(String automaticrefrencenumber) {
        this.automaticrefrencenumber = automaticrefrencenumber;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public Long getCreatedbyadmin() {
        return createdbyadmin;
    }

    public void setCreatedbyadmin(Long createdbyadmin) {
        this.createdbyadmin = createdbyadmin;
    }

    public Long getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Long getModifiedbyadmin() {
        return modifiedbyadmin;
    }

    public void setModifiedbyadmin(Long modifiedbyadmin) {
        this.modifiedbyadmin = modifiedbyadmin;
    }

    public Date getModifiedbyadmindate() {
        return modifiedbyadmindate;
    }

    public void setModifiedbyadmindate(Date modifiedbyadmindate) {
        this.modifiedbyadmindate = modifiedbyadmindate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaUserDetails)) {
            return false;
        }
        MaUserDetails other = (MaUserDetails) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.realdeal.entity.MaUserDetails[ userid=" + userid + " ]";
    }

}
