package Utils;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �\�[�X�R�[�h�ҏW�Ɋւ���Util�N���X
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
     * �\�[�X�̎w��s�̐擪��'#'��}������
     */
    public static List<String> putMarkStart(List<String> source, int row){
        StringBuilder sb = new StringBuilder(source.get(row));
        int index = sb.lastIndexOf(TAB)+4;
        sb.insert(Math.max(index, 0), MARK_START);
//        #����ꂽ�s��1�����ڂ��������ƂŁA
//        �ǂ��Ƀ}�[�N���������킩��₷���Ȃ�
//        if (!(row==0 || row==source.size()-1)){
//            sb.deleteCharAt(0);
//        }
        List<String> newSource = new ArrayList<>(source);
        newSource.set(row, sb.toString());
        return newSource;
    }

    /**
     * �\�[�X�̎w�蕡���s�̐擪��'#'��}������
     */
    public static List<String> putMarkStart(List<String> source, int[] rows) {
        for (int row:rows) {
            source = putMarkStart(source, row);
        }
        return source;
    }

    /**
     * �\�[�X�R�[�h������蕶������܂ލs��ԋp����
     */
    public static int findRow(List<String> source, String patternStr){
        Pattern pattern = Pattern.compile(patternStr);
        for (int i = 0; i < source.size(); i++) {
            String s = source.get(i);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) return i;
        }
        System.out.println("�\�[�X�R�[�h��"+patternStr+"�͊܂܂�Ă��܂���B");
        return -1;
    }

    /**
     * �\�[�X�R�[�h������蕶������܂ލs�̔z���ԋp����
     */
    public static int[] findRows(List<String> source, String patternStr){
        List<Integer> rowList = new ArrayList<>();
        Pattern pattern = Pattern.compile(patternStr);
        for (int i = 0; i < source.size(); i++) {
            String s = source.get(i);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) rowList.add(i);
        }
        if (rowList.size()==0) System.out.println("�\�[�X�R�[�h��"+patternStr+"�͊܂܂�Ă��܂���B");
        return rowList.stream().mapToInt(i->i).toArray();

    }
}
