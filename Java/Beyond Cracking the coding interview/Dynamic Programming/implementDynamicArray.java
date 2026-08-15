import java.util.Scanner;
/*
Assume your programming language only supports fixed-size arrays. Implement a dynamic array data structure that supports the following:

Dynamic Array API:

append(x): adds element x to the end of the array
get(i): returns the element at index i
set(i, x): updates the preexisting element at index i to be x
size(): returns the number of elements in the array
pop_back(): removes the last element
You should only declare arrays of a fixed size and not use built-in append() methods or equivalent.
Constraints:

If you are coding in a strongly typed language, you can either assume all elements are integers, or define a generic dynamic array type.
All operations should work with arrays of up to 10^6 elements
 */
public class implementDynamicArray {
    public static void append(int arr[], int value)
    {
        int size = arr.length;
        int newArr[] = new int[size+1];
        for(int i=0;i<size;i++)
        {
            newArr[i] = arr[i];
        }
        newArr[size] = value;
        arr = newArr;
    }
    public static void get(int arr[], int index)
    {
        if(index>=arr.length)
        {
            System.out.println("Index out of bounds");
            return;
        }
        System.out.println(arr[index]);
    }
    public static void set(int arr[], int index, int value)
    {
        if(index>=arr.length)
        {
            System.out.println("Index out of bounds");
            return;
        }
        arr[index] = value;
    }
    public static void size(int arr[])
    {
        System.out.println(arr.length);
    }
    public static void pop_back(int arr[])
    {
        int size = arr.length;
        if(size==0)
        {
            System.out.println("Array is empty");
            return;
        }
        int newArr[] = new int[size-1];
        for(int i=0;i<size-1;i++)
        {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the value of the array");
        for(int i=0;i<size;i++)
        {
            arr[i] = sc.nextInt();
        }
        int operation;
        do 
        {
            System.out.println("Enter the operation you want to perform");
            System.out.println("1. Append");
            System.out.println("2. Get");
            System.out.println("3. Set");
            System.out.println("4. Size");
            System.out.println("5. Pop_back");
            System.out.println("6. Quit");
            operation = sc.nextInt();
            switch(operation)
            {
                case 1:
                    System.out.println("Enter the value to append");
                    int value = sc.nextInt();
                    append(arr, value);
                    break;
                case 2:
                    System.out.println("Enter the index to get");
                    int index = sc.nextInt();
                    get(arr, index);
                    break;
                case 3:
                    System.out.println("Enter the index to set");
                    int setIndex = sc.nextInt();
                    System.out.println("Enter the value to set");
                    int setValue = sc.nextInt();
                    set(arr, setIndex, setValue);
                    break;
                case 4:
                    size(arr);
                    break;
                case 5:
                    pop_back(arr);
                    break;
                default:
                    System.out.println("Invalid operation");
            }
        }while(operation!=6);
    }
}
