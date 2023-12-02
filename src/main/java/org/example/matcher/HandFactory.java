package org.example.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class HandFactory {
    private static final String validPattern = "[23456789TJQKASHDC]+";
    private static final String spaceMatches = "\\s";

    public static List<String> getCards(String hand) {
        String[] cardArray = hand.split(spaceMatches);
        List<String> cards = new ArrayList<>();
        if (isValidCardArray(cardArray)) {
            Collections.addAll(cards, cardArray);
        } else {
            throw new NumberFormatException("Only these values are allowed for a poker hand: " + validPattern);
        }
        return cards;
    }

    private static boolean isValidCardArray(String[] cardArray) {
        return Arrays.stream(cardArray).allMatch(card -> Pattern.matches(validPattern, card));
    }
}
