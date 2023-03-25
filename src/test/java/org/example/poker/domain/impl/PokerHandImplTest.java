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
    void splitPotSameHands() {
        same(TestUtility.HIGH_CARD_LOW, TestUtility.HIGH_CARD_LOW);
        same(TestUtility.PAIR_LOW, TestUtility.PAIR_LOW);
        same(TestUtility.TWO_PAIR_LOW, TestUtility.TWO_PAIR_LOW);
        same(TestUtility.THREE_OF_A_KIND_LOW, TestUtility.THREE_OF_A_KIND_LOW);
        same(TestUtility.STRAIGHT_LOW, TestUtility.STRAIGHT_LOW);
        same(TestUtility.FLUSH_LOW, TestUtility.FLUSH_LOW);
        same(TestUtility.FULL_HOUSE_LOW, TestUtility.FULL_HOUSE_LOW);
        same(TestUtility.FOUR_OF_A_KIND_LOW, TestUtility.FOUR_OF_A_KIND_LOW);
        same(TestUtility.STRAIGHT_FLUSH_LOW, TestUtility.STRAIGHT_FLUSH_LOW);
    }

    @Test
    void splitPotDifferentSuits() {
        same(TestUtility.HIGH_CARD_LOW, TestUtility.HIGH_CARD_LOW_DIFFERENT_SUITS);
        same(TestUtility.PAIR_LOW, TestUtility.PAIR_LOW_DIFFERENT_SUITS);
        same(TestUtility.TWO_PAIR_LOW, TestUtility.TWO_PAIR_LOW_DIFFERENT_SUITS);
        same(TestUtility.THREE_OF_A_KIND_LOW, TestUtility.THREE_OF_A_KIND_LOW_DIFFERENT_SUITS);
        same(TestUtility.STRAIGHT_LOW, TestUtility.STRAIGHT_LOW_DIFFERENT_SUITS);
        same(TestUtility.FULL_HOUSE_LOW, TestUtility.FULL_HOUSE_LOW_DIFFERENT_SUITS);
        same(TestUtility.FOUR_OF_A_KIND_LOW, TestUtility.FOUR_OF_A_KIND_LOW_DIFFERENT_SUITS);
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
    void samePair() {
        compare(TestUtility.SAME_PAIR_LOW, TestUtility.SAME_PAIR_HIGH);
    }

    @Test
    void twoPair() {
        compare(TestUtility.TWO_PAIR_LOW, TestUtility.TWO_PAIR_HIGH);
    }

    @Test
    void sameTwoPair() {
        compare(TestUtility.SAME_TWO_PAIR_LOW, TestUtility.SAME_TWO_PAIR_HIGH);
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

    private void same(final Collection<Card> cards1, final Collection<Card> cards2) {
        assertTrue(new PokerHandImpl(cards1).compareTo(new PokerHandImpl(cards2)) == 0);
    }
}