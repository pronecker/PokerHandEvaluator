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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CardImpl card = (CardImpl) o;

        if (suit != card.suit) return false;
        return value == card.value;
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
