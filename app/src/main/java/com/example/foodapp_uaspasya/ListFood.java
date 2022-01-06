package com.example.foodapp_uaspasya;

import android.content.Context;

import java.util.ArrayList;

public class ListFood{


    public static ArrayList<Integer> getGambar() {
        ArrayList<Integer> drawables = new ArrayList<Integer>();
        drawables.add(R.drawable.black_salad);
        drawables.add(R.drawable.kopi_hitam);
        drawables.add(R.drawable.nasigoreng);
        drawables.add(R.drawable.batagor);
        drawables.add(R.drawable.cheesecake);
        drawables.add(R.drawable.cappuchino);
        drawables.add(R.drawable.cireng);
        drawables.add(R.drawable.sparkling_tea);
        drawables.add(R.drawable.donut);
        drawables.add(R.drawable.mie_goreng);

        return drawables;
    }

    public static ArrayList<Food> getData(Context context) {
        ArrayList<Food> list = new ArrayList<Food>();
        list.add(new Food("Black Salad","Salad Hitam dari Hungaria", "Rp. 50.000", context.getDrawable(R.drawable.black_salad)));
        list.add(new Food("Kopi Hitam", "Dibuat dengan kopi robusta yang dipetik langsung oleh petani di aceh yang dimasak dengan sepenuh hati dan di proses dengan teliti. ", "Rp. 10.000", context.getDrawable(R.drawable.kopi_hitam)));
        list.add(new Food("Nasi Goreng","Nasi Goreng khas Indonesia dengan cita rasa nusantara", "Rp. 15.000", context.getDrawable(R.drawable.nasigoreng)));
        list.add(new Food("Batagor","Batagor khas bandung ini sangat terkenal sehingga membuat para penikmatnya ingin lagi dan lagi", "Rp. 5.000", context.getDrawable(R.drawable.batagor)));
        list.add(new Food("Cheese Cake", "Dengan perpaduan keju swiss dan tehnik pembuatan cake dari jepang yang membuat Cheese cake ini semakin diminati para pecinta dessert ", "Rp. 25.000", context.getDrawable(R.drawable.cheesecake)));
        list.add(new Food("Cappuccino", "Kopi pilihan yang dipadukan dengan susu dari belgia sehingga membuat kenikmatan dari Cappuchino ini semakin terasa bagi orang orang", "Rp. 15.000", context.getDrawable(R.drawable.cappuchino)));
        list.add(new Food("Cireng","Makanan khas Jawa Barat dengan tekstur yang garing diluar dan lembut didalam membuat makanan ini mempunyai banyak peminat ", "Rp. 5.000", context.getDrawable(R.drawable.cireng)));
        list.add(new Food("Lemon Sparkling Tea","Dengan kesegaran lemon yang membuat minuman ini semakin diminati dan juga perpaduan dengan soda yang membuatnya semakin segar", "Rp. 20.000", context.getDrawable(R.drawable.sparkling_tea)));
        list.add(new Food("Donut","Donat yang disukai oleh polisi di negara Paman Sam.", "Rp. 5.000", context.getDrawable(R.drawable.donut)));
        list.add(new Food("Mie Goreng","Mie goreng dengan kearifan lokal yang dibuat dengan sepenuh hati dengan tangan amang amang bandung", "Rp. 15.000", context.getDrawable(R.drawable.mie_goreng)));

        return list;
    }

    public static void initialData(Context context) {
        DB db = new DB(context);
        for (Food food : getData(context)) {
            db.tambahData(food);
        }
    }
}
