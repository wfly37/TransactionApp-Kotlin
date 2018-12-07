package edu.dcccd.trans.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(name = "Encrypted_Password")
    private String encryptedPassword;

    public User( String username, String encode ) {
        this.username = username;
        this.encryptedPassword = encode;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }
}
