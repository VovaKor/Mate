package com.korobko.controller;

import com.korobko.web.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Vova Korobko
 */
public interface Controller {
    ViewModel process(HttpServletRequest req, HttpServletResponse resp);
}
