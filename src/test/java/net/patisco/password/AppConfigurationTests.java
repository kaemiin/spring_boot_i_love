package net.patisco.password;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class AppConfigurationTests {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	@Ignore
	public void shouldReturn200WhenSendingRequestToController() throws Exception { 
		
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.port + "/password/forget?Language=&App=&EMailAddress=", Map.class);
		
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);		
		
	}
	
}
