package com.example.algorith;

import java.util.*;

public class AlgorithmDemo {

    public static void main(String[] args) {
//        int[] arrs = {3, 1, 6, 3, 9, 3};
//        AlgorithmDemo al = new AlgorithmDemo();
//
//        //al.insertSort(arrs);
//        al.fastSort(arrs, 0, arrs.length - 1);
//        System.out.println(Arrays.toString(arrs));
      //  System.out.println(Arrays.toString(getValidT9Words("2",new String[]{"a", "b", "c", "d"}).toArray()));


        System.out.println(new AlgorithmDemo().maxSubArray(new int[]{-3,-2,-2,-3}));
    }


    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int res = -100000000;
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            for(int j = i ;j<nums.length;j++){
                if(i==0){
                    result[j] = (j==0?0:result[j-1]) + nums[j];
                }else{
                    result[j] = result[j]-nums[i-1];
                }
                res = Math.max(res,result[j]);
            }

        }
        return res;
    }
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(dfs(board,i,j,0,chars)){
                    return true;
                };
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,int i,int j,int k,char[] chars){
        if(i<0||j<0||i>=board.length||j>=board.length||board[i][j]!=chars[k]||board[i][j]=='/'){
            return false;
        }
        if(k==chars.length-1){
            return true;
        }
        board[i][j]='/';
        boolean result = dfs(board,i,j-1,k+1,chars)||dfs(board,i,j+1,k+1,chars)||dfs(board,i-1,j,k+1,chars)||dfs(board,i+1,j,k+1,chars);
        return result;
    }

    /**
     * 快速排序
     */
    public void fastSort(int[] arrs, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int i = head, j = tail,key = arrs[(i + j) / 2];
        while (i <= j) {
            int temp;
            while (arrs[i] < key) {
                i++;
            }
            while (arrs[j] > key) {
                j--;
            }
            if (i < j) {
                temp = arrs[i];
                arrs[i] = arrs[j];
                arrs[j] = temp;
                i++;
                j--;
            }else if(i==j){
                i++;
            }
        }
        fastSort(arrs, head, j);
        fastSort(arrs, i, tail);
    }

    public void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }


    /**
     * 插入排序
     *
     * @param arrs
     */
    public void insertSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            int key = arrs[i];
            int j = i - 1;
            while (j >= 0 && key < arrs[j]) {
                arrs[j + 1] = arrs[j];
                j--;
            }
            arrs[j + 1] = key;
        }
    }

    public static  List<String> getValidT9Words(String num, String[] words) {
        Map<Character, Character> map = new HashMap<>(26);
        map.put('a', '2');
        map.put('b', '2');
        map.put('c', '2');
        map.put('d', '3');
        map.put('e', '3');
        map.put('f', '3');
        map.put('g', '4');
        map.put('h', '4');
        map.put('i', '4');
        map.put('j', '5');
        map.put('k', '5');
        map.put('l', '5');
        map.put('m', '6');
        map.put('n', '6');
        map.put('o', '6');
        map.put('p', '7');
        map.put('q', '7');
        map.put('r', '7');
        map.put('s', '7');
        map.put('t', '8');
        map.put('u', '8');
        map.put('v', '8');
        map.put('w', '9');
        map.put('x', '9');
        map.put('y', '9');
        map.put('z', '9');

        List<String> result = Arrays.asList(words);


        for (String word : words) {
            boolean match = true;
            for (int i = 0; i < word.length(); i++) {
                if (map.get(word.charAt(i)) != num.charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                result.add(word);
            }
        }
        return result;
    }

    public int findRepeatNumber(int[] nums) {
        int[] result = new int[nums.length];
        for(int i :nums){
            if(result[i]==1){
                return i;
            }else{
                result[i] = 1;
            }
        }
        return -1;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if(matrix[0][0]>target||matrix[matrix.length][matrix[matrix.length].length]<target){
            return false;
        }

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length-1;j++){
                if(matrix[i][j]==target||matrix[i][j+1]==target){
                    return true;
                }else if(matrix[i][j]<target&&matrix[i][j+1]>target){
                    continue;
                }
            }
        }
        return false;
    }



    public int[] reversePrint(ListNode head) {
        Stack<ListNode> current = new Stack<>();


        while(head!=null){
            current.push(head);
            head = head.next;
        }
        int[] result = new int[current.size()];
        for(int i = 0;i<current.size();i++){
            result[i] = current.pop().val;
        }
        return result;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }



}



