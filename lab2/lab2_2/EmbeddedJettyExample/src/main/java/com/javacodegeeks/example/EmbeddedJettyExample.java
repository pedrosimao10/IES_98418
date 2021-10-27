package com.javacodegeeks.example;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class EmbeddedJettyExample {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8680);

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        servletHandler.addServletWithMapping(HelloServlet.class, "/");

        server.start();
        server.join();

    }

    public static class HelloServlet extends HttpServlet
    {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String user = request.getParameter("username");

            if(user == null){
                throw new NullPointerException("Username not found!");
            }
            else{
                try {
                    // Write some content
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>MyFirstServlet</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h2>Hello " + user + "</h2>");
                    out.println("</body>");
                    out.println("</html>");
                } finally {
                    out.close();
                }

            }



        }
    }
}