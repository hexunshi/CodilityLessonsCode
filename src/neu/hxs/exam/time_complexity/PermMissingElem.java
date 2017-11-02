package neu.hxs.exam.time_complexity;


public class PermMissingElem {
    private int solution(int[] A) {
        int N = A.length+1;
        double mean = (1+N)/2.0;
        double miss = 0.0;
        for (int a : A)
            miss += a - mean;
        return (int)(mean-miss);
    }

    public static void main(String[] args) {
        double a = Math.sqrt(2);
        System.out.println(a*a);
    }
}
