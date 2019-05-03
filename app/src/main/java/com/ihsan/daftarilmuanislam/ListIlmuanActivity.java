package com.ihsan.daftarilmuanislam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListIlmuanActivity extends AppCompatActivity {
    // cara pembuatan String Array

    String[] nama = {"Al Khawarizmi",
            "Al Zahrawi",
            "Ibnu al-Baithar",
            "Ibnu al-Nafis",
            "Ibnu Haitham",
            "Ibnu Khaldun",
            "Ibnu Sina",
            "Jabir Ibn- Hayyan",
            "Thbit ibn Qurra",
            " Umar Khayyam"};


    // cara pembuatan int gambar

    int[] gambar = {R.drawable.alkhawarizmi,
    R.drawable.alzahrawi,
    R.drawable.ibnualbhaitar,
    R.drawable.ibnualnafis,
    R.drawable.ibnuhaitman,
    R.drawable.ibnukhaldun,
    R.drawable.ibnusina,
    R.drawable.jabilibnhayyan,
    R.drawable.thbitibnqurra,
    R.drawable.umarkhayyam,};

    String[] url = {"https://id.wikipedia.org/wiki/Mu%E1%B8%A5ammad_bin_M%C5%ABs%C4%81_al-Khaw%C4%81rizm%C4%AB",
    "https://id.wikipedia.org/wiki/Abu_al-Qasim_al-Zahrawi",
   "https://id.wikipedia.org/wiki/Ibnu_al-Baithar",
    "https://id.wikipedia.org/wiki/Ibnu_al-Nafis",
   "https://id.wikipedia.org/wiki/Ibnu_Haitham",
    "https://id.wikipedia.org/wiki/Ibnu_Khaldun",
    "https://id.wikipedia.org/wiki/Ibnu_Sina",
    "https://id.wikipedia.org/wiki/Abu_Musa_Jabir_bin_Hayyan",
    "https://id.wikipedia.org/wiki/Tsabit_bin_Qurrah",
    "https://id.wikipedia.org/wiki/Umar_Khayy%C4%81m}"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ilmuan);

        ListView listView = findViewById(R.id.listViewIlmuan);
        CustomListviewAdapter customListviewAdapter = new CustomListviewAdapter();
        listView.setAdapter(customListviewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posisi, long l) {
                Intent i = new Intent(ListIlmuanActivity.this, DetailIlmuanActivity.class);
                i.putExtra("putNama", nama[posisi]);
                i.putExtra("putUrl", url[posisi]);
                startActivity(i);
            }
        });
    }

    class CustomListviewAdapter extends BaseAdapter{

        //list view akan menyusuaikan ada berapa gamabr
        @Override
        public int getCount() {
            return gambar.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

    // mengambil layout luar di tempelkan
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_listview,null);
            ImageView imageView = view.findViewById(R.id.imgIlmuwan);
            TextView textView = view.findViewById(R.id.txtIlmuwan);
            imageView.setImageResource(gambar[position]);
            textView.setText(nama[position]);
            return view;
        }
    }
}
