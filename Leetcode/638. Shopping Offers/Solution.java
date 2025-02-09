import java.util.*;

public class Solution {
    // leetcode 638.Shopping Offers

    public static int answer = 0;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        for(int i=0; i<needs.size(); i++) {
            answer += needs.get(i) * price.get(i);
        }

        trackLowestPrice(price, special, needs, 0);

        return answer;
    }

    public void trackLowestPrice(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int sum){
        for(int i=0; i<needs.size(); i++){
            if(needs.get(i) < 0) return;
        }

        for(int i=0; i<special.size(); i++){
            List<Integer> specialItems = special.get(i);
            int specialSum = specialItems.get(specialItems.size()-1);
            int regularSum = 0;
            for(int j=0; j<specialItems.size()-1; j++){
                regularSum += specialItems.get(j) * price.get(j);
            }
            if(regularSum <= specialSum){
                special.remove(i);
            }
        }

        boolean check = true;
        for(int i=0; i<needs.size(); i++){
            if(needs.get(i) != 0){
                check = false;
                break;
            }
        }

        if(check){
            answer = Math.min(answer, sum);
            return;
        }

        int failCount = 0;
        for(int i=0; i<special.size(); i++){
            List<Integer> specialItems = special.get(i);
            boolean specialCheck = true;
            for(int j=0; j<specialItems.size()-1; j++){
                if(needs.get(j) < specialItems.get(j)) {
                    failCount++;
                    specialCheck = false;
                    break;
                }
            }
            if(specialCheck){
                for(int j=0; j<specialItems.size()-1; j++){
                    needs.set(j, needs.get(j)-specialItems.get(j));
                }
                trackLowestPrice(price, special, needs, sum+specialItems.get(specialItems.size()-1));
                for(int j=0; j<specialItems.size()-1; j++){
                    needs.set(j, needs.get(j)+specialItems.get(j));
                }
            }
        }
        if(failCount == special.size()){
            int eachSum = 0;
            for(int i=0; i<needs.size(); i++){
                eachSum += needs.get(i) * price.get(i);
            }
            answer = Math.min(answer, sum + eachSum);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // make testcase
//        Integer[] priceArr = {2, 5};
//        Integer[] data1Arr = {3, 0, 5};
//        Integer[] data2Arr = {1, 2, 10};
//        Integer[] needsArr = {3, 2};
        Integer[] priceArr = {9};
        Integer[] data1Arr = {1, 10};
        Integer[] data2Arr = {2, 2};
        Integer[] needsArr = {3};

        List<Integer> price = Arrays.asList(priceArr);

        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(data1Arr));
        special.add(Arrays.asList(data2Arr));

        List<Integer> needs = Arrays.asList(needsArr);

        System.out.println(solution.shoppingOffers(price, special, needs));
    }
}