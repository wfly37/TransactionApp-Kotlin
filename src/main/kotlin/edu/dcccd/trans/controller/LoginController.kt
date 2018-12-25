package edu.dcccd.trans.controller

import edu.dcccd.trans.utils.WebUtils
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal

@Controller
class LoginController {

    @GetMapping(value = ["/login"])
    fun loginPage(model: Model): String {
        return "login"
    }

    @GetMapping(value = ["/logout"])
    fun logoutSuccessfulPage(model: Model): String {
        model.addAttribute("title", "Logged out")
        return "logoutSuccess"
    }

    @GetMapping(value = ["/403"])
    fun accessDenied(model: Model, principal: Principal?): String {
        if (principal != null) {
            val loggedInUser = (principal as Authentication).principal as User
            val user = WebUtils.toString(loggedInUser)
            model.addAttribute("user", user)
            val message = ("Hi " + principal.name
                    + "<br> You do not have permission to access this page!")
            model.addAttribute("message", message)
        }
        return "403"
    }

}
