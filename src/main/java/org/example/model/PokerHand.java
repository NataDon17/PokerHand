package org.example.model;

import org.example.matcher.HandFactory;
import org.example.model.enumshand.Combination;

import java.util.List;

import static org.example.definition.ScorePokerHands.getRankPokerHand;

public class PokerHand implements Comparable<PokerHand> {
    private final String hand;
    private final List<String> cards;
    private final Combination combination;

    public PokerHand(String hand) {
        this.hand = hand;
        cards = HandFactory.getCards(hand);
        combination = getRankPokerHand(cards);
    }

    public List<String> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "\nPokerHand{" +
                "hand='" + hand + '\'' +
                ", combination=" + combination +
                '}';
    }

    @Override
    public int compareTo(PokerHand o) {
        return Integer.compare(o.combination.ordinal(), this.combination.ordinal());
    }
}






