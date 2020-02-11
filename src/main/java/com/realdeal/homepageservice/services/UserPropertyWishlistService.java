/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.services;

import com.realdeal.homepageservice.entity.MaUserPropertyWishlist;
import com.realdeal.homepageservice.repositories.UserPropertyWishlistRepo;
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
public class UserPropertyWishlistService {

    @Autowired
    UserPropertyWishlistRepo userPropertyWishlistRepo;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(MaUserPropertyWishlist maUserPropertyWishlist) {
        userPropertyWishlistRepo.save(maUserPropertyWishlist);
    }

    public List<MaUserPropertyWishlist> Select_All_MA_User_Property_Wishlist(Long UserID, String Status) {
        String q = "select * from ma_user_property_wishlist where status=:status and createdby=:userid";
        Map params = new HashMap();
        params.put("userid", UserID);
        params.put("status", Status);
        return namedParameterJdbcTemplate.query(q, params, new BeanPropertyRowMapper<>(MaUserPropertyWishlist.class));
    }

    public MaUserPropertyWishlist Select_MA_User_Property_Wishlist_By_ID(Long ID, Long UserID, String Status) {
        try {
            String q = "select * from ma_user_property_wishlist where id=:id and createdby=:userid and status=:status";
            Map params = new HashMap();
            params.put("userid", UserID);
            params.put("id", ID);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaUserPropertyWishlist.class));
        } catch (Exception ex) {
            return null;
        }
    }

    public MaUserPropertyWishlist Select_MA_User_Property_Wishlist_By_PropertyID(Long PropertyID, Long UserID, String Status) {
        try {
            String q = "select * from ma_user_property_wishlist where propertyid=:propertyid and createdby=:userid and status=:status";
            Map params = new HashMap();
            params.put("userid", UserID);
            params.put("propertyid", PropertyID);
            params.put("status", Status);
            return namedParameterJdbcTemplate.queryForObject(q, params, new BeanPropertyRowMapper<>(MaUserPropertyWishlist.class));
        } catch (Exception ex) {
            return null;
        }
    }

}
