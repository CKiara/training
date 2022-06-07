package com.example.account.api;

import com.example.account.core.Gender;
import com.example.account.core.State;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
    @JsonProperty("account_number")
    private Long accountNumber;

    private Integer balance;

    private String firstname;

    private String lastname;

    private Integer age;

    private Gender gender;

    private String address;

    private String employer;

    private String email;

    private String city;

    private State state;

    @JsonCreator
    public AccountDTO(@JsonProperty("account_number") Long accountNumber, @JsonProperty("balance") Integer balance,
                      @JsonProperty("firstname") String firstname, @JsonProperty("lastname") String lastname,
                      @JsonProperty("age") Integer age, @JsonProperty("gender") Gender gender,
                      @JsonProperty("address") String address, @JsonProperty("employer") String employer,
                      @JsonProperty("email") String email, @JsonProperty("city") String city,
                      @JsonProperty("state") State state) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.employer = employer;
        this.email = email;
        this.city = city;
        this.state = state;
    }

    public String getGender() {
        return gender.name();
    }

    public String getState() {
        return state.name();
    }

    @Override
    public String toString() {
        return "AccountDTO{" + "accountNumber=" + accountNumber + ", balance=" + balance + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + ", age=" + age + ", gender=" + gender + ", address='" + address + '\'' + ", employer='" + employer + '\'' + ", email='" + email + '\'' + ", city='" + city + '\'' + ", state=" + state + '}';
    }
}
