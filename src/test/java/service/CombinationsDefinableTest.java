package service;

import org.example.constant.ConstantMethods;
import org.example.model.Combination;
import org.example.model.PokerHand;
import org.example.service.CombinationsDefinable;
import org.example.service.impl.*;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static constants.PokerHandConstants.*;
import static org.junit.Assert.*;

public class CombinationsDefinableTest {

    private final CombinationsDefinable highestCard = new HighestCard();
    private final CombinationsDefinable pair = new Pair();
    private final CombinationsDefinable twoPair = new TwoPairs();
    private final CombinationsDefinable trips = new Trips();
    private final CombinationsDefinable quads = new Quads();
    private final CombinationsDefinable straight = new Straight();
    private final CombinationsDefinable flash = new Flash();
    private final CombinationsDefinable fullHouse = new FullHouse((Pair) pair, (Trips) trips);
    private final CombinationsDefinable straightFlush = new StraightFlush((Straight) straight, (Flash) flash);

    @Test
    public void testHasHighestCard() {
        Combination result = highestCard.getCombination(HIGHEST_CARD_TEST);
        Combination expected = Combination.HIGHEST_CARD;

        assertEquals(expected, result);
    }

    @Test
    public void testPair() {
        Map<String, Long> expectedMap = Map.of(
                "2", 1L,
                "3", 1L,
                "T", 1L,
                "K", 2L);
        Map<String, Long> resultMap = pair.cardCountMap(PAIR_TEST);

        assertEquals(expectedMap, resultMap);

        Combination result = pair.getCombination(PAIR_TEST);
        Combination expected = Combination.PAIR;

        assertEquals(expected, result);
    }

    @Test
    public void testTwoPairs() {
        Map<String, Long> expectedMap = Map.of(
                "2", 2L,
                "K", 2L,
                "T", 1L);
        Map<String, Long> resultMap = twoPair.cardCountMap(TWO_PAIR_TEST);

        assertEquals(expectedMap, resultMap);

        Combination result = twoPair.getCombination(TWO_PAIR_TEST);
        Combination expected = Combination.TWO_PAIR;

        assertEquals(expected, result);
    }

    @Test
    public void testTrips() {
        PokerHand testHand2 = new PokerHand("2S 9H KD 9C TC");
        Map<String, Long> expectedMap = Map.of(
                "2", 3L,
                "K", 1L,
                "T", 1L);
        Map<String, Long> resultMap = trips.cardCountMap(TRIPS_TEST);
        assertEquals(expectedMap, resultMap);

        Combination result1 = trips.getCombination(TRIPS_TEST);
        Combination expected1 = Combination.TRIPS;

        assertEquals(expected1, result1);

        Combination result2 = trips.getCombination(testHand2);
        Combination expected2 = Combination.NON_COMBINATION;

        assertEquals(expected2, result2);
    }

    @Test
    public void testQuads() {
        Map<String, Long> expectedMap = Map.of(
                "2", 4L,
                "T", 1L);
        Map<String, Long> resultMap = quads.cardCountMap(QUADS_TEST);
        assertEquals(expectedMap, resultMap);

        Combination result1 = quads.getCombination(QUADS_TEST);
        Combination expected1 = Combination.QUADS;

        assertEquals(expected1, result1);

        Combination result2 = quads.getCombination(HIGHEST_CARD_TEST);
        Combination expected2 = Combination.NON_COMBINATION;

        assertEquals(expected2, result2);
    }

    @Test
    public void testStraight() {
        PokerHand testHand2 = new PokerHand("9S 9H KD 9C TC");

        List<Integer> expected = List.of(0, 1, 2, 3);

        List<Integer> var = STRAIGHT_TEST.getCards().stream()
                .map(card -> ConstantMethods.getCardValue(card.substring(0, 1)))
                .sorted()
                .toList();

        List<Integer> resultList = IntStream.range(0, var.size() - 1)
                .filter(i -> var.get(i + 1) - var.get(i) == 1)
                .boxed().toList();
        assertEquals(expected, resultList);

        Combination result1 = straight.getCombination(STRAIGHT_TEST);
        Combination expected1 = Combination.STRAIGHT;

        assertEquals(expected1, result1);

        Combination result2 = straight.getCombination(testHand2);
        Combination expected2 = Combination.NON_COMBINATION;

        assertEquals(expected2, result2);
    }

    @Test
    public void testFlash() {
        Map<String, Long> expectedMap = Map.of(
                "DIAMONDS", 5L);
        Map<String, Long> resultMap = FLASH_TEST.getCards().stream()
                .map(card -> ConstantMethods.getCardSuit(card.substring(1)))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );
        assertEquals(expectedMap, resultMap);

        Combination result1 = flash.getCombination(FLASH_TEST);
        Combination expected1 = Combination.FLASH;

        assertEquals(expected1, result1);

        Combination result2 = flash.getCombination(TWO_PAIR_TEST);
        Combination expected2 = Combination.NON_COMBINATION;

        assertEquals(expected2, result2);

    }

    @Test
    public void testFullHouse() {
        Combination result = fullHouse.getCombination(FULL_HOUSE_TEST);
        Combination expected = Combination.FULL_HOUSE;

        assertEquals(expected, result);

        Combination result1 = fullHouse.getCombination(TRIPS_TEST);
        Combination expected1 = Combination.NON_COMBINATION;

        assertEquals(expected1, result1);
    }

    @Test
    public void testStraightFlush() {
        Combination result = straightFlush.getCombination(STRAIGHT_FLASH_TEST);
        Combination expected = Combination.STRAIGHT_FLASH;

        assertEquals(expected, result);

        Combination result1 = straightFlush.getCombination(FLASH_TEST);
        Combination expected1 = Combination.NON_COMBINATION;

        assertEquals(expected1, result1);
    }
}
