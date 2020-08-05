package com.hb.algorithm.sort;

/**
 * 归并排序 
 * 稳定的
 * nlogn
 * 
 * @author uname
 *
 */
public class MergeSort {
	/**
	 * 递归
	 * 
    将序列每相邻两个数字进行归并操作，形成 c e i l ( n / 2 ) 个序列，排序后每个序列包含两/一个元素
    若此时序列数不是1个则将上述序列再次归并，形成 c e i l ( n / 4 ) 个序列，每个序列包含四/三个元素
    重复步骤2，直到所有元素排序完毕，即序列数为1

	 * @param arr
	 * @param result
	 * @param start
	 * @param end
	 */
	static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
		if (start >= end)
			return;
		int len = end - start;
		int mid = (len >> 1) + start;
		int start1 = start;
		int end1 = mid;
		int start2 = mid + 1;
		int end2 = end;
		merge_sort_recursive(arr, result, start1, end1);
		merge_sort_recursive(arr, result, start2, end2);
		int k = start;
		while (start1 <= end1 && start2 <= end2)
			result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
		while (start1 <= end1)
			result[k++] = arr[start1++];
		while (start2 <= end2)
			result[k++] = arr[start2++];
		for (k = start; k <= end; k++)
			arr[k] = result[k];
	}
	public static void merge_sort(int[] arr) {
		int len = arr.length;
		int[] result = new int[len];
		merge_sort_recursive(arr, result, 0, len - 1);
	}
	/**
	 * 迭代版本
	 * 
    申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
    设定两个指针，最初位置分别为两个已经排序序列的起始位置
    比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
    重复步骤3直到某一指针到达序列尾
    将另一序列剩下的所有元素直接复制到合并序列尾

	 * @param arr
	 */
	public static void merge_sort2(int[] arr) {
	    int len = arr.length;
	    int[] result = new int[len];
	    int block, start;
	    
	    // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
	    for(block = 1; block < len; block *= 2) {
	        for(start = 0; start <len; start += 2 * block) {
	            int low = start;
	            int mid = (start + block) < len ? (start + block) : len;
	            int high = (start + 2 * block) < len ? (start + 2 * block) : len;
	            //两个块的起始下标及结束下标
	            int start1 = low, end1 = mid;
	            int start2 = mid, end2 = high;
	            //开始对两个block进行归并排序
	            while (start1 < end1 && start2 < end2) {
	            	result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
	            }
	            while(start1 < end1) {
			        result[low++] = arr[start1++];
	            }
	            while(start2 < end2) {
	            	result[low++] = arr[start2++];
	            }
	        }
			int[] temp = arr;
			arr = result;
			result = temp;
	    }
	    result = arr;       
	}
	
}
