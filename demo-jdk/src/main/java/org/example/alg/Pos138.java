package org.example.alg;

public class Pos138 {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node tmp = new Node(cur.val);
            cur.next = tmp;
            tmp.next = next;
            cur = next;
        }
        //生成random并重新拆分为2个链表
        cur = head;
        Node newHead = new Node(-1);
        Node newCur = newHead;
        //循环
        while (cur != null) {
            //赋值random
            Node next = cur.next;
            next.random = cur.random == null ? null : cur.random.next;
            //旧链表
            cur.next = next.next;
            cur = next.next;
            //构建新链表
            newCur.next = next;
            newCur = next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        //
        node0.next = node1;
        node1.next = node2;
        node1.random = node0;
        //
        Node node = copyRandomList(node0);
        System.out.println("----");

    }
}
