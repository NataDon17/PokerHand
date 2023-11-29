package org.example;

public class Card {
    private Suit suit;
    private int value; // Значение карты, например, от 2 до 14 (11 - Валет, 12 - Дама, 13 - Король, 14 - Туз)

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
