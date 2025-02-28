
// Write code to remove duplicates from an unsorted linked list.
import java.util.Scanner;

class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class RemoveDuplicates {
    public static Node removeDuplicate(Node head) {
        if (head == null)
            return null;
        // Node prev = null;
        Node current = null;
        current = head;
        // HashSet<Integer> data = new HashSet<>();
        // while (current != null) {
        // if (data.contains(current.data)) {
        // prev.next = current.next;
        // current = current.next;
        // continue;
        // }
        // data.add(current.data);
        // prev = current;
        // current = current.next;
        // }
        while (current != null) {
            Node runner = current;
            while (runner != null && runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    public static void printNode(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of Nodes");
        int totalNodes = sc.nextInt();
        Node head = new Node(1);
        Node temp = head;
        System.out.println("Enter Value of Nodes");
        for (int i = 0; i < totalNodes; i++) {
            int val = sc.nextInt();
            Node temp2 = new Node(val);
            temp.next = temp2;
            temp = temp.next;
        }
        removeDuplicate(head.next);
        System.out.println("After Removing Duplicates");
        printNode(head.next);
        sc.close();
    }
}