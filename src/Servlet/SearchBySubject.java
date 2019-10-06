package Servlet;

import DB.DBConnection;
import models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "SearchBySubject")
public class SearchBySubject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //  out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles/styles.css />");

        String subject = request.getParameter("subject");

        List<Book> books;
        DBConnection.getConnection();

        out.println("<h2 Align='center'>Display records</h2>");
        out.println("<P ALIGN='center'><TABLE WIDTH='500' BORDER=1>");
       out.println("<tr><th>Id</th><th>Title</th><th>Author</th><th>Subject</th></tr>");

        //out.println("<ol>");
        books = DBConnection.findSubject(subject);
        Search.iterate(out, books);

    }
}
