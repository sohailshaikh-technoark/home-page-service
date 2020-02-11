/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.services;

import com.realdeal.homepageservice.entity.MaRestapiKeys;
import com.realdeal.homepageservice.repositories.ApiKeyRepo;
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
public class ApiKeyService {

    @Autowired
    ApiKeyRepo apiKeyRepo;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(MaRestapiKeys maRestapiKeys) {
        apiKeyRepo.save(maRestapiKeys);
    }

    public MaRestapiKeys GetApiKey(String Status) {
        try {

            String q = "select * from ma_restapi_keys where status=:status limit 1";
            Map params = new HashMap();
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaRestapiKeys.class));
        } catch (Exception ex) {
            return null;
        }
    }


}
