package fr.soat.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Car {

	private int idCar;
	private String nameCar;

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getNameCar() {
		return nameCar;
	}

	public void setNameCar(String nameCar) {
		this.nameCar = nameCar;
	}

}
