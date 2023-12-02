package org.example.service.impl;

import org.example.constant.ConstantMethods;
import org.example.model.Combination;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;

import java.util.Comparator;
import java.util.Optional;

public class HighestCard implements CombinationsDefinable {
    @Override
    public Combination getCombination(PokerHand hand) {
        Optional<String> highestCard = hand.getCards().stream()
                .map(card -> card.substring(0, 1))
                .max(Comparator.comparingInt(ConstantMethods::getCardValue));
        if (highestCard.isPresent()) {
            return Combination.HIGHEST_CARD;
        }
        return Combination.NON_COMBINATION;
    }
}
