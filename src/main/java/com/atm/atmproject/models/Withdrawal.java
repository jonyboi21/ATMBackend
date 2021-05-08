package com.atm.atmproject.models;

import com.atm.atmproject.enums.Medium;
import com.atm.atmproject.enums.Status;
import com.atm.atmproject.enums.Transactions;

import javax.persistence.*;

@Entity
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Transactions type;

    private String transactionDate;

    private Status status;

    private Long payeeId;

    private Medium medium;

    private Double amount;

    private String description;

    private Long accountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transactions getType() {
        return type;
    }

    public void setType(Transactions type) {
        this.type = type;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "id=" + id +
                ", type=" + type +
                ", transactionDate='" + transactionDate + '\'' +
                ", status=" + status +
                ", payeeId=" + payeeId +
                ", medium=" + medium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
