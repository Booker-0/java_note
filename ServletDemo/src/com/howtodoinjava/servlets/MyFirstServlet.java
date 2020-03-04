package com.howtodoinjava.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

public class MyFirstServlet extends HttpServlet {
    private static final long serialVersionUID = -191543532411657451L;
    public void init() throws ServletException{

    }
    protected  void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html:charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MyFirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet MyFirstServlet at " + request.getContextPath() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    protected  void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

    }
    public String getServletInfo(){
        return "MyFirstServlet";
    }
    public void destory(){
        super.destroy();
    }
}
