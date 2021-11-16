package br.com.mysafeestablishment.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.StringJoiner;

@Entity
public class Establishment extends AbstractEntity {

    @Column(
            nullable = false
    )
    private String tradingName;
    @Column(
            nullable = false
    )
    private String companyName;
    @Column(
            nullable = false
    )
    private String cnpj;
    @Column(
            nullable = false
    )
    private String typeEstablishment;
    @Column(
            nullable = false
    )
    private String phoneNumber;
    @OneToOne(
            cascade = CascadeType.PERSIST
    )
    private Address address;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTypeEstablishment() {
        return typeEstablishment;
    }

    public void setTypeEstablishment(String typeEstablishment) {
        this.typeEstablishment = typeEstablishment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Establishment(String companyName, String tradingName, String cnpj, String typeEstablishment, String phoneNumber) {
        this.companyName = companyName;
        this.tradingName = tradingName;
        this.cnpj = cnpj;
        this.typeEstablishment = typeEstablishment;
        this.phoneNumber = phoneNumber;
    }

    public Establishment() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Establishment.class.getSimpleName() + "[", "]")
                .add("tradingName='" + tradingName + "'")
                .add("companyName='" + companyName + "'")
                .add("cnpj='" + cnpj + "'")
                .add("typeEstablishment='" + typeEstablishment + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("address=" + address)
                .toString();
    }
}
