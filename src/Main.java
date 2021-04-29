import Status.Area;
import Status.Difficulty;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuestionManager qm = new QuestionManager();
//        Area area = inputArea();
//        Difficulty dif = inputDif();
        Question q = qm.generateQ();
        qm.questioning(q);
    }


    // �o��͈͂̓���
    public static Area inputArea(){
        Area a = null;
        Area[] values = Area.values();
        System.out.println("�W���������X�g");
        for (int i = 0; i <values.length; i++) {
            System.out.println(i+":"+values[i]);
        }
        int cnt=0;
        System.out.print("�o�肷��W����������͂��Ă�������->");
        while (a==null) {
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (0 <= num && num < values.length){
                a = values[num];
            } else {
                if (2<++cnt){
                    System.out.println("���s���͂��J��Ԃ��ꂽ����ALL���I������܂����B\n");
                    return Area.ALL;
                }
                System.out.println("�W�������ɂ��鐔������͂��Ă�������->");
            }
        }
        System.out.println(a + "���I������܂����B\n");
        return a;
    }

    // �o���Փx�̓���
    public static Difficulty inputDif(){
        Difficulty d = null;
        Difficulty[] values = Difficulty.values();
        System.out.println("difficulty list");
        for (int i = 0; i < values.length; i++) {
            System.out.println(i+":"+values[i]);
        }
        int cnt=0;
        while (d==null) {
            System.out.print("input difficulty->");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (0 <= num && num < values.length){
                d = values[num];
            } else {
                if (2<++cnt){
                    System.out.println("forced selection:ALL\n");
                    return Difficulty.ALL;
                }
            }
        }
        System.out.println(d + " was selected.\n");
        return d;
    }

    // ���s�̊m�F
    public static boolean isContinuance(){
        System.out.print("Would you like to continue? y/n ->");
        Scanner sc = new Scanner(System.in);
        char c = (char) sc.nextByte();
        return c=='y';
    }
}