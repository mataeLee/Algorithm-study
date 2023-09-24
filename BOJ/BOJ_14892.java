import java.io.*;
import java.util.*;

class Main{
    // 백준 구현 톱니바퀴 - 14892
    static class Gear{
        Gear leftGear;
        Gear rightGear;
        int leftIdx = 6;
        int rightIdx = 2;
        int[] status = new int[8];

        boolean rotated = false;

        public Gear(int[] values){
            for(int i=0; i<values.length; i++){
                status[i] = values[i];
            }
        }

        public void rotationR(){
            if(rotated) return;
            rotated = true;

            if(leftGear != null){
                if(leftGear.getRightValue() != status[leftIdx]){
                    leftGear.rotationL();
                }
            }
            if(rightGear != null){
                if(rightGear.getLeftValue() != status[rightIdx]){
                    rightGear.rotationL();
                }
            }
            rightIdx--;
            leftIdx--;
            Idxhandler();
        }

        public void rotationL(){
            if(rotated) return;
            rotated = true;

            if(leftGear != null){
                if(leftGear.getRightValue() != status[leftIdx]){
                    leftGear.rotationR();
                }
            }
            if(rightGear != null){
                if(rightGear.getLeftValue() != status[rightIdx]){
                    rightGear.rotationR();
                }
            }
            rightIdx++;
            leftIdx++;
            Idxhandler();
        }

        private void Idxhandler(){
            if(rightIdx < 0 ) rightIdx = 7;
            if(rightIdx > 7) rightIdx = 0;
            if(leftIdx < 0) leftIdx = 7;
            if(leftIdx > 7) leftIdx = 0;
        }

        public int getLeftValue(){
            return status[leftIdx];
        }

        public int getRightValue(){
            return status[rightIdx];
        }

        public void setLeftGear(Gear leftGear) {
            this.leftGear = leftGear;
        }

        public void setRightGear(Gear rightGear) {
            this.rightGear = rightGear;
        }

        public int get12Value(){
            return (rightIdx >= 2)? status[rightIdx-2] : status[leftIdx+2];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니 세팅
        Gear[] gears = new Gear[4];
        for(int i=0; i<4; i++){
            int[] values = new int[8];
            String line = br.readLine();
            for(int j=0; j<8; j++){
                values[j] = line.charAt(j) - '0';
            }

            Gear gear = new Gear(values);
            gears[i] = gear;
        }

        // 톱니 주변 세팅
        gears[0].setRightGear(gears[1]);

        gears[1].setLeftGear(gears[0]);
        gears[1].setRightGear(gears[2]);

        gears[2].setLeftGear(gears[1]);
        gears[2].setRightGear(gears[3]);

        gears[3].setLeftGear(gears[2]);

        // action
        int row = Integer.parseInt(br.readLine());
        for(int i=0; i<row; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            if(direction == 1){
                gears[idx-1].rotationR();
            }
            else {
                gears[idx-1].rotationL();
            }
            for(int j=0; j<4; j++){
                gears[j].rotated = false;
            }
        }

        int answer = 0;
        if(gears[0].get12Value() == 1){
            answer += 1;
        }
        if(gears[1].get12Value() == 1){
            answer += 2;
        }
        if(gears[2].get12Value() == 1){
            answer += 4;
        }
        if(gears[3].get12Value() == 1){
            answer += 8;
        }

        System.out.println(answer);
    }
}