package com.lanpang.algorithm.singleton;

/**
 * @program: algorithm
 * @description: 双重校验锁-线程安全
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F.md#1-%E5%8D%95%E4%BE%8Bsingleton
 * @author: yanghao
 * @create: 2019-01-15 15:22
 **/
public class Singleton {
    private volatile static Singleton singleton;
    private String name;

    private Singleton(){
    }
    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized(Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
