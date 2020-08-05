package com.hb.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 不稳定排序 最差n房， 最小logn nlogn
 * 
 * 选一个基准数，将数组分区再递归
 * @author uname
 *
 */

public class QuickSort {
	public static void qSort(int[] arr, int head, int tail) {
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
	public static void main(String[] args) {
		int[] arr = {2,5,7,2,6,3};
		qSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}
}
