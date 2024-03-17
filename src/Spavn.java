import java.util.ArrayList;

public class Spavn {
    private double[] ver = {0.90,0.83,0.77,0.70,0.63,0.57,0.50,0.57,0.63,0.70,0.77,0.83,0.90,0.83,0.77,0.70};
    //раз в 5 минут
    //private int n; // час

    /*public Spavn(int n) {
        this.n = n;
    }*/

    public int[][] spavn() {
        int[][] arr_time = new int[181][2];
        int cnt = 0;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 12; j++){
                if (Math.random() < ver[i]) {
                    Car ma = new Car();
                    arr_time[j + i*12][0] = (i + 0) * 60 + (j + 1) * 5;
                    arr_time[j + i*12][1] = ma.time_to_zap();
                    cnt++;
                }
            }
        }

        int[][] time = new int[cnt][2];
        int ff  = 0;
        for(int t = 0; t < cnt; t++){
            //System.out.println(ff);
            boolean f = true;
            for(int i = ff; i < 181;i++){
                if(arr_time[i][0] != 0 && f == true){
                    time[t][0] = arr_time[i][0];
                    time[t][1] = arr_time[i][1];
                    ff = i+1;

                    f = false;
                }
            }
        }

        return time;
    }

    /*public int[][][] spavn(){

        int[][][] arr_time = new int[15][20][2];
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 20; j++){
                if (Math.random() < ver[i]) {
                    Car ma = new Car();
                    arr_time[i][j][0] = (i + 0)*60 + (j + 1)*5;
                    arr_time[i][j][1] = ma.time_to_zap();
                }

            }
        }
        return arr_time;
    }*/

    /*public ArrayList<Integer> spavn(){
        ArrayList<Integer> arr_time = new ArrayList<>();
        for(int i = 0; i < 20;i++) {
            if (Math.random() < ver[n - 7]) {
                Car ma = new Car();
                arr_time.add(ma.time_to_zap());
            }
            else {
                arr_time.add(0);
            }
        }
        return arr_time;// вернул динамический массив со спауном машин
    }*/
}