package com.example.clean.architecture.usecase.response;

import lombok.ToString;

@ToString
public class VoidResponse {

    private static final VoidResponse OK = new VoidResponse("OK");

    private static final VoidResponse EMPTY = new VoidResponse("EMPTY");

    private final String output;

    private VoidResponse(final String output) {
        this.output = output;
    }

    public static VoidResponse ok() {
        return OK;
    }

    public static VoidResponse empty() {
        return EMPTY;
    }

}