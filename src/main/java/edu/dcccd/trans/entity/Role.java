package edu.dcccd.trans.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    @Column(name = "user_id")
    private Long userId;

    public Role(String role, Long userId) {
        this.role = role;
        this.userId = userId;
    }
}