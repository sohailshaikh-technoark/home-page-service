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
@Table(name = "ma_restapi_keys")
@NamedQueries({
        @NamedQuery(name = "MaRestapiKeys.findAll", query = "SELECT m FROM MaRestapiKeys m")})
@SequenceGenerator(name = "ma_restapi_keys_seq", sequenceName = "ma_restapi_keys_seq", allocationSize = 1)
public class MaRestapiKeys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ma_restapi_keys_seq")
    private Long id;
    @Size(max = 2147483647)
    @Column(name = "apikey")
    private String apikey;
    @Size(max = 2147483647)
    @Column(name = "apisecret")
    private String apisecret;
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Column(name = "modifieddate")
    @Temporal(TemporalType.TIME)
    private Date modifieddate;
    @Column(name = "createdby")
    private Long createdby;
    @Column(name = "modifiedby")
    private Long modifiedby;
    @Size(max = 10)
    @Column(name = "status")
    private String status;

    public MaRestapiKeys() {
    }

    public MaRestapiKeys(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getApisecret() {
        return apisecret;
    }

    public void setApisecret(String apisecret) {
        this.apisecret = apisecret;
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

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Long getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaRestapiKeys)) {
            return false;
        }
        MaRestapiKeys other = (MaRestapiKeys) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.realdeal.entity.MaRestapiKeys[ id=" + id + " ]";
    }

}
