package org.example.service.impl;

import lombok.Data;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;
@Data
public class StraightFlush implements CombinationsDefinable {
    private Straight straight;
    private Flash flash;
    @Override
    public boolean hasCombination(PokerHand hand) {
        return straight.hasCombination(hand) && flash.hasCombination(hand);
    }
}
