package com.huai.booksystem.unit;

/**
 * 坚持试不试在极速模式
 * @Author: laiyunjing
 * @Date: 2019/11/14 0014 16:17
 * @Version 1.0
 */
public class BrowserveUnit {
    public static void main(String[] args) {

    }

    public static boolean checkUserAger(String UserAger){
        boolean flag =true;
        UserAger = UserAger.toLowerCase();
        if(UserAger.indexOf("trident")!= -1){
            flag = false;
        }
        return flag;
    }
}
