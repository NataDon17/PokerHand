package org.example.constant;

public interface ConstantMethods {
    static int getCardValue(String cardValue) {
        return switch (cardValue) {
            case "A" -> 14;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> 11;
            case "T" -> 10;
            default -> Integer.parseInt(cardValue);
        };
    }

    static String getCardSuit(String cardSuit) {
        return switch (cardSuit) {
            case "H" -> "HEARTS";
            case "D" -> "DIAMONDS";
            case "C" -> "CLUBS";
            case "S" -> "SPADES";
            default -> throw new NumberFormatException("Invalid card suit: " + cardSuit);
        };
    }
}
