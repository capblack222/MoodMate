package tech.gupnish.moodmate.moodRecommendation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import tech.gupnish.moodmate.errors.MoodNotFoundException;

@Service
public class RecommendationService {
    private final List<MoodRecommendation> recommendations = new ArrayList<>();

    public RecommendationService() {
        this.recommendations.addAll(List.of(
            new MoodRecommendation("Happy", "Upbeat music", "Go for a walk in the park", "Try a new ice cream flavor"),
            new MoodRecommendation("Sad", "Soft, calming music", "Watch a feel-good movie", "Cook your favorite comfort food"),
            new MoodRecommendation("Stressed", "Relaxing instrumental music", "Practice meditation or yoga", "Order takeout from your favorite restaurant"),
            new MoodRecommendation("Energetic", "High-energy music", "Go for a run or hit the gym", "Grab a quick, healthy snack"),
            new MoodRecommendation("Bored", "Eclectic mix of genres", "Try a new hobby or activity", "Explore a new cuisine"),
            new MoodRecommendation("Lonely", "Melancholic or nostalgic music", "Call a friend or family member", "Cook a meal for yourself and enjoy it mindfully"),
            new MoodRecommendation("Angry", "Aggressive or intense music", "Engage in physical activity to release tension", "Cook a hearty meal to channel your energy"),
            new MoodRecommendation("Relaxed", "Chillout or ambient music", "Read a book or take a bath", "Enjoy a light, refreshing meal"),
            new MoodRecommendation("Distracted", "Instrumental or focus-enhancing music", "Organize your workspace or declutter", "Opt for a simple, nutritious meal")
        ));
    }

    public List<MoodRecommendation> getRecommendations() {
        return recommendations;
    }

    public MoodRecommendation getParticularRecommendation(String moodType) throws MoodNotFoundException {
        MoodRecommendation found = new MoodRecommendation();
        if (moodType == null || moodType.isEmpty()) {
            throw new IllegalArgumentException("Mood type cannot be null or empty");
        }
        if (recommendations.stream().anyMatch(mood -> mood.getMoodType().equalsIgnoreCase(moodType))) {
            found = recommendations.stream()
                .filter(mood -> mood.getMoodType().equalsIgnoreCase(moodType))
                .findFirst()
                .orElse(null);
            return found;
        }
        throw new MoodNotFoundException("No recommendations found for the specified mood type: " + moodType);
    }
}
