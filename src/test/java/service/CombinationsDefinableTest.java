package service;

import org.example.model.enumshand.CardRate;
import org.example.model.enumshand.CardSuit;
import org.example.service.CombinationsDefinable;
import org.example.service.impl.*;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

import static constants.PokerHandConstants.*;
import static org.junit.Assert.*;

public class CombinationsDefinableTest {

    private final CombinationsDefinable pair = new PairDefinitionService();
    private final CombinationsDefinable twoPair = new TwoPairsDefinitionService();
    private final CombinationsDefinable trips = new TripsDefinitionService();
    private final CombinationsDefinable quads = new QuadsDefinitionService();
    private final CombinationsDefinable straight = new StraightDefinitionService();
    private final CombinationsDefinable flash = new FlashDefinitionService();
    private final CombinationsDefinable fullHouse = new FullHouseDefinitionService((PairDefinitionService) pair, (TripsDefinitionService) trips);
    private final CombinationsDefinable straightFlush = new StraightFlushDefinitionService((StraightDefinitionService) straight, (FlashDefinitionService) flash);

    @Test
    public void testPair() {
        Map<CardRate, Long> expectedMap = Map.of(
                CardRate.FIVE, 1L,
                CardRate.FOUR, 1L,
                CardRate.TEN, 1L,
                CardRate.KING, 2L
        );
        Map<CardRate, Long> resultMap = pair.cardRateCountMap(PAIR_TEST.getCards());

        assertEquals(expectedMap, resultMap);

        boolean result = pair.hasCombination(PAIR_TEST.getCards());
        boolean result1 = pair.hasCombination(HIGHEST_CARD_TEST.getCards());
        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testTwoPairs() {
        Map<CardRate, Long> expectedMap = Map.of(
                CardRate.TEN, 1L,
                CardRate.FOUR, 2L,
                CardRate.KING, 2L
        );
        Map<CardRate, Long> resultMap = twoPair.cardRateCountMap(TWO_PAIR_TEST.getCards());

        assertEquals(expectedMap, resultMap);

        boolean result = twoPair.hasCombination(TWO_PAIR_TEST.getCards());
        boolean result1 = twoPair.hasCombination(PAIR_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testTrips() {
        Map<CardRate, Long> expectedMap = Map.of(
                CardRate.KING, 1L,
                CardRate.FOUR, 3L,
                CardRate.TEN, 1L
        );
        Map<CardRate, Long> resultMap = trips.cardRateCountMap(TRIPS_TEST.getCards());

        assertEquals(expectedMap, resultMap);

        boolean result = trips.hasCombination(TRIPS_TEST.getCards());
        boolean result1 = trips.hasCombination(HIGHEST_CARD_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testQuads() {
        Map<CardRate, Long> expectedMap = Map.of(
                CardRate.TEN, 1L,
                CardRate.FOUR, 4L
        );
        Map<CardRate, Long> resultMap = quads.cardRateCountMap(QUADS_TEST.getCards());

        assertEquals(expectedMap, resultMap);

        boolean result = quads.hasCombination(QUADS_TEST.getCards());
        boolean result1 = quads.hasCombination(TWO_PAIR_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testStraight() {
        List<Integer> expectedList = List.of(0, 1, 2, 3);
        List<CardRate> sort = straight.cardRateCountMap(STRAIGHT_TEST.getCards()).keySet().stream()
                .sorted()
                .toList();
        List<Integer> resultList = IntStream.range(0, sort.size() - 1)
                .filter(i -> sort.get(i + 1).ordinal() - sort.get(i).ordinal() == 1)
                .boxed().toList();

        assertEquals(expectedList, resultList);

        boolean result = straight.hasCombination(STRAIGHT_TEST.getCards());
        boolean result1 = straight.hasCombination(HIGHEST_CARD_TEST.getCards());

        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void testFlash() {
        Map<CardSuit, Long> expectedMap = Map.of(
                CardSuit.D, 5L);
        Map<CardSuit, Long> resultMap = flash.cardSuitCountMap(FLASH_TEST.getCards());
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
