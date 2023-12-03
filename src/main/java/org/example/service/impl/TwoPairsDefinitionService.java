package org.example.service.impl;

import org.example.service.CombinationsDefinable;

import java.util.List;

public class TwoPairsDefinitionService implements CombinationsDefinable {
    @Override
    public boolean hasCombination(List<String> cards) {
        long pairCount = cardRateCountMap(cards).entrySet().stream()
                .filter(entry -> entry.getValue() == 2L)
                .count();
        return pairCount == 2L;
    }
}
