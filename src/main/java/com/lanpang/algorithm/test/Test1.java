package com.lanpang.algorithm.test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: 阶乘-大数字运算
 * 进阶：输出时不显示前面的0 两个大数字相乘
 * @description:
 * @author: yanghao
 * @create: 2018-10-24 09:15
 **/
public class Test1 {

    public static void main(String[] args) {
        test1();
        int n = 50;
        int[] num1 = new int[100];
        num1[num1.length-1] = 1;
        for (int i = 1; i <= n; i++) {
//            num1 = num1 * i;
            System.out.println("调用"+i+"次!");
            num1 = compute(num1, i);
        }
        Arrays.stream(num1).forEach(System.out::print);
        System.out.println();
        Arrays.stream(num1).boxed().collect(Collectors.toList()).forEach(System.out::print);
    }
    public static void test1(){
        //n! = 1*2*3*4*5...n  阶乘
        //大数字运算 计算50的阶乘
        int n = 5;
        double num1 = 1;
        for (int i = 1; i <= n; i++) {
            num1 = num1 * i;
        }
        System.out.println(num1);
    }
//        当n=50的时候 结果会超过int的范围 使用double会使用科学计数法,丢失精度，这时候只能使用数组来实现
//        将很大数字放入数组当中 计算一个大数字乘以一个int
    public static int[] compute(int[] a,int b){
//        利用数组计算732*16
//        1、计算每一位
        for (int i = 0; i < a.length; i++) {
            a[i]*= b;
        }
        System.out.println("计算每一位:" + Arrays.toString(a));
//        2、进位和留位 从后往前
        for (int i = a.length-1; i>0; i--) {
//            进位
            a[i-1] += a[i]/10;
            a[i] = a[i]%10;
        }
        System.out.println("最终结果：" + Arrays.toString(a));
        return a;
    }
}
