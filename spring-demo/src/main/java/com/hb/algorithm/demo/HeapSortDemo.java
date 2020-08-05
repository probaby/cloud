package com.hb.algorithm.demo;

import java.util.Arrays;

public class HeapSortDemo {
	//堆排序，
	
	public static void heapSort(int[] arr){
		//确定最后一个根节点
		int leng = arr.length-1;
		int index = (leng-1)/2;
		for(int i = index;i>=0;i--){
			heapDeal(arr,i,leng);
		}
		
		for (int i = leng; i > 0; i--) {
			swap(arr,0,i);
			heapDeal(arr,0,i-1);
		}
	}
	
	public static void heapDeal(int[] arr,int index,int length){
		int left = index*2+1;
		int right = index*2+2;
		if(left>length){
			return ;
		}
		int max = (right<=length&&arr[left]<=arr[right])?right:left;
		if(arr[index]<arr[max]){
			swap(arr,index,max);
			heapDeal(arr,max,length);
		}
	}
	
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		//int []arr = {9,8,7,6,5,4,3,2,1};
		int []arr = {1,2,3,4,5,6,7,9,8};
        heapSort(arr);;
        System.out.println(Arrays.toString(arr));
	}
	
}
