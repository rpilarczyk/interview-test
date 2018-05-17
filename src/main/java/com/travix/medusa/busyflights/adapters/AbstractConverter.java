package com.travix.medusa.busyflights.adapters;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Abstract implementation of {@link Converter} interface. It implements
 * collection conversion.
 *
 * @param <S> type of source object
 * @param <R> type of result object
 */
public abstract class AbstractConverter<S, R> implements Converter<S, R> {

    @Override
    public Optional<R> convert(final S source) {
        Optional<R> result;

        if (source != null) {
            result = Optional.of(convertNotNull(source));
        } else {
            result = convertNull();
        }

        return result;
    }

    @Override
    public Collection<R> convertCollection(final Collection<S> sourceCollection) {

        final ImmutableCollection.Builder<R> builder;

        if (sourceCollection instanceof List) {
            builder = ImmutableList.builder();
        } else if (sourceCollection instanceof Set) {
            builder = ImmutableSet.builder();
        } else {
            throw new RuntimeException("Converter for type of collection " + sourceCollection.getClass() + " not found");
        }

        if (sourceCollection != null) {
            for (final S source : sourceCollection) {
                final Optional<R> resultObject = convert(source);
                if (resultObject.isPresent()) {
                    builder.add(resultObject.get());
                }
            }
        }

        return builder.build();
    }

    /**
     * Should be implemented by concrete classes to convert source object that
     * is not null
     *
     * @param source source object
     * @return result object @
     */
    protected abstract R convertNotNull(S source);

    /**
     * Called when source object is null
     *
     * @return
     */
    protected Optional<R> convertNull() {
        return Optional.empty();
    }
}
