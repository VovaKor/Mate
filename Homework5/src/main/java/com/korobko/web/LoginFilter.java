package com.korobko.web;

import com.korobko.Factory;
import com.korobko.dao.UserDao;
import com.korobko.dao.UserDaoImpl;
import com.korobko.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.korobko.util.ApplicationConstants.TOKEN;

/**
 * @author Vova Korobko
 */
public class LoginFilter implements Filter {
    private UserDao userDao;
    private final String protectedUri = "/servlet/profile";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userDao = new UserDaoImpl(Factory.getConnection());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (httpServletRequest.getRequestURI().equals(protectedUri)) {
            String token = null;
            for (Cookie cookie : cookies) {
                String name =  cookie.getName().toUpperCase();
                if (name.equals(TOKEN)) {
                    token = cookie.getValue();
                    User user = userDao.getUserByToken(token);
                    httpServletRequest.setAttribute("UserId", String.valueOf(user.getId()));
                }
            }
            if (token == null) {
                httpServletRequest.getRequestDispatcher("/servlet/login").forward(httpServletRequest, servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
