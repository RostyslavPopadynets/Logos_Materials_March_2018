package ua.airlines.entity.enums;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SitsClass {

	BUSINESS("BUSINESS", new BigDecimal(1.5)),
	ECONOMY("ECONOMY", new BigDecimal(1));
	
	private String name;
	private BigDecimal coef;
	
}
