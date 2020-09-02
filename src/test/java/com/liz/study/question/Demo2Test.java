package com.liz.study.question;


import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/15 13:50
 */

public class Demo2Test {

    public void test1(){
        short s1=1;
        s1+=1;
    }

    public void test(){
        new Stack<String>();
        new HashSet<String>();
        new Hashtable<>();
        new LinkedHashMap();
        new WeakHashMap();
        new TreeMap<>();
        new IdentityHashMap<>();
        new ConcurrentHashMap<>();
    }

    @Test
    public void demo1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] intArr = new int[n];
            for (int i = 0; i < n; i++) {
                intArr[i] = scanner.nextInt();
            }
            Arrays.sort(intArr);
            for (int i = 0; i < intArr.length; i++) {
                // 第一个数字或者不等于前一个数字都可以输出
                if (i == 0 || intArr[i] != intArr[i - 1]) {
                    System.out.println(intArr[i]);
                }
            }
        }
    }

    @Test
    public void blockServer() throws IOException {
        //1.获取通道
        ServerSocketChannel open = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //2.绑定连接
        open.bind(new InetSocketAddress(9898));
        //3.获取客户端连接的通道
        SocketChannel socketChannel = open.accept();
        //4.接收客户端的数据，保存本地
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (socketChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.close();
        outChannel.close();
        open.close();
    }

    @Test
    public void blockClient() throws IOException {
        //1.获取通道
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        //2.分配缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }
        inChannel.close();
        channel.close();
    }


    @Test
    public void noBlockServer() throws IOException {
        //1.获取通道
        ServerSocketChannel open = ServerSocketChannel.open();
        open.configureBlocking(false);
        //2.绑定连接
        open.bind(new InetSocketAddress(9898));
        //3.获取选择器
        Selector selector = Selector.open();
        //4.将通道注册到选择器上
        open.register(selector, SelectionKey.OP_ACCEPT);
        //5.轮询获取选择器上准备就绪的事件
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (next.isAcceptable()) {
                    SocketChannel socketChannel = open.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (next.isReadable()) {
                    SocketChannel sk = (SocketChannel) next.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sk.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, len));
                    }
                }
                //取消选择器
                iterator.remove();
            }
        }

    }

    @Test
    public void noBlockClient() throws IOException {
        //1.获取通道
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        channel.configureBlocking(false);
        //2.分配缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(new Date().toString().getBytes());
        buffer.flip();
        channel.write(buffer);
        buffer.clear();
        channel.close();
    }


}