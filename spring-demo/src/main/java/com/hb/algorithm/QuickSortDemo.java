package com.hb.algorithm;

import java.util.Arrays;

public class QuickSortDemo {
	public static void QuickSortDemo(int[] arr,int left,int right){
		if(left >= right || left < 0 || right > arr.length || arr == null || arr.length <= 1){
			return ;
		}
		int i = left,j = right,mid = arr[(right + left) / 2];
		while(i <= j){
			while(arr[i] < mid){
				++i;
			}
			while(arr[j]>mid){
				--j;
			}
			if(i < j){
				swap(arr,i,j);
				++i;
				--j;
			}else if(i == j){
				++i;
			}
		}
		QuickSortDemo(arr, left, j);
		QuickSortDemo(arr, i,right);
	}
	public static void swap(int arr[],int index1,int index2){
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {2,5,7,2,6,3};
		QuickSortDemo(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
