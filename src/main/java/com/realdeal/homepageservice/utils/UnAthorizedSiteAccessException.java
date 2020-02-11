/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.utils;

/**
 * @author Admin
 */
public class UnAthorizedSiteAccessException extends Exception {

    private static final long serialVersionUID = -3332292346834265371L;

    public UnAthorizedSiteAccessException(String msg) {
        super(msg);
    }
}
