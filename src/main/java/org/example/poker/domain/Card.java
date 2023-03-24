package org.example.poker.domain;

import org.jetbrains.annotations.NotNull;

public interface Card {

    @NotNull CardSuit getSuit();

    @NotNull CardValue getValue();
}
