package com.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class ShipwreckRepositoryIntegrationTest {

	@Autowired
	ShipwreckRepository repository;

	@Test
	public void testFindAll() {
		List<Shipwreck> wrecks = repository.findAll();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}
	
}
