
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.lang.Math;

class OneAway {
    public static void oneAway(String input, String result) {
        if (Math.abs(input.length() - result.length()) > 1) {
            System.out.println("False");
        }
        int[] count = new int[26];
        for (int i = 0; i < input.length(); i++) {
            if (i == result.length()) {
                count[input.charAt(i) - 'a']++;
            } else {
                count[input.charAt(i) - 'a']++;
                count[result.charAt(i) - 'a']--;
            }
        }
        if (result.length() > input.length()) {
            count[result.charAt(result.length() - 1) - 'a']--;
        }
        int change = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                change++;
            }
        }
        if (change == 1 || change == 2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String input = sc.nextLine();
        System.out.println("Enter a String");
        String result = sc.nextLine();
        oneAway(input, result);
        sc.close();
    }
}
