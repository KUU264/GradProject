import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Area a = inputArea();
        Difficulty d = inputDifficulty();
        QuestionGenerator qg = new QuestionGenerator(a, d);
        Question q = qg.generateQ();

        q.output();
    }

    public static Area inputArea(){
        Area a = null;
        System.out.println("area list");
        for (int i = 0; i <Area.values().length; i++) {
            System.out.println(i+":"+Area.values()[i]);
        }
        int cnt=0;
        while (a==null) {
            System.out.print("input area->");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (0 <= num && num < Area.values().length){
                a = Area.values()[num];
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

    public static Difficulty inputDifficulty(){
        Difficulty d = null;
        System.out.println("difficulty list");
        for (int i = 0; i <Difficulty.values().length; i++) {
            System.out.println(i+":"+Difficulty.values()[i]);
        }
        int cnt=0;
        while (d==null) {
            System.out.print("input difficulty");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (0 <= num && num < Difficulty.values().length){
                d = Difficulty.values()[num];
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
}