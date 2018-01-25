package com.xyz.company.xiao20180125;

import java.io.*;

/**
 * Created by Xiao on 2018/1/25.
 */
public class ObjSerial {

    public static void main(String[] args) {
//        serializeUser();
        User user = deSerializeUser();
//        System.out.println(user.getId());
    }

    private static void serializeUser() {
        User user = new User();
//        user.setId(30L);
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("/Users/yindingyu/xiaoyizhi/t.txt"));
            outputStream.writeObject(user);
            System.out.println("序列化成功。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private static User deSerializeUser() {

        User user = null;
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream("/Users/yindingyu/xiaoyizhi/t.txt"));
            try {
                user = (User) inputStream.readObject();
                System.out.println("执行反序列化过程成功。");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
