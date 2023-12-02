package org.example.service.impl;

import org.example.constant.ConstantMethods;
import org.example.model.Combination;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Flash implements CombinationsDefinable, ConstantMethods {
    @Override
    public Combination getCombination(PokerHand hand) {
        Map<String, Long> suitCount = hand.getCards().stream()
                .map(card -> ConstantMethods.getCardSuit(card.substring(1)))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );
        if (suitCount.values().stream().anyMatch(count -> count >= 5)) {
            return Combination.FLASH;
        }
        return Combination.NON_COMBINATION;
    }
}

