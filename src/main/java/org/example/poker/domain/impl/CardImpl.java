package org.example.poker.domain.impl;

import org.example.poker.domain.Card;
import org.example.poker.domain.CardSuit;
import org.example.poker.domain.CardValue;
import org.jetbrains.annotations.NotNull;

public final class CardImpl implements Card {

    private final CardSuit suit;
    private final CardValue value;

    public CardImpl(@NotNull final CardSuit suit,
                    @NotNull final CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public @NotNull CardSuit getSuit() {
        return suit;
    }

    @Override
    public @NotNull CardValue getValue() {
        return value;
    }
}
