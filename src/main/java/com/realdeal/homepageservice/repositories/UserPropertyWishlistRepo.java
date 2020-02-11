/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.repositories;

import com.realdeal.homepageservice.entity.MaUserPropertyWishlist;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Admin
 */
@Repository
@Scope(value = "request")
public interface UserPropertyWishlistRepo extends JpaRepository<MaUserPropertyWishlist, Long> {


}

