public class Solution {
    // leetcode 813. Largest Sum of Averages

    public double largestSumOfAverages(int[] nums, int k) {
        // 누적합 데이터 저장
        double[] prefixSum = new double[nums.length];
        prefixSum[0] = nums[0];

        for(int i=1; i<prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i-1] + nums[i];
        }

        // 메모이제이션
        // start 인덱스와 남은 집합수에 따른 max 평균값 저장
        double[][] memo = new double[nums.length][k+1];

        return divide(prefixSum, k, 0, memo);
    }

    public double divide(double[] prefixSum, int k, int start, double[][] memo){
        // K개로 배열이 잘 분할 되었다면 정상 탈출
        if(k == 0 && start == prefixSum.length){
            return 0;
        }
        // 제대로 분할되지 않은 경우 버리는 값으로 탈출
        if(k == 0 || start == prefixSum.length){
            return Double.NEGATIVE_INFINITY;
        }

        // 메모한 데이터 return
        if(memo[start][k] != 0){
            return memo[start][k];
        }

        // max 평균값 구하기
        double max = 0;
        for(int end=start; end<prefixSum.length; end++){
            // 현재 인덱스의 평균값
            double startSum = 0;
            if (start > 0) startSum = prefixSum[start - 1];
            double avg = (prefixSum[end] - startSum) / (end - start + 1);

            // recursive로 분할된 배열의 평균값 계산
            double result = avg + divide(prefixSum, k - 1, end + 1, memo);

            // 비교하여 max 값 저장
            max = Math.max(max, result);
        }
        // start에서 k개의 집합수가 남았을 때 max 값 메모
        return memo[start][k] = max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // make testcase
//        int[] nums = {4,1,7,5,6,2,3};
//        int k = 4;
//        int[] nums = {9, 1, 2, 3, 9};
//        int k = 3;
        int[] nums = {4663,3020,7789,1627,9668,1356,4207,1133,8765,4649,205,6455,8864,3554,3916,5925,3995,4540,3487,5444,8259,8802,6777,7306,989,4958,2921,8155,4922,2469,6923,776,9777,1796,708,786,3158,7369,8715,2136,2510,3739,6411,7996,6211,8282,4805,236,1489,7698};
        int k = 17;

        // excute
        // run time
        long startTime = System.nanoTime();
        System.out.println("answer : " + solution.largestSumOfAverages(nums, k));
        long endTime = System.nanoTime();
        System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}