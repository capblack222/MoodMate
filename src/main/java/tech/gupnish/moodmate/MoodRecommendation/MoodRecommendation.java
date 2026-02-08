package tech.gupnish.moodmate.MoodRecommendation;

// @Entity
public class MoodRecommendation {
    private String moodType;
    private String music;
    private String stuff_to_do;
    private String dining;

    public MoodRecommendation(String moodType, String music, String stuff_to_do, String dining) {
        this.moodType = moodType;
        this.music = music;
        this.stuff_to_do = stuff_to_do;
        this.dining = dining;
    }

    public MoodRecommendation(String moodType, String music) {
        this.moodType = moodType;
        this.music = music;
    }

    public MoodRecommendation(String moodType, String music, String stuff_to_do) {
        this.moodType = moodType;
        this.music = music;
        this.stuff_to_do = stuff_to_do;
    }

    // Getters and setters
    public String getMoodType() {
        return moodType;
    }

    public void setMoodType(String moodType) {
        this.moodType = moodType;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getStuffToDo() {
        return stuff_to_do;
    }

    public void setStuffToDo(String stuff_to_do) {
        this.stuff_to_do = stuff_to_do;
    }

    public String getDining() {
        return dining;
    }

    public void setDining(String dining) {
        this.dining = dining;
    }
}