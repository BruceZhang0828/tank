package com.zhy.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertiesMgr {

    static Properties props = new Properties();

    static {
        try {
            props.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static Object getConfig(String key){
        if (props==null)return null;
        return props.get(key);
    }


    public static void main(String[] args) {
        System.out.println(Integer.parseInt((String)PropertiesMgr.getConfig("initTank")) );
    }

}
