package org.example.service.impl;

import org.example.constant.ConstantMethods;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Flash implements CombinationsDefinable, ConstantMethods {
    @Override
    public boolean hasCombination(PokerHand hand) {
        Map<Integer, Long> suitCount = hand.getCards().stream()
                .map(card -> ConstantMethods.getCardSuit(card.substring(1)))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );
        return suitCount.values().stream().anyMatch(count -> count >= 5);
    }
}
