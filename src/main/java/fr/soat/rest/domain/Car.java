package fr.soat.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car {

	private int idCar;
	private String nameCar;
	private String colorCar;

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

	public String getColorCar() {
		return colorCar;
	}

	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}

	@Override
	public String toString() {
		return "Hi every Body I am a car ; my id is :" + idCar
				+ " , my nmae is :" + nameCar + " and my color is :" + colorCar;
	}
}