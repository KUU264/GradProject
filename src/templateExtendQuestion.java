import Status.Area;
import Status.Difficulty;
import Status.QType;

import java.util.ArrayList;
import java.util.List;

/**
 * Questionを継承したクラスのテンプレート
 */
public class templateExtendQuestion extends Question{
    // エラー回避
    public templateExtendQuestion(Area area, Difficulty difficulty, QType qType, List<String> source) {
        super(area, difficulty, qType, source);
    }
    @Override
    public Question generateQ() {
        return null;
    }

    /*
    template
     public templateExtendQuestion(Difficulty dif, List<String> source) {
         super([Area], dif, [QType], source);

     }

     @Override
     public Question generateQ() {
         setSources();
         return this;
     }

     private void setSources() {

         List<String> collect = new ArrayList<>(getSource());
         List<String> wrong = new ArrayList<>(getSource());
         collect = makeCollect();
         wrong = makeWrong();
         setCollectSource(collect);
         setWrongSource(wrong);
     }
    */

}
