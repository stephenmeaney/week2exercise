package com.stephenmeaney.week2exercise;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;

@Component
public class QuoteAggregateInfo {

    private int maxPrice;

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }
}
