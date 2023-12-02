package org.example.service.impl;

import org.example.constant.ConstantMethods;
import org.example.service.CombinationsDefinable;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlashDefinitionService implements CombinationsDefinable, ConstantMethods {
    @Override
    public boolean hasCombination(List<String> cards) {
        Map<String, Long> suitCount = cards.stream()
                .map(card -> ConstantMethods.getCardSuit(card.substring(1)))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );
        return suitCount.values().stream().anyMatch(count -> count >= 5);
    }
}

