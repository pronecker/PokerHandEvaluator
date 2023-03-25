package org.example.poker.domain.impl;

import org.example.poker.domain.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public final class HandRankEvaluatorImpl implements HandRankEvaluator {

    private static final HandRankEvaluator INSTANCE = new HandRankEvaluatorImpl();

    public static HandRankEvaluator getInstance() {
        return INSTANCE;
    }

    private HandRankEvaluatorImpl() {
    }

    @Override
    public @NotNull HandRank evaluate(@NotNull final Collection<? extends Card> cards) {
        final List<? extends Card> orderedCards = cards.stream()
                                                       .sorted(Comparator.comparing(Card::getValue).reversed())
                                                       .toList();

        final boolean isFlush = isFlush(cards);
        final boolean isStraight = isStraight(orderedCards);
        final Map<CardValue, Integer> valueCounts = ValueCounter.count(cards);

        if (isFlush && isStraight) {
            return HandRank.STRAIGHT_FLUSH;
        }

        if (hasCount(valueCounts, 4)) {
            return HandRank.FOUR_OF_A_KIND;
        }

        if (hasCount(valueCounts, 3) && hasCount(valueCounts, 2)) {
            return HandRank.FULL_HOUSE;
        }

        if (isFlush) {
            return HandRank.FLUSH;
        }

        if (isStraight) {
            return HandRank.STRAIGHT;
        }

        if (hasCount(valueCounts, 3)) {
            return HandRank.THREE_OF_A_KIND;
        }

        if (countPairs(valueCounts) == 2) {
            return HandRank.TWO_PAIRS;
        }

        if (countPairs(valueCounts) == 1) {
            return HandRank.PAIR;
        }

        return HandRank.HIGH_CARD;
    }

    private boolean hasCount(final Map<CardValue, Integer> valueCounts, final int count) {
        return valueCounts.values().stream().anyMatch(c -> c == count);
    }

    private int countPairs(final Map<CardValue, Integer> valueCounts) {
        int pairs = 0;
        for (final int count : valueCounts.values()) {
            if (count == 2) {
                pairs++;
            }
        }
        return pairs;
    }

    private boolean isFlush(final Collection<? extends Card> cards) {
        final CardSuit suit = cards.iterator().next().getSuit();
        return cards.stream().allMatch(c -> c.getSuit() == suit);
    }

    private boolean isStraight(final List<? extends Card> orderedCards) {
        CardValue previousValue = orderedCards.iterator().next().getValue();
        for (int i = 1; i < orderedCards.size(); i++) {
            final CardValue currentValue = orderedCards.get(i).getValue();
            if (previousValue.ordinal() - currentValue.ordinal() != 1) {
                return false;
            }
            previousValue = currentValue;
        }
        return true;
    }

}
