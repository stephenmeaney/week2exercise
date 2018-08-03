package com.stephenmeaney.week2exercise.controller;

import com.stephenmeaney.week2exercise.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuoteController {

    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping("/{date}")
    public String getTest(@PathVariable("date") String date) {
        return "get reached, the path variable is " + date;
    }

    @PostMapping("/load")
    public String postTest() {
        return "post reached";

    }
}
