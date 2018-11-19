package edu.dcccd.trans.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Entity
@Table(name = "TRANSACTION")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time;
    @NotNull
    @NotEmpty
    private String day;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    @Column( precision=7, scale=2)
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
