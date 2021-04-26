import Utils.PathUtils;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Status.*;

/**
 * 分野,難易度を設定して問題を生成
 */
public class QuestionGenerator {
    private final Area area;
    private final Difficulty difficulty;
    private List<Question> qList = new ArrayList<>();

    public QuestionGenerator(Area area, Difficulty difficulty) {
        this.area = area;
        this.difficulty = difficulty;
    }

    /**
     * 1問生成
     */
    public Question generateQ(Path path) {
        switch (area) {
            case ALL -> {
            }
            case BRACKETS -> {
            }
            case CLASS_CALL -> {
            }
            case CLASS_DIAGRAM_TO_SOURCE_CODE -> {
            }
            case CLASS_DIAGRAM -> {
            }
            case CODINGSTYLE_CLASSNAME -> {
            }
            case CODINGSTYLE_METHOD -> {
            }
            case CODINGSTYLE_VARIABLE -> {
            }
            case COMMENT -> {
            }
            case COMPILE_AND_RUN -> {
            }
            case CONSTRUCTOR -> {
            }
            case FOR -> {
                Question q = new For();
                q.setSource(generateSource(path));
                return q.generateQ();
            }
            case INDENT -> {
            }
            case LITERAL_STRING -> {
            }
            case METHOD -> {
            }
            case OPERATOR_ASSIGNMENT -> {
            }
            case OPERATOR_COMPARISON -> {
            }
            case OPERATOR_LOGIC -> {
            }
            case PARAMETER_TYPE -> {
            }
            case PARAMETER -> {
            }
            case PROGRAM_ARGUMENTS -> {
            }
            case RETURN_TYPE -> {
            }
            case RETURN_VALUE_DEFAULT -> {
            }
            case RETURN_VALUE -> {
            }
            case SCOPE -> {
            }
            case SOURCE_CODE_TO_CLASS_DIAGRAM -> {
            }
            case STATIC_METHOD_CALL -> {
            }
            case VARIABLE_SENTENCE -> {
            }
            case VARIABLE -> {
            }
        }
        return null;
    }

    private List<String> generateSource(Path path) {
        List<String> source;

        source = PathUtils.readAll(path, Charset.forName("Windows-31J"));

        return source;
    }

    public void reStart(String area, String difficulty) {

    }

    public void reStart(String area) {

    }

    public void randomRestart() {

    }
}