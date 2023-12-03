package service;

import org.example.constant.ConstantMethods;
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

    private final CombinationsDefinable highestCard = new HighestCardDefinitionService();
    private final CombinationsDefinable pair = new PairDefinitionService();
    private final CombinationsDefinable twoPair = new TwoPairsDefinitionService();
    private final CombinationsDefinable trips = new TripsDefinitionService();
    private final CombinationsDefinable quads = new QuadsDefinitionService();
    private final CombinationsDefinable straight = new StraightDefinitionService();
    private final CombinationsDefinable flash = new FlashDefinitionService();
    private final CombinationsDefinable fullHouse = new FullHouseDefinitionService((PairDefinitionService) pair, (TripsDefinitionService) trips);
    private final CombinationsDefinable straightFlush = new StraightFlushDefinitionService((StraightDefinitionService) straight, (FlashDefinitionService) flash);

    @Test
    public void testHasHighestCard() {
        PokerHand testHand = new PokerHand("JC QC AC TC KC");

        boolean result = highestCard.hasCombination(HIGHEST_CARD_TEST.getCards());
        assertTrue(result);

        Optional<String> expected = Optional.of("A");
        Optional<String> resultString = testHand.getCards().stream().map(card -> card.substring(0, 1))
                .max(Comparator.comparingInt(ConstantMethods::getCardValue));

        assertEquals(expected, resultString);
    }

    @Test
    public void testPair() {
        Map<String, Long> expectedMap = Map.of(
                "2", 1L,
                "3", 1L,
                "T", 1L,
                "K", 2L);
        Map<String, Long> resultMap = pair.cardCountMap(PAIR_TEST.getCards());

        assertEquals(expectedMap, resultMap);

        boolean result = pair.hasCombination(PAIR_TEST.getCards());
        boolean result1 = pair.hasCombination(HIGHEST_CARD_TEST.getCards());
        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testTwoPairs() {
        Map<String, Long> expectedMap = Map.of(
                "2", 2L,
                "K", 2L,
                "T", 1L);
        Map<String, Long> resultMap = twoPair.cardCountMap(TWO_PAIR_TEST.getCards());

        assertEquals(expectedMap, resultMap);

        boolean result = twoPair.hasCombination(TWO_PAIR_TEST.getCards());
        boolean result1 = twoPair.hasCombination(PAIR_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testTrips() {
        Map<String, Long> expectedMap = Map.of(
                "2", 3L,
                "K", 1L,
                "T", 1L);
        Map<String, Long> resultMap = trips.cardCountMap(TRIPS_TEST.getCards());
        assertEquals(expectedMap, resultMap);

        boolean result = trips.hasCombination(TRIPS_TEST.getCards());
        boolean result1 = trips.hasCombination(HIGHEST_CARD_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testQuads() {
        Map<String, Long> expectedMap = Map.of(
                "2", 4L,
                "T", 1L);
        Map<String, Long> resultMap = quads.cardCountMap(QUADS_TEST.getCards());
        assertEquals(expectedMap, resultMap);

        boolean result = quads.hasCombination(QUADS_TEST.getCards());
        boolean result1 = quads.hasCombination(TWO_PAIR_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testStraight() {
        List<Integer> expected = List.of(0, 1, 2, 3);

        List<Integer> var = STRAIGHT_TEST.getCards().stream()
                .map(card -> ConstantMethods.getCardValue(card.substring(0, 1)))
                .sorted()
                .toList();

        List<Integer> resultList = IntStream.range(0, var.size() - 1)
                .filter(i -> var.get(i + 1) - var.get(i) == 1)
                .boxed().toList();
        assertEquals(expected, resultList);

        boolean result = straight.hasCombination(STRAIGHT_TEST.getCards());
        boolean result1 = straight.hasCombination(HIGHEST_CARD_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
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

        boolean result = flash.hasCombination(FLASH_TEST.getCards());
        boolean result1 = flash.hasCombination(QUADS_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testFullHouse() {
        boolean result = fullHouse.hasCombination(FULL_HOUSE_TEST.getCards());
        boolean result1 = fullHouse.hasCombination(TRIPS_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testStraightFlush() {
        boolean result = straightFlush.hasCombination(STRAIGHT_FLASH_TEST.getCards());
        boolean result1 = straightFlush.hasCombination(FLASH_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
    }
}
