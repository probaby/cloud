package com.hb.algorithm;

import java.util.Arrays;

public class BubbleSortDemo {
	public static void bubbleSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length-i; j++) {
				if(arr[j-1]>arr[j]){
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp; 
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {2,5,7,2,6,3};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
