package com.stephenmeaney.week2exercise.repository;

import com.stephenmeaney.week2exercise.entity.QuoteEntity;
import com.stephenmeaney.week2exercise.entity.SymbolEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuoteRepository extends CrudRepository<SymbolEntity, Long> {

    @Query(value =
            "SELECT MIN(price) AS minPrice, MAX(price) AS maxPrice, SUM(volume) AS totalVolume, (\n" +
            "   SELECT price\n" +
            "   FROM week2stockquotes.stockquote JOIN week2stockquotes.stocksymbol ON week2stockquotes.stockquote.stocksymbol_id = week2stockquotes.stocksymbol.stocksymbol_id\n" +
            "   WHERE date(quote_date) = ?2 AND symbol = ?1 AND time(quote_date) = (\n" +
            "       SELECT MAX(time(quote_date))\n" +
            "       FROM week2stockquotes.stockquote JOIN week2stockquotes.stocksymbol ON week2stockquotes.stockquote.stocksymbol_id = week2stockquotes.stocksymbol.stocksymbol_id)) AS closingPrice\n" +
            "FROM week2stockquotes.stockquote JOIN week2stockquotes.stocksymbol ON week2stockquotes.stockquote.stocksymbol_id = week2stockquotes.stocksymbol.stocksymbol_id\n" +
            "WHERE date(quote_date) = ?2 AND symbol = ?1", nativeQuery = true)
    QuoteAggregateData findAggregateQuoteDataByDate(String symbol, String date);

    @Query(value =
            "SELECT MIN(price) AS minPrice, MAX(price) AS maxPrice, SUM(volume) AS totalVolume, (\n" +
            "   SELECT price\n" +
            "   FROM week2stockquotes.stockquote JOIN week2stockquotes.stocksymbol ON week2stockquotes.stockquote.stocksymbol_id = week2stockquotes.stocksymbol.stocksymbol_id\n" +
            "   WHERE YEAR(quote_date) = ?2 AND MONTH(quote_date) = ?3 AND symbol = ?1 AND quote_date = (\n" +
            "       SELECT MAX(quote_date)\n" +
            "       FROM week2stockquotes.stockquote JOIN week2stockquotes.stocksymbol ON week2stockquotes.stockquote.stocksymbol_id = week2stockquotes.stocksymbol.stocksymbol_id)) AS closingPrice\n" +
            "FROM week2stockquotes.stockquote JOIN week2stockquotes.stocksymbol ON week2stockquotes.stockquote.stocksymbol_id = week2stockquotes.stocksymbol.stocksymbol_id\n" +
            "WHERE YEAR(quote_date) = ?2 AND MONTH(quote_date) = ?3 AND symbol = ?1", nativeQuery = true)
    QuoteAggregateData findAggregateQuoteDataByMonth(String symbol, String year, String month);

    interface QuoteAggregateData {
        double getMinPrice();
        double getMaxPrice();
        int getTotalVolume();
        double getClosingPrice();
    }
}