package com.liz.study.file;

import java.io.*;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/13 15:35
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {
        String str = fileInputStream("D:\\1.txt");
        System.out.println(str);
    }

    /**
     * fileInputStream读文件
     * @param path
     * @return
     * @throws IOException
     */
    private static String fileInputStream(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        while (bufferedReader.readLine() != null){
            line += bufferedReader.readLine();
        }
        return line;
    }
}
