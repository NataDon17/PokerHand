package org.example.service.impl;

import org.example.service.CombinationsDefinable;

import java.util.List;

public class FlashDefinitionService implements CombinationsDefinable {
    @Override
    public boolean hasCombination(List<String> cards) {
        return cardSuitCountMap(cards).values().stream().anyMatch(count -> count == 5);
    }
}

