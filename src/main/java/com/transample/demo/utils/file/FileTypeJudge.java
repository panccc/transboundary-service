package com.transample.demo.utils.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileTypeJudge {

    /**
     * 二进制转化为16进制
     */
    private static String bytes2hex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                hex.append("0");
            }
            hex.append(temp.toLowerCase());
        }
        return hex.toString();
    }

    /**
     * 读取文件头
     */
    private static String getFileHeader(String filePath) throws IOException {
        //这里需要注意的是,每个文件的magic word的长度都不相同,因此需要使用startwith
        byte[] b = new byte[28];
        InputStream inputStream = new FileInputStream(filePath);
        inputStream.read(b, 0, 28);
        inputStream.close();
        return bytes2hex(b);
    }

    private static String getFileHeader(InputStream inputStream) throws IOException
    {
        byte[] b = new byte[28];
        inputStream.read(b, 0, 28);
        inputStream.close();
        return bytes2hex(b);
    }

    /**
     * 判断文件类型
     */
    public static FileType getType(InputStream inputStream) throws IOException {
        String fileHead = getFileHeader(inputStream);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
        fileHead = fileHead.toUpperCase();
        FileType[] fileTypes = FileType.values();
        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }
        return null;
    }

    /**
     * 判断文件类型
     */
    public static FileType getType(String filePath) throws IOException {

        String fileHead = getFileHeader(filePath);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
        fileHead = fileHead.toUpperCase();
        FileType[] fileTypes = FileType.values();
        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(FileTypeJudge.getType("D:\\pic\\generatorConfig.jpg"));
    }
}
