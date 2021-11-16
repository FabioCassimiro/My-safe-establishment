package br.com.mysafeestablishment.api.response;

import java.util.StringJoiner;

public class OwnerResponse {

    private Long id;
    private String email;
    private String token;

    public OwnerResponse(Long id, String email, String token) {
        this.id = id;
        this.email = email;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OwnerResponse.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("email='" + email + "'")
                .add("token='" + token + "'")
                .toString();
    }
}
