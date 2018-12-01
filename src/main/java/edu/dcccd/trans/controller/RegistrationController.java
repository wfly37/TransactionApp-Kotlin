package edu.dcccd.trans.controller;

import edu.dcccd.trans.entity.RegistrationForm;
import edu.dcccd.trans.entity.Role;
import edu.dcccd.trans.entity.User;
import edu.dcccd.trans.repository.RoleRepository;
import edu.dcccd.trans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
  @Autowired
  private UserRepository userRepo;
  @Autowired
  private RoleRepository roleRepo;
  @Autowired
  private PasswordEncoder passwordEncoder;

  
  @GetMapping("/register")
  public String registerForm() {
    return "registration";
  }
  
  @PostMapping("/register")
  public String processRegistration( RegistrationForm form, Model model) {

      if(!form.getPassword().equals(form.getConfirm())) {
          model.addAttribute("message", "Passwords is not match.");
          return "403";
      }
      User user = userRepo.findByUsername(form.getUsername());
      if(user != null) {
          model.addAttribute("message","User already registered.");
          return "403";
      }
      user = userRepo.save(form.toUser(passwordEncoder));
      roleRepo.save(new Role("ROLE_USER", user.getId()));
      return "redirect:/login";
  }

}
