package edu.dcccd.trans.entity;

import lombok.*;

@Data
public class Value {
    private int id;
    private String joke;

    public String getJoke() {
        return joke;
    }
}
