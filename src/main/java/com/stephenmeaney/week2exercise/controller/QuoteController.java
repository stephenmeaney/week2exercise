package com.stephenmeaney.week2exercise.controller;

import com.stephenmeaney.week2exercise.QuoteAggregateInfo;
import com.stephenmeaney.week2exercise.entity.QuoteEntity;
import com.stephenmeaney.week2exercise.repository.QuoteRepository;
import com.stephenmeaney.week2exercise.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {

    private QuoteService quoteService;
    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteController(QuoteService quoteService, QuoteRepository quoteRepository) {
        this.quoteService = quoteService;
        this.quoteRepository = quoteRepository;
    }

//    @GetMapping("/{date}")
//    public String getTest(@PathVariable("date") String date) {
//        return "get reached, the path variable is " + date;
//    }

    @GetMapping("/{symbol}/{date}")
    public QuoteRepository.QuoteAggregateData getData(
            @PathVariable("symbol") String symbol, @PathVariable("date") String date) {

//        Timestamp dt = new Timestamp(2018, 1, 1, 1, 1, 1, 1);
//        QuoteEntity quote = new QuoteEntity("abcd", 12.13, 1000, dt);
//
//        return quote;

//        return new LinkedList<QuoteEntity>();

        //System.out.println(quoteService.getAggregateData(date));

        return quoteRepository.findAggregateQuoteData(symbol, date);
    }

    @PostMapping("/load")
    public List<QuoteEntity> postTest() {
        return quoteService.loadData();
    }
}
