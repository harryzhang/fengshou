package com.kder.web.common.memcache;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class MemcachedSessionFilter extends OncePerRequestFilter {

    private HttpSessionManager sessionManager;
    private String sessionSuffix;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        String sessionKey = sessionManager.getSessionKey();
        String cookiePath = sessionManager.getCookiePath();
        int sessionTimeout = sessionManager.getSessionTimeout();

        Cookie cookies[] = req.getCookies();
        String sessionIdInCookie = null;
        boolean sessionFromCookie = true;
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(sessionKey)) {
                    sessionIdInCookie = cookies[i].getValue();
                }
            }
        }
        if (sessionIdInCookie == null) {
            sessionIdInCookie = parseSessionIdFromUri(req);
            sessionFromCookie = false;
        }
        String sessionId = mixSessionId(sessionIdInCookie);
        System.out.println("===================session id in cookie:"+sessionIdInCookie);
        HttpSession session = sessionManager.getSession(sessionId);
        if (session == null) {
            String newSessionId = RandomStringUtils.randomAlphanumeric(20);

            sessionId = mixSessionId(newSessionId);
            session = sessionManager.newSession(sessionId);
            Cookie sessionCookie = new Cookie(sessionKey, newSessionId);
            sessionCookie.setPath(cookiePath);
            sessionCookie.setDomain(sessionManager.getCookieDomain());
            res.addCookie(sessionCookie);
        } else {
        	System.out.println("===================get session from sessionManager:"+sessionIdInCookie);
        	
            if (!sessionFromCookie) {// session id from url  , set cookie
                Cookie sessionCookie = new Cookie(sessionKey, sessionId);
                sessionCookie.setPath(cookiePath);
                sessionCookie.setDomain(sessionManager.getCookieDomain());
                res.addCookie(sessionCookie);
            }
        }
        session.setMaxInactiveInterval(sessionTimeout * 60);

        req = new HttpSessionRequestWrapper(req, session);
        res = new HttpSessionResponseWrapper(res, session, sessionManager, sessionFromCookie);
        chain.doFilter(req, res);
        sessionManager.updateSession(session);
    }

    @Override
    protected void initFilterBean() throws ServletException {
        WebApplicationContext spring = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        sessionManager = (HttpSessionManager) spring.getBean("sessionManager");
        sessionSuffix = ";" + sessionManager.getSessionKey() + "=";
    }

    @Override
    public void destroy() {
        sessionManager = null;
    }

    private String parseSessionIdFromUri(HttpServletRequest request) {
        String sessionId = null;

        //String uri = request.getRequestURI();
        String uri = request.getRequestURL().toString();
        int p = uri.indexOf(sessionSuffix);
        if (p >= 0) {
            int suffixLength = sessionSuffix.length();
            int tail = uri.indexOf(';', p + suffixLength);
            if (tail > 0)
                sessionId = uri.substring(p + suffixLength, tail);
            else
                sessionId = uri.substring(p + suffixLength);
        }
        return sessionId;
    }

    private String mixSessionId(String sessionIdInCookie) {
        if (StringUtils.isEmpty(sessionIdInCookie)) {
            return null;
        }

        return sessionIdInCookie;
    }
}
