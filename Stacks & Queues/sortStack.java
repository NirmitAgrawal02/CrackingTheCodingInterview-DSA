import java.util.*;
public class sortStack {
    private static void push(Scanner sc, Stack<Integer> stack) {
        System.out.println("Enter the value");
        int value = sc.nextInt();
        Stack<Integer> newStack = new Stack<>();
        while (!stack.isEmpty() && stack.peek() < value) {
            newStack.push(stack.pop());
        }
        stack.push(value);
        while (!newStack.isEmpty()) {
            stack.push(newStack.pop());
        }
    }

    private static int pop(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return stack.pop();
    }

    private static int peek(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack();
        do {
            System.out.println("What operation do you want to perform");
            System.out.println("1. Push \n 2. Pop 2 \n 3. Peek 3 \n ");
            int operation = sc.nextInt();
            if (operation == 1) {
                push(sc, stack);
            } else if (operation == 2) {
                System.out.println("Pop Element = " +pop(stack));
            } else if (operation == 3) {
                System.out.println("Peek Element = " +peek(stack));
            } else {
                break;
            }
        } while (true);
    }
}
