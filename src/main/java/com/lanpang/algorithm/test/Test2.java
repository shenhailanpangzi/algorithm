package com.lanpang.algorithm.test;

import java.util.Arrays;

/**
 * @program:
 *
 * 效率：如果目标是把n个元素的序列升序排列，那么采用插入排序存在最好情况和最坏情况。最好情况就是，序列已经是升序排列了，在这种情况下，需要进行的比较操作需（n-1）次即可。最坏情况就是，序列是降序排列，那么此时需要进行的比较共有n(n-1)/2次。插入排序的赋值操作是比较操作的次数加上 (n-1）次。平均来说插入排序算法的时间复杂度为O(n^2）
 * @description:
 * @author: yanghao
 * @create: 2018-12-13 10:20
 **/
public class Test2 {
    private static int[] ints= {9,7,5,6,8,4,1,4,3,9,2};

    public static void main(String[] args) {

        insertionSort2(ints);
        Arrays.stream(ints).forEach(System.out::print);
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
     * 插入排序 三个循环
     *
     * @param arr
     */
//    private static int[] ints= {9,7,5,6,8,4,1,4,3,19,2};

    public static void insertionSort4(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]){
//                寻找需要插入的位置
                for (int j=0;j<i;j++){
                    if (arr[i]<arr[j]){
                        int temp = arr[i];
//                        插入位置之后的数字 向后移动一位
                        for (int k = i-1;k >= j;k --){
                            arr[k+1] = arr[k];
                        }
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
    }
    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;//设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
    /**
     * 简单选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
//每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //进行交换，如果min发生变化，则进行交换
            if (min != i) {
                swap(arr,min,i);
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
