package com.platzi.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class UserDomain {
    public static final int CORRECT_YEAR = 2021;
    @JsonIgnore
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;

    public UserDomain(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public UserDomain() {
    }

    public UserDomain(Long id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void isAgeCorrect() {
        if (birthDate.getYear() != CORRECT_YEAR) {
            //error
            throw new RuntimeException("Error en el año de creación del usuario");
        }
    }
}
