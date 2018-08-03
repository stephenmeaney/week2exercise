package com.stephenmeaney.week2exercise.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="stockquote")
public class QuoteEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="symbol")
    private String symbol;

    @Column(name="price")
    private double price;

    @Column(name="volume")
    private int volume;

    @Column(name="quote_date")
    private Timestamp date;

//    public QuoteEntity(String symbol, double price, int volume, Timestamp date) {
//        this.symbol = symbol;
//        this.price = price;
//        this.volume = volume;
//        this.date = date;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp quoteDate) {
        this.date = quoteDate;
    }
}
