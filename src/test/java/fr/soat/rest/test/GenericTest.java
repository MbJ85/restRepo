package fr.soat.rest.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-test.xml" })
public class GenericTest {

	private ClientConfig clientConfig;
	private Client client;
	protected WebTarget webTarget;

	@Before
	public void before() throws Exception {

		clientConfig = new ClientConfig();
		client = ClientBuilder.newClient(clientConfig).register(JacksonFeature.class);
		webTarget = client.target("http://localhost:8080/jerseyExample/rest");
	}


}
