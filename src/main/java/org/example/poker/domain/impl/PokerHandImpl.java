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


        return switch (rank) {
            case HIGH_CARD, FLUSH, STRAIGHT, STRAIGHT_FLUSH -> compareHighCards(other.getCards());
            case PAIR, TWO_PAIRS -> comparePairs(other.getCards());
            case THREE_OF_A_KIND, FULL_HOUSE -> compareByCount(other.getCards(), 3);
            case FOUR_OF_A_KIND -> compareByCount(other.getCards(), 4);
        };
    }

    @Override
    public @NotNull HandRank getRank() {
        return rank;
    }

    @Override
    public @NotNull Collection<? extends Card> getCards() {
        return Collections.unmodifiableCollection(cards);
    }

    private int comparePairs(final Collection<? extends Card> otherCards) {
        final List<CardValue> myPairValues = getPairValues(cards);
        final List<CardValue> otherPairValues = getPairValues(otherCards);

        for (int i = 0; i < myPairValues.size(); i++) {
            final int compare = myPairValues.get(i).compareTo(otherPairValues.get(i));
            if (compare != 0) {
                return compare;
            }
        }

        return compareHighCards(otherCards);
    }

    private List<CardValue> getPairValues(final Collection<? extends Card> cards) {
        final Map<CardValue, Integer> valueCounts = ValueCounter.count(cards);

        final List<CardValue> pairs = new ArrayList<>();
        for (final Map.Entry<CardValue, Integer> entry : valueCounts.entrySet()) {
            if (entry.getValue() == 2) {
                pairs.add(entry.getKey());
            }
        }

        return pairs.stream()
                    .sorted(Comparator.reverseOrder())
                    .toList();
    }

    private int compareByCount(final Collection<? extends Card> otherCards, final int count) {
        final CardValue myValue = getValueForCount(cards, count);
        final CardValue otherValue = getValueForCount(otherCards, count);
        return myValue.compareTo(otherValue);
    }

    private CardValue getValueForCount(final Collection<? extends Card> cards, final int count) {
        final Map<CardValue, Integer> valueCounts = ValueCounter.count(cards);

        for (final Map.Entry<CardValue, Integer> entry : valueCounts.entrySet()) {
            if (entry.getValue() == count) {
                return entry.getKey();
            }
        }

        throw new IllegalStateException("no " + count + " of a kind found in " + cards);
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

