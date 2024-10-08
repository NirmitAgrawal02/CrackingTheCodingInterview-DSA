import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class LoopDetection {

    public static boolean cycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

        }
        return false;
    }

    public static Node input(Scanner sc, Node head, int n) {
        System.out.println("Enter value of Nodes");
        Node curr = head;
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            curr.next = new Node(data);
            curr = curr.next;
        }
        curr.next = head.next.next.next;
        return head.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total Number of Nodes");
        int n = sc.nextInt();
        Node i1 = new Node(1);
        Node head1 = input(sc, i1, n);
        System.out.println(cycle(head1));
    }
}
