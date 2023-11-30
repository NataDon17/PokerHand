package org.example.service.impl;

import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

public class TwoPairs implements CombinationsDefinable {
    @Override
    public boolean hasCombination(PokerHand hand) {
        long pairCount = cardCountMap(hand).values().stream()
                .filter(count -> count == 2)
                .count();
        return pairCount == 2;
    }
}
