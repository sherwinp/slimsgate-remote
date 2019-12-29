package gov.fda.client;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class ServerStart {

	public static void start(int port) throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		
		Connector connector = new Connector("HTTP/1.1");
		connector.setPort(port);
		tomcat.getService().addConnector(connector);
		tomcat.setConnector(connector);
		
		String filePath = new File("webapp").getAbsolutePath();
		
		tomcat.addWebapp("", filePath);
		tomcat.getConnector();
		tomcat.start();
		
		tomcat.getServer().await();
	}
}