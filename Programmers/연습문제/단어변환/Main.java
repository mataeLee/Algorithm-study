import java.util.*;
public class Main {

    // test case
    static String begin = "hit";
    static String target = "cog";
    //static String [] words = {"hhh","hht"};
    static String [] words = {"hot", "dot", "dog", "lot", "log", "cog"};

    // algorithm solution
    static class Solution {
        static int graph[][];
        public int solution(String begin, String target, String[] words) {
            int answer = 0;

            if(!check(words, target))
                return 0;

            ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
            wordList.add(0, begin);

            graph = new int[words.length+1][words.length+1];
            for(int i=0; i<wordList.size(); i++){
                String word = wordList.get(i);
                for (int j=0; j<wordList.size(); j++){
                    if(i!=j && compare(word, wordList.get(j))){
                        graph[i][j] = 1;
                    }
                }
            }
            boolean [] visited = new boolean[words.length+1];
            answer = bfs(visited, 0, target, wordList, answer);
            return answer;
        }

        public int bfs(boolean[] visited, int s, String target, List<String> wordList, int answer) {
            LinkedList<Integer> queue = new LinkedList<>();

            visited[s] = true;
            queue.add(s);
            while (true) {
                if(wordList.get(s).equals(target))
                    return answer;

                if(!queue.isEmpty())
                    s = queue.poll();
                else{
                    answer++;
                    for (int i = 0; i < wordList.size(); i++) {
                        if (!visited[i] && graph[s][i] == 1) {
                            visited[i] = true;
                            queue.add(i);
                        }
                    }
                }
            }
        }

        public boolean compare(String word1, String word2){
            int cnt=0;
            for(int i=0; i<word1.length(); i++){
                if(word1.charAt(i) != word2.charAt(i)) {
                    cnt++;
                }
                if(cnt > 1) return false;
            }
            return true;
        }

        public boolean check(String[] words, String target){
            for(int i=0; i<words.length; i++){
                if(words[i].equals(target))
                    return true;
            }
            return false;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(begin, target, words);
        System.out.println(answer);
    }
}