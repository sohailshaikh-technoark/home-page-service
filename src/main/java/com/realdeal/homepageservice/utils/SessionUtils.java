/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Admin
 */
@Component
public class SessionUtils {

    public SessionUtils() {
    }

    public synchronized void setSessionValue(HttpServletRequest request, String key, Object value) {
        HttpSession session = (HttpSession) request.getSession(true);
        session.setAttribute(key, value);
    }

    public synchronized Object getSessionValue(HttpServletRequest request, String key) {
        HttpSession session = (HttpSession) request.getSession(true);
        return session.getAttribute(key);
    }

    public synchronized void removeSessionValue(HttpServletRequest request, String key) {
        HttpSession session = (HttpSession) (HttpSession) request.getSession(true);
        session.removeAttribute(key);
    }

    public synchronized String getSessionId(HttpServletRequest request) {
        HttpSession session = (HttpSession) (HttpSession) request.getSession(false);
        return session.getId();
    }

    public synchronized void invalidate(HttpServletRequest request) {
        HttpSession session = (HttpSession) (HttpSession) request.getSession(false);
        if (session != null) {
            session.removeAttribute("authaccount");
            session.invalidate();
        }
    }

}
