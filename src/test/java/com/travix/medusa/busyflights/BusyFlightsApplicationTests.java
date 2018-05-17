package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.adapters.dispatcher.AdapterFactoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
@Suite.SuiteClasses({AdapterFactoryTest.class})
@SpringBootTest
public class BusyFlightsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
