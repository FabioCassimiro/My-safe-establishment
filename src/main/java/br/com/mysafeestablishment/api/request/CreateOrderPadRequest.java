package br.com.mysafeestablishment.api.request;

public class CreateOrderPadRequest {

    private long customerId;
    private int quantityCustomer;
    private long tableId;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getQuantityCustomer() {
        return quantityCustomer;
    }

    public void setQuantityCustomer(int quantityCustomer) {
        this.quantityCustomer = quantityCustomer;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public CreateOrderPadRequest() {
    }

    public CreateOrderPadRequest(long customerId, int quantityCustomer, long tableId) {
        this.customerId = customerId;
        this.quantityCustomer = quantityCustomer;
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        return "CreateOrderPadRequest{" +
                "customerId=" + customerId +
                ", quantityCustomer=" + quantityCustomer +
                ", tableId=" + tableId +
                '}';
    }
}
