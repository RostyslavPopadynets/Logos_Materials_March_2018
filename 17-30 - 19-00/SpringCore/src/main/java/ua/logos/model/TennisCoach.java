package ua.logos.model;

import ua.logos.service.Coach;
import ua.logos.service.FortuneService;

public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	private String name;

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDailyWorkout() {
		return "Тренер по тенісу: Відпрацьовуй подачі протягом 2 год";
	}

	@Override
	public String getDailyFortune() {
		return name + ", tренер по тенісу, сказав: " + fortuneService.getFortune();
	}

}
