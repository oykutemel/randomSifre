package com.example.randomsifre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Şifre oluştur butonu ve şifre görüntüleme metni için değişkenler
    Button btn_sifre;
    TextView txt_sifre;

    // Şifre oluştururken kullanılacak harf, rakam ve özel karakter dizileri
    String[] harf = {"A", "B", "C", "D", "E"};
    Integer[] rakam = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] ozelKarakter = {"+", "-", "*", "/", "%", "$", "#"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML dosyasındaki öğeleri kod ile eşleştirme
        txt_sifre = findViewById(R.id.txt_sifre);
        btn_sifre = findViewById(R.id.btn_sifre);

        // Şifre oluştur butonuna tıklama dinleyicisi eklenmesi
        btn_sifre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Boş bir şifre string'i oluşturulması
                String sifre = "";
                Random random = new Random();

                // Dört kez dönerek şifrenin oluşturulması
                for (int i = 0; i <= 3; i++) {
                    sifre = sifre + ozelKarakter[random.nextInt(7)] +
                            rakam[random.nextInt(10)] +
                            harf[random.nextInt(5)];
                }

                // Oluşturulan şifrenin TextView'e set edilmesi
                txt_sifre.setText("" + sifre);
            }
        });
    }
}
