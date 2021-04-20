import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question {
    protected Random random = new Random();
    protected int userAnswer;
    protected int collectAnswer;
    protected List<String> source = new ArrayList<>();
    protected List<String> collectSource = new ArrayList<>();
    protected List<String> wrongSource = new ArrayList<>();
    protected List<List<String>> sourceList = new ArrayList<>();
    protected Area area;
    protected Difficulty difficulty;
    protected boolean result;

    public Question() {

    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getCollectAnswer() {
        return collectAnswer;
    }

    public void setCollectAnswer(int collectAnswer) {
        this.collectAnswer = collectAnswer;
    }

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

    public List<List<String>> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<List<String>> sourceList) {
        this.sourceList = sourceList;
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

    public void output(){
        System.out.println("area:"+ area);
        System.out.println("difficulty:"+difficulty+"\n");
        System.out.println("question");
        System.out.println("1.");
        for (String s:collectSource) System.out.println(s);
        System.out.println("\n2.");
        for (String s:wrongSource) System.out.println(s);
        System.out.println("\ncorrect:"+collectAnswer);
    }
}