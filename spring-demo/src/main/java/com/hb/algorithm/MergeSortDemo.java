package com.hb.algorithm;

import java.util.Arrays;

public class MergeSortDemo {
	public static void sort(int[] arr){
		int[] arrTemp = new int[arr.length];
		sort(arr,arrTemp,0,arr.length-1);
		System.out.println(Arrays.toString(arrTemp));
	}
	
	public static void sort(int[] arr,int[] arrTemp,int left,int right){
		if(left >= right){
			return;
		}
		int mid = (left+right)/2;
		sort(arr,arrTemp,left,mid);
		sort(arr,arrTemp,mid+1,right);
		merge(arr,arrTemp,left,mid,right);
	}
	
	public static void merge(int[] arr,int[] arrTemp,int left,int mid,int right){
		int i = left,j = mid+1,zero = 0;
		while(i<=mid&&j<=right){
			arrTemp[zero++] = arr[i]<arr[j]?arr[i++]:arr[j++];
		}
		while(i<=mid){
			arrTemp[zero++] = arr[i++];
		}
		while(j<=right){
			arrTemp[zero++] = arr[j++];
		}
		zero = 0;
		while(left<=right){
			arr[left++] = arrTemp[zero++];
		}
	}
	
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
