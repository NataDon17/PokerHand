package org.example.definition;

import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;
import org.example.service.impl.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RankPokerHands implements Comparator<PokerHand> {
    public Map<CombinationsDefinable, Integer> handRanks;
    public RankPokerHands() {
        handRanks=new HashMap<>();
        handRanks.put(new StraightFlush(), 1);
        handRanks.put(new Quads(), 2);
        handRanks.put(new FullHouse(), 3);
        handRanks.put(new Flash(), 4);
        handRanks.put(new Straight(), 5);
        handRanks.put(new Trips(), 6);
        handRanks.put(new TwoPairs(), 7);
        handRanks.put(new Pair(), 8);
        handRanks.put(new HighestCard(), 9);
    }

    private int getRankOfHand(PokerHand hand) {
        for (Map.Entry<CombinationsDefinable, Integer> entry : handRanks.entrySet()) {
            CombinationsDefinable combination = entry.getKey();
            int rank = entry.getValue();
            if (combination.hasCombination(hand)) {
                return rank;
            }
        }
        return -1; // Дефолтный ранг
    }

    @Override
    public int compare(PokerHand hand1, PokerHand hand2) {
        int rankHand1 = getRankOfHand(hand1);
        int rankHand2 = getRankOfHand(hand2);
        return Integer.compare(rankHand1, rankHand2);
    }
//        if (hasFlash(hand) && hasStraight(hand)) {
//            return 1; // Стрит-флеш, включая флеш-рояль
//        } else if (hasQuads(hand)) {
//            return 2; // Каре
//        } else if (hasPair(hand) && hasTrips(hand)) {
//            return 3; // Фулл-хаус
//        } else if (hasFlash(hand)) {
//            return 4; // Флеш
//        } else if (hasStraight(hand)) {
//            return 5; // Стрит
//        } else if (hasTrips(hand)) {
//            return 6; // Тройка
//        } else if (hasTwoPairs(hand)) {
//            return 7; // Две пары
//        } else if (hasPair(hand)) {
//            return 8; // Пара
//        } else if (hasHighestCard(hand)) {
//            return 9; // Ни одна из комбинаций выше
//        } else {
//            return 10;
//        }
    }

