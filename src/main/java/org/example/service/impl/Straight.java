package org.example.service.impl;

import org.example.constant.ConstantMethods;
import org.example.model.Combination;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

import java.util.List;
import java.util.stream.IntStream;

public class Straight implements CombinationsDefinable {
    @Override
    public Combination getCombination(PokerHand hand) {
        List<Integer> values = hand.getCards().stream()
                .map(card -> ConstantMethods.getCardValue(card.substring(0, 1)))
                .sorted()
                .toList();
        if (IntStream.range(0, values.size() - 1).allMatch(i -> values.get(i + 1) - values.get(i) == 1)) {
            return Combination.STRAIGHT;
        }
        return Combination.NON_COMBINATION;
    }
}

