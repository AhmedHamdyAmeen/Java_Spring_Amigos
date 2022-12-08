package com.cashcall.merchant.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table // allow to map this class to the table in our database
public class Merchant {
    @Id
    @SequenceGenerator(
            name = "merchant_sequence",
            sequenceName = "merchant_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "merchant_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient // to tell the compiler don't make column for this value in the db.
    private Integer age;


    public Merchant() {
    }

    public Merchant(
            String name,
            String email,
            LocalDate dob
    ) {
        this.name = name;
        this.email = email;
        this.dob = dob;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        // Calculate the age.
        // Age = date of now - date of birth
        return Period.between(this.dob, LocalDate.now()).getYears();

    }

    public void setAge(Integer age) {
        this.age = age;
    }
}



