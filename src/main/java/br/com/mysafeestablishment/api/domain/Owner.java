package br.com.mysafeestablishment.api.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Owner extends AbstractEntity {

    @Column(
            nullable = false
    )
    private String name;
    @Column(
            nullable = false
    )
    private String cpf;
    @Column(
            nullable = false
    )
    private String phoneNumber;
    @Column(
            nullable = false,
            unique = true
    )
    private String email;
    @Column(
            nullable = false,
            unique = true
    )
    private String password;
    @OneToOne(
            cascade = CascadeType.PERSIST
    )
    private Establishment establishment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    public Owner(String name, String cpf, String phoneNumber, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public Owner(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Owner() {
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
