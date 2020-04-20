package com.liz.study.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/19 23:12
 */
public class NioReadFile {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("D:\\1.txt"));
            FileChannel channel = fileInputStream.getChannel();
            int capacity = 100;
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + byteBuffer.limit() + "\n容量是：" + byteBuffer.capacity() + "\n位置是：" + byteBuffer.position());
            int length = -1;
            while ((length = channel.read(byteBuffer)) != -1){
                byteBuffer.clear();
                byte[] bytes = byteBuffer.array();
                System.out.write(bytes,0,length);
                System.out.println();
                System.out.println("限制是：" + byteBuffer.limit() + "\n容量是：" + byteBuffer.capacity() + "\n位置是：" + byteBuffer.position());
            }
            channel.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
