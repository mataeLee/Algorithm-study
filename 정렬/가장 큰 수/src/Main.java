import java.util.*;
public class Main {

    // test case
    static int [] numbers = {0,0,0,0};

    // algorithm solution
    static class Solution {
        static class Number implements Comparable<Number>{
            public String num;

            @Override
            public int compareTo(Number number) {
                return (number.num+num).compareTo(num+number.num);
            }
        }

        public String solution(int[] numbers) {
            String answer = "";

            List<Number> numberList = new ArrayList<>();
            for(int i=0; i<numbers.length; i++){
                Number number = new Number();
                number.num = numbers[i]+"";
                numberList.add(number);
            }
            Collections.sort(numberList);
            if(numberList.get(0).num.equals("0"))
                return "0";
            for(int i=0; i<numberList.size(); i++){
                answer += numberList.get(i).num;
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        String  answer = solution.solution(numbers);
        System.out.println(answer);
    }
}