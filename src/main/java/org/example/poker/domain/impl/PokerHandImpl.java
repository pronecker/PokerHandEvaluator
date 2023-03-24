package org.example.poker.domain.impl;

import org.example.poker.domain.Card;
import org.example.poker.domain.HandRank;
import org.example.poker.domain.PokerHand;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public final class PokerHandImpl implements PokerHand {

    private final Collection<? extends Card> cards;
    private final HandRank rank;

    public PokerHandImpl(@NotNull final Collection<? extends Card> cards) {
        this.cards = cards;
        rank = HandRankEvaluatorImpl.getInstance().evaluate(cards);
    }

    @Override
    public int compareTo(@NotNull PokerHand other) {
        throw new IllegalStateException("not implemented!");
    }

    @Override
    public @NotNull HandRank getRank() {
        return rank;
    }

}

