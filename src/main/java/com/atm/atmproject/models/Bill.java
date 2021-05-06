package com.atm.atmproject.models;

import javax.persistence.*;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Bill_ID")
    private Long id;

    @Column(name = "Status")
    private String status;

    @Column(name = "Payee")
    private String payee;

    @Column(name = "Nickname")
    String nickname;

    @Column(name = "Creation_Date")
    String creation_date;

    @Column(name = "Payment_Date")
    String payment_date;

    @Column(name = "Upcoming_Payment_Date")
    String upcoming_payment_date;

    @Column(name = "payment_amount")
    Double payment_amount;

    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "Account_ID")
    String account_id;

//   Get SEt


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getUpcoming_payment_date() {
        return upcoming_payment_date;
    }

    public void setUpcoming_payment_date(String upcoming_payment_date) {
        this.upcoming_payment_date = upcoming_payment_date;
    }

    public Double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(Double payment_amount) {
        this.payment_amount = payment_amount;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", payee='" + payee + '\'' +
                ", nickname='" + nickname + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", payment_date='" + payment_date + '\'' +
                ", upcoming_payment_date='" + upcoming_payment_date + '\'' +
                ", payment_amount=" + payment_amount +
                ", account_id='" + account_id + '\'' +
                '}';
    }
}
