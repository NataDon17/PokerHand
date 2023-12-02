package service;

import org.example.definition.ScorePokerHands;
import org.example.model.PokerHand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SortPokerHandTest {
    @Test
    public void tesGetRankPokerHand() {
        List<PokerHand> expectedHands = new ArrayList<>();
        expectedHands.add(new PokerHand("6S 7S 8S 9S TS"));    // 9
        expectedHands.add(new PokerHand("7H 5S 7D 7D 7S"));    // 8
        expectedHands.add(new PokerHand("TS 4C 4S TD 4H"));    // 7
        expectedHands.add(new PokerHand("2C 3C AC 4C 5C"));    // 6
        expectedHands.add(new PokerHand("7S 3D 4H 6S 5S"));    // 5
        expectedHands.add(new PokerHand("7H 5S 5D 2D 5S"));    // 4
        expectedHands.add(new PokerHand("7H 7S 5D 2D 5S"));    // 3
        expectedHands.add(new PokerHand("2H 5S 7D 7D 3S"));    // 2

        ArrayList<PokerHand> resultHands = new ArrayList<>();
        resultHands.add(new PokerHand("7S 3D 4H 6S 5S"));       // 5
        resultHands.add(new PokerHand("2H 5S 7D 7D 3S"));       // 2
        resultHands.add(new PokerHand("2C 3C AC 4C 5C"));       // 6
        resultHands.add(new PokerHand("7H 5S 5D 2D 5S"));       // 4
        resultHands.add(new PokerHand("6S 7S 8S 9S TS"));       // 9
        resultHands.add(new PokerHand("TS 4C 4S TD 4H"));       // 7
        resultHands.add(new PokerHand("7H 5S 7D 7D 7S"));       // 8
        resultHands.add(new PokerHand("7H 7S 5D 2D 5S"));       // 3

        for (PokerHand hand : resultHands) {
            PokerHand expectedHand = expectedHands.get(resultHands.indexOf(hand));
            assertNotEquals(ScorePokerHands.getRankPokerHand(hand), ScorePokerHands.getRankPokerHand(expectedHand));
        }

        Collections.sort(resultHands);

        for (PokerHand hand : resultHands) {
            PokerHand expectedHand = expectedHands.get(resultHands.indexOf(hand));
            assertEquals(ScorePokerHands.getRankPokerHand(hand), ScorePokerHands.getRankPokerHand(expectedHand));
        }
    }
}
