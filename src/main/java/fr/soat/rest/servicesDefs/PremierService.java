/**
 * 
 */
package fr.soat.rest.servicesDefs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
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
	@Produces(MediaType.APPLICATION_XML)
	public Response getHelloWorld_Response() {
		Car car = new Car();
		car.setIdCar(1);
		car.setNameCar("nameCar");
		return Response.status(200).entity(Entity.xml(car)).header("custom", "custom")
				.build();
	}

	
	@Path("/xml")
	@GET
	@Produces(MediaType.TEXT_HTML)
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
	
	
	@GET()
	@Path("cars/{myparam}")
	@Produces({MediaType.APPLICATION_JSON})
	public Car get_car_by_id(@PathParam("myparam") String id) {
		return carsManager.get_car_by_id(id);
	}


	public List<Car> get_car_by_name(String name) {
		return carsManager.get_car_by_name(name);
	}

	public Car get_car_by_id_and_by_name(String id, String name) {
		return carsManager.get_car_by_id_and_by_name(id, name);
	}

	public List<Car> get_some_cars_by_color(String color) {
		return carsManager.get_some_cars_by_color(color);
	}

	
	
	@GET
	@Path("allCars")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> get_all_cars() {
		return carsManager.get_all_cars();
	}

	
	@POST
	@Path("/createNewCarByForm")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void add_a_car_by_json_via_form(@FormParam("idCar") String idCar, @FormParam("nameCar") String nameCar, @FormParam("colorCar") String colorCar) {
		Car car = new Car();
		car.setIdCar(Integer.parseInt(idCar));
		car.setNameCar(nameCar);
		car.setColorCar(colorCar);
		carsManager.add_a_car(car);
		//return Response.status(200).build();
	}
	
	@PUT
	@Path("/createNewCar")
	@Consumes(MediaType.APPLICATION_XML)
	public Response add_a_car_by_xml(Car car) {
		carsManager.add_a_car(car);
		return Response.status(200)
				.entity("Car added is called, name : " + car.getNameCar())
				.build();
	
	}
	
	
	@PUT
	@Path("/createNewCarJson")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add_a_car_by_json(Car car) {
		carsManager.add_a_car(car);
		return Response.status(200)
				.entity("Car added is called, name : " + car.getNameCar())
				.build();
	}

	@POST
	@Path("/updateCarJson")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update_a_car_by_json(Car car) {
		carsManager.update_a_car(car);
		return Response.status(200)
				.entity("Car updated is called : " + car.getNameCar() + " and its id is :"+ car.getIdCar())
				.build();
	}

	@POST
	@Path("/updateCarXml")
	@Consumes(MediaType.APPLICATION_XML)
	public Response update_a_car_by_xml(Car car) {
		carsManager.update_a_car(car);
		return Response.status(200)
				.entity("Car updated is called : " + car.getNameCar() + " and its id is :"+ car.getIdCar())
				.build();
	
	}

	public boolean remove_car_by_id(Car car) {
		return false;
	}

	public boolean remove_some_cars(Car car) {
		return false;
	}

}
