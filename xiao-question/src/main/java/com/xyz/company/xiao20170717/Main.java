package com.xyz.company.xiao20170717;

/**
 * Created by Xiao on 2017/7/17.
 */
public class Main {
    public static void main(String[] args){
        int i = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        //Integer会自动拆箱为int，所以为true
        System.out.println(i == i2); // true
        System.out.println(i == i3); // true
        System.out.println("**************");
        Integer i5 = 127;//java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        Integer i6 = 127;
        System.out.println(i5 == i6);//true
        Integer ii5 = 128;
        Integer ii6 = 128;
        System.out.println(ii5 == ii6);//false
        Integer iii5 = new Integer(127);
        System.out.println(i5 == iii5); //false
        Integer i7 = new Integer(128);
        Integer i8 = new Integer(128);
        System.out.println(i7 == i8);  //false

        int i9 = 1000;
        Integer ii9 = 1000;
        System.out.println(i9 == ii9); // true
    }
}
