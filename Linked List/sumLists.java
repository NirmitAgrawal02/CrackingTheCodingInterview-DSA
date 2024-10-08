import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class sumLists {
    public static Node sum(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        int carry = 0;
        Node temp1 = head1;
        Node temp2 = head2;
        Node head = new Node(0);
        Node temp = head;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null) {
                temp.next = temp2;
                temp = temp.next;
                break;
            } else if (temp2 == null) {
                temp.next = temp1;
                temp = temp.next;
                break;
            }
            int sum = temp1.data + temp2.data + carry;
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            System.out.println(carry);
            temp.next = new Node(sum % 10);
            temp = temp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while (carry == 1) {
            if (temp.next == null) {
                temp.next = new Node(1);
                break;
            }
            int data = temp.data;
            temp.data = (carry + temp.data) % 10;
            if (carry + data < 10) {
                carry = 0;
            }
            temp = temp.next;
        }
        return head.next;
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

    public static void print(Node head) {
        if (head == null) {
            System.out.println("No Value Enteres");
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
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
        Node head = sum(head1, head2);
        print(head);
    }
}