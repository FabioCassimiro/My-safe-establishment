package br.com.mysafeestablishment.api.response;

import java.util.StringJoiner;

public class OwnerResponse {

    private Long id;
    private String name;
    private String token;

    public OwnerResponse(Long id, String name, String token) {
        this.id = id;
        this.name = name;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return new StringJoiner(", ", OwnerResponse.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("token='" + token + "'")
                .toString();
    }
}
