/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.utils;

/**
 * @author Admin
 */
public enum StatusEnums {
    ACTIVE {
        @Override
        public String toString() {
            return "Active";
        }
    },
    SUCCESS {
        @Override
        public String toString() {
            return "Success";
        }
    },
    ERROR {
        @Override
        public String toString() {
            return "Error";
        }
    },
    DELETED {
        @Override
        public String toString() {
            return "Deleted";
        }
    },
    USERID {
        @Override
        public String toString() {
            return "UserID";
        }
    },
    SIMPLYRETS_BASEAPI {
        @Override
        public String toString() {
            return "https://api.simplyrets.com";
        }
    },
    CRIME_BASEAPI {
        @Override
        public String toString() {
            return "https://api.crimeometer.com/v1/incidents/raw-data";
        }
    },
    CRIME_API_KEY {
        @Override
        public String toString() {
            return "LtgqScPKvC7vwfMVbYpGo7p6lgAzUDeE5Dw1oPjC";
        }
    },
    PASSWORD {
        @Override
        public String toString() {
            return "RealDeal@2019!";
        }
    },
    ISALLOWED {
        @Override
        public String toString() {
            return "Yes";
        }
    },
    ISALLOWED_KEY {
        @Override
        public String toString() {
            return "IsAllowed";
        }
    },
    ADMINID {
        @Override
        public String toString() {
            return "AdminID";
        }
    },
    ADMINNAME {
        @Override
        public String toString() {
            return "AdminName";
        }
    }

}
