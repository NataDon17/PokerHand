package org.example.service.impl;

import org.example.model.Combination;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

public class Quads implements CombinationsDefinable {
    @Override
    public Combination getCombination(PokerHand hand) {
        if (cardCountMap(hand).values().stream().anyMatch(count -> count == 4)) {
            return Combination.QUADS;
        }
        return Combination.NON_COMBINATION;
    }
}
