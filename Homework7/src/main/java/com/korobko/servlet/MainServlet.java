package com.korobko.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Vova Korobko
 */
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if (req.getRequestURI().equals("/servlet/home")) {
           req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
       } else {
           req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
       }

    }
}
