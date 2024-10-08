import java.util.Scanner;
import java.util.HashMap;

class Node {
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
    }
}

class Kth {
    public static Node removeKth(Node head, int k) {
        if (head == null) {
            return null;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        Node curr = head;
        int count = 0;
        while (curr != null) {
            map.put(count, curr);
            count++;
            curr = curr.next;
        }
        if (count < k) {
            return null;
        }
        return map.get(count - k);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of nodes");
        int length = sc.nextInt();
        Node head = new Node(0);
        Node curr = head;
        System.out.println("Enter data for nodes");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            curr.next = new Node(val);
            curr = curr.next;
        }
        System.out.println("Enter Removing Element number");
        int k = sc.nextInt();
        Node result = removeKth(head.next, k);
        if (result == null)
            System.out.println("Null Value Provided");
        else {
            System.out.println(result.data);
        }
    }
}