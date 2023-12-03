package org.example.model;

import org.example.model.enumshand.CardSuit;
import org.example.model.enumshand.CardRate;

public class Card {
    private final CardRate cardRate;
    private final CardSuit suit;

    public Card(CardRate rote, CardSuit suit) {
        this.cardRate = rote;
        this.suit = suit;
    }

    public CardRate getRate() {
        return cardRate;
    }

    public CardSuit getSuit() {
        return suit;
    }

}
