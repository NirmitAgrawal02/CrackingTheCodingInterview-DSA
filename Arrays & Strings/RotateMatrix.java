// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.lang.Math;
class HelloWorld {
    public static void rotateMatrix(int matrix[][])
    {
        int m = matrix.length;
        int n = matrix[0].length;
        // Transposing the matrix
        for(int i = 0; i < m; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;
            }
        }
        // Switch places of column values in matrix
        for(int i =0; i < m; i++)
        {
            for(int j = 0; j < n/2; j++)
            {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = swap;
            }
        }
        for(int i = 0; i< m; i++)
        {
            System.out.println();
            for(int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row length of Matrix");
        int m = sc.nextInt();
        System.out.println("Enter the column length of Matrix");
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        System.out.println("Enter the Matrix values");
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int k = sc.nextInt();
                matrix[i][j] = k;
            }
        }
        String input = sc.nextLine();
        rotateMatrix(matrix);
    }
}
