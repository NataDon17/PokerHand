package org.example.matcher;

import org.example.model.Card;
import org.example.model.enumshand.CardRate;
import org.example.model.enumshand.CardSuit;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CardFactory {
    public static Card fromString(String card) {
        char charRate = card.charAt(0);
        CardRate rate;
        if (Character.isDigit(charRate)) {
            int num = Character.getNumericValue(charRate);
            rate = CardRate.values()[num];
        } else {
            rate = getFromCharRate(charRate);
        }
        char charSuit = card.charAt(1);
        CardSuit suit = getFromCharSuit(charSuit);
        return new Card(rate, suit);
    }

    public static CardRate getFromCharRate(char name) {
        CardRate rate;
        switch (name) {
            case 'T' -> rate = CardRate.TEN;
            case 'J' -> rate = CardRate.JACK;
            case 'Q' -> rate = CardRate.QUEEN;
            case 'K' -> rate = CardRate.KING;
            case 'A' -> rate = CardRate.ACE;
            default -> throw new IllegalArgumentException("Invalid card rate");
        }
        return rate;
    }

    public static CardSuit getFromCharSuit(char name) {
        return Arrays.stream(CardSuit.values())
                .filter(suit -> suit.name().equals(String.valueOf(name)))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
