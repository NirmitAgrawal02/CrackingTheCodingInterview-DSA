import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class minStack {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int minimum = Integer.MAX_VALUE;

    public static int push(Scanner sc, Stack<Integer> stack, int count) {
        System.out.println("Enter the value");
        int value = sc.nextInt();
        stack.push(value);
        minimum = Math.min(value, minimum);
        map.put(count, minimum);
        return count + 1;
    }

    public static int pop(Stack<Integer> stack, int count) {
        if (stack.isEmpty()) {
            return 0;
        }
        System.out.println(stack.pop());
        return count - 1;
    }

    public static void peek(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("stack is Empty");
        }
        System.out.println(stack.peek());
    }

    public static void minimum(Stack<Integer> stack, int count) {
        if (stack.isEmpty()) {
            System.out.println("stack is Empty");
        }
        System.out.println(map.get(count - 1));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack();
        int count = 0;
        do {
            System.out.println("What operation do you want to perform");
            System.out.println("1. Push \n 2. Pop 2 \n 3. Peek 3 \n 4. getMinimum");
            int operation = sc.nextInt();
            if (operation == 1) {
                count = push(sc, stack, count);
            } else if (operation == 2) {
                count = pop(stack, count);
            } else if (operation == 3) {
                peek(stack);
            } else if (operation == 4) {
                minimum(stack, count);
            } else {
                break;
            }
        } while (true);
    }
}
