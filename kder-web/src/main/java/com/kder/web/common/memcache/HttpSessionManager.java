package com.kder.web.common.memcache;

import javax.servlet.http.HttpSession;

public interface HttpSessionManager {

    HttpSession getSession(String sessionId);

    boolean exists(String sessionId);

    HttpSession newSession(String sessionId);

    void updateSession(HttpSession session);

    /** 
     * 更新session
     * @param mobile
     * @param session  
     */
    void updateUserSession(String mobile, HttpSession session);

    String getSessionKey();

    int getSessionTimeout();

    String getCookieDomain();

    String getCookiePath();
}
