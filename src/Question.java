import Status.*;

import java.util.ArrayList;
import java.util.List;

public class Question {
    protected Area area;
    protected Difficulty difficulty;
    protected List<String> collectSource = new ArrayList<>();
    protected List<String> wrongSource = new ArrayList<>();

    public Question() {

    }

    public List<String> getCollectSource() {
        return collectSource;
    }

    public void setCollectSource(List<String> collectSource) {
        this.collectSource = collectSource;
    }

    public List<String> getWrongSource() {
        return wrongSource;
    }

    public void setWrongSource(List<String> wrongSource) {
        this.wrongSource = wrongSource;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

}