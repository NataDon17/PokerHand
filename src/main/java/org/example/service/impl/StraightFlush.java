package org.example.service.impl;

import org.example.model.Combination;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;


public class StraightFlush implements CombinationsDefinable {

    private final Straight straight;
    private final Flash flash;

    public StraightFlush(Straight straight, Flash flash) {
        this.straight = straight;
        this.flash = flash;
    }

    @Override
    public Combination getCombination(PokerHand hand) {
        Combination combination = straight.getCombination(hand);
        Combination combination1 = flash.getCombination(hand);
        if (combination.equals(Combination.STRAIGHT) && combination1.equals(Combination.FLASH)) {
            return Combination.STRAIGHT_FLASH;
        }
        return Combination.NON_COMBINATION;
    }
}
