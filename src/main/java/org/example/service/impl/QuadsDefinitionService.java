package org.example.service.impl;

import org.example.service.CombinationsDefinable;

import java.util.List;

public class QuadsDefinitionService implements CombinationsDefinable {
    @Override
    public boolean hasCombination(List<String> cards) {
        return cardRateCountMap(cards).entrySet().stream().anyMatch(entry -> entry.getValue() == 4);
    }
}
