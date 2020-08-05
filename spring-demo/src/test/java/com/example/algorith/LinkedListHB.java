package com.example.algorith;

/**
 * @author huangbiaof
 * @data 创建时间：2019/6/26 12:43
 */

public class LinkedListHB {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node nodeResult = ReverseList.ReverseList(node,2,3);
        System.out.println(node + "  /n " + nodeResult);
    }
}

/**
 * 打印两个有序链表的公共部分
 */
class CommonContent {
    public void getCommont(Node node1, Node node2) {

        while (node1 != null && node2 != null) {
            if (node1.value > node2.value) {
                node1 = node1.next;
            } else if (node1.value < node2.value) {
                node2 = node2.next;
            } else {
                System.out.println(node1.value);
            }
        }
    }


}

/**
 * 删除链表中倒数几个元素
 */
class DeleteLastIndexcode {

    public void deleteNode(Node node, int num) {
        Node cur = node;
        while (cur != null) {
            num--;
        }
        //大于0 时表示超过链表长度
        // 等于0 时表示刚好到第一位
        // 小于0 时表示正向数数有多少个
        if (num == 0) {
            node = node.next;
        }
        if (num < 0) {
            cur = node;
            while (++num != 0) {
                cur = node.next;
            }
            cur.next = cur.next.next;
        }
    }
}


/**
 * 删除链表中间元素
 * 删除的元素位置每次加1，最后一个元素的位置就加2
 */

class deleteMidOfNode {

    public void deleteMid(Node node) {
        if (node.next != null && node.next.next != null) {
            return;
        }
        Node pre = node;
        Node cur = node.next.next;

        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
    }

}

/**
 * 反转单项列表
 * 构建一个新链表，每次向其中插入元素
 */
class ReverseList {
    //反转链表
    public static Node ReverseList(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    //反转部分链表
    public static Node ReverseList(Node node,int from,int to) {

        Node head = node;
        int i = 0;
        int limit = to-from;
        while(i<from){
            if(head.next==null){
                return node;
            }
            head = head.next;
            i++;
        }

        Node pre = head;
        Node next = null;
        while (node != null&&from<limit) {
            from++;
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String s = value + "";
        Node node = this;
        while (node.next != null) {
            s = s + " : " + node.next.value;
            node = node.next;
        }
        return s;
    }
}