import java.util.*;

public class Main {
    // test case

    static int[] priorities = {1, 1, 9, 1, 1, 1};
    static int location = 0;

    // algorithm solution
    static class Solution {
        class Document{
            public int priority;
            public int index;

            public Document(int priority, int i) {
                this.priority = priority;
                this.index = i;
            }
        }
        public int solution(int[] priorities, int location) {

            Queue<Document> queue = new LinkedList<>();

            List<Document> print = new ArrayList<>();

            for(int i=0; i<priorities.length; i++){
                Document document = new Document(priorities[i], i);
                queue.add(document);
            }

            while(true){
                if(print.size()==priorities.length)
                    break;
                Document current = queue.poll();
                Iterator<Document> iterator = queue.iterator();
                if(isPrintable(iterator, current.priority)){
                    print.add(current);
                }
                else {
                    queue.add(current);
                }
            }
            int answer = -1;
            for(int i=0; i<print.size(); i++){
                if(location == print.get(i).index) {
                    answer = i + 1;
                    break;
                }
            }
            return answer;
        }
        public boolean isPrintable(Iterator<Document> iterator, int current){
            while (iterator.hasNext()){
                if(current < iterator.next().priority){
                    return false;
                }
            }
            return true;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(priorities, location);
        System.out.println(answer);
    }

}
