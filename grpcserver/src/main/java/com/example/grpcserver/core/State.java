package com.example.grpcserver.core;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum State {
    TX("TX"),
    MD("MD"),
    ID("ID"),
    AL("AL"),
    ME("ME"),
    TN("TN"),
    WY("WY"),
    DC("DC"),
    MA("MA"),
    ND("ND"),
    IL("IL"),
    VA("VA"),
    WA("WA"),
    PA("PA"),
    IN("IN"),
    OK("OK"),
    DE("DE"),
    RI("RI"),
    BO("BO");

    private final String state;

    State(String state) {
        this.state = state;
    }
}
