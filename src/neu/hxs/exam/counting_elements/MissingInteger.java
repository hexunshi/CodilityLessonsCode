package neu.hxs.exam.counting_elements;


import java.util.Arrays;

/**
 * This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class MissingInteger {
    public int solution(int[] A) {
        int i = 0;
        int n = A.length;
        if (n == 1)
            return A[0] == 1 ? 2 : 1;
        while (i < n) {
            if (A[i] == i + 1)
                i++;
            else {
                if (0 < A[i] && A[i] <= n && A[A[i] - 1] != A[i]) {
                    int t = A[i];
                    A[i] = A[t - 1];
                    A[t - 1] = t;
                } else
                    i++;
            }
//            System.out.println(i + ":" + Arrays.toString(A));
        }
        for (i = 0; i < n; i++)
            if (A[i] != i + 1)
                return i + 1;

        return n + 1;
    }

    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        System.out.println(missingInteger.solution(new int[]{1, -3, 2, 4, 5}));
    }
}
