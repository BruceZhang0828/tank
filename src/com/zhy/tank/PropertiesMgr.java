package com.zhy.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertiesMgr {

    private PropertiesMgr(){};

    static Properties props = new Properties();

    static {
        try {
            props.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @param key
     * @return
     */
    public static Object getConfig(String key){
        if (props==null)return null;
        return props.get(key);
    }


    public static int getConfigInt(String key){
        if (props==null)return 0;
        String value= (String)props.get(key);
        return Integer.parseInt(value);
    }


    public static String getConfigStr(String key){
        if (props==null)return null;
        String value= (String)getConfig(key);
        return value;
    }


    public static void main(String[] args) {
        System.out.println(Integer.parseInt((String)PropertiesMgr.getConfig("initTank")) );
    }

}
