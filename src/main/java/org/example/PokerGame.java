package org.example;

import org.example.definition.RankPokerHands;
import org.example.model.PokerHand;

import java.util.*;


public class PokerGame {
    public static void main(String[] args) {

        ArrayList<PokerHand> hands = new ArrayList<>();
        hands.add(new PokerHand("3S 4S 7S 5S 6S"));
        hands.add(new PokerHand("JC QС AC TC KC"));

//        Collections.sort(hands, new RankPokerHands());
        hands.sort(new RankPokerHands());
        hands.forEach(System.out::println);
    }
}




