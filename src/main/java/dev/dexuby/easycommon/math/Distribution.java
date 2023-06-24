package dev.dexuby.easycommon.math;

import dev.dexuby.easycommon.tuple.KeyValuePair;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Distribution<T> {

    private final Random random;
    private final Map<T, Double> weights = new LinkedHashMap<>();

    private boolean eliminate = false;

    public Distribution(@NotNull final Map<T, Double> weights) {

        this.random = new Random();
        this.weights.putAll(weights);

    }

    public Distribution(@NotNull final Random random, @NotNull final Map<T, Double> weights) {

        this.random = random;
        this.weights.putAll(weights);

    }

    @SafeVarargs
    public Distribution(@NotNull final KeyValuePair<T, Double>... entries) {

        this.random = new Random();
        for (final KeyValuePair<T, Double> entry : entries)
            this.weights.put(entry.getKey(), entry.getValue());

    }

    @SafeVarargs
    public Distribution(@NotNull final Random random, @NotNull final KeyValuePair<T, Double>... entries) {

        this.random = random;
        for (final KeyValuePair<T, Double> entry : entries)
            this.weights.put(entry.getKey(), entry.getValue());

    }

    public T next() {

        T result = null;
        double bestValue = Double.MAX_VALUE;

        for (final T key : this.weights.keySet()) {
            final double value = -Math.log(this.random.nextDouble()) / this.weights.get(key);
            if (value < bestValue) {
                bestValue = value;
                result = key;
            }
        }

        if (this.eliminate) this.weights.remove(result);
        return result;

    }

    public void clear() {

        this.weights.clear();

    }

    public void setEliminate(final boolean eliminate) {

        this.eliminate = eliminate;

    }

}
