package org.example;

import org.example.model.PokerHand;

import java.util.*;

public class PokerGameApplication {
    public static void main(String[] args) {

        ArrayList<PokerHand> hands = new ArrayList<>();
        hands.add(new PokerHand("KS 2H 5C JD TD"));
        hands.add(new PokerHand("2C 3C AC 4C 5C"));

        Collections.sort(hands);
        System.out.println(hands);
    }
}




