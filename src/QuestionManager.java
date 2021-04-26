import Utils.CsvUtils;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Status.*;

/** 問題を全体を管理するクラス */
public class QuestionManager {
    private List<String[]> csvData;

    public QuestionManager() {
        csvData = CsvUtils.readAllLines(Path.of("src/data.csv"));
    }

    public List<String[]> getCsvData() {
        return csvData;
    }

    public List<Question> generateQList(){
        return null;
    }

    public Question generateQ(){
        Area area = Area.FOR;
        Difficulty dif = Difficulty.A;
        QuestionGenerator qg = new QuestionGenerator(Area.FOR, Difficulty.A);

        File file = new File("src/questions/"+area.getClassName()+"/"+dif.getClassName());
        try {
            File[] files = file.listFiles();
            assert files != null;
            Path path = Path.of(String.valueOf(files[new Random().nextInt(files.length)]));
            return qg.generateQ(path);
        }catch (Exception ignored){}

        return null;
    }

    // 出題
    public void questioning(Question q){
        System.out.println("area:"+ q.getArea());
        System.out.println("difficulty:"+q.getDifficulty()+"\n");

        printText(q);

        // 正答をランダムに決め出力
        int correctAnswer = new Random().nextInt(2) + 1;
        System.out.println("1.");
        if(correctAnswer==1) for (String s : q.getCollectSource()) System.out.println(s);
        else for (String s : q.getWrongSource()) System.out.println(s);
        System.out.println("\n2.");
        if (correctAnswer==1) for (String s : q.getWrongSource()) System.out.println(s);
        else for (String s : q.getCollectSource()) System.out.println(s);

        // 解答,判定
        System.out.print("your answer -> ");
        Scanner sc = new Scanner(System.in);
        int userAnswer = sc.nextInt();
        System.out.println((correctAnswer==userAnswer)?"correct!":"incorrect..");
    }

    // 問題文の出力
    private void printText(Question q){
        switch (q.getqType()) {
            case FOR -> System.out.println("select " + ((For) q).getAnswer()[((For) q).getCollectAnswer()] + " status");
            default -> {

            }
        }
    }

}