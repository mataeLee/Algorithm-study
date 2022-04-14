import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 프린터 큐 - 1966
    static class Document{
        int idx;
        int val;
        Document(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String[] strs = br.readLine().split(" ");
            String[] strs2 = br.readLine().split(" ");

            List<Document> queue = new ArrayList<>();
            for(int j=0; j<strs2.length; j++){
                queue.add(new Document(j, Integer.parseInt(strs2[j])));
            }
            int target = Integer.parseInt(strs[1]);
            int res = 0;
            while (!queue.isEmpty()){
                Document doc = queue.get(0);
                queue.remove(0);
                boolean flag = true;
                for(int j=0; j<queue.size(); j++){
                    if(doc.val < queue.get(j).val){
                        queue.add(doc);
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    res++;
                    if(doc.idx == target) break;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}