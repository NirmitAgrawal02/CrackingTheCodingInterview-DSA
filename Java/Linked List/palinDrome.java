import java.util.Scanner;
import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class palinDrome {

    public static boolean palin(Node head) {
        if (head == null) {
            return true;
        }
        Node curr = head;
        int count = 0;
        HashMap<Integer, Node> map = new HashMap<>();
        while (curr != null) {
            map.put(count++, curr);
            curr = curr.next;
        }
        int i = 0;
        count--;
        while (i < count) {
            if (map.get(i++).data != map.get(count--).data) {
                return false;
            }
        }
        return true;

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
        System.out.println("Enter total Number of Nodes");
        int n = sc.nextInt();
        Node i1 = new Node(1);
        Node head1 = input(sc, i1, n);
        System.out.println(palin(head1));
    }
}
