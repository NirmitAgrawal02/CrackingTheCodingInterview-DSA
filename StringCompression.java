// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.lang.Math;
class HelloWorld {
    public static void stringCompression(String input)
    {
        String res = "";
        int count = 1, i = 1;
        while(i <= input.length())
        {
            if(i == input.length())
            {
                res = res + input.charAt(i -1) + count;
                break;
            }
            else if(i < input.length())
            {
                if(input.charAt(i) != input.charAt(i-1))
                {
                    res = res+input.charAt(i-1) + count;
                    count = 1;
                }
                else 
                {
                    count ++;
                }
            }
            i++;
        }
        System.out.println(res);
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String input = sc.nextLine();
        stringCompression(input);
    }
}
