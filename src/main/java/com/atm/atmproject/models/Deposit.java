package com.atm.atmproject.models;

import javax.persistence.*;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Enum transactionsType;

    private String transactionDate;

    private Enum status;

    private Long payeeId;

    private Enum depositType;

    private Double amount;

    private String description;

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

    public Enum getDepositType() {
        return depositType;
    }

    public void setDepositType(Enum depositType) {
        this.depositType = depositType;
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

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", transactionsType=" + transactionsType +
                ", transactionDate='" + transactionDate + '\'' +
                ", status=" + status +
                ", payeeId=" + payeeId +
                ", depositType=" + depositType +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
