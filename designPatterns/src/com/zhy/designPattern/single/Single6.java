package com.zhy.designPattern.single;

//不仅线程安全而且可以防止反序列化
public enum Single6 {
    INSTANCE;

    public void m(){
        System.out.println(this.hashCode());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()-> Single6.INSTANCE.m()).start();
        }
    }
}
