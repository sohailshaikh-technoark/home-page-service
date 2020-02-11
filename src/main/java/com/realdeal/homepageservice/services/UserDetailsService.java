/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.services;

import com.realdeal.homepageservice.entity.MaUserDetails;
import com.realdeal.homepageservice.repositories.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Admin
 */
@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDetailsService {

    @Autowired
    UserDetailsRepo userDetailsRepo;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(MaUserDetails maUserDeatils) {
        userDetailsRepo.save(maUserDeatils);
    }

    public MaUserDetails AuthenticateUser(String Email, String Status) {
        try {

            String q = "select * from ma_user_details where email=:email and status=:status";
            Map params = new HashMap();
            params.put("email", Email);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaUserDetails.class));
        } catch (Exception ex) {
            return null;
        }
    }

    public MaUserDetails CheckUserExists(String Email, String Status) {
        try {
            String q = "select * from ma_user_details where LOWER(email)=LOWER(:email) and status=:status";
            Map params = new HashMap();
            params.put("email", Email);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaUserDetails.class));
        } catch (Exception ex) {
            return null;
        }
    }

    public MaUserDetails CheckUserExistsForUpdate(Long Userid, String Email, String Status) {
        try {
            String q = "select * from ma_user_details where LOWER(email)=LOWER(:email) and status=:status and userid!=:userid";
            Map params = new HashMap();
            params.put("email", Email);
            params.put("status", Status);
            params.put("userid", Userid);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaUserDetails.class));
        } catch (Exception ex) {
            return null;
        }
    }

    public MaUserDetails GetUserDetailsByUserID(Long UserID, String Status) {
        try {
            String q = "select * from ma_user_details where userid=:userid and status=:status";
            Map params = new HashMap();
            params.put("userid", UserID);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaUserDetails.class));
        } catch (Exception ex) {
            return null;
        }
    }


    public List<MaUserDetails> GetUserList(String Status) {
        String q = "select * from ma_user_details where status=:status";
        Map params = new HashMap();
        params.put("status", Status);
        return namedParameterJdbcTemplate.query(q, params, new BeanPropertyRowMapper<>(MaUserDetails.class));
    }

}