class ListNode {
     int val;
    ListNode next;
      ListNode(int x) { val = x; }
  }


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class CQueue {


    Stack<Integer> add ;
    Stack<Integer> del ;
    public CQueue() {
        add = new Stack<Integer>();
        del = new Stack<Integer>();
    }

    public void appendTail(int value) {
        add.push(value);
    }

    public int deleteHead() {
        if(del==null){
            while(add!=null){
                del.push(add.pop());
            }
        }
        if(del!=null){
            return del.pop();
        }else{
            return -1;
        }
    }
    public int fib(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 2;
        for(int i = 2;i<=n;i++){
            result[i] = result[i-1]+result[i-2];
            result[i] %= 1000000007;
        }
        return result[n] ;
    }

    public int numWays(int n) {
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for(int i = 2;i<n+1;i++){
//            result[i] = result[i-1]+1+result[i-2]+
        }
    return 0;
    }





}

class Solution {
//    public boolean exist(char[][] board, String word) {
//        char[] words = word.toCharArray();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (dfs(board, words, i, j, 0)) return true;
//            }
//        }
//        return false;
//    }
//
//    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
//        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
//        if (k == word.length - 1) return true;
//        char tmp = board[i][j];
//        board[i][j] = '/';
//        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
//                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
//        board[i][j] = tmp;
//        return res;
//    }
//    public static boolean exist(char[][] board, String word) {
//        char[] chars = word.toCharArray();
//        for(int i = 0;i<board.length;i++){
//            for(int j = 0;j<board[0].length;j++){
//                if(dfs(board,i,j,0,chars)){
//                    return true;
//                };
//            }
//        }
//        return false;
//    }
//
//    public static boolean dfs(char[][] board,int i,int j,int k,char[] chars){
//        if(i<0||j<0||i>=board.length||j>=board.length||board[i][j]!=chars[k]||board[i][j]=='/'){
//            return false;
//        }
//        if(k==chars.length-1){
//            return true;
//        }
//        board[i][j]='/';
//        boolean result = dfs(board,i,j-1,k+1,chars)||dfs(board,i,j+1,k+1,chars)||dfs(board,i-1,j,k+1,chars)||dfs(board,i+1,j,k+1,chars);
//        return result;
//    }

//    public int movingCount(int m, int n, int k) {
//        int[][] target = new int[m][n];
//
//    }

    public int dfs(int m,int n,int k,int[][] target){
        if(m<0||n<0||m>target.length||n>target[m].length){
            return -1;
        }
        return 0;
    }

//    public double myPow(double x, int n) {
//        if(x==0){
//            return 0;
//        }
//        if(x==1||n==0){
//            return 1;
//        }
//        long b = n;
//        double result = 1.0;
//        if(b<0){
//            x = 1/x;
//            b = -b;
//        }
//        while(b>0){
//            if((b&1)==1){
//                result *= x;
//            }
//            x *= x;
//            b = b>>1;
//        }
//
//        return result;
//    }
//    public double myPow(double x, int n) {
//        if(x == 0) return 0;
//        long b = n;
//        double res = 1.0;
//        if(b < 0) {
//            x = 1 / x;
//            b = -b;
//        }
//        while(b > 0) {
//            if((b & 1) == 1) res *= x;
//            x *= x;
//            b >>= 1;
//        }
//        return res;
//    }
//
//    public boolean isNumber(String s) {
//        char[] chars = s.toCharArray();
//        String charStart = "-+1234567890";
//        boolean usedE = false;
//        boolean userQ = false;
//        for(int i = 0;i<chars.length;i++){
//            if(i==1){
//                if(charStart.charAt(chars[i])<0){
//                    return false;
//                }
//            }else{
//                if(chars[i]=='.'&&(userQ||usedE)&&i!=(chars.length-1)){
//                    return false;
//                }else{
//                    userQ = true;
//                }
//                if(chars[i]=='e'&&(userQ||usedE)&&i!=(chars.length-1)){
//                    return false;
//                }else{
//                    usedE = true;
//                }
//            }
//        }
//        return true;
//    }


//    public int[] levelOrder(TreeNode root) {
//
//        Queue<TreeNode> que = new LinkedList<>();
//        List<int> list = new ArrayList<>();
//        que.add(root);
//        while(que!=null){
//            TreeNode cur = que.poll();
//            list.add(cur.val);
//            if(cur.left!=null){
//                que.add(cur.left);
//            }
//            if(cur.right!=null){
//                que.add(cur.right);
//            }
//        }
//        return list.toArray();
//    }

}