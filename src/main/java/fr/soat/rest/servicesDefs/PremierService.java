/**
 * 
 */
package fr.soat.rest.servicesDefs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.soat.rest.business.CarsManager;
import fr.soat.rest.domain.Car;

/**
 * @author Formation
 *
 */

@Path("/monPremierService")
@Component
@Scope("request")
public class PremierService {

	@Autowired
	private CarsManager carsManager;

	@Path("/html")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHelloWorld_Html() {
		return carsManager.getHelloWorld();
	}

	@Path("/txt")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHelloWorld_Plain_Txt() {
		return carsManager.getHelloWorld();
	}

	@Path("/response")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHelloWorld_Response() {
		Car car = new Car();
		car.setIdCar(1);
		car.setNameCar("nameCar");
		return Response.status(200).entity(car).header("custom", "custom")
				.build();
	}

	
	@Path("/xml")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Car getHelloWorld_xml() {
		Car car = new Car();
		car.setIdCar(1);
		car.setNameCar("nameCar");
		return car;
	}

	@Path("/json")
	@GET
	@Produces(MediaType.TEXT_XML)
	public Car getHelloWorld_json() {
		Car car = new Car();
		car.setIdCar(1);
		car.setNameCar("nameCar");
		return car;
	}
	
	public Car get_car_by_id(String id) {
		return null;
	}

	public Car get_car_by_name(String name) {
		return null;
	}

	public Car get_car_by_id_and_by_name(String id, String name) {
		return null;
	}

	public List<Car> get_some_cars_by_color(String color) {
		return null;
	}

	public List<Car> get_all_cars() {
		return null;
	}

	public boolean add_a_car_by_json(Car car) {
		return false;
	}

	public boolean add_a_car_by_xml(Car car) {
		return false;
	}

	public boolean update_a_car_by_json(Car car) {
		return false;
	}

	public boolean update_a_car_by_xml(Car car) {
		return false;
	}

	public boolean remove_car_by_id(Car car) {
		return false;
	}

	public boolean remove_some_cars(Car car) {
		return false;
	}

}
