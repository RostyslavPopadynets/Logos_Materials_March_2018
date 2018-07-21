package ua.airlines.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlaneType {

	BOEING_737_200("BOEING 737", 200), 
	BOEING_777_180("BOEING 777", 180), 
	AIRBUS_A220_190("AIRBUS A220", 190);

	private String name;
	private int seetsNumber;

}
