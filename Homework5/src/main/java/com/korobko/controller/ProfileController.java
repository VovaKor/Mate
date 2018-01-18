package com.korobko.controller;

import com.korobko.model.User;
import com.korobko.service.UserService;
import com.korobko.web.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.korobko.web.Methods.GET;

/**
 * @author Vova Korobko
 */
public class ProfileController implements Controller {
    private UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(HttpServletRequest req, HttpServletResponse resp) {
        ViewModel viewModel = new ViewModel("profile");
        if (req.getMethod().equals(GET.toString())) {
            return viewModel;
        }
        User user = userService.findById(Long.parseLong((String) req.getAttribute("UserId")));
        viewModel.setArgument("User", user);
        return viewModel;
    }
}
