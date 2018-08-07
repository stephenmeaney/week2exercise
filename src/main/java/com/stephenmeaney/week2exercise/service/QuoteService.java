package com.stephenmeaney.week2exercise.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stephenmeaney.week2exercise.entity.QuoteEntity;
import com.stephenmeaney.week2exercise.entity.SymbolEntity;
import com.stephenmeaney.week2exercise.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<SymbolEntity> loadData() {

        List<SymbolEntity> symbolEntityList = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            URL url = new URL("https://bootcamp-training-files.cfapps.io/week1/week1-stocks.json");

            List<QuoteEntity> quoteList = mapper.readValue(url, new TypeReference<List<QuoteEntity>>(){});

            Map<String, List<QuoteEntity>> symbolQuoteMap = quoteList.stream().collect(Collectors.groupingBy(QuoteEntity::getSymbol));

            for (Map.Entry<String, List<QuoteEntity>> entry : symbolQuoteMap.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                symbolEntityList.add(new SymbolEntity(entry.getKey(), entry.getValue()));
            }

            quoteRepository.saveAll(symbolEntityList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return symbolEntityList;
    }

    public QuoteRepository.QuoteAggregateData getQuoteAggregateData(String symbol, String date) {
        if (date.matches("\\d+-\\d+")) {
            String[] splitDate = date.split("-");
            String year = splitDate[0];
            String month = splitDate[1];

            return quoteRepository.findAggregateQuoteDataByMonth(symbol, year, month);

        } else {
            return quoteRepository.findAggregateQuoteDataByDate(symbol, date);
        }

    }
}
