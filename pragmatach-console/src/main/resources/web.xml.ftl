<?xml version="1.0" encoding="UTF-8"?>
<web-app id="${name}" version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
        <display-name>${name}</display-name>
        <listener>
  			<listener-class>com.khubla.pragmatach.framework.listener.AnnotationScannerListener</listener-class>
  		</listener>
        <servlet>
                <servlet-name>PragmatachServlet</servlet-name>
                <servlet-class>com.khubla.pragmatach.framework.servlet.PragmatachServlet</servlet-class>
                <load-on-startup>1</load-on-startup>
        </servlet>
        <servlet-mapping>
                <servlet-name>PragmatachServlet</servlet-name>
                <url-pattern>/*</url-pattern>
        </servlet-mapping>
        <welcome-file-list>
	        <welcome-file>/</welcome-file>        
	    </welcome-file-list>
</web-app>
        