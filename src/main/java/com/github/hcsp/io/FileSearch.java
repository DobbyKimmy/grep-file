package com.github.hcsp.io;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileSearch {
    // 找到第一个包含text的行的行号，行号从1开始计算。若没找到，则返回-1。
    // 如果指定的文件不存在或者无法被读取，抛出一个 IllegalArgumentException。
    // 请不要让这个方法抛出checked exception
    public static int grep(File target, String text) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(target))) {
            String str = null;
            int count = 1;
            int rowNumber = -1;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.contains(text)){
                    rowNumber = count;
                }
                count++;
            }
            return rowNumber;
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        System.out.println("结果行号：" + grep(new File(projectDir, "log.txt"), "BBB"));
    }
}
