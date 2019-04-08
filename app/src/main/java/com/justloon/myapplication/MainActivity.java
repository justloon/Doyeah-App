package com.justloon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.FirebaseApp;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<ModelMenu> menuArrayList;

    private Toolbar mToolbar;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        FirebaseApp.initializeApp(this);

        hideSoftKeyboard();
        recyclerView = findViewById(R.id.list_menu);

        // array daftar menu
        menuArrayList = new ArrayList<>();
        menuArrayList.add(new ModelMenu(R.drawable.balok_red_velvet, "Balok Red Velvet", "Rp 5.000",
                "Kue balok yang memiliki rasa red velvet ini merupakan inovasi baru dari kami, ditambah taburan keju diatasnya"));
        menuArrayList.add(new ModelMenu(R.drawable.balok_dark_chocolate, "Balok Dark Chocolate", "Rp 5.000",
                "Kue balok yang nyoklat ini merupakan inovasi baru dari kami, ditambah taburan keju diatasnya"));
        menuArrayList.add(new ModelMenu(R.drawable.balok, "Balok", "Rp 4.000",
                "Kue balok ini menu andalan kami dengan berbagai rasa seperti green tea, choco chip, strawberry, keju, original"));
        menuArrayList.add(new ModelMenu(R.drawable.cireng_ngojay, "Cireng Ngojay",  "Rp 10.000",
                "Cireng crispy yang disajikan dengan kuah rempah khas Balok Do_yeah"));
        menuArrayList.add(new ModelMenu(R.drawable.ice_cream_balok, "Ice Cream Balok", "Rp 10.000",
                "Recommended banget nih, karena kue balok ini yang paling beda dari kue balok yang lainnya"));
        menuArrayList.add(new ModelMenu(R.drawable.jangjang_doyeah, "Jangjang Doyeah", "Rp 15.000",
                "Sayap ayam yang digoreng dengan saus racikan Balok Do_yeah dan pastinya menyerap broohh..."));
        menuArrayList.add(new ModelMenu(R.drawable.kwetiauw, "Kwetiauw", "Rp 13.000",
                "Merupakan salah satu menu favorit dari Balok Do_yeah, Karena racikannya yang beda dengan kwetiauw pada umumnya"));
        menuArrayList.add(new ModelMenu(R.drawable.nasi_gila, "Nasi Gila", "Rp 15.000",
                "Paduan telur, sosis, baso, ayam, serta sayuran menjadi topping di menu jenis rice bowl ini"));
        menuArrayList.add(new ModelMenu(R.drawable.skin_rice, "Skin Rice Bowl",  "Rp 14.000",
                "Rice bowl yang diberi topping kulit ayam crispy dan di lumuri saus black pepper"));
        menuArrayList.add(new ModelMenu(R.drawable.tahu_goang, "Tahu Goang", "Rp 8.000",
                "Camilan pedas yang dibuat dari tahu crispy kemudian di ulek dengan sambal goang"));
        menuArrayList.add(new ModelMenu(R.drawable.tahu_rosalinda, "Tahu Rosalinda", "Rp 10.000",
                "Rosalinda kami beri nama yang artinya, NYA RAOS NYA LADA, dua makna itulah yang menyampaikan rasa dari menu light meal ini"));
        menuArrayList.add(new ModelMenu(R.drawable.tempe_mendoan, "Tempe Mendoan", "Rp 8.000",
                "Camilan tradisional asal banyumas ini sekarang ada di Balok Do_yeah, ditambah dengan saus kecap pedas yang pastinya nagih"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager list_pLayoutManager = layoutManager;
        recyclerView.setLayoutManager(list_pLayoutManager);

        MenuAdapter adapter = new MenuAdapter(this, menuArrayList);
        recyclerView.setAdapter(adapter);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

//        Spinner spinner =  findViewById(R.id.item_quantity);
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, arraySpinner);
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter1);


    }

    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Shows the soft keyboard
     */
    public void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }
}
