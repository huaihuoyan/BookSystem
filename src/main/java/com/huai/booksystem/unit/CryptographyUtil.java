package com.huai.booksystem.unit;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 *
 * @Author: laiyunjing
 * @Date: 2019/11/15 0015 16:04
 * @Version 1.0
 */
public class CryptographyUtil {

    public static void main(String[] args) throws Exception {
        //用于测试加密程序
        System.out.println(md5("123456", "java"));

    }

    /**
     * Md5加密  加盐
     *
     * @param pwd
     *            加密的内容
     * @param salt
     *            盐值
     */

    //这个方法主要是为了在我们将密码传入数据库时进行加密使用
    public static String md5(String pwd, String salt) {
        return new Md5Hash(pwd, salt).toString();
    }

}
