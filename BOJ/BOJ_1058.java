import java.util.*;
import java.io.*;

public class Main {
    // 백준 브루트포스 친구 - 1058

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        int N = Integer.parseInt(br.readLine());
        char[][] friends = new char[N][N];
        for (int i=0; i<N; i++) {
            friends[i] = br.readLine().toCharArray();
        }

        int answer = 0;

        // 각 사람에 대해 2-친구를 계산
        for (int i=0; i<N; i++) {
            Set<Integer> twoFriends = new HashSet<>();

            for (int j=0; j<N; j++) {
                if (i == j) continue; // 자기 자신은 제외

                // i와 j가 친구라면
                if (friends[i][j] == 'Y') {
                    twoFriends.add(j);

                    // j의 친구들을 2-친구로 추가
                    for (int k=0; k<N; k++) {
                        if (friends[j][k] == 'Y' && k != i) {
                            twoFriends.add(k);
                        }
                    }
                }
            }

            // 최대 2-친구 수 갱신
            answer = Math.max(answer, twoFriends.size());
        }

        System.out.println(answer);
    }
}