package com.datvutech.cashlog.data.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.datvutech.cashlog.data.entity.type.RoleType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "email", "code", "username" }))
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(length = 16, nullable = false)
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @Column(length = 16, nullable = false)
    private String code;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 16)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role;

    /* Begin: Constructors */
    public User(Long userId) {
        this.userId = userId;
    }
    /* End: Constructors */

    /* Begin: References */
    @OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE })
    private Set<Transaction> transactions;
    /* End: References */
}
