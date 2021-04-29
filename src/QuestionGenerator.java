import Utils.PathUtils;

import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Status.*;

/**
 * ����,��Փx��ݒ肵�Ė��𐶐�
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
     * 1�␶��
     */
    public Question generateQ(Path path) {
        Object q;
        List<String> source = PathUtils.readAll(path);
        try {
            // ���t���N�V������p���ăW������������C���X�^���X�𐶐�
            Class<?> className = Class.forName(area.getClassName());
            Constructor<?> constructor = className.getConstructor(Difficulty.class, List.class);
            q = constructor.newInstance(difficulty, source);
            return ((Question) q).generateQ();
        } catch (Exception e) {
            System.out.println("���̐����Ɏ��s���܂����B");
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.exit(1);
            return null;
        }
    }

    public void reStart(String area, String difficulty) {

    }

    public void reStart(String area) {

    }

    public void randomRestart() {

    }
}