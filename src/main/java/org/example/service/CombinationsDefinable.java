package org.example.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface CombinationsDefinable {
    boolean hasCombination(List<String> cards);

    default Map<String, Long> cardCountMap(List<String> cards) {
        return cards.stream()
                .collect(Collectors.groupingBy(
                        card -> card.substring(0, card.length() - 1),
                        Collectors.counting())
                );
    }
}
