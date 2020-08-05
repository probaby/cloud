package com.example.algorith;

import java.util.Arrays;

public class AlgorithmDemo {

    public static void main(String[] args) {
        int[] arrs = {3, 1, 6, 3, 9, 3};
        AlgorithmDemo al = new AlgorithmDemo();

        //al.insertSort(arrs);
        al.fastSort(arrs, 0, arrs.length - 1);
        System.out.println(Arrays.toString(arrs));

    }

    /**
     * 快速排序
     */
    public void fastSort(int[] arrs, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int i = head, j = tail,key = arrs[(i + j) / 2];
        while (i <= j) {
            int temp;
            while (arrs[i] < key) {
                i++;
            }
            while (arrs[j] > key) {
                j--;
            }
            if (i < j) {
                temp = arrs[i];
                arrs[i] = arrs[j];
                arrs[j] = temp;
                i++;
                j--;
            }else if(i==j){
                i++;
            }
        }
        fastSort(arrs, head, j);
        fastSort(arrs, i, tail);
    }

    public void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }


    /**
     * 插入排序
     *
     * @param arrs
     */
    public void insertSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            int key = arrs[i];
            int j = i - 1;
            while (j >= 0 && key < arrs[j]) {
                arrs[j + 1] = arrs[j];
                j--;
            }
            arrs[j + 1] = key;
        }
    }
}
