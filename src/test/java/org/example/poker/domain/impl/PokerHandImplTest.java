package org.example.poker.domain.impl;

import org.example.poker.domain.Card;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PokerHandImplTest {

    @Test
    void differentHandRanks() {
        compare(TestUtility.HIGH_CARD_LOW, TestUtility.PAIR_LOW);
        compare(TestUtility.PAIR_LOW, TestUtility.TWO_PAIR_LOW);
        compare(TestUtility.TWO_PAIR_LOW, TestUtility.THREE_OF_A_KIND_LOW);
        compare(TestUtility.THREE_OF_A_KIND_LOW, TestUtility.STRAIGHT_LOW);
        compare(TestUtility.STRAIGHT_LOW, TestUtility.FLUSH_LOW);
        compare(TestUtility.FLUSH_LOW, TestUtility.FULL_HOUSE_LOW);
        compare(TestUtility.FULL_HOUSE_LOW, TestUtility.FOUR_OF_A_KIND_LOW);
        compare(TestUtility.FOUR_OF_A_KIND_LOW, TestUtility.STRAIGHT_FLUSH_LOW);
    }

    @Test
    void highCard() {
        compare(TestUtility.HIGH_CARD_LOW, TestUtility.HIGH_CARD_HIGH);
    }

    @Test
    void pair() {
        compare(TestUtility.PAIR_LOW, TestUtility.PAIR_HIGH);
    }

    @Test
    void twoPair() {
        compare(TestUtility.TWO_PAIR_LOW, TestUtility.TWO_PAIR_HIGH);
    }

    @Test
    void threeOfAKind() {
        compare(TestUtility.THREE_OF_A_KIND_LOW, TestUtility.THREE_OF_A_KIND_HIGH);
    }

    @Test
    void straight() {
        compare(TestUtility.STRAIGHT_LOW, TestUtility.STRAIGHT_HIGH);
    }

    @Test
    void flush() {
        compare(TestUtility.FLUSH_LOW, TestUtility.FLUSH_HIGH);
    }

    @Test
    void fullHouse() {
        compare(TestUtility.FULL_HOUSE_LOW, TestUtility.FULL_HOUSE_HIGH);
    }

    @Test
    void fourOfAKind() {
        compare(TestUtility.FOUR_OF_A_KIND_LOW, TestUtility.FOUR_OF_A_KIND_HIGH);
    }

    @Test
    void straightFlush() {
        compare(TestUtility.STRAIGHT_FLUSH_LOW, TestUtility.STRAIGHT_FLUSH_HIGH);
    }

    private void compare(final Collection<Card> lowCards, final Collection<Card> highCards) {
        assertTrue(new PokerHandImpl(lowCards).compareTo(new PokerHandImpl(highCards)) < 0);
    }
}