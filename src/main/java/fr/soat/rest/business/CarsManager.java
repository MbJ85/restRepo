/**
 * 
 */
package fr.soat.rest.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.soat.rest.domain.Car;

/**
 * @author Formation
 *
 */

@Service
public class CarsManager {

	private List<Car> carsList = new ArrayList<Car>();

	{
		Car car1 = new Car();
		car1.setIdCar(1);
		car1.setNameCar("Mercedes");
		car1.setColorCar("Noir");
		Car car2 = new Car();
		car2.setIdCar(2);
		car2.setNameCar("Opel");
		car2.setColorCar("Rouge");
		Car car3 = new Car();
		car3.setIdCar(3);
		car3.setNameCar("Renault");
		car3.setColorCar("Noir");
		Car car4 = new Car();
		car4.setIdCar(4);
		car4.setNameCar("BMW");
		car4.setColorCar("gris");
		Car car5 = new Car();
		car5.setIdCar(5);
		car5.setNameCar("Peugeot");
		car5.setColorCar("blanc");
		Car car6 = new Car();
		car6.setIdCar(6);
		car6.setNameCar("Citroen");
		car6.setColorCar("gris");
		Car car7 = new Car();
		car7.setIdCar(7);
		car7.setNameCar("Mercedes");
		car7.setColorCar("Blanc");
		Car car8 = new Car();
		car8.setIdCar(8);
		car8.setNameCar("Mercedes");
		car8.setColorCar("gris");

		carsList.add(car1);
		carsList.add(car2);
		carsList.add(car3);
		carsList.add(car4);
		carsList.add(car5);
		carsList.add(car6);
		carsList.add(car7);
		carsList.add(car8);

	}

	public String getHelloWorld() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";

	}

	public List<Car> getCarsList() {
		return carsList;
	}

	public void setCarsList(List<Car> carsList) {
		this.carsList = carsList;
	}

	public Car get_car_by_id(String id) {
		boolean found = false;
		int i = 0;
		Car car = null;
		while ((i < carsList.size()) && (!found)) {
			if (carsList.get(i).getIdCar() == Integer.parseInt(id)) {
				car = carsList.get(i);
				found = true;
			}
			i++;
		}
		return car;

	}

	public List<Car> get_car_by_name(String name) {
		List<Car> cars = new ArrayList<Car>();
		for (Car car : carsList) {
			if (car.getNameCar().equalsIgnoreCase(name)) {
				cars.add(car);
			}
		}
		return cars;
	}

	public Car get_car_by_id_and_by_name(String id, String name) {
		boolean found = false;
		int i = 0;
		Car car = null;
		while ((i < carsList.size()) && (!found)) {
			if ((carsList.get(i).getIdCar() == Integer.parseInt(id))
					&& (carsList.get(i).getNameCar().equalsIgnoreCase(name))) {
				car = carsList.get(i);
				found = true;
			}
			i++;
		}
		return car;

	}

	public List<Car> get_some_cars_by_color(String color) {
		List<Car> cars = new ArrayList<Car>();
		for (Car car : carsList) {
			if (car.getColorCar().equalsIgnoreCase(color)) {
				cars.add(car);
			}
		}
		return cars;
	}

	public List<Car> get_all_cars() {
		return this.getCarsList();
	}

	public boolean add_a_car(Car car) {
		carsList.add(car);
		return true;
	}

	public boolean update_a_car(Car car) {
		Car foundCar = this.get_car_by_id(new Integer(car.getIdCar())
				.toString());
		foundCar.setNameCar(car.getNameCar());
		foundCar.setColorCar(car.getColorCar());
		return true;
	}

	public boolean remove_car_by_id(Car car) {
		carsList.remove(car.getIdCar() - 1);
		return false;
	}

}
