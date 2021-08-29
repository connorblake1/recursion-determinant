import java.util.Scanner;

public class DeterminantRunner
{

    public static void main(String[] args)
    {
        Scanner keyReader = new Scanner(System.in);
        System.out.print("Enter the size of the matrix: ");

        int N = keyReader.nextInt();

        if (N<1)
            throw new RuntimeException("Error. Enter a positive integer.");

        int[][] matrix = generateMatrix(N);

        showMatrix(matrix);

//        System.out.println("Copy and paste this into Wolfram Alpha:");
//        System.out.print("determinant of {");
//        for (int r = 0; r<N; r++)
//        {
//            System.out.print("{");
//            for (int c=0; c<N; c++)
//            {
//                System.out.print(matrix[r][c]);
//                if (c<N-1)
//                    System.out.print(",");
//            }
//            System.out.print("}");
//            if (r<N-1)
//                System.out.print(",");
//        }
//        System.out.println("}");

        System.out.print("I calculate the determinant to be: ");
        System.out.println(getDeterminant(matrix));
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        for (int r=0; r<n; r++)
            for (int c=0; c<n; c++)
                result[r][c] = (int)(Math.random()*200-100);
        return result;}
    public static long getDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n == 2) {
            return matrix[1][1]*matrix[0][0]-matrix[1][0]*matrix[0][1];}
        long r = 0;
        for (int i = 0; i < n; i++) {
            int s = 1-2*(i%2); //1 or -1 for even and odd respectively
            r += matrix[0][i]*s*getDeterminant(subDivide(matrix,i));}
        return r;}
    public static int[][] subDivide(int[][] m, int index) {
        int n = m.length;
        int [][] r = new int[n-1][n-1];
        for (int i = 0; i < n; i++) {
            if (i!=index) {
                int modI = (i >= index) ? i-1 : i;
                for (int y = 1; y < n; y++) {
                    r[y-1][modI] = m[y][i];}}}
        return r;}
    public static void showMatrix(int [][] m) {
        System.out.println("Matrix:");
        for (int[] row: m){
            for (int x: row)
                System.out.printf("%4d ",x);
            System.out.println("");}}}
