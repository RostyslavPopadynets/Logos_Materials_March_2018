package ua.logos.service.impl;

import ua.logos.service.FortuneService;

public class SadnessFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Сьогодні твій не щасливий день";
	}

}
