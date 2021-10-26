package org.codehaus.mojo.archetypes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyFirstServlet", urlPatterns = {"/MyFirstServlet"})
public class MyFirstServlet extends HttpServlet {

    private static final long serialVersionUID = -1915463532411657451L;

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

        String user = request.getParameter("username");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

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

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //Do some other work
    }
}