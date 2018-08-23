package com.stephenmeaney.week2exercise.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stocksymbol")
public class SymbolEntity {

    @Id
    @Column(name = "stocksymbol_id")
    @GeneratedValue
    private long id;

    @Column(name = "symbol")
    private String symbol;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "stocksymbol_id")
    private List<QuoteEntity> quoteEntityList;


    public SymbolEntity(String symbol, List<QuoteEntity> quoteEntityList) {
        this.symbol = symbol;
        this.quoteEntityList = quoteEntityList;
    }

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
}
