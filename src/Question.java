import Status.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Question {
    private Area area;
    private Difficulty difficulty;
    private QType qType;


    private List<String> source;
    private List<String> collectSource = new ArrayList<>();
    private List<String> wrongSource = new ArrayList<>();
    protected final String MARK_START = "#";
    protected final String MARK_END = "#";

    abstract public Question generateQ();

    public List<String> getSource() {
        return source;
    }

    public void setSource(List<String> source) {
        this.source = source;
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

    public QType getqType() {
        return qType;
    }

    public void setqType(QType qType) {
        this.qType = qType;
    }
}