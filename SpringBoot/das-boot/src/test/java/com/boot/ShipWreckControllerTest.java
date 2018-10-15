package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;



public class ShipWreckControllerTest {
	
	@InjectMocks
	ShipwreckController shipWreckController;
	
	@Mock
	ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipWreckGet() {
		
		//stubbed shipwreck
		Shipwreck wreck = new Shipwreck();
		wreck.setId(1L);
		//if mocked behavior like shipwreckRepository.findOne(1L) invoked return stubbed wreck
		when(shipwreckRepository.findOne(1L)).thenReturn(wreck);
		//invoke method which will invoke mock behavior
		Shipwreck sw = shipWreckController.get(1L);
		//verify if findOne(1L) behaviour was invoked on mock object(Repository) 
		verify(shipwreckRepository).findOne(1L);
		//Final assertion test
		//assertEquals(1L, sw.getId().longValue());
		assertThat(sw.getId().longValue(), is(1L));
	}
	
}
