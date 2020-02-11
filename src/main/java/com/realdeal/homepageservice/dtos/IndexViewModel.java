/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.dtos;

import javax.validation.constraints.NotEmpty;

/**
 * @author Admin
 */
public class IndexViewModel {


    @NotEmpty(message = "Please enter your password.")
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
