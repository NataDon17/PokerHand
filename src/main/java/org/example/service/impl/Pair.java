package org.example.service.impl;

import org.example.model.Combination;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

public class Pair implements CombinationsDefinable {
    @Override
    public Combination getCombination(PokerHand hand) {
        if (cardCountMap(hand).values().stream().anyMatch(count -> count == 2)) {
            return Combination.PAIR;
        }
        return Combination.NON_COMBINATION;
    }
}
