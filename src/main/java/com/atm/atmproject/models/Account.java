package com.atm.atmproject.models;
import com.atm.atmproject.enums.AccountType;
import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ACCOUNT_ID")
    private Long id;

//    @Column(name = "type")
    private AccountType type;

//    @Column(name = "NICKNAME")
    private String nickname;

//    @Column(name = "REWARDS")
    private Integer rewards;

//    @Column(name = "BALANCE")
    private Double balance;

    //@JoinColumn(name = "CUSTOMER_ID")
    // No property accountId found for type Customer!
    private Long customerId;
    //private Customer customer;

    public Account() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", type=" + type +
                ", nickname='" + nickname + '\'' +
                ", rewards=" + rewards +
                ", balance=" + balance +
                ", customerId=" + customerId +
                '}';
    }
}
