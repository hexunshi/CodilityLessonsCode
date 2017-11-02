package neu.hxs.exam.iterations;

import java.util.Arrays;

/**
 * A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is also moved to the first place.
 * <p>
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times; that is, each element of A will be shifted to the right by K indexes.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution,
 */
public class CyclicRotation {
    private int[] solution(int[] A, int K) {
        int len = A.length;
        if (len > 0) {
            K = K % len;
            if (K > 0) {
                for (int i = len - 1; i >= 0; i--) {
                    if (i >= K) {
                        int temp = A[i - K];
                        A[i - K] = A[i];
                        A[i] = temp;
                    }
                }
                len = K;
                K = A.length % K;
                int[] a = Arrays.copyOf(A, len);
                for (int i = 0; i < len; i++)
                    A[i] = a[(i + K) % len];
            }
        }
        return A;
    }

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        System.out.println(Arrays.toString(cyclicRotation.solution(new int[]{1, 2, 3, 4, 5, 6}, 3)));
    }
}
