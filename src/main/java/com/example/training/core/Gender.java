package com.example.training.core;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {
    M("M"),
    F("F");
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
