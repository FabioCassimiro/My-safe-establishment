package br.com.mysafeestablishment.api.response;

import br.com.mysafeestablishment.api.ErrorResponse;

public class CustomerResponse extends ErrorResponse {

    private Long customerId;
    private String name;
    private String token;

    public CustomerResponse() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
