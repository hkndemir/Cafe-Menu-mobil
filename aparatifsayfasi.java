package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class aparatifsayfasi extends AppCompatActivity {
    CheckBox checkbox8;
    CheckBox checkbox9;
    CheckBox checkbox10;
    CheckBox checkbox11;
    CheckBox checkbox12;
    CheckBox checkbox13;
    CheckBox checkbox14;
    TextView textView1;
    Button btnonay4;
    //diğer sayfalar ile aynı işlemler var burda da yani yan sayfalar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aparatifsayfasi);
        init3();
        btnonay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String siparis1=" ";
                if(checkbox8.isChecked()){
                    siparis1 +="PARMAK PATATES";
                    textView1.append(siparis1.toString()+" adlı siparişiniz listenize eklenmişir\n");
                    Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                    intent1.putExtra("aparatifsipariş",siparis1.toString());
                    startActivity(intent1);
                }
                if(checkbox9.isChecked()){
                    siparis1 +="BAŞLANGIÇ SEPETİ";
                    textView1.append(siparis1.toString()+" adlı siparişiniz listenize eklenmişir\n");
                    Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                    intent1.putExtra("aparatifsipariş",siparis1.toString());
                    startActivity(intent1);
                }
                if(checkbox10.isChecked()){
                    siparis1 +="SİGARA BÖREĞİ";
                    textView1.append(siparis1.toString()+" adlı siparişiniz listenize eklenmişir\n");
                    Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                    intent1.putExtra("aparatifsipariş",siparis1.toString());
                    startActivity(intent1);
                }
                if(checkbox11.isChecked()){
                    siparis1 +="TOST";
                    textView1.append(siparis1.toString()+" adlı siparişiniz listenize eklenmişir\n");
                    Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                    intent1.putExtra("aparatifsipariş",siparis1.toString());
                    startActivity(intent1);
                }
                if(checkbox12.isChecked()){
                    siparis1 +="SANDİVİÇ ";
                    textView1.append(siparis1.toString()+" adlı siparişiniz listenize eklenmişir\n");
                    Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                    intent1.putExtra("aparatifsipariş",siparis1.toString());
                    startActivity(intent1);
                }
                if(checkbox13.isChecked()){
                    siparis1 +="GÜNÜN ÇORBASI";
                    textView1.append(siparis1.toString()+" adlı siparişiniz listenize eklenmişir\n");
                    Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                    intent1.putExtra("aparatifsipariş",siparis1.toString());
                    startActivity(intent1);
                }
                if(checkbox14.isChecked()){
                    siparis1 +="HAMBURGER";
                    textView1.append(siparis1.toString()+" adlı siparişiniz listenize eklenmişir\n");
                    Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                    intent1.putExtra("aparatifsipariş",siparis1.toString());
                    startActivity(intent1);
                }





            }
        });


    }
    public void init3(){

        checkbox8=findViewById(R.id.checkBox8);
        checkbox9=findViewById(R.id.checkBox9);
        checkbox10=findViewById(R.id.checkBox10);
        checkbox11=findViewById(R.id.checkBox11);
        checkbox12=findViewById(R.id.checkBox12);
        checkbox13=findViewById(R.id.checkBox13);
        checkbox14=findViewById(R.id.checkBox14);
        textView1=findViewById(R.id.textView7);
        btnonay4=findViewById(R.id.btnonay4);

    }
}
