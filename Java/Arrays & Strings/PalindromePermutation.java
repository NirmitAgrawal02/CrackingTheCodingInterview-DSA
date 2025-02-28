
import java.util.Scanner;

class HelloWorld {
    public static void palindromePermutation(String input) {
        if (input == "") {
            System.out.println("No Input String Provided");
        }
        int[] count = new int[26];
        input = input.toLowerCase();
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            }
        }
        int odd_count = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                odd_count++;
            }
            if (odd_count > 1) {
                System.out.println("False");
                break;
            }
        }
        if (odd_count <= 1) {
            System.out.println("True");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String input = sc.nextLine();
        palindromePermutation(input);
        sc.close();
    }
}
