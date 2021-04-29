import Status.Area;
import Status.Difficulty;
import Status.QType;
import Utils.SourceEditUtils;

import java.util.*;

public class For extends Question {
    private final int collectAnswer;
    private final int wrongAnswer;
    private final String[] answer = {"初期化","条件","増分"};

    /**
     * 正答と誤答をランダムに配置
     */
    public For(Difficulty dif, List<String> source) {
        super(Area.FOR, dif, QType.FOR, source);
        List<Integer> numList = new LinkedList<>(Arrays.asList(1,2,3));
        collectAnswer = numList.remove(new Random().nextInt(3));
        wrongAnswer = numList.get(new Random().nextInt(2));
    }

    /**
     * 問題の作成
     */
    @Override
    public Question generateQ() {
        int forRow = SourceEditUtils.findRow(source, "for");
        int[] cut = searchCutPoint(forRow);
        setSources(source.get(forRow).substring(cut[0], cut[1]), forRow);

        return this;
    }

    /**
     * 切り出す始点と終点を探す
     */
    private int[] searchCutPoint(int forRow){
        int[] cut = new int[2];

        // 最初'('の位置を記録
        String tmp = source.get(forRow);
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
    private void setSources(String cuttedSource, int i) {
        // 前後の空白を取り除く
        String[] strings = cuttedSource.split("[\\s]*;[\\s]*");

        // 正解
        List<String> collect = new ArrayList<>(source);
        collect.set(i, collect.get(i).replace(cuttedSource, putMark(strings, collectAnswer)));
        setCollectSource(collect);

        //不正解
        List<String> wrong = new ArrayList<>(source);
        wrong.set(i, wrong.get(i).replace(cuttedSource, putMark(strings, wrongAnswer)));
        setWrongSource(wrong);

    }

    /**
     * [int i = 0, i < 4, i++] ->
     * [#int i = 0#, i < 4, i++]
     * 指定位置をマークで囲う
     * stringsは[0-2],pos(=answer)は[1-3]なのでposを-1する
     */
    private String putMark(String[] oldStr, int pos) {
        pos--;
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

    // 正答の文字列を返却
    public String getCollectAnswerStr() {
        return answer[collectAnswer-1];
    }

    public String[] getAnswer() {
        return answer;
    }
}