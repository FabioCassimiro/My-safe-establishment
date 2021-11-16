package br.com.mysafeestablishment.api.request;

import java.util.StringJoiner;

public class OwnerRequest {

    private String email;
    private String password;

    public OwnerRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OwnerRequest() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OwnerRequest.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .toString();
    }
}

