//идея, на хода машина, на выход время, когда колонка освободиться

public class Kolonka {
    //private Car this_car;//оброботка машины
    public int time_out;//осовбождение колонки
    public boolean sostoine_rab;//занята или нет колонка
    public int time_in;

    public Kolonka() {
        this.sostoine_rab = false;
    }

    public void add(int a, int t){//добавляем машину, время приема машины
        if(sostoine_rab == false){
            //this_car = a;
            //time_in = t;
            sostoine_rab = true;
            time_out = t + a;//когда освободиться
        }
        //return time_out;
    }

    /*public boolean proverka(int t){
        if(t == time_out){
            sostoine_rab = false;
        }
        return sostoine_rab;
    }*/

}
