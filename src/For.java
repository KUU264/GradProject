import Status.Area;
import Status.Difficulty;
import Status.QType;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class For extends Question {
    private final int collectAnswer;
    private final int wrongAnswer;
    private final String[] answer = {"������","����","����"};

    /**
     * �����ƌ듚�������_���ɔz�u
     */
    public For(List<String> source) {
        super(Area.FOR, Difficulty.A, QType.FOR, source);
        List<Integer> numList = new LinkedList<>(Arrays.asList(1,2,3));
        collectAnswer = numList.remove(new Random().nextInt(3));
        wrongAnswer = numList.get(new Random().nextInt(2));
    }

    /**
     * ���̍쐬
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
     * �ҏW�������s��������
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

    /** �؂�o���n�_�ƏI�_��T�� */
    private int[] searchCutPoint(int forRow){
        int[] cut = new int[2];

        // �ŏ�'('�̈ʒu���L�^
        String tmp = getSource().get(forRow);
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
    private void setSources(String source, int i) {
        // �O��̋󔒂���菜��
        String[] strings = source.split("[\\s]*;[\\s]*");

        // ����
        List<String> collect = new ArrayList<>(getSource());
        collect.set(i, collect.get(i).replace(source, putMark(strings, collectAnswer)));
        setCollectSource(collect);

        //�s����
        List<String> wrong = new ArrayList<>(getSource());
        wrong.set(i, wrong.get(i).replace(source, putMark(strings, wrongAnswer)));
        setWrongSource(wrong);

    }

    /**
     * �w��ʒu���}�[�N�ň͂�
     * �}�[�N�t����1-3,strings��[0-2]�Ȃ̂�pos��-1����
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