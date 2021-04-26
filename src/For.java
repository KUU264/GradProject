import Status.Area;
import Status.QType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class For extends Question {
    private int collectAnswer;
    private int wrongAnswer;
    private final String[] answer = {"init","condition","increment"};

    /**
     * 正答と誤答をランダムに配置
     */
    public For() {
        setArea(Area.FOR);
        setqType(QType.FOR);
        collectAnswer = new Random().nextInt(3);
        do {
            wrongAnswer = new Random().nextInt(3);
        } while (collectAnswer == wrongAnswer);
    }

    /**
     * 問題の作成
     */
    @Override
    public Question generateQ() {
        int forRow = findFor();
        if (forRow==-1) {
            System.out.println("wrong source");
            return null;
        }
        int[] cut = searchCutPoint(forRow);
        setSources(getSource().get(forRow).substring(cut[0], cut[1]), forRow);

        return this;
    }

    /**
     * 編集したい行を見つける
     */
    public int findFor() {
        Pattern pattern = Pattern.compile("for");
        for (int i = 0; i < getSource().size(); i++) {
            String source = getSource().get(i);
            Matcher matcher = pattern.matcher(source);
            if (matcher.find()) return i;
        }
        return -1;
    }

    /** 切り出す始点と終点を探す */
    private int[] searchCutPoint(int forRow){
        int[] cut = new int[2];

        // 最初'('の位置を記録
        String tmp = getSource().get(forRow);
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i)=='(') {
                cut[0] = i+1;
                break;
            }
        }

        // 最後の')'の位置を記録
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == ')') {
                cut[1] = i;
            }
        }

        return cut;
    }

    /**
     * ソースコードの編集
     */
    private void setSources(String source, int i) {
        // 前後の空白を取り除く
        String[] strings = source.split("[\\s]*;[\\s]*");

        // 正解
        List<String> collect = new ArrayList<>(getSource());
        collect.set(i, collect.get(i).replace(source, putMark(strings, collectAnswer)));
        setCollectSource(collect);

        //不正解
        List<String> wrong = new ArrayList<>(getSource());
        wrong.set(i, wrong.get(i).replace(source, putMark(strings, wrongAnswer)));
        setWrongSource(wrong);

    }

    /**
     * 指定位置をマークで囲う
     */
    private String putMark(String[] oldStr, int pos) {
        StringBuilder sb = new StringBuilder(oldStr[pos]);
        sb.insert(0, MARK_START);
        sb.append(MARK_END);

        String[] newStr = new String[oldStr.length];
        for (int i = 0; i < oldStr.length; i++) {
            if (i == pos) newStr[i] = sb.toString();
            else newStr[i] = oldStr[i];
        }

        // 分割した要素の復旧
        return String.join("; ", newStr);
    }

    public int getCollectAnswer() {
        return collectAnswer;
    }

    public String[] getAnswer() {
        return answer;
    }
}