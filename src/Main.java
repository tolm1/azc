
// начинем с начала. То есть с создания автомобиля. Будет герироваться
// рандомное количество топливо, топлива в баке, сколько заправлять
// скорость пусть будет 20 л/м = 1/3 л/с
// выходные данные время заправки

// со старта будет 2 колоники
// обсулживание 1 машины время + 2 мин на оплату
// пока так

// рандомный спаун машин с динамической нагрузкой
// пусть машина создается раз в 5 м. Вероятность спауна будет не по гаусовой
// Пусть заправка работает с 7 - 22, 15

//7	    0.90
//8	    0.83
//9	    0.77
//10	0.70
//11	0.63
//12	0.57
//13	0.50
//14	0.57
//15	0.63
//16	0.70
//17	0.77
//18	0.83
//19	0.90
//20	0.83
//21	0.77
//22	0.70
//[0.90,0.83,0.77,0.70,0.63,0.57,0.50,0.57,0.63,0.70,0.77,0.83,0.90,0.83,0.77,0.70]

// дальше обработки очереди на 2 заправки
// ограничение топлива

// если очередь больще > 12 м, то +1 колонка через 2 дня

// сейчас получил создание машинок, осталось реализовать заправку + очередь
// вот теперь точно создание сделано

// теперь обратка, предположительно через скайлан

import java.util.ArrayList;

// а что если, хран.ить массив размера 940, где каждая ячейка 1 минута, а хранить она сколько длится заправка
// добавляем счетчик занятых колонок, for бежим по минутам,
public class Main {
    public static void main(String[] args) {
        Spavn he = new Spavn();//создали машины, много и сразу

        //Kolonka k1 = new Kolonka();
        //Kolonka k2 = new Kolonka();

        Kolonka[] arr_kolonka = new Kolonka[]{new Kolonka(),new Kolonka()};


        //пока с одной решу

        int[][] car_all = he.spavn(); //получил матрицы 15 на 20 на 2. 15 - часы работы с 7 по 22, 20 каждые 5 минут может приехать машина

        int x = car_all.length;

        int i,j,cnt,q,cnt_cor,chetpick,total;
        i = j = cnt = q = cnt_cor = chetpick =0;
        total = 0;

        boolean end_of_car = false;



        for(int f = 0;f < car_all.length ;f++) {
            if (car_all[f][0] != 0) {
                cnt_cor++;
            }
            System.out.println("" + car_all[f][0] + " " + car_all[f][1]); //приеда приезда, вермя заправки
        }

        System.out.println(" abc ");

        for(int t = 0;t < 910; t++){

            if(car_all[i][0] <= t && car_all[i][0] != 0){
                for(Kolonka k : arr_kolonka){
                    if(k.sostoine_rab == false){
                        k.add(car_all[i][1],t);
                        break;
                    }
                }
            }

            for(Kolonka k : arr_kolonka){
                if(k.time_out == t){
                    k.sostoine_rab = false;
                    k.time_out = 0;
                    i++;
                    cnt++;
                }
            }

            if(i < x && car_all[i][0] == 0){
                i++;
            }

            if(i == x){
                break;
            }

            System.out.println("" + t + " " + car_all[i][0]  +" " + cnt);

            /*for(Kolonka k : arr_kolonka){
                System.out.println(k.time_out + " ");
            }*/
        }


        System.out.println("" + cnt_cor + " " + (cnt));

        /*for(int t = 0; t < 940; t++){
            i = chetpick%20;
            j = chetpick%15;

            //if(car_all[i][j])
        }*/


        /*for(int t = 0; t < 940; t++){


            if(car_all[i][j][0] <= t && car_all[i][j][1] != 0 && end_of_car == false && (k1.sostoine_rab == false || k1.sostoine_rab == false)){
                if(k1.sostoine_rab == false && k2.sostoine_rab == true) {
                    k1.add(car_all[i][j][1], t);
                }
                if(k1.sostoine_rab == true && k2.sostoine_rab == false) {
                    k2.add(car_all[i][j][1], t);
                }else {
                    k2.add(car_all[i][j][1], t);
                }

            }

            if(k1.time_out == t){
                k1.sostoine_rab = false;
                k1.time_out = 0;

                cnt++;
                j++;

                if(j == 20 && i < 14){
                    j = 0;
                    i++;
                }
                if(j == 0 && i == 15){
                    end_of_car = true;
                }
            }

            if(k2.time_out == t){
                k2.sostoine_rab = false;
                k2.time_out = 0;

                cnt++;
                j++;

                if(j == 20 && i < 14){
                    j = 0;
                    i++;
                }
                if(j == 0 && i == 15){
                    end_of_car = true;
                }
            }

            if(end_of_car == false && car_all[i][j][1] == 0){
                j++;
                total++;
                if(j == 20 && i < 14){
                    j = 0;
                    i++;
                }
                if(j == 0 && i == 15){
                    end_of_car = true;
                }
            }



            System.out.println("" + t + " " + k1.time_out + " " + k2.time_out + " " + cnt);
        }
        System.out.println("" + cnt_cor + " " + i +" "+ j);*/



        /*//int n = 7;
        Spavn he = new Spavn();
        int[][][] aa = he.spavn(); //получил матрицы 15 на 20 на 2. 15 - часы работы с 7 по 22, 20 каждые 5 минут может приехать машина

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.println("" + aa[i][j][0] + " " + aa[i][j][1]); //приеда приезда, вермя заправки
            }
        }

        int i = 0;
        int j = 0;
        int zanat = 0;
        int time_corrent1 = 0;
        //int time_corrent2 = 0;
        int aviting = 0;
        int cnt = 0;

        System.out.println(" ");

        for(int t = 1; t < 940; t++){
            //попытка в очередь, сначала с 1 колонкой разоберусь
            if(t == aa[i][j][0] && zanat == 0){
                time_corrent1 = t + aa[i][j][1];
                zanat++;
            }
            if(t == time_corrent1){
                cnt++;
                j++;
                time_corrent1 = 0;
                zanat--;
            }
            System.out.println(t + " " + time_corrent1);
        }
        System.out.println("" + cnt);*/
    }
}