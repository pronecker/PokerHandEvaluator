package org.example.poker;

import org.example.poker.domain.CardSuit;
import org.example.poker.domain.CardValue;
import org.example.poker.domain.PokerHand;
import org.example.poker.domain.impl.CardImpl;
import org.example.poker.domain.impl.PokerHandImpl;

import java.util.List;

public class Main {
    public static void main(final String[] args) {
        final PokerHand hand1 = new PokerHandImpl(List.of(new CardImpl(CardSuit.C, CardValue.NINE),
                                                          new CardImpl(CardSuit.D, CardValue.THREE),
                                                          new CardImpl(CardSuit.H, CardValue.SEVEN),
                                                          new CardImpl(CardSuit.S, CardValue.KING),
                                                          new CardImpl(CardSuit.C, CardValue.EIGHT)));

        final PokerHand hand2 = new PokerHandImpl(List.of(new CardImpl(CardSuit.S, CardValue.JACK),
                                                          new CardImpl(CardSuit.D, CardValue.ACE),
                                                          new CardImpl(CardSuit.C, CardValue.FIVE),
                                                          new CardImpl(CardSuit.C, CardValue.TWO),
                                                          new CardImpl(CardSuit.H, CardValue.JACK)));

        final int comparison = hand1.compareTo(hand2);
        if (comparison > 0) {
            System.out.println("Hand 1 has won!");
        } else if (comparison < 0) {
            System.out.println("Hand 2 has won!");
        } else {
            System.out.println("Split pot!");
        }

    }
}