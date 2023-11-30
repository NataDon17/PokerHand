package org.example.service.impl;

import org.example.constant.ConstantMethods;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Straight implements CombinationsDefinable, ConstantMethods {

    @Override
    public boolean hasCombination(PokerHand hand) {
        ArrayList<PokerHand> hands = new ArrayList<>();
        hands.add(hand);
        return hands.stream()
                .map(PokerHand::getCards)
                .filter(cards -> cards.size() >= 5)
                .anyMatch(cards -> IntStream.range(0, cards.size() - 4)
                        .anyMatch(i -> isStraight(cards.subList(i, i + 5))));
    }
    private static boolean isStraight(List<String> cards) {
        List<Integer> values = cards.stream()
                .map(card -> ConstantMethods.getCardValue(card.substring(0, 1)))
                .sorted()
                .toList();

        return IntStream.range(0, values.size() - 1)
                .allMatch(i -> values.get(i + 1) - values.get(i) == 1);
    }
}
