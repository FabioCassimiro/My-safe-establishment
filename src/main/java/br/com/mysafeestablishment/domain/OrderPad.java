package br.com.mysafeestablishment.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orderpads")
public class OrderPad extends AbstractEntity{

    private long customerId;
    private String customerName;
    private String payment;
    private double rate;
    private double tip;
    private double value;
    private String status;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public OrderPad(long customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.status = "0";
    }

    public OrderPad() {
    }

    @Override
    public String toString() {
        return "OrderPad{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", payment='" + payment + '\'' +
                ", rate=" + rate +
                ", tip=" + tip +
                ", value=" + value +
                ", status='" + status + '\'' +
                '}';
    }
}
