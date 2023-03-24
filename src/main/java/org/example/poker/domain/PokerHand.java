package org.example.poker.domain;

import org.jetbrains.annotations.NotNull;

public interface PokerHand {

    int compareTo(@NotNull PokerHand other);

    @NotNull
    HandRank getRank();
}
