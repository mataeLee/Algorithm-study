import java.util.*;
public class Main {

    // test case
    //static String [][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    //static String [][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}, {"ICN", "COO"}, {"COO", "ICN"}};
    //static String [][] tickets = {{"COO", "ICN"}, {"ICN", "COO"},  {"ICN", "COO"},  {"ICN", "COO"}, {"COO", "ICN"}};
    //static String [][] tickets= {{"1", "4"}, {"1", "3"}, {"3", "2"}, {"2", "1"}, {"4", "1"}};
    //static String [][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"},{"SFO","QRE"}};
    //static String [][] tickets = {{"SFO", "ATL"}, {"ICN", "SFO"}, {"ICN", "ATL"}, {"ATL", "ICN"}, {"SFO", "TPN"}, {"TPN", "ICN"}, {"ATL", "BTS"}, {"BTS", "SFO"}};
    static String [][] tickets= {{"1", "3"}, {"1", "4"}, {"2", "1"}, {"5", "2"}, {"3", "2"}, {"5", "3"}, {"4","5"}, {"2", "5"}};
    //1->3->2->1->4->5->2->5->3

    // algorithm solution
    static class Solution {
        class Ticket implements Comparable<Ticket> {
            public String from;
            public String to;
            public boolean used;

            // 정렬 방식 설정
            @Override
            public int compareTo(Ticket ticket) {
                return this.to.compareTo(ticket.to);
            }
        }

        public String[] solution(String[][] tickets) {

            Ticket[] ticketList = new Ticket[tickets.length];

            // 클래스 배열 이용
            for (int i = 0; i < tickets.length; i++) {
                Ticket ticket = new Ticket();
                ticket.from = tickets[i][0];
                ticket.to = tickets[i][1];
                ticket.used = false;
                ticketList[i] = ticket;
            }

            // 출발지
            String from = "1";

            // 갈 수 있는 경로 큐
            List<Ticket> queue;

            List<String> answers = new ArrayList<>();
            // 출발지 입력
            answers.add(from);

            while (true) {
                // 티켓 수 + 출발지 = 경로
                if (answers.size() == ticketList.length + 1)
                    break;

                queue = new ArrayList<>();

                // 현재 지점에서 갈 수 있는 경로를 큐에 입력
                for (int i = 0; i < ticketList.length; i++) {
                    if (!ticketList[i].used && ticketList[i].from.equals(from)) {
                        queue.add(ticketList[i]);
                    }
                }

                // 설정한 정렬(목적지 오름차순)방식으로 정렬
                Collections.sort(queue);

                // 갈 수 있는 경로가 여러개일 경우
                if (queue.size() > 1) {
                    for (int i = 0; i < queue.size(); i++) {
                        Ticket ticket = queue.get(i);

                        // 갈 수 있는 경로가 여러개인 경우 다시 돌아오는 경로아 있는지 체크
                        // ex) 1->3->2->1->4->1 일 때, 1->3, 1->4 티켓 둘다 사용하려면 1로 1번은 필수적으로 돌아와야함
                        if(dfs(ticketList, ticket, ticket.from)){
                            // 티켓 사용 및 답변 입력
                            answers.add(ticket.to);
                            ticket.used = true;

                            // 현재 지점 변경
                            from = ticket.to;
                            break;
                        }
                    }
                    // 갈 수 있는 경로가 하나인 경우
                } else if (queue.size() == 1 && !queue.get(0).used) {
                    // 티켓 사용 및 답변 입력
                    queue.get(0).used = true;
                    answers.add(queue.get(0).to);
                    // 현재 지점 변경
                    from = queue.get(0).to;
                }
            }

            // 정답 매핑
            String[] answer = new String[answers.size()];
            for (int i = 0; i < answers.size(); i++) {
                answer[i] = answers.get(i);
            }
            return answer;
        }

        // 경로 탐색(target 까지)
        public boolean dfs(Ticket[] ticketList, Ticket ticket, String target){
            if(ticket.to.equals(target))
                return true;

            for(int i=0; i<ticketList.length; i++){
                if(!ticketList[i].used && ticket.to.equals(ticketList[i].from)){
                    if(dfs(ticketList, ticketList[i], target)) // target까지의 경로가 나올때 까지 재
                        return true;
                }
            }
            return false;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] answer = solution.solution(tickets);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " -> ");
        }
    }
}