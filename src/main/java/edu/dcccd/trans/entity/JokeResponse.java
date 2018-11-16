package edu.dcccd.trans.entity;

import lombok.*;

@Data public class JokeResponse {
    private String type;
    @Getter private Value value;
}
