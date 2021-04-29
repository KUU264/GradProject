import Status.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Question {
    public final Area area;
    public final Difficulty difficulty;
    public final QType qType;

    public final List<String> source;
    private List<String> collectSource = new ArrayList<>();
    private List<String> wrongSource = new ArrayList<>();

    public final String MARK_START = "#";
    public final String MARK_END = "#";
    public final String MARK_START_PDF = "$";
    public final String MARK_END_PDF_NET = "#";
    public final String MARK_END_PDF_RED = "~";
    public final String MARK_END_PDF_UNDERLINE = "?";

    public Question(Area area, Difficulty difficulty, QType qType, List<String> source) {
        this.area = area;
        this.difficulty = difficulty;
        this.qType = qType;
        this.source = source;
    }

    abstract public Question generateQ();

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

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public QType getqType() {
        return qType;
    }
}