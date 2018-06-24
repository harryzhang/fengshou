package com.kder.business.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextJSVersionListener implements ServletContextListener {

    public ApplicationContextJSVersionListener() {
        super();
    }

    public void contextInitialized ( ServletContextEvent event ){
        //添加css,js版本号
        long nowTime = System.currentTimeMillis();
        event.getServletContext().setAttribute("jsversion", nowTime);
        event.getServletContext().setAttribute("cssversion", nowTime);
        event.getServletContext().setAttribute("icoversion", nowTime);

    }

    public void contextDestroyed(ServletContextEvent arg0) {

    }

}
