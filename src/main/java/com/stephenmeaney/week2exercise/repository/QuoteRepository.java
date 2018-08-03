package com.stephenmeaney.week2exercise.repository;

import com.stephenmeaney.week2exercise.entity.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
    //Room findByNumber(String number);
}