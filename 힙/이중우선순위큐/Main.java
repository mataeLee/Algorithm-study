import java.util.*;

public class Main {
    //test case
    static String[] operations = {"I 16", "D 1"};

    //algorithm solution
    static class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<operations.length; i++){
                String[] str = operations[i].split(" ");
                String operation = str[0];
                int val = Integer.parseInt(str[1]);
                switch (operation){
                    case "I":
                        list.add(val);
                        Collections.sort(list);
                        break;
                    case "D":
                        switch (val){
                            case 1:
                                if(list.size() != 0)
                                    list.remove(list.size()-1);
                                break;
                            case 2:
                                if(list.size() != 0)
                                    list.remove(0);
                                break;
                        }
                        break;
                }
            }
            if(list.size() == 0)
                answer[0] = answer[1] = 0;
            else {
                answer[0] = list.get(list.size() - 1);
                answer[1] = list.get(0);
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(operations);
        System.out.println(answer);
    }
}