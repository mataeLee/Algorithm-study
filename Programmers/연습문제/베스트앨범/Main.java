import java.util.*;
public class Main {

    // test case
    static String [] genres = {"classic", "pop", "classic", "classic", "pop"};
    static int [] plays = {500, 600, 150, 800, 2500};

    static class Solution {
        static class Music implements Comparable<Music>{
            public String genre;
            public int plays;
            public int index;

            @Override
            public int compareTo(Music music) {
                if (this.plays > music.plays) {
                    return -1;
                } else if (this.plays == music.plays) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        static class Chart implements Comparable<Chart>{
            String genre;
            int plays;

            @Override
            public int compareTo(Chart chart) {
                if (this.plays > chart.plays) {
                    return -1;
                } else if (this.plays == chart.plays) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        public int[] solution(String[] genres, int[] plays) {

            Music [] musics = new Music[genres.length];

            Map<String,Integer> playsCnt = new HashMap<>();

            for(int i=0; i<genres.length; i++){
                Music music = new Music();
                music.genre = genres[i];
                music.plays = plays[i];
                music.index = i;
                musics[i] = music;
                if(!playsCnt.containsKey(genres[i]))
                    playsCnt.put(genres[i], plays[i]);
                else
                    playsCnt.put(genres[i], playsCnt.get(genres[i]) + plays[i]);
            }
            Arrays.sort(musics);

            Chart[] charts = new Chart[playsCnt.size()];
            Iterator iterator = playsCnt.keySet().iterator();
            int chartIdx = 0;
            while (iterator.hasNext()){
                String key = (String)iterator.next();
                Chart chart = new Chart();
                chart.genre = key;
                chart.plays = playsCnt.get(key);
                charts[chartIdx++] = chart;
            }

            Arrays.sort(charts);
            List<Integer> list = new ArrayList<>();
            int genreCnt=0;
            for(int i=0; i<charts.length; i++){
                String genre = charts[i].genre;

                for(int j=0; j<musics.length; j++){
                    if(genreCnt>1)
                        break;
                    if(musics[j].genre.equals(genre)) {
                        list.add(musics[j].index);
                        genreCnt++;
                    }
                }
                genreCnt=0;
            }
            int [] answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] answer = solution.solution(genres, plays);
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i]+", ");
        }
    }
}