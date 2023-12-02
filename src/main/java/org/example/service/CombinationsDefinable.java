package org.example.service;

import org.example.model.Combination;
import org.example.model.PokerHand;

import java.util.Map;
import java.util.stream.Collectors;

public interface CombinationsDefinable {
    Combination getCombination(PokerHand hand);

    default Map<String, Long> cardCountMap(PokerHand hand) {
        return hand.getCards().stream()
                .collect(Collectors.groupingBy(
                        card -> card.substring(0, card.length() - 1),
                        Collectors.counting())
                );
    }
}
