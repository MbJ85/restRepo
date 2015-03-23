package fr.soat.rest.test;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.soat.rest.domain.Car;

public class CarsManagerTest extends GenericTest {

	private WebTarget carManagerWebTarget;

	@Before
	public void setUp() {
		carManagerWebTarget = webTarget.path("monPremierService");
	}

	@Test
	public void get_hello_world_html() {
		WebTarget htmlResourceWebTarget = carManagerWebTarget.path("html");
		String response = htmlResourceWebTarget.request(MediaType.TEXT_HTML)
				.get(String.class);
		String expected = "<html> <title>Hello Jersey</title><body><h1>Hello Jersey</body></h1></html> ";
		System.out.println("La réponse Html est :::::: " + response.length());
		System.out.println("La réponse Html est :::::: " + expected.length());
		System.out.println(expected.equalsIgnoreCase(response));
		Assert.assertEquals(expected.length(), response.length());
	}

	@Test
	public void get_hello_WOrld_plain_Text() {
		WebTarget textWebTarget = carManagerWebTarget.path("txt");
		String response = textWebTarget.request(MediaType.TEXT_PLAIN).get(
				String.class);
		String expected = "<html> <title>Hello Jersey</title><body><h1>Hello Jersey</body></h1></html> ";
		Assert.assertEquals(response.length(), expected.length());
	}

	@Test
	public void get_hello_world_response() {
		WebTarget responseWebTarget = carManagerWebTarget.path("response");
		Response carResponse = responseWebTarget
				.request(MediaType.APPLICATION_JSON).get();
		System.out.println(carResponse);
		Car myCar = carResponse.readEntity(Car.class);
		Assert.assertEquals(carResponse.getStatus(), 200);
		Assert.assertEquals(myCar.getIdCar(), 1);
		Assert.assertEquals("nameCar", myCar.getNameCar());

	}

	@Test
	public void get_hello_World_Xml() {
		WebTarget xmlWebTarget = carManagerWebTarget.path("xml");
		String responseString = xmlWebTarget.request(MediaType.APPLICATION_XML)
				.get(String.class);
		Car responseCar = xmlWebTarget.request(MediaType.APPLICATION_XML).get(
				Car.class);
		String expectedString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><car><idCar>1</idCar><nameCar>nameCar</nameCar></car>";
		System.out.println(responseString);
		System.out.println(responseCar.toString());
		Assert.assertEquals(expectedString, responseString);
		Assert.assertEquals(responseCar.getIdCar(), 1);
		Assert.assertEquals("nameCar", responseCar.getNameCar());
	}

	@Test
	public void get_car_by_id() {
		WebTarget carsWebTarget = carManagerWebTarget.path("cars").path("6");
		System.out.println(carsWebTarget.getUri().toString());
		Car carResponse = carsWebTarget.request(MediaType.APPLICATION_JSON)
				.get(Car.class);
		System.out.println(carResponse.toString());
	}

	// @Test
	// public void get_car_by_id2() {
	// WebTarget carsWebTarget = carManagerWebTarget.path("7");
	// System.out.println(carsWebTarget.getUri().toString());
	// Car carResponse = carsWebTarget.request(MediaType.APPLICATION_JSON)
	// .get(Car.class);
	// System.out.println(carResponse.toString());
	//
	// }

	@Test
	public void get_all_cars() {
		WebTarget allCarsWebTarget = carManagerWebTarget.path("allCars");
		List<Car> cars = allCarsWebTarget.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Car>>() {
				});
		System.out.println(cars.size());
		for (Car car : cars) {
			System.out.println(car.toString());
		}
		Assert.assertEquals(8, cars.size());
	}

	@Test
	public void add_a_car_by_xml() {
		Car myNewCar = new Car();
		myNewCar.setIdCar(999);
		myNewCar.setNameCar("404 BACHE");
		myNewCar.setColorCar("baydha");
		WebTarget createNewCarWebTarget = carManagerWebTarget
				.path("createNewCar");
		Response response = createNewCarWebTarget.request().put(
				Entity.entity(myNewCar, MediaType.APPLICATION_XML));
		System.out.println(response);
		Assert.assertEquals(200, response.getStatus());
	}

	@Test
	public void add_a_car_by_json() {
		Car myNewCar = new Car();
		myNewCar.setIdCar(33333333);
		myNewCar.setNameCar("404 BACHE");
		myNewCar.setColorCar("baydha222");
		WebTarget createNewCarWebTarget = carManagerWebTarget
				.path("createNewCarJson");
		Response response = createNewCarWebTarget.request().put(
				Entity.entity(myNewCar, MediaType.APPLICATION_JSON));
		System.out.println(response);
	}
}