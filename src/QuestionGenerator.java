import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/** 分野,難易度を設定して問題を生成 */
public class QuestionGenerator {
    private int AREA = 0;
    private int DIFFICULTY = 1;
    private int FILENAME = 2;
    private Random random = new Random();
    private Area area;
    private Difficulty difficulty;
    private List<Question> qList = new ArrayList<>();

    public QuestionGenerator(Area area, Difficulty difficulty) {
        this.area = area;
        this.difficulty = difficulty;
        generateQList();
    }

    /** 1問生成 */
    public Question generateQ() {
        Question q = new Question();
        q.setArea(area);
        q.setDifficulty(difficulty);
        q.setCollectAnswer(1);
        q.setSource(generateSource());
        q.setCollectSource(generateSource());
        q.setWrongSource(generateWrongSource(q.getCollectSource()));
        return q;
    }

    /** 問題をリストに格納 */
    public void generateQList() {
        area = Area.INDENT;
        difficulty=Difficulty.A;
        qList.add(generateQ());

    }


    private List<String> generateSource(){
        List<String> source;
        Path path = Paths.get("C:\\IntelliJworkspace\\GP\\src\\INDENT\\A\\Indent_1.txt");

        source = PathUtils.readAll(path, Charset.forName("Windows-31J"));

        return source;
    }

    /** 誤例の生成 */
    private List<String> generateWrongSource(List<String> collect){
        List<String> wrong = new ArrayList<>(collect);
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).charAt(0) == '^'){
                wrong.add(i,collect.get(i).substring(2));
                wrong.remove(i+1);
                return wrong;
            }
        }
        return wrong;
    }

    public void reStart(String area, String difficulty) {

    }

    public void reStart(String area) {

    }

    public void randomRestart() {

    }
}