package org.example.model;

import lombok.Getter;

import java.util.*;

@Getter
public class PokerHand {
    private final String hand;

    public PokerHand(String hand) {
        this.hand=hand;
    }

    public List<String> getCards() {
        String[] cardArray = getHand().split("\\s");
        List<String> cards = new ArrayList<>();
        Collections.addAll(cards, cardArray);
        return cards;
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "cards=" + hand +
                '}';
    }

//    @Override
//    public int compareTo(@NonNull PokerHand hand2) {
//        int rankHand1 = getRankOfHand(this);
//        int rankHand2 = getRankOfHand(hand2);
//        return Integer.compare(rankHand1, rankHand2);
//    }
}





