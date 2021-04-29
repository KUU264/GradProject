import Utils.CsvUtils;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

import Status.*;
import Utils.FileUtils;

/**
 * ����S�̂��Ǘ�����N���X
 */
public class QuestionManager {
    private final List<String[]> csvData;

    public QuestionManager() {
        csvData = CsvUtils.readAllLines(Path.of("src/data.csv"));
    }

    public List<String[]> getCsvData() {
        return csvData;
    }

    public List<Question> generateQList() {
        return null;
    }

    //    public Question generateQ(Area area, Difficulty dif){
    public Question generateQ() {
        Area area = Area.FOR;
        Difficulty dif = Difficulty.A;
        QuestionGenerator qg = new QuestionGenerator(area, dif);

        // �W�������Ɠ�Փx����\�[�X�R�[�h��I��
        File file = new File("src/questions/" + area.getClassName() + "/" + dif.getClassName());
        try {
            File[] files = file.listFiles();
            assert files != null;
            files = FileUtils.getTxtFiles(files);
            System.out.println(files.length+"���̃\�[�X��������܂����B");
            Path path = Path.of(String.valueOf(files[new Random().nextInt(files.length)]));
            System.out.println(path);
            return qg.generateQ(path);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        return null;
    }




    public void questioning(Question q) {
        QuestionPrinter.questioning(q);
    }
}