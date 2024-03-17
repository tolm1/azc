public class Car {
    public int bak_v; //30-110
    public int bak_in;
    public int bak_zap;

    public void getbak_v(){
        int a  = (int) (Math.random() * 80);
        a += 30;
        bak_v = a;
    }

    public void getbak_in(){
        int a  = (int) (Math.random() * (bak_v - 1)) + 1;
        bak_in = a;
    }

    public void getbak_zap(){
        int a  = (int) (Math.random() * (bak_v - bak_in)) + 1;
        bak_zap = a;
    }

    public Car() {
        getbak_v();
        getbak_in();
        getbak_zap();
    }

    public void show(){
        System.out.println("" + bak_v + " " + bak_in + " " + bak_zap);
    }

    public int time_to_zap(){
        double time_d = bak_zap / 20;
        if(bak_zap%20 != 0){
            time_d += 1;
        }
        time_d += 2; // как бы время на оплату бензина
        //System.out.println(time_d);
        return (int) time_d;
    }
}
