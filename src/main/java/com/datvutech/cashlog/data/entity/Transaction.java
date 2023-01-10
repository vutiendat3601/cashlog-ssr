package com.datvutech.cashlog.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.datvutech.cashlog.data.entity.type.TransactionType;
import com.datvutech.cashlog.data.generator.PrefixSequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "transactions")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PrefixSequenceGenerator.NAME)
    @GenericGenerator(name = PrefixSequenceGenerator.NAME, strategy = PrefixSequenceGenerator.CLASS_PATH, parameters = {
            @Parameter(name = PrefixSequenceGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = PrefixSequenceGenerator.PREFIX_PARAM, value = "CT6N_"),
            @Parameter(name = PrefixSequenceGenerator.NUMBER_FORMAT_PARAM, value = "%05d")
    })
    private String trans_id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(name = "trans_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transType;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String detail;

    /* Begin: References */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    /* End: References */
}
