import java.util.Scanner;

class Node {
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
    }
}

public class deleteMiddleNode {
    public static Node deleteNode(Node mid) {
        if (mid == null) {
            return null;
        }
        if (mid.next == null) {
            return mid;
        }
        mid.data = mid.next.data;
        mid.next = mid.next.next;
        return mid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total Number of Nodes");
        int n = sc.nextInt();
        System.out.println("Enter value of Nodes");
        Node head = new Node(1);
        Node curr = head;
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            curr.next = new Node(data);
            curr = curr.next;
        }
        System.out.println("Enter the value of the node which you want to delete");
        int val = sc.nextInt();
        curr = head.next;
        while (curr != null && curr.data != val) {
            curr = curr.next;
        }
        deleteNode(curr);
        System.out.println(curr.data);
        sc.close();
    }
}
