package fr.soat.rest.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;

import fr.soat.rest.servicesDefs.PremierService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-test.xml" })
public class GenericTest {

	private JerseyTest jersey;

	@Autowired
	PremierService someService;

	@Before
	public void before() throws Exception {
		jersey = new JerseyTest(new InMemoryTestContainerFactory()) {
			protected com.sun.jersey.test.framework.AppDescriptor configure() {
				DefaultResourceConfig rc = new DefaultResourceConfig();
				rc.getSingletons().add(someService);
				rc.getClasses().add(
						org.codehaus.jackson.jaxrs.JacksonJsonProvider.class);
				return new LowLevelAppDescriptor.Builder(rc).contextPath(
						"poc-jersey").build();
			};
		};
		jersey.setUp();
	}

	@Test
	public void testGet1() {
		String result = jersey.resource().path("/someResource/1")
				.get(String.class);
		assertEquals("{\"someBean\":[{\"someAttribute\":\"someValue\"}]}",
				result);
	}

	@After
	public void after() throws Exception {
		jersey.tearDown();
	}
}
