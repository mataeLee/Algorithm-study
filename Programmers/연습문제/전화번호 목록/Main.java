import java.util.*;
public class Main {

    // test case
    static String [] phone_book = {"12","123","1235","567","88"};

    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            String key="";

            for(int i=0; i<phone_book.length; i++){
                key = phone_book[i];
                for(int j=0; j<phone_book.length; j++){
                    if(i != j && phone_book[i].length() < phone_book[j].length()){
                        int end = key.length();
                        String front = phone_book[j].substring(0, end);
                        if(front.equals(key))
                            return false;

                    }
                }
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(phone_book));
    }
}
