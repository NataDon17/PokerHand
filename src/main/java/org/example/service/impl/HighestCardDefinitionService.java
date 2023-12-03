package org.example.service.impl;

import org.example.constant.ConstantMethods;
import org.example.service.CombinationsDefinable;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class HighestCardDefinitionService implements CombinationsDefinable {
    @Override
    public boolean hasCombination(List<String> cards) {
        Optional<String> highestCard = cards.stream()
                .map(card -> card.substring(0, 1))
                .max(Comparator.comparingInt(ConstantMethods::getCardValue));
        return highestCard.isPresent();
    }
}
