package org.example.matcher;

import java.util.*;
import java.util.regex.Pattern;

public class HandFactory {
    private static final Pattern validPattern = Pattern.compile("[\\s23456789TJQKASHDC]+");
    private static final String spaceMatches = "\\s";

    public static List<String> getCards(String hand) {
        String[] cardArray = getValidString(hand).split(spaceMatches);
        List<String> cards = new ArrayList<>();
        Collections.addAll(cards, cardArray);
        if (cards.size() != 5) {
            throw new IllegalArgumentException("Invalid number of cards in hand");
        }
        return cards;
    }
    private static String getValidString(String s) {
        return Optional.of(s)
                .filter(validPattern.asMatchPredicate())
                .map(match -> s)
                .orElseThrow(() -> new NumberFormatException("Only these values are allowed for a poker hand: " + validPattern));
    }
}
