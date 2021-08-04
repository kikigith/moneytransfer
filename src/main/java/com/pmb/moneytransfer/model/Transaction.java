package com.pmb.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pmb.moneytransfer.constants.TransactionType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
    private String description;
    private TransactionType transactionType;
    private double amount;
    private LocalDate transactionDate;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="sender",nullable = false)
    private User sender;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="beneficiary",nullable = false)
    private User beneficiary;
}
