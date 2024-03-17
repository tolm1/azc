//идея, на хода машина, на выход время, когда колонка освободиться

public class Kolonka {
    public int time_out;//осовбождение колонки
    public boolean sostoine_rab;//занята или нет колонка

    public Kolonka() {
        this.sostoine_rab = false;
    }

    public void add(int a, int t){//добавляем машину, время приема машины
        if(sostoine_rab == false){
            sostoine_rab = true;
            time_out = t + a;//когда освободиться
        }
    }
}
