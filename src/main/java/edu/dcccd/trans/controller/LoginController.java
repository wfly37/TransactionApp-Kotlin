package edu.dcccd.trans.controller;

import edu.dcccd.trans.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logged out");
        return "logoutSuccess";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loggedInUser = (User) ((Authentication) principal).getPrincipal();
            String user = WebUtils.toString(loggedInUser);
            model.addAttribute("user", user);
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403";
    }

}
