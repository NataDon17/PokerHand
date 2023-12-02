package org.example.definition;

import lombok.Data;
import org.example.model.Combination;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;
import org.example.service.impl.*;

import java.util.*;

@Data
public class ScorePokerHands {

    private HighestCard highestCard;
    private Pair pair;
    private TwoPairs twoPairs;
    private Trips trips;
    private Straight straight;
    private Flash flash;
    private FullHouse fullHouse;
    private Quads quads;
    private StraightFlush straightFlush;

    private static Map<Combination, CombinationsDefinable> initializeDefinition() {
        Map<Combination, CombinationsDefinable> combinationMap = new LinkedHashMap<>();
        combinationMap.put(Combination.STRAIGHT_FLASH, new StraightFlush(new Straight(), new Flash()));
        combinationMap.put(Combination.QUADS, new Quads());
        combinationMap.put(Combination.FULL_HOUSE, new FullHouse(new Pair(), new Trips()));
        combinationMap.put(Combination.FLASH, new Flash());
        combinationMap.put(Combination.STRAIGHT, new Straight());
        combinationMap.put(Combination.TRIPS, new Trips());
        combinationMap.put(Combination.TWO_PAIR, new TwoPairs());
        combinationMap.put(Combination.PAIR, new Pair());
        combinationMap.put(Combination.HIGHEST_CARD, new HighestCard());
        return combinationMap;
    }

    public static Combination getRankPokerHand(PokerHand hand) {
        Map<Combination, CombinationsDefinable> combinationMatchers = initializeDefinition();
        for (Map.Entry<Combination, CombinationsDefinable> entry : combinationMatchers.entrySet()) {
            if (!entry.getValue().getCombination(hand).equals(Combination.NON_COMBINATION)) {
                return entry.getKey();
            }
        }
        return Combination.NON_COMBINATION;
    }
}



