
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

        Kolonka[] arr_kolonka = new Kolonka[]{new Kolonka(), new Kolonka()};

        //пока с одной решу

        int[][] car_all = he.spavn(); //получил матрицы 15 на 20 на 2. 15 - часы работы с 7 по 22, 20 каждые 5 минут может приехать машина

        int x = car_all.length;

        int i, cnt, cnt_cor,size_kol,time_ozit,count_cor_day,count_quq;
        i = cnt = cnt_cor = time_ozit = count_cor_day = count_quq = 0;

        size_kol = 2;

        //int[] cor_day = new int[7];

        boolean need_fuel = false;
        int cor_fuel = 10000;

        for (int f = 0; f < car_all.length; f++) {
            if (car_all[f][0] != 0) {
                cnt_cor++;
            }
            System.out.println("" + car_all[f][0] + " " + car_all[f][1]); //приеда приезда, вермя заправки
        }

        System.out.println(" abc ");

        for (int day = 0; day < 7; day++) {

            if(count_quq > 0 && day - count_cor_day == 2){//есть запрос на добавление колонки

                size_kol++;
                Kolonka[] arr_kolonka2 = new Kolonka[size_kol];
                count_cor_day = 0;
                count_quq = 0;

                for(int index = 0; index < size_kol; index++){
                    arr_kolonka2[index] = new Kolonka();
                }

                arr_kolonka = arr_kolonka2;
            }

            i = 0;
            cor_fuel = 10000;
            need_fuel = false;


            for (int t = 0; t < 910; t++) {
                if (i < x) {
                    System.out.println("" + t + " " + car_all[i][0] + " " + cnt + " " + x);
                }

                if (car_all[i][0] <= t && (t - car_all[i][0]) <= car_all[i][2]) {
                    for (Kolonka k : arr_kolonka) {
                        if (k.sostoine_rab == false && (cor_fuel - car_all[i][1] * 20) >= 0) {
                            cor_fuel -= car_all[i][1] * 20;
                            k.add(car_all[i][1], t);
                            break;
                        }
                        if ((cor_fuel - car_all[i][1] * 20) < 0) {
                            need_fuel = true;
                            time_ozit = t;
                        }
                    }
                }

                if ((t - car_all[i][0]) > car_all[i][2] && count_cor_day == 0) {
                    i++;
                    count_quq++;
                    count_cor_day = day;//сохранил, когда появился запрос на добавление колонки
                }

                if(need_fuel == true && (t - time_ozit) > 100){
                    need_fuel = false;
                    cor_fuel += 2000;
                    time_ozit = 0;
                }

                for (Kolonka k : arr_kolonka) {
                    if (k.time_out == t) {
                        k.sostoine_rab = false;
                        k.time_out = 0;
                        i++;
                        cnt++;
                    }
                }

                if (i == x) {
                    break;
                }

                for (Kolonka k : arr_kolonka) {
                    System.out.println(k.time_out);
                }
            }

            System.out.println("" + cnt_cor + " " + cnt + " " + cor_fuel + " " + count_quq + " " + arr_kolonka.length + " " + size_kol);
        }
    }
}
