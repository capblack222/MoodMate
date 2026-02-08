package tech.gupnish.moodmate.MoodRecommendation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/recommendations")
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @RequestMapping("/all")
    public Object getAllRecommendations() {
        return recommendationService.getRecommendations();
    }

    @GetMapping("/recommend")
    public Object getOneRecommendation(@RequestParam("mood") String moodType) {
        return recommendationService.getParticularRecommendation(moodType);
    }
}
