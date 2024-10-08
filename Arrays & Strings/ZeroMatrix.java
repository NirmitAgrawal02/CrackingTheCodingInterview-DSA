import java.util.Scanner;

class zeroMatrixes {
    public static void zeroMatrix(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    rows[count] = r;
                    cols[count] = c;
                    count++;
                }
            }
        }
        System.out.println(count);
        int i = 0;
        while (i < count) {
            int r = rows[i];
            int c = cols[i];
            for (int j = 0; j < m; j++) {
                matrix[j][c] = 0;
            }
            for (int j = 0; j < n; j++) {
                matrix[r][j] = 0;
            }
            i++;
        }
        for (i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = sc.nextInt();
                matrix[i][j] = k;
            }
        }
        zeroMatrix(matrix);
        sc.close();
    }
}
