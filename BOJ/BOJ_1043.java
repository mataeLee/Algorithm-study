import java.io.*;
import java.util.*;

public class Main {
    // 백준 자료구조 거짓말 - 1043
    static int[] parent;
    static class Party{
        public List<Integer> members;
        Party(){
            members = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        parent = new int[n+1];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        boolean[] aware = new boolean[n+1];

        strs = br.readLine().split(" ");
        int count  = Integer.parseInt(strs[0]);

        for(int i=1; i<count+1; i++){
            aware[Integer.parseInt(strs[i])] = true;
        }

        List<Party> parties = new ArrayList<>();

        for(int i=0; i<m; i++){
            strs = br.readLine().split(" ");
            Party party = new Party();
            boolean truth = false;
            int idx = -1;
            for(int j=1; j<strs.length; j++){
                int person = Integer.parseInt(strs[j]);
                party.members.add(person);
                if(!truth && aware[find(person)]){
                    truth = true;
                    idx = party.members.size()-1;
                }
            }
            if(truth){
                for(int j=0; j<party.members.size(); j++){
                    if(idx != j)
                        union(party.members.get(idx), party.members.get(j));
                }
            }
            else{
                int val = party.members.get(0);
                for(int j=1; j<party.members.size(); j++){
                    union(val, party.members.get(j));
                }
            }
            parties.add(party);
        }

        for(int i=0; i<parties.size(); i++){
            Party party = parties.get(i);
            boolean lie = true;
            for(int j=0; j<party.members.size(); j++){
                if(aware[find(party.members.get(j))]) {
                    lie = false;
                    break;
                }
            }
            if(lie) answer++;
        }


        System.out.println(answer);
    }

    static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}