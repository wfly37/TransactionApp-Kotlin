package edu.dcccd.trans.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
public class Transaction
{
    private Long id;
    private String time;
    @NotNull
    @NotEmpty
    private String day;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private String type;

    public Transaction(){ this.time = currentTime(); }

    public Transaction(Long id, String type,String day, BigDecimal amount, String description)
    {
        this.time = currentTime();
        this.id = id;
        this.day = day;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    private static String currentTime()
    {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
    }
}

