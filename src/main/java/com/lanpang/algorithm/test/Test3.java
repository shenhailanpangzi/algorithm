package com.lanpang.algorithm.test;

/**
 * @program: algorithm
 * @description:查找 二分法
 * @author: yanghao
 * @create: 2018-12-13 16:26
 **/
public class Test3 {
    private static int[] ints= {9,7,5,6,8,4,1,4,3,19,2};

    public static void main(String[] args) {
//        要先排序
        insertionSort2(ints);
        //开始位置
        int s = 0;
        //结束位置
        int e = ints.length-1;
        //中间位置
        int m = 0;
        //要查找的数字
        int num =5;
//        当开始位置小于结束位置
        while (s<=e){
            m = (s+e)/2;
            if (num == ints[m]){
                System.out.println("找到了"+m);
                return;
            }else if (num < m){
                //要找的数在左边
                e = m - 1;
            }else {
                //要找的数在右边
                s = m + 1;
            }
        }
        System.out.println("不存在");
    }
    /**
     * 插入排序 两个循环  比冒泡排序效率要高
     *
     * @param arr
     */
    public static void insertionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
//            不断与前一个数进行比较，如果比前一个数小的话就交换
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr,j,j-1);
                j--;
            }
        }
    }
    /**
     * 交换数组元素
     * @param arr
     * @param a 第一个元素
     * @param b 第二个元素
     */
    public static void swap(int []arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
//        arr[a] = arr[a]+arr[b];
//        arr[b] = arr[a]-arr[b];
//        arr[a] = arr[a]-arr[b];
    }
}


