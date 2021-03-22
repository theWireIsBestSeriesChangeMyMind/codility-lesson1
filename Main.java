import java.util.Arrays;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Random random = new Random();//use random instead of casting mat random to int
        Solution solution = new Solution();
//        System.out.println(solution.solutionString(32));//binary 100000
//        System.out.println(solution.solutionString(9));//binary 1001
//        System.out.println(solution.solutionString(1041));//binary 10000010001
//        System.out.println(solution.solutionString(15));//binary 1111
//        System.out.println(solution.solutionString(1));//binary 1
        double start = System.currentTimeMillis();
        for (int i = 0; i < 100_00; i++) {
            solution.solutionString(random.nextInt(Integer.MAX_VALUE - 1 + 1) + 1);
            //solution.solutionString((int)(Math.random() * (Integer.MAX_VALUE - 1) + 1));
        }
        System.out.println("Execution time: " + (System.currentTimeMillis() - start));
    }
}

class Solution {
    public int solution(int N) {

//        Integer.bitCount(N);
//        return Integer.numberOfLeadingZeros(N);
//        return Integer.numberOfTrailingZeros(N);

        return 0;
    }

    public int solutionString(int N) {
        if (Integer.bitCount(N) == 1) return 0;
        String[] arr = Integer.toBinaryString(N).split("1");
        if (arr.length == 0) return 0;
        if (arr.length == 2) return arr[1].length();
        Arrays.sort(arr);
        return arr[arr.length - 1].length();
    }
}