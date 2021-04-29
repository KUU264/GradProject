package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * PathëÄçÏÇ…ä÷Ç∑ÇÈUtilÉNÉâÉX
 */
public class PathUtils {
    public static final String CRLF = "\r\n";
    public static final String COMMA = ",";

    /*
    public static List<String> readAll(Path path, Charset charset){
        try{
            FileInputStream in = new FileInputStream(path.toString());
            InputStreamReader is = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(is);
            List<String> list = new ArrayList<>();
            String str;
            while((str = br.readLine()) != null){
                list.add(str);
            }
            return list;
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    */

    public static List<String> readAll(Path path){
        try{
            FileInputStream in = new FileInputStream(path.toString());
            InputStreamReader is = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(is);
            List<String> list = new ArrayList<>();
            String str;
            while((str = br.readLine()) != null){
                list.add(str);
            }
            return list;
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Path writeString(Path path, String all, Charset charset){
        try{
            return Files.writeString(path, all, charset);
        } catch(IOException e){
            e.printStackTrace();
        }
        return path;
    }

    public static int countFiles(Path path){
        int count = 0;
        File file = new File(path.toString());
        for(File f: Objects.requireNonNull(file.listFiles())){
            if(f.isFile()){
                count++;
            }
        }
        return count;
    }
}