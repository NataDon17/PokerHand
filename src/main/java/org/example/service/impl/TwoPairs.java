package org.example.service.impl;

import org.example.model.Combination;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

public class TwoPairs implements CombinationsDefinable {
    @Override
    public Combination getCombination(PokerHand hand) {
        long pairCount = cardCountMap(hand).values().stream()
                .filter(count -> count == 2)
                .count();
        if (pairCount == 2) {
            return Combination.TWO_PAIR;
        }
        return Combination.NON_COMBINATION;
    }
}
