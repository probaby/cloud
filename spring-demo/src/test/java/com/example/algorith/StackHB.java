package com.example.algorith;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author huangbiaof
 * @data 创建时间：2019/6/24 12:34
 */

public class StackHB {


    public static void main(String[] args) {

    }
}

/**
 * 栈弹出最小值
 */
class StackMin {
    public Stack<Integer> stackData;
    public Stack<Integer> stackMin;

    public StackMin() {
        this.stackMin = new Stack<Integer>();
        this.stackData = new Stack<Integer>();

    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("this is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public void push(int i) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(i);
        }
        if (i < this.getMin()) {
            this.stackMin.push(i);
        }
        stackData.push(i);
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("");
        }
        return this.stackMin.peek();
    }

}


/**
 * 2个栈是实现队列
 */
class DoubleStackToQueue {
    public Stack<Integer> stackPop;
    public Stack<Integer> stackPush;

    public DoubleStackToQueue() {
        this.stackPop = new Stack<Integer>();
        this.stackPush = new Stack<Integer>();

    }

    public void add(int i) {
        this.stackPush.push(i);
    }

    public int poll(int i) {
        if (this.stackPush.isEmpty() || this.stackPop.isEmpty()) {
            throw new RuntimeException("this is empty");
        }else if(stackPop.empty()){
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return this.stackPop.pop();
    }

    public int peek() {
        if (this.stackPush.isEmpty() || this.stackPop.isEmpty()) {
            throw new RuntimeException("this is empty");
        }else if(stackPop.empty()){
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return this.stackPop.peek();
    }

}

class StackChange {
    public Stack stackSort ;

    /**
     * 返回栈中最后一个元素
     *
     * @return
     */
    public int returnLastNum(Stack<Integer> stack) {
        int last = stack.pop();
        if(stack.isEmpty()){
            return last;
        }else{
            int next = returnLastNum(stack);
            stack.push(last);
            return next;
        }
    }

    public Stack sort(Stack<Integer> stack){
        if(stack.isEmpty()){
            return null;
        }
        int s = returnLastNum(stack);
        sort(stack);
        stackSort.push(s);
        return stack;
    }
}

/**
 * 猫狗游戏： 增加时间戳
 */
class CatDogGame {
//    class
}

/**
 * 使用一个栈，给另一个栈排序
 * 两个栈互相接收值，再互相push和pop
 *
 *
 */
class StackSort {
    public Stack<Integer> stackSorted;

    public Stack<Integer> sort(Stack<Integer> stack) {

        while (!stack.isEmpty()) {
            int stackThring = stack.pop();

            while (stackSorted != null && stackSorted.peek() < stackThring) {
                stack.push(stackSorted.pop());
            }
            stackSorted.push(stackThring);
        }

        return stackSorted;
    }

}

class BigestWindows {
    public void getBigArr(int [] arr,int w) {
        LinkedList<Integer> maxList = new LinkedList<>();
        int[] arrMax = new int[arr.length-w+1];
        int index = 0;
        for (int i = 0;i<arr.length;i++) {
            //如果maxLast 的最后一个元素 小于 arr当前元素的话，就增加对应元素
            while (!maxList.isEmpty()&&arr[maxList.peekLast()]<arr[i]) {
                maxList.pollLast();
            }
            maxList.addLast(i);

            //maxList的第一个元素 == 框前一个元素是，过期
            if(maxList.peekFirst()==i-w){
                maxList.pollFirst();
            }

            //当 框中数目达到w时，开始往数组中放值
            if(i>=w-1){
                arrMax[index++] = arr[maxList.peekFirst()];
            }
        }
    }
}

/**
 * 数组没有重复元素
 * 二叉树，数组每个值对应一个节点
 * 值最大的点时树的头部
 */
class MaxTree {

    class Node {
        Node left;
        Node Rigth;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    //类似堆排序，堆顶为最大元素
    public void getMaxTree(int[] arr){

    }

}