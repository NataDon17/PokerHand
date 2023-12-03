package constants;

import org.example.model.PokerHand;

public class PokerHandConstants {
    public static final PokerHand HIGHEST_CARD_TEST = new PokerHand("2S 3H KD 9C TC");
    public static final PokerHand PAIR_TEST = new PokerHand("2S 3H KD KC TC");
    public static final PokerHand TWO_PAIR_TEST = new PokerHand("2S 2H KD KC TC");
    public static final PokerHand TRIPS_TEST = new PokerHand("2S 2H 2D KC TC");
    public static final PokerHand QUADS_TEST = new PokerHand("2S 2H 2D 2C TC");
    public static final PokerHand STRAIGHT_TEST = new PokerHand("2S 3H 4D 5C 6C");
    public static final PokerHand FLASH_TEST = new PokerHand("7D 8D TD 4D AD");
    public static final PokerHand STRAIGHT_FLASH_TEST = new PokerHand("JC QC AC TC KC");
    public static final PokerHand FULL_HOUSE_TEST = new PokerHand("7S 7H JD JC JS");
}
