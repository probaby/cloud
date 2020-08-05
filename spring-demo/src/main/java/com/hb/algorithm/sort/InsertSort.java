package com.hb.algorithm.sort;

/**
 * 插入排序
 * n平方
 * 将第一个数作 为已排序的数，然后将后面的数与其前面的 数做比较，将大的数后移
 * @author uname
 *
 */
public class InsertSort {
	public static void insertion_sort( int[] arr ){
	    for( int i=0; i<arr.length-1; i++ ) {	
	        for( int j=i+1; j>0; j-- ) {
	            if( arr[j-1] <= arr[j] )
	                break;
	            int temp = arr[j];
	            arr[j] = arr[j-1];
	            arr[j-1] = temp;
	        }
	    }
	}
	
    //将arr[i] 插入到arr[0]...arr[i - 1]中

	public static void insertion_sort2(int[] arr) {
		for (int i = 1; i < arr.length; i++ ) {
			int temp = arr[i];
			int j = i - 1;  
    //如果将赋值放到下一行的for循环内, 会导致在第10行出现j未声明的错误
			for (; j >= 0 && arr[j] > temp; j-- ) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}
}
