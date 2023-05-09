package kz.bitlab.techorda.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.User;


import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = DBConnection.getUser(email);
        System.out.println(user.getEmail());
        System.out.println(user.getFullName());
        System.out.println(user.getPassword());
        if (user != null && user.getPassword().equals(password)) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("currentUser", user);
            request.setAttribute("check", "ok");
            response.sendRedirect("/profile");
        }
        else {
            request.setAttribute("error", "invalid");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
            requestDispatcher.include(request, response);

        }
    }
}