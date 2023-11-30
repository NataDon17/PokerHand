package org.example.service.impl;

import lombok.Data;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;
@Data
public class FullHouse implements CombinationsDefinable{
    private Pair pair;
    private Trips trips;


    @Override
    public boolean hasCombination(PokerHand hand) {
        return pair.hasCombination(hand) && trips.hasCombination(hand);
    }
}
