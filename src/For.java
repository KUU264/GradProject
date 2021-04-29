import Status.Area;
import Status.Difficulty;
import Status.QType;
import Utils.SourceEditUtils;

import java.util.*;

public class For extends Question {
    private final int collectAnswer;
    private final int wrongAnswer;
    private final String[] answer = {"������","����","����"};

    /**
     * �����ƌ듚�������_���ɔz�u
     */
    public For(Difficulty dif, List<String> source) {
        super(Area.FOR, dif, QType.FOR, source);
        List<Integer> numList = new LinkedList<>(Arrays.asList(1,2,3));
        collectAnswer = numList.remove(new Random().nextInt(3));
        wrongAnswer = numList.get(new Random().nextInt(2));
    }

    /**
     * ���̍쐬
     */
    @Override
    public Question generateQ() {
        int forRow = SourceEditUtils.findRow(source, "for");
        int[] cut = searchCutPoint(forRow);
        setSources(source.get(forRow).substring(cut[0], cut[1]), forRow);

        return this;
    }

    /**
     * �؂�o���n�_�ƏI�_��T��
     */
    private int[] searchCutPoint(int forRow){
        int[] cut = new int[2];

        // �ŏ�'('�̈ʒu���L�^
        String tmp = source.get(forRow);
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i)=='(') {
                cut[0] = i+1;
                break;
            }
        }

        // �Ō��')'�̈ʒu���L�^
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == ')') {
                cut[1] = i;
            }
        }

        return cut;
    }

    /**
     * �\�[�X�R�[�h�̕ҏW
     */
    private void setSources(String cuttedSource, int i) {
        // �O��̋󔒂���菜��
        String[] strings = cuttedSource.split("[\\s]*;[\\s]*");

        // ����
        List<String> collect = new ArrayList<>(source);
        collect.set(i, collect.get(i).replace(cuttedSource, putMark(strings, collectAnswer)));
        setCollectSource(collect);

        //�s����
        List<String> wrong = new ArrayList<>(source);
        wrong.set(i, wrong.get(i).replace(cuttedSource, putMark(strings, wrongAnswer)));
        setWrongSource(wrong);

    }

    /**
     * [int i = 0, i < 4, i++] ->
     * [#int i = 0#, i < 4, i++]
     * �w��ʒu���}�[�N�ň͂�
     * strings��[0-2],pos(=answer)��[1-3]�Ȃ̂�pos��-1����
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

        // ���������v�f�̕���
        return String.join("; ", newStr);
    }

    public int getCollectAnswer() {
        return collectAnswer;
    }

    // �����̕������ԋp
    public String getCollectAnswerStr() {
        return answer[collectAnswer-1];
    }

    public String[] getAnswer() {
        return answer;
    }
}