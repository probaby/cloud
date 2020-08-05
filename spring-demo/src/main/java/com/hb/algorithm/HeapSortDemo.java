package com.hb.algorithm;

import java.util.Arrays;

public class HeapSortDemo {
	public static void heapSort(int[] arr){
		int length = arr.length-1;
		int index = (length-1)/2;
		for(int i = index;i>=0;i--){
			heapDeal(arr,i,length);
		}
		
		for(int i = length ; i>0;i--){
			swap(arr,0,i);
			heapDeal(arr,0,i-1);
		}
	}
	
//	public static void heapDeal(int[] arr,int index,int length){
//		
//		int left = index*2+1;
//		int  right = index*2+2;
//		int max = left;
//		if(left > length||left<0){
//			return ;
//		}
//		if(arr[left]<arr[right]&&right<=length){
//			max = right;
//		}
//		if(arr[index]<arr[max]){
//			swap(arr,index,max);
//			heapDeal(arr,max,length);
//		}
//	}
	
    private static void heapDeal(int[] arr,int index,int len){
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。
        
        if(li > len) return;       // 左子节点索引超出计算范围，直接返回。
        if(ri <= len && arr[ri] > arr[li]) // 右节点可能会大于len，此时是只有左节点的情况，先判断左右子节点，哪个较大。
            cMax = ri;
        if(arr[cMax] > arr[index]){
            swap(arr,cMax, index);      // 如果父节点被子节点调换，把最大的换为根节点
            heapDeal(arr,cMax, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }
	
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
	
}
