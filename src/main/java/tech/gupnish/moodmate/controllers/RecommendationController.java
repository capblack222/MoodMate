package tech.gupnish.moodmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.gupnish.moodmate.errors.MoodNotFoundException;
import tech.gupnish.moodmate.services.RecommendationService;

@RestController
@RequestMapping("/v1/api/recommendations")
public class RecommendationController {

    @Autowired
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @RequestMapping("/all")
    public Object getAllRecommendations() {
        return recommendationService.getRecommendations();
    }

    @GetMapping("")
    public Object getOneRecommendation(@RequestParam("mood") String moodType) throws MoodNotFoundException {
        return recommendationService.getParticularRecommendation(moodType);
    }

    @GetMapping("/{type}")
    public String getOneRecommendationByType(@PathVariable String type, @RequestParam("mood") String mood) 
        throws MoodNotFoundException {
        return recommendationService.getParticularRecommendationForType(mood, type);
    }
}
