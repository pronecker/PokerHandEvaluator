package org.example.poker.domain.impl;

import org.example.poker.domain.Card;
import org.example.poker.domain.HandRank;
import org.example.poker.domain.PokerHand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        return compareHighCards(other.getCards());
    }

    @Override
    public @NotNull HandRank getRank() {
        return rank;
    }

    @Override
    public @NotNull Collection<? extends Card> getCards() {
        return Collections.unmodifiableCollection(cards);
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

