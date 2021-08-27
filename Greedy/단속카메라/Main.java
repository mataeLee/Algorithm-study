import java.util.*;

public class Main {
    // test case
//    static int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}; // 2 ok
//    static int[][] routes = {{-2, -1}, {1, 2}, {-3, 0}}; // 2 ok
//    static int[][] routes = {{0, 0}}; // 1 ok
//    static int[][] routes = {{0, 1}, {2, 3}, {4, 5}, {6, 7}}; // 4 ok
//    static int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}; // 2 ok
//    static int[][] routes = {{-20, 15}, {-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}; // 2 ok
    static int[][] routes = {{10, 5}, {0, -7}, {-6, 5}, {-10, -7}, {-5, 8}}; // 2

    // algorithm solution
    static class Solution {

        class Car implements Comparable<Car>{
            public int entry;
            public int exit;

            @Override
            public int compareTo(Car car) {
                if(this.entry > car.entry)
                    return 1;
                else if(this.entry == car.entry)
                    return 0;
                else
                    return -1;
            }
        }

        public int solution(int[][] routes) {
            int answer = 0;

            List<Car> cars = new ArrayList<>();
            for(int i=0; i<routes.length; i++){
                if(routes[i][0] > routes[i][1]){
                    int tmp = routes[i][0];
                    routes[i][0] = routes[i][1];
                    routes[i][1] = tmp;
                }
                Car car = new Car();
                car.entry = routes[i][0];
                car.exit = routes[i][1];
                cars.add(car);
            }

            Collections.sort(cars);

            Car car = cars.get(0);
            answer++;
            int front = car.entry;
            int end = car.exit;

            for(int i=1; i<cars.size(); i++){
                car = cars.get(i);
                if(end >= car.entry){
                    front = (front < car.entry) ? car.entry : front;
                    end = (end < car.exit) ? end : car.exit;
                    continue;
                }
                answer++;
                front = car.entry;
                end = car.exit;
            }
            return answer;
        }
    }
    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(routes);
        System.out.println(answer);
    }
}
