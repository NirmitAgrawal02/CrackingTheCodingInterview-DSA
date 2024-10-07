// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.util.HashSet;
class HelloWorld {
    public static boolean permutations(String s, String p)
    {
        if( s.length() != p.length())
        {
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++)
        {
            if(count[i] != 0)
            {
                return false;
            }
        }
        return true;
    }
     public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String input = sc.nextLine();
        System.out.println("Enter a String");
        String input1 = sc.nextLine();

        System.out.println(permutations(input, input1));
    }
}
