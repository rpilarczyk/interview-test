package com.travix.medusa.busyflights.adapters.dispatcher;

import com.travix.medusa.busyflights.adapters.BusyAdapter;
import com.travix.medusa.busyflights.adapters.CrazyAdapter;
import com.travix.medusa.busyflights.adapters.ToughtAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdapterFactory extends AbstractAdapterFactory {

    @Override
    public Optional<Adapter> getAdapter(Lines type) {

        if (type == null) {
            return Optional.empty();
        }

        if (Lines.BUSY.equals(type)) {
            return Optional.of(new BusyAdapter());

        } else if (Lines.CRAZY.equals(type)) {
            return Optional.of(new CrazyAdapter());

        } else if (Lines.TOUGHT.equals(type)) {
            return Optional.of(new ToughtAdapter());
        }

        return Optional.empty();
    }


}
