package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.Item;


@WebServlet(value = "/home.html")
public class HomePageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ArrayList<Item> items = DBConnection.getAllItems();
        for (Item item : items) System.out.println(item);
        System.out.println(items.size());
        request.setAttribute("tovary", items);

        request.getRequestDispatcher("jsp/shop.jsp").forward(request, response);
    }
}
