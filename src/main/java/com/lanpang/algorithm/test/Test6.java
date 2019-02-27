package com.lanpang.algorithm.test;

/**
 * @program: algorithm
 * @description: 替换空格
 * @author: yanghao
 * @create: 2019-01-24 15:22
 **/
public class Test6 {
    public static void main(String[] args) {
        String a = "A B";
        String b = a.replace(" ","%20");
        System.out.println(b);

        String c = replaceSpace(new StringBuffer(a));
        System.out.println(c);
    }

    public static String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
