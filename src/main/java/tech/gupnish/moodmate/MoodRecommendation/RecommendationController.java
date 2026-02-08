package tech.gupnish.moodmate.moodRecommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.gupnish.moodmate.errors.MoodNotFoundException;

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

    @GetMapping("/recommend")
    public Object getOneRecommendation(@RequestParam("mood") String moodType) throws MoodNotFoundException {
        // if(moodType == null || moodType.isEmpty()) {
        //     throw new IllegalArgumentException("<h1>Mood type cannot be null or empty</h1>");
        // } else if (recommendationService.getParticularRecommendation(moodType) == null) {
        //     throw new IllegalArgumentException("<h1>No recommendations found for the specified mood type: " + moodType + "</h1>");
        // }
        return recommendationService.getParticularRecommendation(moodType);
    }
}
