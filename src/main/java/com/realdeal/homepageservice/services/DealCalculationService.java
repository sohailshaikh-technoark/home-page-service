/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.services;

import com.realdeal.homepageservice.entity.MaDealCalculation;
import com.realdeal.homepageservice.repositories.DealCalculationRepo;
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
public class DealCalculationService {

    @Autowired
    DealCalculationRepo dealCalculationRepo;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(MaDealCalculation dealCalculation) {
        dealCalculationRepo.save(dealCalculation);
    }

    public List<MaDealCalculation> Get_All_MA_Property_Calculation_By_UserID(Long UserID, String Status) {
        String q = "select * from ma_deal_calculation where status=:status and createdby=:userid";
        Map params = new HashMap();
        params.put("userid", UserID);
        params.put("status", Status);
        return namedParameterJdbcTemplate.query(q, params, new BeanPropertyRowMapper<>(MaDealCalculation.class));
    }

    public MaDealCalculation Select_MA_Property_Calculation_By_ID(Long ID, Long UserID, String Status) {
        try {
            String q = "select * from ma_deal_calculation where createdby=:userid and id=:id and status=:status";
            Map params = new HashMap();
            params.put("id", ID);
            params.put("userid", UserID);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaDealCalculation.class));
        } catch (Exception ex) {
            return null;
        }
    }

    public MaDealCalculation Select_MA_Property_Calculation_By_PropertyID(Long PropertyID, Long UserID, String Status) {
        try {
            String q = "select * from ma_deal_calculation where createdby=:userid and propertyid=:propertyid and status=:status limit 1";
            Map params = new HashMap();
            params.put("propertyid", PropertyID);
            params.put("userid", UserID);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaDealCalculation.class));
        } catch (Exception ex) {
            return null;
        }
    }

}
