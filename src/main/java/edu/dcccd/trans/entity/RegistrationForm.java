package edu.dcccd.trans.entity;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

  private String username;
  private String password;
  private String confirm;

  public User toUser( PasswordEncoder passwordEncoder) {
    return new User(username, passwordEncoder.encode(password));
  }
}
