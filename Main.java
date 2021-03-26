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

//        System.out.println(solution.solution(32));//binary 100000
//        System.out.println(solution.solution(9));//binary 1001
//        System.out.println(solution.solution(1041));//binary 10000010001
//        System.out.println(solution.solution(15));//binary 1111
//        System.out.println(solution.solution(1));//binary 1

        System.out.println(solution.solutionStringStream(32));//binary 100000
        System.out.println(solution.solutionStringStream(9));//binary 1001
        System.out.println(solution.solutionStringStream(1041));//binary 10000010001
        System.out.println(solution.solutionStringStream(15));//binary 1111
        System.out.println(solution.solutionStringStream(1));//binary 1

//        double start = System.currentTimeMillis();
//        for (int i = 0; i < 100_00; i++) {
//            solution.solutionString(random.nextInt(Integer.MAX_VALUE - 1 + 1) + 1);
//        }
//        System.out.println("Execution time: " + (System.currentTimeMillis() - start));
    }
}

class Solution {
    public int solution(int n) {
        int numberOfTrailingZeros;
        int result = 0;
        for (int i = 0; i < 32 - Integer.numberOfLeadingZeros(n); i++) {
            numberOfTrailingZeros = Integer.numberOfTrailingZeros(n);
            if (numberOfTrailingZeros == 0) {
                n = n >> 1;
            } else {
                n = n >> numberOfTrailingZeros;
                i += numberOfTrailingZeros;
                result = Math.max(numberOfTrailingZeros, result);
            }
        }
        return result;
    }

    public int solutionString(int n) {
        if (Integer.bitCount(n) == 1) return 0;
        String[] arr = Integer.toBinaryString(n).split("1");
        if (arr.length == 0) return 0;
        if (arr.length == 2) return arr[1].length();
        Arrays.sort(arr);
        return arr[arr.length - 1].length();
    }

    public int solutionStringStream(int n) {
        String result = Arrays.stream(Integer.toBinaryString(n).split("1"))
                .filter(element -> !element.equals(""))
                .max((a, b) -> a.length() > b.length() ? 1 : 0).get();
        return result.length();
    }
}