import java.util.Random;
import java.util.Scanner;

/**
 * 問題の出力を行うクラス
 */
public class QuestionPrinter {
    // 出題
    public static void questioning(Question q) {
        System.out.println("出題ジャンル:" + q.getArea());
        System.out.println("難易度:" + q.getDifficulty() + "\n");


        // 正答をランダムに決め問題文を出力
        int correctAnswer = new Random().nextInt(2) + 1;
        printText(q);
        printSource(q, correctAnswer);

        // 解答,判定
        System.out.print("解答を入力してください(1/2)->");
        Scanner sc = new Scanner(System.in);
        int userAnswer = sc.nextInt();
        System.out.println((correctAnswer == userAnswer) ? "正解です。" : "不正解です。");
    }

    // 問題の出力(文章)
    private static void printText(Question q) {
        switch (q.getqType()) {
            case FOR -> System.out.println("次のうち#で囲った部分が" + ((For)q).getCollectAnswerStr() + "であるソースコードはどちらか。");
            default -> {

            }
        }
    }

    // 問題の出力(ソースコード)
    private static void printSource(Question q, int correctAnswer) {
        System.out.println("1.");
        if (correctAnswer == 1) for (String s : q.getCollectSource()) System.out.println(s);
        else for (String s : q.getWrongSource()) System.out.println(s);
        System.out.println("\n2.");
        if (correctAnswer == 1) for (String s : q.getWrongSource()) System.out.println(s);
        else for (String s : q.getCollectSource()) System.out.println(s);
    }
}
