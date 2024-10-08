// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.lang.Math;
class HelloWorld {
    public static void isSubstring(String input, String substring)
    {
        if(input.length() != substring.length())
        {
            System.out.println("Strings are not the same");
        }
        if(input == "")
        {
            System.out.println("empty string provided");
        }
        char ch = input.charAt(0);
        int index = substring.indexOf(ch);
        if(index == -1)
        {
            System.out.println("Strings are not the same");
        }
        else
        {
            if(input.substring(0, input.length() - index).equals(substring.substring(index)))
            {
                if(input.substring(input.length() - index).equals(substring.substring(0,index)))
                {
                    System.out.println(true);
                }
                else
                {
                    System.out.println(false);
                }
            }
            else
            {
                System.out.println(false);
            }
            
        }
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Orignal String");
        String input = sc.nextLine();
        System.out.println("Enter Rotated String");
        String rotatedString = sc.nextLine();
        isSubstring(input, rotatedString);
    }
}
