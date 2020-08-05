package com.hb.algorithm;

import java.util.Arrays;

public class InsertSortDemo {
	public static void insertSort(int[] arr){
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = i-1; j >= 0; j--) {
				if(arr[j+1]>arr[j]){
					break;
				}
				swap(arr,j+1,j);
			}
		}
	}
	public static void swap(int[] arr, int i ,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {2,5,7,2,6,3};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
