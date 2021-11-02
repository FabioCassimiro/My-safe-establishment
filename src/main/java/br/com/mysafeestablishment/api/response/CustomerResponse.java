package br.com.mysafeestablishment.api.response;

import br.com.mysafeestablishment.api.ErrorResponse;

public class CustomerResponse {

    private String name;
    private Long customerId;
    private String token;

    public CustomerResponse(String name, Long customerId, String token) {
        this.name = name;
        this.customerId = customerId;
        this.token = token;
    }

    public CustomerResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
                "name='" + name + '\'' +
                ", customerId=" + customerId +
                ", token='" + token + '\'' +
                '}';
    }
}
