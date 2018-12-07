package edu.dcccd.trans.entity;

import lombok.*;

@Data public class JokeResponse {
    private String type;
    private Value value;

    public Value getValue() {
        return value;
    }
}
