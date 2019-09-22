package com.zhy.designPattern.observer.v1;

public class Main {

    public static boolean isCry = false;

    public static void main(String[] args) {
        while (!isCry){
            //监听是不是婴儿是不是在哭 如果再哭的时候进行处理
            System.out.println("喂奶");
        }
    }

}
