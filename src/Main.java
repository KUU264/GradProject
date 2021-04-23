import java.util.Scanner;

import Status.*;
import org.apache.pdfbox.tools.PDFBox;

public class Main {
    public static void main(String[] args) {
        QuestionManager qm = new QuestionManager();
        do{

        }while (isContinuance());
        Area area = Area.ALL;
        Difficulty dif = Difficulty.ALL;
        QuestionGenerator qg = new QuestionGenerator(area, dif);
        Question q = qg.generateQ();
    }


    // 出題範囲の入力
    public static Area inputArea(){
        Area a = null;
        Area[] values = Area.values();
        System.out.println("area list");
        for (int i = 0; i <values.length; i++) {
            System.out.println(i+":"+values[i]);
        }
        int cnt=0;
        while (a==null) {
            System.out.print("input area->");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (0 <= num && num < values.length){
                a = values[num];
            } else {
                if (2<++cnt){
                    System.out.println("forced selection:ALL\n");
                    return Area.ALL;
                }
            }
        }
        System.out.println(a + " was selected.\n");
        return a;
    }

    // 出題難易度の入力
    public static Difficulty inputDif(){
        Difficulty d = null;
        Difficulty[] values = Difficulty.values();
        System.out.println("difficulty list");
        for (int i = 0; i < values.length; i++) {
            System.out.println(i+":"+values[i]);
        }
        int cnt=0;
        while (d==null) {
            System.out.print("input difficulty");
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

    // 続行の確認
    public static boolean isContinuance(){
        System.out.print("Would you like to continue? y/n ->");
        Scanner sc = new Scanner(System.in);
        char c = (char) sc.nextByte();
        return c=='y';
    }
}