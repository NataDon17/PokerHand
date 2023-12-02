package org.example.service.impl;

import org.example.service.CombinationsDefinable;

import java.util.List;

public class TwoPairsDefinitionService implements CombinationsDefinable {
    @Override
    public boolean hasCombination(List<String> cards) {
        long pairCount = cardCountMap(cards).values().stream()
                .filter(count -> count == 2)
                .count();
        return (pairCount == 2);
    }
}
