package com.DoAn.HairStyle.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private  String token;
    @Column
    @NotBlank
    private  String fullName;
    @Column
    @NotBlank
    private  String numberPhone;
    @Column
    @NotBlank
    private  String passWord;
    @Column
    @NotBlank
    private  String role;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Column
    @NotBlank
    private String address;

    public void setToken(String token) {
        this.token = token;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserEntity() {
        super();
    }

    public String getToken() {
        return token;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public String getPassWord() {
        return passWord;
    }
}