/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;

/**
 * @author Admin
 */
public class Contact {
    String email, office, cell;

    public String getEmail() {

        return email == null ? "" : email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {

        return office == null ? "" : office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getCell() {

        return cell == null ? "" : cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

}
