package com.example.file;

import java.io.File;

/**
 * @author huangbiaof
 * @data 创建时间：2019/5/29 20:03
 */

public class DeleteFileSourceDemo {

    public static void main(String[] args) {
        new DeleteFileSourceDemo().deleteSourFile("D:\\a\\b\\d\\dfs.txt");
    }

    public boolean deleteSourFile(String filePath) {
        String sourFilePath = filePath.substring(0, filePath.lastIndexOf(File.separator));
        if (!"D:\\a".equalsIgnoreCase(filePath)) {
            new File(filePath).delete();
        }


        if ("D:\\a".equalsIgnoreCase(sourFilePath)) {
            return true;
        }

        File file = new File(sourFilePath);
        if (file.exists() && file.list().length < 2) {
            deleteSourFile(sourFilePath);
        }
        return true;
    }

}
