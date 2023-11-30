package org.example.service.impl;

import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

public class Pair implements CombinationsDefinable {
    @Override
    public boolean hasCombination(PokerHand hand) {
        return cardCountMap(hand).values().stream()
                .anyMatch(count -> count == 2);
    }
}
