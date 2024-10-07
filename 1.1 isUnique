// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.util.HashSet;
class HelloWorld {
    public static boolean uniqueString(String input)
    {
        for(int i = 0; i < input.length(); i++)
        {
            if(input.indexOf(input.charAt(i),i+1) != -1)
            {
                return false;
            }
        }
        // HashSet<Character> characters = new HashSet<>();
        // for(char ch : input.toCharArray())
        // {
        //     if(characters.contains(ch))
        //     {
        //         return false;
        //     }
        //     characters.add(ch);
        // }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String input = sc.nextLine();
        System.out.println(uniqueString(input));
    }
}
