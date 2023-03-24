package org.example.poker.domain.impl;

import org.example.poker.domain.Card;
import org.example.poker.domain.HandRank;
import org.example.poker.domain.HandRankEvaluator;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public final class HandRankEvaluatorImpl implements HandRankEvaluator {

    private static final HandRankEvaluator INSTANCE = new HandRankEvaluatorImpl();

    public static HandRankEvaluator getInstance() {
        return INSTANCE;
    }

    private HandRankEvaluatorImpl() {
    }

    @Override
    public @NotNull HandRank evaluate(@NotNull Collection<? extends Card> cards) {

        throw new IllegalStateException("not implemented!");
    }
}
