import java.util.*;

public class Main {
    //test case
    static String skill = "CBD";
    static String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

    //algorithm solution
    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            int cnt = 0;
            int idx;
            for(int i=0; i<skill_trees.length; i++){
                String str = skill_trees[i];
                idx = 0;
                for(int j=0; j<str.length(); j++) {
                    if(idx == skill.length()) break;
                    if(!check(str, skill, idx, j)) {
                        cnt++;
                        break;
                    }
                    if(str.charAt(j) == skill.charAt(idx))
                        idx++;
                }
            }
            return skill_trees.length - cnt;
        }

        public boolean check(String str, String skill, int idx, int j){
            for(int k=0; k<skill.length(); k++){
                if(k != idx && skill.charAt(k) == str.charAt(j)){
                    return false;
                }
            }
            return true;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(skill, skill_trees);
        System.out.println(answer);
    }
}