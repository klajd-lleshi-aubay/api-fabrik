package com.sella.api.entity;

import com.sella.api.enumeration.Currency;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRANSACTION")
@Data
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "operation_id")
    private String operationId;

    @Column(name = "accounting_date")
    private String accountingDate;

    @Column(name = "value_date")
    private String valueDate;

    @ManyToOne
    @JoinColumn(name = "type")
    private TransactionType type;

    @Column(name = "amount")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;

    @Column(name = "description")
    private String description;

}
