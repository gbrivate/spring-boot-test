package br.com.cinq.greet.test;

import br.com.cinq.greet.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertTrue;

import br.com.cinq.greet.Application;

import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebIntegrationTest(randomPort = true)
public class EndpointTest {
	
	@Value("${local.server.port}")
	private int port;

	private URL base;
	private RestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		restTemplate = new TestRestTemplate();
	}

	// retrieve default message.
	@Test
	public void retrieveMessaOfDay() {
		Message result = restTemplate.getForObject(this.base+"/greeting/retrieveMessage", Message.class, null, null);
		assertTrue(result!=null);
	}


	// retrieve message by id.
	@Test
	public void retrieveMessageOfDayByID() {
		Message result = restTemplate.getForObject(this.base+"/greeting/1", Message.class, null,null);
		assertTrue(result!=null && result.getId()!=null);
	}

	// message not found.
	@Test
	public void messageNotFoundByID() {
		Message result = restTemplate.getForObject(this.base+"/greeting/2", Message.class, null,null);
		assertTrue(result!=null && result.getId()==null);
	}

	// update the message
	@Test
	public void updateMessage() {
		Message found = restTemplate.getForObject(this.base + "/greeting/1", Message.class, null, null);
		// change the message.
		found.setDescription("This is a new message!!");
		Message update = restTemplate.postForObject(this.base + "/greeting/updateMessage", found,Message.class);
		assertTrue(update.getDescription().equals("This is a new message!!"));
	}

}
