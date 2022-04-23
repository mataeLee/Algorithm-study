import java.util.*;

public class Main {

    // test case
    static int [] answers = {1,3,2,4,2};

    // algorithm solution
    static class Solution {
        public int[] solution(int[] answers) {
            int a=0;
            int b=0;
            int c=0;
            int [] ansa = {1,2,3,4,5};
            int [] ansb = {2,1,2,3,2,4,2,5};
            int [] ansc = {3,3,1,1,2,2,4,4,5,5};

            for(int i=0; i<answers.length; i++){
                if(answers[i]==ansa[i%ansa.length])
                    a++;
                if(answers[i]==ansb[i%ansb.length])
                    b++;
                if(answers[i]==ansc[i%ansc.length])
                    c++;
            }
            int [] count = {a, b, c};
            int max=a;
            for(int i=0; i<3; i++){
                if(max<count[i])
                    max = count[i];
            }

            List list = new ArrayList<Integer>();
            for(int i=0; i<3; i++){
                if(count[i] == max)
                    list.add(i);
            }
            int [] answer = new int[list.size()];
            for(int i=0; i<list.size();i++){
                answer[i] = (int)list.get(i)+1;
            }
            return answer;
        }
    }

        public boolean check(int[] truck, int bridge_length){
            for(int i=0; i<truck.length; i++){
                if(truck[i] < bridge_length)
                    return false;
            }
            return true;
        }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] answer = solution.solution(answers);
        for(int i=0; i<answer.length; i++) {
            System.out.print(answer[i] + ", ");
        }
    }
}