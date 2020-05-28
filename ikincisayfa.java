package com.example.myapplication;
//Burası sistemin kendiği attığı methodlar import edildiği çağrıldığı yer.
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ikincisayfa extends AppCompatActivity {
    //Burada kullandığım değişkenleri global olarak tanımladım.
    CheckBox checbox8;
    CheckBox checbox9;
    CheckBox checbox10;
    CheckBox checbox11;
    CheckBox checbox12;
    CheckBox checbox13;
    CheckBox checbox14;
    TextView textView;
    Button btnonay1;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikincisayfa);
        init();//burada alt tarafta oluşturduğum methodu çağırdım yani siteme tanımladım değişkenleri kod  kalabalığı olmaması için


        btnonay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//burada buton onay kısmını click ettim
                String siparis=" ";//boş bir String tanımladım
                if(checbox8.isChecked()){//burada eğer bu checkbox a tıklandğınd şunu yap diye koşul tanımladım hepsi sebebi ise birden fazla seçilebilsin diye
                    siparis +="KÖRİ SOSLU TAVUK";//burada seçilenin ismini oluşturduğum String değişkenşne attım artı koydum sebebi ise birden fazla yan yana yazsın diye
                    textView.append(siparis.toString()+" adlı siparişiniz listenize eklenmişir");//sayfanın alt tarafını bunu yerleştirdim bilgi vermesi için
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);////bu verileri  ana sayfaya ilermem için kullandım
                    intent.putExtra("tavuksipariş",siparis.toString());//burada putExtra ile verdiğim isimi girilen veriye değerini tanımladım
                    startActivity(intent);//ana sayfaya geçiş için

                //Aynı şekilde diğerleri içinde geçerli
                }
                if(checbox9.isChecked()){
                    siparis +="MEXİCAN SOSLU TAVUK";
                    textView.append(siparis.toString()+" adlı siparişiniz listenize eklenmişir");
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("tavuksipariş",siparis);
                    startActivity(intent);
                }
                if(checbox10.isChecked()){
                    siparis ="CHİLİ SOSLU TAVUK";
                    textView.append(siparis.toString()+" adlı siparişiniz listenize eklenmişir");
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("tavuksipariş",siparis);
                    startActivity(intent);
                }
                if(checbox11.isChecked()){
                    siparis +="IZGARA TAVUK";
                    textView.append(siparis.toString()+" adlı siparişiniz listenize eklenmişir");
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("tavuksipariş",siparis.toString());
                    startActivity(intent);
                }
                if(checbox12.isChecked()){
                    siparis +="TAVUK ŞNİTZEL";
                    textView.append(siparis.toString()+" adlı siparişiniz listenize eklenmişir");
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("tavuksipariş",siparis.toString());
                    startActivity(intent);
                }
                if(checbox13.isChecked()){
                    siparis +="TAVUK DÜRÜM";
                    textView.append(siparis.toString()+" adlı siparişiniz listenize eklenmişir");
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("tavuksipariş",siparis.toString());
                    startActivity(intent);
                }
                if(checbox14.isChecked()){
                    siparis +="TAVUK FAJİTA";
                    textView.append(siparis.toString()+" adlı siparişiniz listenize eklenmişir");
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("tavuksipariş",siparis.toString());
                    startActivity(intent);
                }
            }
        });

    }
    //buda kullandığım bir method kod kalabalığı olmasın diye
    public void init(){
        checbox8=findViewById(R.id.checkBox8);
        checbox9=findViewById(R.id.checkBox9);
        checbox10=findViewById(R.id.checkBox10);
        checbox11=findViewById(R.id.checkBox11);
        checbox12=findViewById(R.id.checkBox13);
        checbox13=findViewById(R.id.checkBox12);
        checbox14=findViewById(R.id.checkBox14);
        textView=findViewById(R.id.textView);
        btnonay1=findViewById(R.id.btnonay1);



    }

}
