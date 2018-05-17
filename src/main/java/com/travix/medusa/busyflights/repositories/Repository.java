package com.travix.medusa.busyflights.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Repository<T, S> {

    Set<S> search(Optional<T> request);
}
