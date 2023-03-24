package org.example.poker.domain.impl;

import org.example.poker.domain.HandRank;
import org.example.poker.domain.HandRankEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandRankEvaluatorImplTest {

    private HandRankEvaluator testSubject;

    @BeforeEach
    void setUp() {
        testSubject = HandRankEvaluatorImpl.getInstance();
    }

    @Test
    void highCard() {
        assertEquals(HandRank.HIGH_CARD, testSubject.evaluate(TestUtility.HIGH_CARD_LOW));
        assertEquals(HandRank.HIGH_CARD, testSubject.evaluate(TestUtility.HIGH_CARD_HIGH));
    }

    @Test
    void pair() {
        assertEquals(HandRank.PAIR, testSubject.evaluate(TestUtility.PAIR_LOW));
        assertEquals(HandRank.PAIR, testSubject.evaluate(TestUtility.PAIR_HIGH));
    }

    @Test
    void twoPair() {
        assertEquals(HandRank.TWO_PAIRS, testSubject.evaluate(TestUtility.TWO_PAIR_LOW));
        assertEquals(HandRank.TWO_PAIRS, testSubject.evaluate(TestUtility.TWO_PAIR_HIGH));
    }

    @Test
    void threeOfAKind() {
        assertEquals(HandRank.THREE_OF_A_KIND, testSubject.evaluate(TestUtility.THREE_OF_A_KIND_LOW));
        assertEquals(HandRank.THREE_OF_A_KIND, testSubject.evaluate(TestUtility.THREE_OF_A_KIND_HIGH));
    }

    @Test
    void straight() {
        assertEquals(HandRank.STRAIGHT, testSubject.evaluate(TestUtility.STRAIGHT_HIGH));
        assertEquals(HandRank.STRAIGHT, testSubject.evaluate(TestUtility.STRAIGHT_LOW));
    }

    @Test
    void flush() {
        assertEquals(HandRank.FLUSH, testSubject.evaluate(TestUtility.FLUSH_LOW));
        assertEquals(HandRank.FLUSH, testSubject.evaluate(TestUtility.FLUSH_HIGH));
    }

    @Test
    void fullHouse() {
        assertEquals(HandRank.FULL_HOUSE, testSubject.evaluate(TestUtility.FULL_HOUSE_HIGH));
        assertEquals(HandRank.FULL_HOUSE, testSubject.evaluate(TestUtility.FULL_HOUSE_LOW));
    }

    @Test
    void fourOfAKind() {
        assertEquals(HandRank.FOUR_OF_A_KIND, testSubject.evaluate(TestUtility.FOUR_OF_A_KIND_HIGH));
        assertEquals(HandRank.FOUR_OF_A_KIND, testSubject.evaluate(TestUtility.FOUR_OF_A_KIND_LOW));
    }

    @Test
    void straightFlush() {
        assertEquals(HandRank.STRAIGHT_FLUSH, testSubject.evaluate(TestUtility.STRAIGHT_FLUSH_LOW));
        assertEquals(HandRank.STRAIGHT_FLUSH, testSubject.evaluate(TestUtility.STRAIGHT_FLUSH_HIGH));
    }
}