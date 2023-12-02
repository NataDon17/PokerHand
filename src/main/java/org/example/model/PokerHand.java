package org.example.model;

import lombok.Getter;

import java.util.*;
import java.util.regex.Pattern;

import static org.example.definition.ScorePokerHands.getRankPokerHand;

@Getter
public class PokerHand implements Comparable<PokerHand> {
    private String hand;
    private Combination combination;

    public PokerHand(String hand) {
        this.hand = hand;
    }

    public List<String> getCards() {
        String[] cardArray = getHand().split("\\s");
        List<String> cards = new ArrayList<>();
        if (isValidCardArray(cardArray)) {
            Collections.addAll(cards, cardArray);
        } else {
            throw new NumberFormatException("Only these values are allowed for a poker hand: 23456789TJQKA");
        }
        return cards;
    }

    private boolean isValidCardArray(String[] cardArray) {
        // Регулярное выражение для символов "23456789TJQKASHDC"
        String validPattern = "[23456789TJQKASHDC]+";
        return Arrays.stream(cardArray).allMatch(card -> Pattern.matches(validPattern, card));
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
        this.combination = getRankPokerHand(this);
        o.combination = getRankPokerHand(o);
        return Integer.compare(o.combination.ordinal(), this.combination.ordinal());
    }
}






