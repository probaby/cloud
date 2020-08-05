package com.hb.algorithm;

public class SanJiaoDemo {
	
	
	//递归
	static int[][] next = {{1,0},{1,1}};
	static int min = 1000000; 
	public static void maxSum(int[][] arr,int x, int y,int sum){           //从D(i,j)到底边的各条路径中，最佳路径的数字之和。  
		if(x==(arr.length-1)){
			for(int i = y; i < arr[x].length;i++){
				sum += arr[x][i];
			}
			min = min<sum?min:sum;
	    	return ;
		}
	    for(int k = 0;k<2;k++){
	    	int tx = x + next[k][0];
	    	int ty = y + next[k][1];
	    	if(ty>(arr.length-1)){
	    		continue;
	    	}
	    	maxSum(arr,tx,ty,sum+arr[x][y]);
	    }
	} 
	

	//动态规划
	public static int getMin(int x,int y ,int[][] arr){
		
		
		if(x<0||y<0){
			return 99999;
		}
		if(x==0&&y==0){
			return arr[0][0];
		}
		if(y==0&&x!=0){
			return getMin(x-1,y,arr)+arr[x][y];
		}
		return Math.min(getMin(x,y-1,arr),getMin(x-1,y-1,arr)) + arr[x][y];
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1},{2,5},{3,1,5},{3,1,1,1}};
		maxSum(arr,0,0,0);
		System.out.println(min);
		System.out.println(getMin(arr.length-1,arr[arr.length-1].length-1,arr));
	}
}
