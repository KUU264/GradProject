package Utils;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import Status.*;

public class CsvUtils {
    public static final Charset CHARSET = Charset.forName("Windows-31J");
    public static List<String[]> readAllLines(Path path){
        List<String> all = readAll(path);
        List<String[]> splittedList = new ArrayList<>();
        for(String s: all){
            splittedList.add(s.split(PathUtils.COMMA));
        }
        splittedList.remove(0);
        return splittedList;
    }

    public static List<String[]> readAllLines(Path path, Area area, Difficulty difficulty){
        List<String> all = readAll(path);
        List<String[]> splittedList = new ArrayList<>();
        for(String s: all){
            String[] splittedStr = s.split(PathUtils.COMMA);
            if(area.equals(Area.ALL)){
                if(difficulty.equals(Difficulty.ALL)){
                    splittedList.add(splittedStr);
                } else if(splittedStr[1].equals(difficulty.toString())){
                    splittedList.add(splittedStr);
                }
            } else if(splittedStr[0].equals(area.toString())){
                if(difficulty.equals(Difficulty.ALL)){
                    splittedList.add(splittedStr);
                } else if(splittedStr[1].equals(difficulty.toString())){
                    splittedList.add(splittedStr);
                }
            }
        }
        return splittedList;
    }

    public static List<String> readAll(Path path){
        return PathUtils.readAll(path,CHARSET);
    }
}