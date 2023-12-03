package org.example.definition;

import org.example.model.enumshand.Combination;
import org.example.service.CombinationsDefinable;
import org.example.service.impl.*;

import java.util.*;

public class ScorePokerHands {
    private static final Map<Combination, CombinationsDefinable> initializeDefinition = new LinkedHashMap<>();

    static {
        Map<Combination, CombinationsDefinable> combinationMap = initializeDefinition;
        combinationMap.put(Combination.STRAIGHT_FLASH, new StraightFlushDefinitionService(new StraightDefinitionService(), new FlashDefinitionService()));
        combinationMap.put(Combination.QUADS, new QuadsDefinitionService());
        combinationMap.put(Combination.FULL_HOUSE, new FullHouseDefinitionService(new PairDefinitionService(), new TripsDefinitionService()));
        combinationMap.put(Combination.FLASH, new FlashDefinitionService());
        combinationMap.put(Combination.STRAIGHT, new StraightDefinitionService());
        combinationMap.put(Combination.TRIPS, new TripsDefinitionService());
        combinationMap.put(Combination.TWO_PAIR, new TwoPairsDefinitionService());
        combinationMap.put(Combination.PAIR, new PairDefinitionService());
    }

    public static Combination getRankPokerHand(List<String> cards) {
        return initializeDefinition.entrySet().stream()
                .filter(entry -> entry.getValue().hasCombination(cards))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(Combination.HIGHEST_CARD);
    }
}



