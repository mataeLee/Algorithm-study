import java.util.*;
import java.io.*;

public class Main {
    // 백준 브르투포스 감시 - 15683

    static class CCTV{
        public int x;
        public int y;
        public int type;
        CCTV(int x, int y, int type){this.x = x; this.y = y; this.type = type;}
    }

    static int[][] map;
    static int answer = 0;
    static List<CCTV> cctvList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");

        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        answer = N * M;
        map = new int[N][M];

        for(int i=0; i<N; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(line[j]);
                // cctv 세팅
                if(map[i][j] != 0 && map[i][j] != 6){
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        recursive(map, N, M,0);

        System.out.println(answer);
    }

    public static void recursive(int[][] out, int N, int M, int depth){
        if(depth == cctvList.size()){
             int spots = countSpot(out);
             if(answer > spots) answer = spots;
             return;
        }

        CCTV cctv = cctvList.get(depth);
        int type = cctv.type;
        int[][] newOut;
        switch(type){
            case 1:
                // 좌
                newOut = forkMap(out, N, M);
                spy(newOut, 1, cctv, N, M);
                recursive(newOut, N, M, depth+1);

                // 우
                newOut = forkMap(out, N, M);
                spy(newOut, 2, cctv, N, M);
                recursive(newOut, N, M, depth+1);

                // 위
                newOut = forkMap(out, N, M);
                spy(newOut, 3, cctv, N, M);
                recursive(newOut, N, M, depth+1);

                // 아래
                newOut = forkMap(out, N, M);
                spy(newOut, 4, cctv, N, M);
                recursive(newOut, N, M, depth+1);
                break;
            case 2:
                // 좌, 우
                newOut = forkMap(out, N, M);
                spy(newOut, 1, cctv, N, M);
                spy(newOut, 2, cctv, N, M);
                recursive(newOut, N, M, depth+1);

                // 위, 아래
                newOut = forkMap(out, N, M);
                spy(newOut, 3, cctv, N, M);
                spy(newOut, 4, cctv, N, M);
                recursive(newOut, N, M, depth+1);
                break;
            case 3:
                // 위, 우
                newOut = forkMap(out, N, M);
                spy(newOut, 3, cctv, N, M);
                spy(newOut, 2, cctv, N, M);
                recursive(newOut, N, M, depth+1);

                // 우, 아래
                newOut = forkMap(out, N, M);
                spy(newOut, 2, cctv, N, M);
                spy(newOut, 4, cctv, N, M);
                recursive(newOut, N, M, depth+1);

                // 아래, 좌
                newOut = forkMap(out, N, M);
                spy(newOut, 4, cctv, N, M);
                spy(newOut, 1, cctv, N, M);
                recursive(newOut, N, M, depth+1);

                // 좌, 위
                newOut = forkMap(out, N, M);
                spy(newOut, 1, cctv, N, M);
                spy(newOut, 3, cctv, N, M);
                recursive(newOut, N, M, depth+1);
                break;
            case 4:
                // 좌 빼고
                newOut = forkMap(out, N, M);
                spy(newOut, 2, cctv, N, M);
                spy(newOut, 3, cctv, N, M);
                spy(newOut, 4, cctv, N, M);
                recursive(newOut, N, M, depth+1);

                // 우 빼고
                newOut = forkMap(out, N, M);
                spy(newOut, 1, cctv, N, M);
                spy(newOut, 3, cctv, N, M);
                spy(newOut, 4, cctv, N, M);
                recursive(newOut, N, M, depth+1);

                // 아래 빼고
                newOut = forkMap(out, N, M);
                spy(newOut, 1, cctv, N, M);
                spy(newOut, 2, cctv, N, M);
                spy(newOut, 3, cctv, N, M);
                recursive(newOut, N, M, depth+1);

                // 위 빼고
                newOut = forkMap(out, N, M);
                spy(newOut, 1, cctv, N, M);
                spy(newOut, 2, cctv, N, M);
                spy(newOut, 4, cctv, N, M);
                recursive(newOut, N, M, depth+1);
                break;
            case 5:
                // 전체
                newOut = forkMap(out, N, M);
                spy(newOut, 1, cctv, N, M);
                spy(newOut, 2, cctv, N, M);
                spy(newOut, 3, cctv, N, M);
                spy(newOut, 4, cctv, N, M);
                recursive(newOut, N, M, depth+1);
                break;
        }
    }

    public static void spy(int[][] map, int dir, CCTV cctv, int N, int M){
        switch(dir){
            // 좌
            case 1:
                for(int i=cctv.y-1; i>-1; i--){
                    if(map[cctv.x][i] == 6) break;
                    if(map[cctv.x][i] == 0) map[cctv.x][i] = -1;
                }
                break;
            // 우
            case 2:
                for(int i=cctv.y+1; i<M; i++){
                    if(map[cctv.x][i] == 6) break;
                    if(map[cctv.x][i] == 0) map[cctv.x][i] = -1;
                }
                break;
            // 위
            case 3:
                for(int i=cctv.x-1; i>-1; i--){
                    if(map[i][cctv.y] == 6) break;
                    if(map[i][cctv.y] == 0) map[i][cctv.y] = -1;
                }
                break;
            // 아래
            case 4:
                for(int i=cctv.x+1; i<N; i++){
                    if(map[i][cctv.y] == 6) break;
                    if(map[i][cctv.y] == 0) map[i][cctv.y] = -1;
                }
                break;
        }
    }


    public static int countSpot(int[][] map){
        int count = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static int[][] forkMap(int[][] map, int N, int M){
        int[][] newMap = new int[N][M];
        for(int i=0; i<N; i++){
            System.arraycopy(map[i], 0, newMap[i], 0, M);
        }
        return newMap;
    }

}