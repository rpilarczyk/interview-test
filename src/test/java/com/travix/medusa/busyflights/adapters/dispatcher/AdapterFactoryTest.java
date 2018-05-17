package com.travix.medusa.busyflights.adapters.dispatcher;

import com.travix.medusa.busyflights.adapters.CrazyAdapter;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Optional;

import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertThat;


public class AdapterFactoryTest extends TestCase {

    @InjectMocks
    AdapterFactory adapterFactory;

    @Test
    public void getAdapter() {

        Optional<Adapter> result = adapterFactory.getAdapter(Lines.CRAZY);

        assertThat(result.get(), isA(CrazyAdapter.class));

    }
}