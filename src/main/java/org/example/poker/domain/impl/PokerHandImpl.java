package org.example.poker.domain.impl;

import org.example.poker.domain.Card;
import org.example.poker.domain.CardValue;
import org.example.poker.domain.HandRank;
import org.example.poker.domain.PokerHand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

import java.util.*;

public final class PokerHandImpl implements PokerHand {

    private final Collection<? extends Card> cards;
    private final HandRank rank;

    public PokerHandImpl(@NotNull final Collection<? extends Card> cards) {
        this(cards, HandRankEvaluatorImpl.getInstance().evaluate(cards));
    }

    @TestOnly
    PokerHandImpl(final Collection<? extends Card> cards,
                  final HandRank rank) {
        this.cards = cards;
        this.rank = rank;
    }

    @Override
    public int compareTo(@NotNull final PokerHand other) {
        if (!rank.equals(other.getRank())) {
            return rank.compareTo(other.getRank());
        }

        if (rank.equals(HandRank.HIGH_CARD)
            || rank.equals(HandRank.FLUSH)
            || rank.equals(HandRank.STRAIGHT)
            || rank.equals(HandRank.STRAIGHT_FLUSH)) {
            return compareHighCards(other.getCards());
        }

        if (rank.equals(HandRank.PAIR)) {
            return comparePair(other.getCards());
        }

        if (rank.equals(HandRank.TWO_PAIRS)) {
            return compareTwoPairs(other.getCards());
        }

        if (rank.equals(HandRank.THREE_OF_A_KIND)
            || rank.equals(HandRank.FULL_HOUSE)) {
            return compareThreeOfAKind(other.getCards());
        }

        if (rank.equals(HandRank.FOUR_OF_A_KIND)) {
            return compareFourOfAKind(other.getCards());
        }

        throw new IllegalStateException("rank comparison not implemented for " + rank);
    }

    @Override
    public @NotNull HandRank getRank() {
        return rank;
    }

    @Override
    public @NotNull Collection<? extends Card> getCards() {
        return Collections.unmodifiableCollection(cards);
    }

    private int comparePair(final Collection<? extends Card> otherCards) {
        final CardValue myPairValue = getValueForCount(cards, 2);
        final CardValue otherPairValue = getValueForCount(otherCards, 2);
        final int compare = myPairValue.compareTo(otherPairValue);
        if (compare != 0) {
            return compare;
        }
        return compareHighCards(otherCards);
    }

    private int compareTwoPairs(final Collection<? extends Card> otherCards) {
        final List<CardValue> myPairValues = getTwoPairs(cards);
        final List<CardValue> otherPairValues = getTwoPairs(otherCards);

        for (int i = 0; i < myPairValues.size(); i++) {
            final int compare = myPairValues.get(i).compareTo(otherPairValues.get(i));
            if (compare != 0) {
                return compare;
            }
        }

        return compareHighCards(otherCards);
    }

    private List<CardValue> getTwoPairs(final Collection<? extends Card> cards) {
        final Map<CardValue, Integer> valueCounts = new HashMap<>();
        for (final Card card : cards) {
            valueCounts.put(card.getValue(),
                            valueCounts.getOrDefault(card.getValue(), 0) + 1);
        }

        final List<CardValue> pairs = new ArrayList<>();
        for (final Map.Entry<CardValue, Integer> entry : valueCounts.entrySet()) {
            if (entry.getValue() == 2) {
                pairs.add(entry.getKey());
            }
        }

        if (pairs.size() != 2) {
            throw new IllegalStateException("no two pairs found in " + cards);
        }

        return pairs.stream()
                    .sorted(Comparator.reverseOrder())
                    .toList();
    }

    private int compareThreeOfAKind(final Collection<? extends Card> otherCards) {
        final CardValue myValue = getValueForCount(cards, 3);
        final CardValue otherValue = getValueForCount(otherCards, 3);
        return myValue.compareTo(otherValue);
    }

    private int compareFourOfAKind(final Collection<? extends Card> otherCards) {
        final CardValue myValue = getValueForCount(cards, 4);
        final CardValue otherValue = getValueForCount(otherCards, 4);
        return myValue.compareTo(otherValue);
    }

    private CardValue getValueForCount(final Collection<? extends Card> cards, final int count) {
        final Map<CardValue, Integer> valueCounts = new HashMap<>();
        for (final Card card : cards) {
            valueCounts.put(card.getValue(),
                            valueCounts.getOrDefault(card.getValue(), 0) + 1);
        }

        for (final Map.Entry<CardValue, Integer> entry : valueCounts.entrySet()) {
            if (entry.getValue() == count) {
                return entry.getKey();
            }
        }

        throw new IllegalStateException("no four of a kind found in " + cards);
    }

    private int compareHighCards(final Collection<? extends Card> otherCards) {
        final List<? extends Card> myCardsSorted = cards.stream()
                                                        .sorted(Comparator.comparing(Card::getValue).reversed())
                                                        .toList();
        final List<? extends Card> otherCardsSorted = otherCards.stream()
                                                                .sorted(Comparator.comparing(Card::getValue).reversed())
                                                                .toList();

        for (int i = 0; i < myCardsSorted.size(); i++) {
            final Card myCurrentCard = myCardsSorted.get(i);
            final Card otherCurrentCard = otherCardsSorted.get(i);
            if (!myCurrentCard.getValue().equals(otherCurrentCard.getValue())) {
                return myCurrentCard.getValue().compareTo(otherCurrentCard.getValue());
            }
        }

        return 0;
    }
}

