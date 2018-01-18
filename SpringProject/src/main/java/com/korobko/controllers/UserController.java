package com.korobko.controllers;

import com.korobko.configuration.SocialConfig;
import com.korobko.model.User;
import com.korobko.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vova Korobko
 */

@Controller

public class UserController {

    @Autowired
    private UserService userService;

//
//    @Autowired
//    private FacebookTemplate facebookTemplate;
    private Facebook facebook;
    private ConnectionRepository repository;

    public UserController(Facebook facebook, ConnectionRepository repository) {
        this.facebook = facebook;
        this.repository = repository;

    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView vm) {
        vm.setViewName("home");
        return vm;
    }
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView vm) {
        vm.setViewName("login");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, ModelAndView vm) {
        return vm;
    }

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView vm) {
        vm.setViewName("signup");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute User user, ModelAndView vm) {
        vm.setViewName("welcome");
        vm.addObject("user", userService.addUser(user));
        return vm;
    }

    @RequestMapping("/hello")
    public String helloFacebook(Model model) {
        if (repository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        return "hello";
    }
}
