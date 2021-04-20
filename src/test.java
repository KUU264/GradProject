import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String[]> list = CsvUtils.readAllLines(Paths.get("C:\\IntelliJworkspace\\GP\\src\\INDENT\\INDENT.csv"));
        List<List<String>> lists = new ArrayList<>();
        for (String[] s:list) {
            lists.add(Arrays.asList(s));
        }
        System.out.println();
    }
}
