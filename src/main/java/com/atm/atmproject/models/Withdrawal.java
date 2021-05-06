package com.atm.atmproject.models;

import javax.persistence.*;

@Entity
public class Withdrawal {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "WITHDRAWAL_ID")
    private Long id;

    @Column(name = "TYPE")
    private Enum transactionsType;

    @Column(name = "TRANSACTION_DATE")
    private String transactionDate;

    @Column(name = "STATUS")
    private Enum status;

    @Column(name = "PAYEE_ID")
    private Long payeeId;

    @Column(name = "MEDIUM")
    private Enum withdrawalType;

    @Column(name = "AMOUNT")//deposit amount
    private Double amount;

    @Column(name = "DESCRIPTION")
    private String description;

    public Withdrawal (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enum getTransactionsType() {
        return transactionsType;
    }

    public void setTransactionsType(Enum transactionsType) {
        this.transactionsType = transactionsType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    public Enum getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(Enum withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
