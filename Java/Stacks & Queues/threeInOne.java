// Stack Operation - Push, pop, peek
// Queue Operation - Enqueue, dequeue, peek

import java.util.Scanner;

public class threeInOne {
    static int[] values;
    static int numStacks = 3;
    static int[] size;
    static int capacity = 0;

    private static void initalization(int sizes) {
        values = new int[sizes * 3];
        size = new int[numStacks];
        capacity = sizes;
    }

    private static void push(Scanner sc, int stackNum) {
        System.out.println("Enter the value to be pushed");
        int val = sc.nextInt();
        if (capacity == size[stackNum]) {
            System.out.println("Stack is full");
        } else {
            values[capacity * (stackNum) + size[stackNum]] = val;
            size[stackNum]++;
        }
    }

    private static void pop(int stackNum) {
        if (size[stackNum] == 0) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("The value of pop element is " + values[capacity * (stackNum) + size[stackNum] - 1]);
            size[stackNum]--;
        }
    }

    private static void peek(int stackNum) {
        if (size[stackNum] == 0) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("The Value of the top of Stack Element is"
                    + values[capacity * (stackNum) + size[stackNum] - 1]);
        }
    }

    private static void print(int stackNum) {
        for (int i = 0; i < size[stackNum]; i++) {
            System.out.println(values[capacity * (stackNum) + i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the single stack");
        int size = sc.nextInt();
        initalization(size);

        do {
            System.out.println("For which stack do you want to perform operations");
            System.out.println("1. Stack 1 \n 2. Stack 2 \n 3. Stack 3 \n 0. Exit");
            int choice = sc.nextInt();
            if (choice == 0) {
                break;
            } else {
                System.out.println("What operation do you want to perform");
                System.out.println("1. Push \n 2. Pop 2 \n 3. Peek 3 \n 4. Print");
                int operation = sc.nextInt();
                if (operation == 1) {
                    push(sc, choice - 1);
                } else if (operation == 2) {
                    pop(choice - 1);
                } else if (operation == 3) {
                    peek(choice - 1);
                } else if (operation == 4) {
                    print(choice - 1);
                }
            }
        } while (true);

    }
}
