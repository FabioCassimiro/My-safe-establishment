package br.com.mysafeestablishment.api.domain;

public class OrderPad extends AbstractEntity{

    private long customerId;
    private String customerName;
    private long tableId;
    private int quantityCustomer;
    private String status;
    private double tip;
    private double rate;
    private double value;
    private double paybleValue;

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

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public int getQuantityCustomer() {
        return quantityCustomer;
    }

    public void setQuantityCustomer(int quantityCustomer) {
        this.quantityCustomer = quantityCustomer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getPaybleValue() {
        return paybleValue;
    }

    public void setPaybleValue(double paybleValue) {
        this.paybleValue = paybleValue;
    }

    public OrderPad() {
    }

    @Override
    public String toString() {
        return "OrderPad{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", tableId=" + tableId +
                ", quantityCustomer=" + quantityCustomer +
                ", status='" + status + '\'' +
                ", tip=" + tip +
                ", rate=" + rate +
                ", value=" + value +
                ", paybleValue=" + paybleValue +
                '}';
    }
}