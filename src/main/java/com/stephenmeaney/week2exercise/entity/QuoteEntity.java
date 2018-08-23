package com.stephenmeaney.week2exercise.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "stockquote")
public class QuoteEntity {

    @Id
    @Column(name = "stockquote_id")
    @GeneratedValue
    private long id;

    @Transient
    private String symbol;

    @ManyToOne
    @JoinColumn(name = "stocksymbol_id")
    private SymbolEntity symbolEntity;

    @Column(name = "price")
    private double price;

    @Column(name = "volume")
    private int volume;

    @Column(name = "quote_date")
    private Timestamp date;


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

    public SymbolEntity getSymbolEntity() {
        return symbolEntity;
    }

    public void setSymbolEntity(SymbolEntity symbolEntity) {
        this.symbolEntity = symbolEntity;
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

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
