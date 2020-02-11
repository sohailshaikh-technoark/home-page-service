/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.services;

import com.realdeal.homepageservice.entity.MaUserPreferences;
import com.realdeal.homepageservice.repositories.UserPrefrencesRepo;
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
public class UserPreferencesService {

    @Autowired
    UserPrefrencesRepo userPrefrencesRepo;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(MaUserPreferences maUserPreferences) {
        userPrefrencesRepo.save(maUserPreferences);
    }

    public MaUserPreferences Select_MA_User_Preferences_By_UserID(Long UserID, String Status) {
        try {
            String q = "select * from ma_user_preferences where createdby=:userid  and status=:status limit 1";
            Map params = new HashMap();
            params.put("userid", UserID);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaUserPreferences.class));
        } catch (Exception ex) {
            return null;
        }
    }

    public MaUserPreferences Select_MA_User_Preferences_By_ID(Long ID, Long UserID, String Status) {
        try {
            String q = "select * from ma_user_preferences where id=:id and createdby=:userid  and status=:status";
            Map params = new HashMap();
            params.put("userid", UserID);
            params.put("id", ID);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaUserPreferences.class));
        } catch (Exception ex) {
            return null;
        }
    }

}
