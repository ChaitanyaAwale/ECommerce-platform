package com.Chaitanya.Project1.E_Commerce.platform.Entity;

import com.Chaitanya.Project1.E_Commerce.platform.Enum.RoleType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable =false)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;
}
