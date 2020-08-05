package com.hb.algorithm.sort;



public class ShellSort {

	public void shellSort() {

		int a[] = { 1, 54, 6, 3, 78, 34, 12, 45, 56, 100 };
		double d1 = a.length;
		int temp = 0;

		while (true) {
			d1 = Math.ceil(d1 / 2);
			int d = (int) d1;
			for (int x = 0; x < d; x++) {
				//交換間隔的位置
				for (int i = x + d; i < a.length; i += d) {
					int j = i - d;
					temp = a[i];
					for (; j >= 0 && temp < a[j]; j -= d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}

			if (d == 1) {
				break;
			}

			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
			}
		}
	}
	
	
//	public static void shell_sort(int[] arr) {
//		int gap = 1, i, j, len = arr.length;
//		int temp;
//		while (gap < len / 3)
//			gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
//		for (; gap > 0; gap /= 3)
//			for (i = gap; i < len; i++) {
//				temp = arr[i];
//				for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
//					arr[j + gap] = arr[j];
//				arr[j + gap] = temp;
//			}
//	}
}
