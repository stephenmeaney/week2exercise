package com.stephenmeaney.week2exercise.controller;

import com.stephenmeaney.week2exercise.entity.QuoteEntity;
import com.stephenmeaney.week2exercise.repository.QuoteRepository;
import com.stephenmeaney.week2exercise.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {

    private QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/{symbol}/{date}")
    public QuoteRepository.QuoteAggregateData getData(
            @PathVariable("symbol") String symbol, @PathVariable("date") String date) {

        return quoteService.getQuoteAggregateData(symbol, date);
    }

    @PostMapping("/load")
    public List<QuoteEntity> postTest() {
        return quoteService.loadData();
    }
}
