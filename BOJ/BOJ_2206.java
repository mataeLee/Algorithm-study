import java.io.*;
import java.util.*;

class Main{
    // 백준 벽 부수고 이동하기 - 2206
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");

        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        if(N == 1 && M == 1){
            System.out.println("1");
            return;
        }

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int val = line.charAt(j) - '0';
                if(val != 0)
                    map[i][j] = val;
            }
        }

        System.out.println(bfs(map, N, M));

    }

    public static int bfs(int[][] map, int N, int M) {
        int[][][] visited = new int[N][M][2];
        // N M 0 : 벽 안부수고 이동
        // N M 1 : 벽 부수고 이동

        // direction
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {0, 0, 0});
        visited[0][0][0] = 1;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1], w = node[2];

            for(int i=0; i<4; i++){
                int nx = x + dx[i], ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 이동하려는 곳이 벽이 아닐 때
                if(map[nx][ny] == 0) {
                    if(visited[nx][ny][w] == 0){
                        queue.offer(new int[] { nx, ny, w });
                        visited[nx][ny][w] = visited[x][y][w] + 1;
                        if(nx == N - 1 && ny == M - 1) return visited[nx][ny][w];
                    }
                }
                // 벽일 때
                else {
                    // 여태 벽을 부수지 않았을 경우에만 벽 부수고 체크
                    if(w == 0){
                        if(visited[nx][ny][1] == 0){
                            queue.offer(new int[] { nx, ny, 1 });
                            visited[nx][ny][1] = visited[x][y][0] + 1;
                            if(nx == N - 1 && ny == M - 1) return visited[nx][ny][1];
                        }
                    }
                }
            }
        }
        return -1;
    }
}