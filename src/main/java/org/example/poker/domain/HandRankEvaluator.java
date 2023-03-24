package org.example.poker.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface HandRankEvaluator {

    @NotNull
    HandRank evaluate(@NotNull Collection<? extends Card> cards);
}
