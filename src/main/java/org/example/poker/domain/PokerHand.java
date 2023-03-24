package org.example.poker.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface PokerHand {

    int compareTo(@NotNull PokerHand other);

    @NotNull
    HandRank getRank();

    @NotNull
    Collection<? extends Card> getCards();
}
