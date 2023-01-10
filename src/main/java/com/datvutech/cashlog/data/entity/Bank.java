package com.datvutech.cashlog.data.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "banks", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
@Entity
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Long bankId;

    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 16, nullable = false)
    private String code;

    @Column(nullable = false)
    private String description;

    /* Begin: Constructors */
    public Bank(Long bankId) {
        this.bankId = bankId;
    }
    /* End: Constructors */

    /* Begin: References */
    @OneToMany(mappedBy = "bank")
    private Set<Transaction> transactions;
    /* End: References */
}
