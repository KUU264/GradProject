import java.util.Random;
import java.util.Scanner;

/**
 * ���̏o�͂��s���N���X
 */
public class QuestionPrinter {
    // �o��
    public static void questioning(Question q) {
        System.out.println("�o��W������:" + q.getArea());
        System.out.println("��Փx:" + q.getDifficulty() + "\n");


        // �����������_���Ɍ��ߖ�蕶���o��
        int correctAnswer = new Random().nextInt(2) + 1;
        printText(q);
        printSource(q, correctAnswer);

        // ��,����
        System.out.print("�𓚂���͂��Ă�������(1/2)->");
        Scanner sc = new Scanner(System.in);
        int userAnswer = sc.nextInt();
        System.out.println((correctAnswer == userAnswer) ? "�����ł��B" : "�s�����ł��B");
    }

    // ���̏o��(����)
    private static void printText(Question q) {
        switch (q.getqType()) {
            case FOR -> System.out.println("���̂���#�ň͂���������" + ((For)q).getCollectAnswerStr() + "�ł���\�[�X�R�[�h�͂ǂ��炩�B");
            default -> {

            }
        }
    }

    // ���̏o��(�\�[�X�R�[�h)
    private static void printSource(Question q, int correctAnswer) {
        System.out.println("1.");
        if (correctAnswer == 1) for (String s : q.getCollectSource()) System.out.println(s);
        else for (String s : q.getWrongSource()) System.out.println(s);
        System.out.println("\n2.");
        if (correctAnswer == 1) for (String s : q.getWrongSource()) System.out.println(s);
        else for (String s : q.getCollectSource()) System.out.println(s);
    }
}
