import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class setOfStack {
    static ArrayList<Stack> stacks;
    static int threshold = 0;
    static int count;

    private static void initalization(int t) {
        threshold = t;
        stacks = new ArrayList<Stack>();
        count = 0;
    }

    private static void push(int val) {

        if (stacks.size() == 0 || count == threshold) {
            Stack s = new Stack();
            stacks.add(s);
            stacks.get(stacks.size() - 1).push(val);
            count = 1;
        } else if (count < threshold) {
            stacks.get(stacks.size() - 1).push(val);
            count++;
        }
    }

    private static void pop() {
        int i = 1;
        while (stacks.size() - i >= 0 && stacks.get(stacks.size() - i).isEmpty()) {
            i++;
        }
        if (stacks.size() - i < 0) {
            System.out.println("Stack is empty");

        } else {
            System.out.println(stacks.get(stacks.size() - i).pop());
        }

    }

    private static void popAt(int a) {
        System.out.println(stacks.get(a).pop());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Threshold Value");
        int t = sc.nextInt();
        initalization(t);
        int x = 1;
        while (x == 1 || x == 2) {
            System.out.println("Enter Values for Stack");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. PopAt");
            x = sc.nextInt();
            if (x == 1) {
                System.out.println("Enter Value");
                int val = sc.nextInt();
                push(val);
            } else if (x == 2) {
                pop();
            } else if (x == 3) {
                System.out.println("Enter Stack index");
                int index = sc.nextInt();
                popAt(index);
            }
        }
    }
}
