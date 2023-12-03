package org.example.service;

import org.example.matcher.CardFactory;
import org.example.model.Card;
import org.example.model.enumshand.CardRate;
import org.example.model.enumshand.CardSuit;

import java.util.*;
import java.util.stream.Collectors;

public interface CombinationsDefinable {
    boolean hasCombination(List<String> cards);

    default Map<CardRate, Long> cardRateCountMap(List<String> cards) {
        return cards.stream()
                .map(CardFactory::fromString)
                .collect(Collectors.groupingBy(
                        Card::getRate,
                        Collectors.counting())
                );
    }

    default Map<CardSuit, Long> cardSuitCountMap(List<String> cards) {
        return cards.stream()
                .map(CardFactory::fromString)
                .collect(Collectors.groupingBy(
                        Card::getSuit,
                        Collectors.counting())
                );
    }
}
