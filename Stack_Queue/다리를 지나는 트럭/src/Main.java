public class Main {

    // test case
    static int bridge_length = 2;
    static int weight = 10;
    static int [] truck_weights = {7, 4, 5, 6};

    // algorithm solution
    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int [] truck = new int[truck_weights.length];
            int answer = 0;
            int truckIdx = 0;
            int raise = 0;
            while(true){
                if(check(truck, bridge_length)){
                    break;
                }
                for(int i=0; i<truck.length; i++){
                    if(truck[i] >= bridge_length){
                        raise -= truck_weights[i];
                        truck_weights[i] = 0;
                    }
                }
                for(int i=0; i<truck.length; i++) {
                    if (truck[i] > 0 && truck[i] < bridge_length) {
                        truck[i]++;
                    }
                }
                if(truckIdx < truck_weights.length && raise + truck_weights[truckIdx] <= weight){
                    raise += truck_weights[truckIdx];
                    truck[truckIdx++] += 1;
                }
                answer++;
            }
            return answer + 1;
        }

        public boolean check(int[] truck, int bridge_length){
            for(int i=0; i<truck.length; i++){
                if(truck[i] < bridge_length)
                    return false;
            }
            return true;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(bridge_length,weight,truck_weights);
        System.out.println(answer);
    }
}