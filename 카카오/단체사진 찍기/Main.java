import java.util.*;

public class Main {
    //test case
    static String[] data = {"N~F=0", "R~T>2"};
    static int n = 2;

    //algorithm solution
    static class Solution {
        static int answer;
        static Map<Character, Integer> map;
        static int[] idx;
        public int solution(int n, String[] data) {
            // A, C, F, J, M, N, R, T
            // 0, 1, 2, 3, 4, 5, 6, 7
            int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
            idx = new int[8];
            boolean[] visited = new boolean[8];
            map = new HashMap<>();
            map.put('A', 0); map.put('C', 1); map.put('F', 2); map.put('J', 3); map.put('M', 4); map.put('N', 5); map.put('R', 6); map.put('T', 7);
            answer = 0;

            permutation(arr, visited, idx, data,0, 8, 8);
            return answer;
        }

        public void permutation(int[] arr, boolean[] visited, int[] idx, String[] data, int depth, int n, int r) {
            if (depth == r) {
                if(check(data))
                    answer++;
                return;
            }

            for (int i = 0; i < n; i++) {
                if (visited[i] != true) {
                    visited[i] = true;
//                    output[depth] = arr[i];
                    idx[arr[i]] = depth;
                    permutation(arr, visited, idx, data, depth + 1, n, r);
                    visited[i] = false;
                }
            }
        }

        public boolean check(String[] data){
            for(int i=0; i<data.length; i++){
                String con = data[i];
                int c1 = map.get(con.charAt(0));
                int c2 = map.get(con.charAt(2));
                int gap = con.charAt(4) - 48 + 1;
                int gap2;
                switch (con.charAt(3)){
                    case '=':
                        gap2 = (idx[c1] < idx[c2])? idx[c2] - idx[c1] : idx[c1] - idx[c2];
                        if(gap == gap2)break;
                        else return false;
                    case '>':
                        gap2 = (idx[c1] < idx[c2])? idx[c2] - idx[c1] : idx[c1] - idx[c2];
                        if(gap < gap2)break;
                        else return false;
                    case '<':
                        gap2 = (idx[c1] < idx[c2])? idx[c2] - idx[c1] : idx[c1] - idx[c2];
                        if(gap > gap2)break;
                        else return false;
                }
            }
            return true;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(n, data);
        System.out.println(answer);
    }
}