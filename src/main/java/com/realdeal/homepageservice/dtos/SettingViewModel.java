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
public class SettingViewModel {


    @NotEmpty(message = "Please enter your api key.")
    private String ApiKey;

    @NotEmpty(message = "Please enter your api secret.")
    private String ApiSecret;

    /**
     * @return the ApiKey
     */
    public String getApiKey() {
        return ApiKey;
    }

    /**
     * @param ApiKey the ApiKey to set
     */
    public void setApiKey(String ApiKey) {
        this.ApiKey = ApiKey;
    }

    /**
     * @return the ApiSecret
     */
    public String getApiSecret() {
        return ApiSecret;
    }

    /**
     * @param ApiSecret the ApiSecret to set
     */
    public void setApiSecret(String ApiSecret) {
        this.ApiSecret = ApiSecret;
    }


}
