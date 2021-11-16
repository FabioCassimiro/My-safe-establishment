package br.com.mysafeestablishment.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends AbstractEntity {

    @Column(
            nullable = false
    )
    private String publicPlace;
    @Column(
            nullable = false
    )
    private String number;
    @Column(
            nullable = false
    )
    private String district;
    @Column(
            nullable = false
    )
    private String city;

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String publicPlace, String number, String district, String city) {
        this.publicPlace = publicPlace;
        this.number = number;
        this.district = district;
        this.city = city;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "publicPlace='" + publicPlace + '\'' +
                ", number='" + number + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
