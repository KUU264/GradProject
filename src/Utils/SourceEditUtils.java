package Utils;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ソースコード編集に関するUtilクラス
 */
public class SourceEditUtils {
    private static final String MARK_START = "#";
    private static final String MARK_END = "#";
    private static final String MARK_START_PDF = "$";
    private static final String MARK_END_PDF_NET = "#";
    private static final String MARK_END_PDF_RED = "~";
    private static final String MARK_END_PDF_UNDERLINE = "?";
    private static final String TAB = "    ";

    /**
     * ソースの指定行の先頭に'#'を挿入する
     */
    public static List<String> putMarkStart(List<String> source, int row){
        StringBuilder sb = new StringBuilder(source.get(row));
        int index = sb.lastIndexOf(TAB)+4;
        sb.insert(Math.max(index, 0), MARK_START);
//        #を入れた行の1文字目を消すことで、
//        どこにマークしたかがわかりやすくなる
//        if (!(row==0 || row==source.size()-1)){
//            sb.deleteCharAt(0);
//        }
        List<String> newSource = new ArrayList<>(source);
        newSource.set(row, sb.toString());
        return newSource;
    }

    /**
     * ソースの指定複数行の先頭に'#'を挿入する
     */
    public static List<String> putMarkStart(List<String> source, int[] rows) {
        for (int row:rows) {
            source = putMarkStart(source, row);
        }
        return source;
    }

    /**
     * ソースコードから特定文字列を含む行を返却する
     */
    public static int findRow(List<String> source, String patternStr){
        Pattern pattern = Pattern.compile(patternStr);
        for (int i = 0; i < source.size(); i++) {
            String s = source.get(i);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) return i;
        }
        System.out.println("ソースコードに"+patternStr+"は含まれていません。");
        return -1;
    }

    /**
     * ソースコードから特定文字列を含む行の配列を返却する
     */
    public static int[] findRows(List<String> source, String patternStr){
        List<Integer> rowList = new ArrayList<>();
        Pattern pattern = Pattern.compile(patternStr);
        for (int i = 0; i < source.size(); i++) {
            String s = source.get(i);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) rowList.add(i);
        }
        if (rowList.size()==0) System.out.println("ソースコードに"+patternStr+"は含まれていません。");
        return rowList.stream().mapToInt(i->i).toArray();

    }
}
