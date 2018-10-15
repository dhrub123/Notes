package com.boot;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
public class ShipWreckWebIntegrationTest {
	
	@Test
	public void testGetAll() throws IOException{
		
		RestTemplate template = new TestRestTemplate();
		ResponseEntity<String> response = template.getForEntity("http://localhost:9090/api/v1/shipwrecks", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonResponse = mapper.readTree(response.getBody());
		assertThat(jsonResponse.isMissingNode(), is(false));
		assertThat(jsonResponse.toString(), equalTo("[]"));
	}
	
}
