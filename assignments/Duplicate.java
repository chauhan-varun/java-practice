import java.util.HashMap;
import java.util.Map;

public class Duplicate {
    public static void findDuplicate(int[] arr) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int it : arr) {
            mpp.put(it, mpp.getOrDefault(it, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : mpp.entrySet()) {
            if (e.getValue() > 1)
                System.out.println(e.getKey());
        }
    }

    public static void findFrequency(int[] arr) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int it : arr) {
            mpp.put(it, mpp.getOrDefault(it, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : mpp.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public static void rotateArr(int[] arr, int k) {
        int n = arr.length;
        k %= n;

        reverse(arr, 0, k - 1);

        reverse(arr, k, n - 1);

        reverse(arr, 0, n - 1);
    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
    }

    public static void pairSum(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == x) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }

    public static int maxSumSubArr(int[] arr) {
        int n = arr.length, sum = 0, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
            }
            if (sum < 0)
                sum = 0;
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // findDuplicate(arr);
        // findFrequency(arr);
        // rotateArr(arr, 5);
        // pairSum(arr, 10);
        System.out.println(maxSumSubArr(arr));

    }
}
