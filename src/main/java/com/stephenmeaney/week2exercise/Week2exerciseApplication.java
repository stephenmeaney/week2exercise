package com.stephenmeaney.week2exercise;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stephenmeaney.week2exercise.entity.Quote;
import com.stephenmeaney.week2exercise.repository.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URL;
import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class Week2exerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week2exerciseApplication.class, args);
    }



    @Bean
    CommandLineRunner runner(QuoteRepository repository) {
        return args -> {
            System.out.println("Starting CommandLineRunner");
//            Timestamp dt = new Timestamp(2018, 1, 1, 1, 1, 1, 1);
//            Quote quote = new Quote("abcd", 12.13, 1000, dt);
//            repository.save(quote);

            ObjectMapper mapper = new ObjectMapper();
            URL url = new URL("https://bootcamp-training-files.cfapps.io/week1/week1-stocks.json");

            List<Quote> quoteList = mapper.readValue(url, new TypeReference<List<Quote>>(){});
            repository.saveAll(quoteList);
        };
    }
}
