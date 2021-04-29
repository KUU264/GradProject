package Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * ファイル操作に関するUtilクラス
 */
public class FileUtils {
    public static File[] getTxtFiles(File[] files) {
        return getSpecificFiles(files, "txt");
    }

    public static File[] getJavaFiles(File[] files){
        return getSpecificFiles(files, "java");
    }

    // ファイル配列から指定された拡張子のファイルを抽出し、その配列を返す
    public static File[] getSpecificFiles(File[] files, String extension){
        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.substring(fileName.lastIndexOf('.')+1).equals(extension)) {
                fileList.add(file);
            }
        }
        File[] returnFiles = new File[fileList.size()];
        for (int i = 0; i < fileList.size(); i++) {
            returnFiles[i] = fileList.get(i);
        }
        return returnFiles;
    }

    // 複数の拡張子を選択したい場合
    public static File[] getSpecificFiles(File[] files, String[] extensions){
        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            String fileName = file.getName();
            for (String extension : extensions) {
                if (fileName.substring(fileName.lastIndexOf('.')+1).equals(extension)) {
                    fileList.add(file);
                }
            }
        }
        File[] returnFiles = new File[fileList.size()];
        for (int i = 0; i < fileList.size(); i++) {
            returnFiles[i] = fileList.get(i);
        }
        return returnFiles;
    }

}
