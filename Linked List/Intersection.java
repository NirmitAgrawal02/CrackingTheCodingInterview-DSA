import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Intersection {

    public static boolean intersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return false;
        }
        Node temp1 = head1, temp2 = head2;
        int c1 = 0, c2 = 0;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null && c1 < 1) {
                temp1 = head2;
                c1++;
            }
            if (temp2 == null && c2 < 1) {
                temp2 = head1;
                c2++;
            }
            if ((temp1 == null && c1 == 1) || (temp2 == null && c2 == 1)) {
                return false;
            }
            if (temp1 == temp2) {
                return true;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
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
        return head.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Values for Linked List 1");
        System.out.println("Enter total Number of Nodes");
        int n = sc.nextInt();
        Node i1 = new Node(1);
        Node head1 = input(sc, i1, n);
        System.out.println("Enter Values for Linked List 2");
        Node i2 = new Node(1);
        System.out.println("Enter total Number of Nodes");
        int j = sc.nextInt();
        Node head2 = input(sc, i2, j);
        head1.next = head2;
        System.out.println(intersection(head1, head2));
    }
}
