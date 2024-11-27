import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class myQueue {
    private static Stack<Integer> Queuestack;

    private static void implementation() {
        Queuestack = new Stack<>();
    }

    private static void enqueue(int val) {
        Queuestack.push(val);
    }

    private static void poll() {
        if (Queuestack.isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            Stack<Integer> newStack = new Stack<>();
            while (!Queuestack.isEmpty()) {
                newStack.push(Queuestack.pop());
            }
            System.out.println(newStack.pop());
            while (!newStack.isEmpty()) {
                Queuestack.push(newStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1;
        implementation();
        while (x == 1 || x == 2) {
            System.out.println("1. Enqueue");
            System.out.println("2. Poll");
            x = sc.nextInt();
            if (x == 1) {
                System.out.println("Enter the element to be added");
                int val = sc.nextInt();
                enqueue(val);
            }
            if (x == 2) {
                poll();
            }
        }

    }
}