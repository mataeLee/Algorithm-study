import java.util.*;

public class Main {
    //test case
    static String s = "{{20,111},{111}}";

    //algorithm solution
    static class Solution {
        public int[] solution(String s) {
            s = s.substring(1,s.length()-1);
            List<Integer>[] arr = new ArrayList[500];
            Queue<Character> queue = new LinkedList<>();

            int idx = 0;

            int start = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '{'){
                    start = i+1;
                    arr[idx] = new ArrayList<>();
                    continue;
                }
                if(s.charAt(i) == ',' && arr[idx] != null){
                    arr[idx].add(Integer.parseInt(s.substring(start,i)));
                    start = i+1;
                    continue;
                }
                if(s.charAt(i) == '}'){
                    arr[idx++].add(Integer.parseInt(s.substring(start,i)));
                    continue;
                }
            }


            Arrays.sort(arr, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    if(o1 != null && o2 != null) {
                        if (o1.size() > o2.size()) return 1;
                        else if (o1.size() == o2.size()) return 0;
                        else return -1;
                    }
                    return 0;
                }
            });

            int[] answer = new int[idx];
            HashSet set = new HashSet();
            int answerIdx = 0;
            for(int i=0; i<idx; i++){
                List<Integer> list = arr[i];
                for(Integer n : list){
                    if(!set.contains(n)) {
                        set.add(n);
                        answer[answerIdx++] = n;
                    }
                }
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(s);
        System.out.println(answer);
    }
}