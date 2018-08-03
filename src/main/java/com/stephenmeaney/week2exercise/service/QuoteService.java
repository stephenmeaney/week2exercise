package com.stephenmeaney.week2exercise.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stephenmeaney.week2exercise.entity.QuoteEntity;
import com.stephenmeaney.week2exercise.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<QuoteEntity> loadData() {

        List<QuoteEntity> quoteList = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            URL url = new URL("https://bootcamp-training-files.cfapps.io/week1/week1-stocks.json");

            quoteList = mapper.readValue(url, new TypeReference<List<QuoteEntity>>(){});
            quoteRepository.saveAll(quoteList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return quoteList;
    }
}
