package ua.logos.model;

import ua.logos.service.Coach;
import ua.logos.service.FortuneService;

public class HockeyCoach implements Coach {

	private FortuneService fortuneService;

	public HockeyCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Тренер по хокею: Забий 100 шайб";
	}

	@Override
	public String getDailyFortune() {
		return "Тренер по хокею: " + fortuneService.getFortune();
	}

}
