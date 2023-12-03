package org.example.model.enumshand;

public enum Combination {
    HIGHEST_CARD(1),
    PAIR(2),
    TWO_PAIR(3),
    TRIPS(4),
    STRAIGHT(5),
    FLASH(6),
    FULL_HOUSE(7),
    QUADS(8),
    STRAIGHT_FLASH(9);
    private final int rank;

    Combination(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
