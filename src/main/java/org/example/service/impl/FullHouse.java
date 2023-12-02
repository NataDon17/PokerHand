package org.example.service.impl;

import org.example.model.Combination;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

public class FullHouse implements CombinationsDefinable {
    private final Pair pair;
    private final Trips trips;

    public FullHouse(Pair pair, Trips trips) {
        this.pair = pair;
        this.trips = trips;
    }

    @Override
    public Combination getCombination(PokerHand hand) {
        Combination combination = pair.getCombination(hand);
        Combination combination1 = trips.getCombination(hand);
        if (combination.equals(Combination.PAIR) && combination1.equals(Combination.TRIPS)) {
            return Combination.FULL_HOUSE;
        }
        return Combination.NON_COMBINATION;
    }
}
