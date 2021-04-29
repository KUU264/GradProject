import Status.Area;
import Status.Difficulty;
import Status.QType;
import Utils.SourceEditUtils;

import java.util.List;

public class Comment extends Question{
    public Comment(Difficulty difficulty, List<String> source) {
        super(Area.COMMENT, difficulty, QType.NET, source);

    }

    @Override
    public Question generateQ() {
        setSources();
        return this;
    }

    public void setSources() {
        int[] commentRows = SourceEditUtils.findRows(source, "//");
        setCollectSource(SourceEditUtils.putMarkStart(source, commentRows));
        for (int i = 0; i < commentRows.length; commentRows[i++]++);
        setWrongSource(SourceEditUtils.putMarkStart(source, commentRows));
    }
}
