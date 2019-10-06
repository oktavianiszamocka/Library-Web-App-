package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnection;
import models.Book;

//@WebServlet(name = "Search", urlPatterns = ("Search"))
public class Search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));


        List<Book> books ;
        DBConnection.getConnection();


        out.println("<h2 Align='center'>Display records</h2>");
        out.println("<P ALIGN='center'><TABLE WIDTH='500' BORDER=1>");
        out.println("<tr><th>Id</th><th>Title</th><th>Author</th><th>Subject</th></tr>");



        books = DBConnection.findbyId(id);
        iterate(out, books);

    }

    public static void iterate(PrintWriter out, List<Book> books){
        for( Book book : books ){


            out.println("<tr><td>");
            out.println(book.getId());
            out.println("</td>");
            out.println("<td>");
            out.println(book.getTitle());
            out.println("</td>");
            out.println("<td>");
            out.println(book.getAuthor());
            out.println("</td>");
            out.println("<td>");
            out.println(book.getSubject());
            out.println("</td>");
            out.println("</tr>");


        }

        out.println("</table>");

    }


}
