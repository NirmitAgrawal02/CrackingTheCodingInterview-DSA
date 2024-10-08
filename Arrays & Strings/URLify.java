
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;

class uRLIfy {
    public static void urlIfy(String input, int length) {
        if (input == "") {
            System.out.println("No Input String Provided");
        }
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');

            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        /**
         * int spaces = 0;
         * for(char c : input.toCharArray())
         * {
         * // System.out.println(c);
         * if(c == ' ')
         * {
         * spaces++;
         * }
         * }
         * char[] result = new char[length + spaces + spaces];
         * int i = 0;
         * for(char c : input.toCharArray())
         * {
         * // System.out.println(c);
         * if(c == ' ')
         * {
         * result[i] = '%';
         * result[++i] = '2';
         * result[++i] = '0';
         * i++;
         * }
         * else
         * {
         * result[i] = c;
         * i++;
         * }
         * }
         * System.out.println(new String(result));
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String input = sc.nextLine();
        urlIfy(input, input.length());
        sc.close();
    }
}
