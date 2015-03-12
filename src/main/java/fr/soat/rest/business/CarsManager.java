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

}
