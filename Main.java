import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(32));//binary 100000
        System.out.println(solution.solution(9));//binary 1001
        System.out.println(solution.solution(1041));//binary 10000010001
        System.out.println(solution.solution(15));//binary 1111
        System.out.println(solution.solution(1));//binary 1
        System.out.println(solution.solution(561892));
    }
}

class Solution {
    public int solution(int n) {
        int numberOfTrailingZeros;
        int maxLoop = 31 - Integer.numberOfLeadingZeros(n); //31 because last bit left is irrelevant to result
        int result = 0;
        boolean firstOneBit = false;
        for (int i = 0; i < maxLoop; i++) {
            numberOfTrailingZeros = Integer.numberOfTrailingZeros(n);
            if (numberOfTrailingZeros == 0) {
                n = n >> 1;
                firstOneBit = true;
            } else if (numberOfTrailingZeros == 1) {
                n = n >> 1;
                if (firstOneBit) result = Math.max(numberOfTrailingZeros, result);
            } else {
                n = n >> numberOfTrailingZeros;
                i += numberOfTrailingZeros - 1;
                if (firstOneBit) result = Math.max(numberOfTrailingZeros, result);
            }
            System.out.println(Integer.toBinaryString(n));
        }
        return result;
    }
}