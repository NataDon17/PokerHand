package org.example.service.impl;

import org.example.constant.ConstantMethods;
import org.example.service.CombinationsDefinable;

import java.util.List;
import java.util.stream.IntStream;

public class StraightDefinitionService implements CombinationsDefinable {
    @Override
    public boolean hasCombination(List<String> cards) {
        List<Integer> values = cards.stream()
                .map(card -> ConstantMethods.getCardValue(card.substring(0, 1)))
                .sorted()
                .toList();
        return (IntStream.range(0, values.size() - 1).allMatch(i -> values.get(i + 1) - values.get(i) == 1));
    }
}

