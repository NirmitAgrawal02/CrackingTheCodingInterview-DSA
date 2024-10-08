import java.util.Scanner;

class Node {
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
    }
}

public class partition {
    private static Node part(Node head, int val) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        int[] arr = new int[count];
        int i = 0;
        curr = head;
        int total = count;
        while (curr != null) {
            if (curr.data >= val) {
                arr[--count] = curr.data;
            } else {
                arr[i++] = curr.data;
            }
            curr = curr.next;
        }
        Node dummy = new Node(0);
        curr = dummy;
        for (i = 0; i < total; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        head = dummy.next;
        return head;
    }

    private static void print(Node head) {
        if (head == null) {
            System.err.println("No Nodes Given");
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
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
        System.out.println("Enter the value of the partition");
        int val = sc.nextInt();
        head = part(head.next, val);
        System.out.println("Values after printing ");
        print(head);
        sc.close();
    }
}
