package org.example.service;

import org.example.model.PokerHand;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface CombinationsDefinable {
    boolean hasCombination(PokerHand hand);
    default Map<String, Long> cardCountMap(PokerHand hand) {
        List<String> cards = hand.getCards();
        return cards.stream()
                .collect(Collectors.groupingBy(
                        card -> card.substring(0, card.length() - 1),
                        Collectors.counting())
                );
    }
}
