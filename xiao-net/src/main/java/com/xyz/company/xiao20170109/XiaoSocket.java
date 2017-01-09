package com.xyz.company.xiao20170109;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端
 * @author xiao
 * @create 2017-01-09 20:01
 **/
public class XiaoSocket {

    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket("127.0.0.1",9999);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            IOUtils.write("你瞅啥！！！",outputStream,"utf-8");
            // 必须要有这一句话，不然就永远阻塞，因为服务器会一直等客户端“写完”
            socket.shutdownOutput();
            String response = IOUtils.toString(inputStream, "utf-8");
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(socket);
        }
    }
}
