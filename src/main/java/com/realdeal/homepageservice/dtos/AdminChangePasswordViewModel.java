/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author Admin
 */
public class AdminChangePasswordViewModel {

    private Long userid;

    @NotEmpty(message = "Please enter your password.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,20}$", message = "Password must meet the following criteria:<br><ul><li>Between 8 and 20 characters.</li><li>At least 1 number (0-9).</li><li>At least 1 lower-case character (a-z).</li><li>At least 1 upper-case character (A-Z).</li></ul>")
    private String password;

    @NotEmpty(message = "Please enter current password")
    private String oldpassword;

    @NotEmpty(message = "Please enter confirm password.")
    private String confirmpassword;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }


}
