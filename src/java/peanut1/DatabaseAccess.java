/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peanut1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet(name = "DatabaseAccess", urlPatterns = {"/DatabaseAccess"})
public class DatabaseAccess extends HttpServlet {
 
    public DatabaseAccess() {}
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        out.println("starting...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
             
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cestarenrollmentsystem?user=root&password=");
             
            Statement statement = connect.createStatement();
             
            ResultSet resultSet = statement.executeQuery("select * from cestarenrollmentsystem.students");
            out.println("<table border=\"1\">");
            while(resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getInt("studentID") + "</td>");
                out.println("<td>" + resultSet.getString("studentName") + "</td>");
                out.println("<td>" + resultSet.getString("GPA") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(out != null)
                out.close();
        }
    }
 
}