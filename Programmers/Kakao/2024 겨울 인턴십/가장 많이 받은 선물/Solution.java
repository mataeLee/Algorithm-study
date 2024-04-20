import java.util.*;

public class Solution {
    // 프로그래머스 - 가장 많이 받은 선물
    static String[] friends = {"muzi", "ryan", "frodo", "neo"};
    static String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

    public int solution(String[] friends, String[] gifts) {
        // friends 인덱스 맵 세팅
        Map<String, Integer> friendsMap = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            friendsMap.put(friends[i], i);
        }

        // gifts 내역, 선물지수 정리
        int[][] giftCount = new int[friends.length][friends.length];
        int[] giftScore = new int[friends.length];
        for(int i=0; i<gifts.length; i++){
            String[] args = gifts[i].split(" ");

            giftCount[friendsMap.get(args[0])][friendsMap.get(args[1])]++;
            giftScore[friendsMap.get(args[0])]++;
            giftScore[friendsMap.get(args[1])]--;
        }

        // 받을 선물 계산
        int[] receiveCount = new int[friends.length];
        for(int i=0; i<friends.length; i++){

            for(int j=i+1; j<friends.length; j++){
                // 서로간 선물 수 계산
                if(giftCount[i][j] > giftCount[j][i]){
                    receiveCount[i]++;
                }
                else if(giftCount[i][j] < giftCount[j][i]){
                    receiveCount[j]++;
                }
                else{
                    // 서로간 선물 수 같은경우 선물지수 계산
                    if(giftScore[i] > giftScore[j]){
                        receiveCount[i]++;
                    }
                    else if(giftScore[i] < giftScore[j]){
                        receiveCount[j]++;
                    }
                }
            }
        }

        return Arrays.stream(receiveCount).max().getAsInt();
    }

    // result
    public static void main(String[] args) {
        Solution main = new Solution();
//        main.solution(rc, operations);
//        TreeNode node = main.solution();
        System.out.println(main.solution(friends, gifts));
//        System.out.println(Result.literal(main.solution(coin, cards))); //2번
//        System.out.println(Result.one_demension(main.solution(dice))); // 3번
//        System.out.println(Result.two_demension(main.solution(rc, operations)));
    }
}