/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;

/**
 * @author Admin
 */
public class Geo {
    private String county;
    private Double lat;
    private Double lng;
    private String marketArea;
    private String directions;

    /**
     * @return the county
     */
    public String getCounty() {

        return county == null ? "" : county;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return the lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public Double getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * @return the marketArea
     */
    public String getMarketArea() {

        return marketArea == null ? "" : marketArea;
    }

    /**
     * @param marketArea the marketArea to set
     */
    public void setMarketArea(String marketArea) {
        this.marketArea = marketArea;
    }

    /**
     * @return the directions
     */
    public String getDirections() {

        return directions == null ? "" : directions;
    }

    /**
     * @param directions the directions to set
     */
    public void setDirections(String directions) {
        this.directions = directions;
    }
}
