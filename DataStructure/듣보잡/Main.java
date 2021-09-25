import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 듣보잡 - 1746
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]);
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(set.contains(str)) {
                res.add(str);
            }
            else set.add(str);
        }
        StringBuilder sb = new StringBuilder(res.size()+"\n");

        Collections.sort(res);
        Iterator it = res.iterator();
        while (it.hasNext()){
            sb.append(it.next()).append("\n");
        }
        System.out.println(sb);
    }
}