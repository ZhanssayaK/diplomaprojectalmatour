package com.example.diploma.project.almatour.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String fullName;
    private String avatarUrl;
    private String phoneNumber;

    @ManyToOne
    private City city;

    @ManyToOne
    private CreditCardDetails creditCardDetails;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    private boolean isBlocked;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isBlocked; // Можно использовать состояние блокировки для управления этим аспектом
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isBlocked; // Если аккаунт заблокирован, isAccountNonLocked будет false
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !isBlocked; // Если аккаунт заблокирован, isEnabled будет false
    }
}
