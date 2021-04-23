import Utils.CsvUtils;

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

    public void generateQ(){
        Area area = Area.ALL;
        Difficulty dif = Difficulty.ALL;
        Question q = new QuestionGenerator(area, dif).generateQ();
    }

    public List<String[]> getCsvData() {
        return csvData;
    }

    public List<Question> generateQList(){
        return null;
    }

    // 出題
    public void questioning(Question q){
        System.out.println("area:"+ q.getArea());
        System.out.println("difficulty:"+q.getDifficulty()+"\n");
        System.out.println("question");

        // 正答をランダムに決め出力
        int correctAnswer = new Random().nextInt(2) + 1;
        System.out.println("1.");
        if(correctAnswer==1) for (String s : q.getCollectSource()) System.out.println(s);
        else for (String s : q.getWrongSource()) System.out.println(s);
        System.out.println("\n2.");
        if (correctAnswer==1) for (String s : q.getWrongSource()) System.out.println(s);
        else for (String s : q.getCollectSource()) System.out.println(s);

        // 解答,判定
        Scanner sc = new Scanner(System.in);
        int userAnswer = sc.nextInt();
        System.out.println((correctAnswer==userAnswer)?"correct!":"incorrect..");
    }

}