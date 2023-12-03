package org.example.service.impl;

import org.example.model.enumshand.CardRate;
import org.example.service.CombinationsDefinable;

import java.util.List;
import java.util.stream.IntStream;

public class StraightDefinitionService implements CombinationsDefinable {
    @Override
    public boolean hasCombination(List<String> cards) {
        List<CardRate> sortRateList = cardRateCountMap(cards).keySet().stream()
                .sorted()
                .toList();
        return IntStream.range(0, sortRateList.size() - 1)
                .allMatch(i -> sortRateList.get(i + 1).ordinal() - sortRateList.get(i).ordinal() == 1);
    }
}

