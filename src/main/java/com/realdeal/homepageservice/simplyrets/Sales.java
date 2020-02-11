/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.simplyrets;

import java.util.Date;

/**
 * @author Admin
 */
public class Sales {
    private Date closeDate;
    private Office2 office;
    private int closePrice;
    private Agent2 agent;
    private Object contractDate;

    /**
     * @return the closeDate
     */
    public Date getCloseDate() {
        return closeDate;
    }

    /**
     * @param closeDate the closeDate to set
     */
    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * @return the office
     */
    public Office2 getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(Office2 office) {
        this.office = office;
    }

    /**
     * @return the closePrice
     */
    public int getClosePrice() {
        return closePrice;
    }

    /**
     * @param closePrice the closePrice to set
     */
    public void setClosePrice(int closePrice) {
        this.closePrice = closePrice;
    }

    /**
     * @return the agent
     */
    public Agent2 getAgent() {
        return agent;
    }

    /**
     * @param agent the agent to set
     */
    public void setAgent(Agent2 agent) {
        this.agent = agent;
    }

    /**
     * @return the contractDate
     */
    public Object getContractDate() {
        return contractDate;
    }

    /**
     * @param contractDate the contractDate to set
     */
    public void setContractDate(Object contractDate) {
        this.contractDate = contractDate;
    }
}
