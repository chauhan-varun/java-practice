public class MultiplyArr {
    public static void multiply(int[][] A, int[][] B) {
        int rowA = A.length, colA = A[0].length, colB = B[0].length;
        int[][] ans = new int[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    ans[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for (int[] arr : ans) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] arr2 = { { 7, 8 }, { 9, 10 }, { 11, 12 } };
        multiply(arr1, arr2);
    }
}
