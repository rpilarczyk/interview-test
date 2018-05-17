package com.travix.medusa.busyflights.adapters;

import java.util.Collection;
import java.util.Optional;

/**
 * INterface for object conversion
 *
 * @param <S> type of source object
 * @param <R> type of result object
 */
public interface Converter<S, R> {

    /**
     * Converts source object to result object
     *
     * @param source source object
     * @return result object @
     */
    Optional<R> convert(S source);

    /**
     * Converts collection of source objects to list of result objects
     *
     * @param sourceCollection collection of source objects
     * @return list of result objects @
     */
    Collection<R> convertCollection(Collection<S> sourceCollection);

}
