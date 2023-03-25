package org.example.poker.domain.impl;

import org.example.poker.domain.Card;
import org.example.poker.domain.CardValue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

final class ValueCounter {

    private ValueCounter() {
    }

    static Map<CardValue, Integer> count(final Collection<? extends Card> cards) {
        final Map<CardValue, Integer> valueCounts = new HashMap<>();
        for (final Card card : cards) {
            valueCounts.put(card.getValue(),
                            valueCounts.getOrDefault(card.getValue(), 0) + 1);
        }
        return valueCounts;
    }
}
