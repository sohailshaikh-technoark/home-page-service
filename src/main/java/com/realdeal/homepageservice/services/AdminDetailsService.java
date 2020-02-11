/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.services;

import com.realdeal.homepageservice.entity.MaAdminDetails;
import com.realdeal.homepageservice.repositories.AdminDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 */
@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AdminDetailsService {

    @Autowired
    AdminDetailsRepo adminDetailsRepo;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(MaAdminDetails adminDetails) {
        adminDetailsRepo.save(adminDetails);
    }

    public MaAdminDetails AuthenticateAdmin(String Email, String Status) {
        try {
            String q = "select * from ma_admin_details where email=:email and status=:status";
            Map params = new HashMap();
            params.put("email", Email);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaAdminDetails.class));
        } catch (Exception ex) {
            return null;
        }
    }

    public MaAdminDetails GetAdminDetailsByAdminID(Long AdminID, String Status) {
        try {
            String q = "select * from ma_admin_details where adminid=:adminid and status=:status";
            Map params = new HashMap();
            params.put("adminid", AdminID);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaAdminDetails.class));
        } catch (Exception ex) {
            return null;
        }
    }

}
