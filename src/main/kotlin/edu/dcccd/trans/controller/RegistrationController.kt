package edu.dcccd.trans.controller

import edu.dcccd.trans.entity.RegistrationForm
import edu.dcccd.trans.entity.Role
import edu.dcccd.trans.entity.User
import edu.dcccd.trans.repository.RoleRepository
import edu.dcccd.trans.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class RegistrationController {
    @Autowired
    private val userRepo: UserRepository? = null
    @Autowired
    private val roleRepo: RoleRepository? = null
    @Autowired
    private val passwordEncoder: PasswordEncoder? = null


    @GetMapping("/register")
    fun registerForm(): String { return "registration" }

    @PostMapping("/register")
    fun processRegistration(form: RegistrationForm, model: Model): String {
        if (form.password != form.confirm) {
            model.addAttribute("message", "Passwords is not match.")
            return "403"
        }
        var user: User? = userRepo!!.findByUsername(form.username!!)
        if (user != null) {
            model.addAttribute("message", "User already registered.")
            return "403"
        }
        user = userRepo.save(form.toUser(passwordEncoder!!))
        roleRepo!!.save(Role(null, "ROLE_USER", user!!.id))
        return "redirect:/login"
    }

}
