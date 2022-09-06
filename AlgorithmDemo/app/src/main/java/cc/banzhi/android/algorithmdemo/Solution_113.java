package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 25. K 个一组翻转链表
 * @author: zoufengli01
 * @create: 2022/9/5 12:09
 **/
public class Solution_113 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null || k <= 0) return head;

        Node hNode = head;
        Node lastNode = head;

        int index = 0;
        while (head != null) {
            head = head.next;
            index++;

            if (index % k == 0) {
                Node startNode = reverse(lastNode, head);
                if (index / k == 1) {
                    hNode = startNode;
                }
            }
        }

        return hNode;
    }

    private Node reverse(Node start, Node end, Node preNode, Node nextNode) {
        Node nextNode = end.next;

        Node

        Node preNode = null;
        while (start != end) {
            Node temp = start.next;
            start.next = preNode;
            preNode = start;
            start = temp;
        }
        if (preNode != null) {
            preNode.next = nextNode;
        }
        return end;
    }

    public static void main(String[] args) {
        Solution_113 solution_113 = new Solution_113();

        Node head = new Node(1);
        Node next = new Node(2);
        Node next1 = new Node(3);
        Node next2 = new Node(4);
        Node next3 = new Node(5);
        head.next = next;
        next.next = next1;
        next1.next = next2;
        next2.next = next3;

        Node res = solution_113.reverseKGroup(head, 2);

        System.out.println(res.value);
    }
}
