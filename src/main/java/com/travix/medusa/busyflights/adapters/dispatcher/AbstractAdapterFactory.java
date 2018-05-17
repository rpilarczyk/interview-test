package com.travix.medusa.busyflights.adapters.dispatcher;

import java.util.Optional;

public abstract class AbstractAdapterFactory {

    public abstract Optional<Adapter> getAdapter(Lines type);

}
