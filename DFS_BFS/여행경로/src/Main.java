import java.util.*;
public class Main {

    // test case
    //static String [][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    static String [][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
    //static String [][] tickets = {{"COO", "ICN"}, {"ICN", "COO"},  {"ICN", "COO"},  {"ICN", "COO"}, {"COO", "ICN"}};
    //static String [][] tickets= {{"1", "4"}, {"1", "3"}, {"3", "2"}, {"2", "1"}, {"4", "1"}};
    //static String [][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"},{"SFO","QRE"}};

    // algorithm solution
    static class Solution {
        static class Ticket implements Comparable<Ticket> {
            public String from;
            public String to;
            public boolean used;

            @Override
            public int compareTo(Ticket ticket) {
                return this.to.compareTo(ticket.to);
            }
        }

        static List<Ticket> dfsQueue = new ArrayList();

        public String[] solution(String[][] tickets) {

            Ticket[] ticketList = new Ticket[tickets.length];

            for (int i = 0; i < tickets.length; i++) {
                Ticket ticket = new Ticket();
                ticket.from = tickets[i][0];
                ticket.to = tickets[i][1];
                ticket.used = false;
                ticketList[i] = ticket;
            }

            String from = "ICN";

            List<Ticket> queue;
            List<String> answers = new ArrayList<>();
            answers.add(from);

            while (true) {
                if (answers.size() == ticketList.length + 1)
                    break;
                //answers.add(from);
                queue = new ArrayList<>();
                for (int i = 0; i < ticketList.length; i++) {
                    if (!ticketList[i].used && ticketList[i].from.equals(from)) {
                        queue.add(ticketList[i]);
                    }
                }

                Collections.sort(queue);
                if (queue.size() > 1) {
                    for (int i = 0; i < queue.size(); i++) {
                        Ticket ticket = queue.get(i);
                        dfsQueue = new ArrayList<>();
                        if(dfs(ticketList, ticket, ticket.from, answers)){
                            for(int j=0; j<dfsQueue.size(); j++) {
                                Ticket dfsTicket = dfsQueue.get(j);
                                from = dfsTicket.to;
                                dfsTicket.used = true;
                                answers.add(dfsTicket.to);
                            }
                            break;
                        }
                    }

                } else if (queue.size() == 1 && !queue.get(0).used) {
                    queue.get(0).used = true;
                    answers.add(queue.get(0).to);
                    from = queue.get(0).to;
                }
            }
            String[] answer = new String[answers.size()];
            for (int i = 0; i < answers.size(); i++) {
                answer[i] = answers.get(i);
            }
            return answer;
        }

        public boolean dfs(Ticket[] ticketList, Ticket ticket, String target, List<String> answers){
            if(ticket.to.equals(target)){
                dfsQueue.add(ticket);
                return true;
            }

            for(int i=0; i<ticketList.length; i++){
                if(!ticketList[i].used && ticket.to.equals(ticketList[i].from)){
                    dfsQueue.add(ticket);
                    return dfs(ticketList, ticketList[i], target, answers);
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