package com.example.myapplication;
//Burası sistemin kendiği attığı methodlar import edildiği çağrıldığı yer.
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {
    //Burada kullandığım değişkenleri global olarak tanımladım.
    TextView garson;
    String tvkgelen;
    String etgelen;
    String icecekgelen;
    String aparatifgelen;
    String salatagelen;
    String[] liste;
    FirebaseDatabase database;
    DatabaseReference myRef;
    int i=0;
    //Burada kullandığım menuyu inflate edttim yani sisteme tanımladım.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }
    //Burada menu de kullandığım itemleri uygulamama uyarladım
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.item2){//hangi itema tıklandığında ne yapıldığı eğer buysa
            Toast.makeText(this, "2 numaralı garson seçildi", Toast.LENGTH_SHORT).show();
            garson.setText("Ahmet");
        }
        if(item.getItemId()==R.id.item1){
            Toast.makeText(this, "1 numaralı garson seçildi", Toast.LENGTH_SHORT).show();
            garson.setText("Hakan");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        garson=findViewById(R.id.garson);//garson textini tanımlama

        //Buarada ana sayfamdaki butanları ilgili sayfayı açmaya yarıyan kodları yazdım ve bunu intentlerle yaptım.

        findViewById(R.id.btntavuk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent=new Intent(getApplicationContext(),ikincisayfa.class);//bu butona tıklandığında o sayfaya git.
                startActivity(ıntent);//gidilen sayfayı açmaya yarıyor
            }
        });
        findViewById(R.id.btnet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent=new Intent(getApplicationContext(),etsayfasi.class);
                startActivity(ıntent);
            }
        });
        findViewById(R.id.btnicecek).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent=new Intent(getApplicationContext(),iceceksayfasi.class);
                startActivity(ıntent);
            }
        });
        findViewById(R.id.btnaparatif).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent=new Intent(getApplicationContext(),aparatifsayfasi.class);
                startActivity(ıntent);
            }
        });
        findViewById(R.id.btnsalata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent=new Intent(getApplicationContext(),salatasayfasi.class);
                startActivity(ıntent);
            }
        });


        //Burada sistem ile diyaloğa geçmek için alert dialog methodunu kullandım
        final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);//Sayfayı tanımladım
        final LayoutInflater inflater =LayoutInflater.from(MainActivity.this);//inflater içine aldım
        @SuppressLint("ResourceType") final View dialog =LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.dialog,(LinearLayout)findViewById(R.layout.dialog));//açtığım dialog  xml li buraya tanımladım.

        findViewById(R.id.btncıkıs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//çıkış butonuna basma
                builder.setTitle("ÇIKIŞ");//dialog  başlığı
                builder.setView(dialog);//dialoğu getirme
                builder.show();//karartma hafif
            }
        });
        dialog.findViewById(R.id.btnevet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//dialog içinde bulunan butonlara tıklama yalnız başında nereden çektiğin yazmammız lazım aksi takdirda çalışmaz
                Toast.makeText(MainActivity.this, "çıkış yapılıyor", Toast.LENGTH_SHORT).show();//toast mesajını verme
                finish();//programdan çıkma

            }
        });
        dialog.findViewById(R.id.btnhayır).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancelDragAndDrop();


            }
        });//buna bir şey bulamadım hayıra tıklandığında ne olucağı





        //Bu kısımda intent yardımıyla diğer sayfalardan aldığım verileri burada ana main kısmıma getirdim ve bir Stringe tanımladım
        Intent intent=getIntent();//kullandığım intenti çağırdım
        tvkgelen=intent.getStringExtra("tavuksipariş");//burada getString yardımıyla isimlerin değerlerini aldım yani seçtiğim isteğim şeyi
        Intent intent1=getIntent();
        etgelen=intent.getStringExtra("etsipariş");
        Intent intent2=getIntent();
        icecekgelen=intent.getStringExtra("iceceksipariş");
        Intent intent3=getIntent();
        aparatifgelen=intent.getStringExtra("aparatifsipariş");
        Intent intent4=getIntent();
        salatagelen=intent.getStringExtra("salatasipariş");

        //Bu kısımda seçtiğim verileri bir dizi ile liste haline getirdim
        liste = new String[5];//diziyi oluşturdum
        liste[0]=tvkgelen;//diziye istediğim elemanları ekledim yani listeme eklediğim siparişleri
        liste[1]=etgelen;
        liste[2]=icecekgelen;
        liste[3]=aparatifgelen;
        liste[4]=salatagelen;


        //Bu kısımda fire basei kullandım seçtiğim elemanları diziye attım ve bu diziyide bir veri tabanında tutmaya çalştım
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("sipariş");

        while (i<liste.length){//burada döngü yardımıyla i değeri ile liste uzunluğuna gittim tek tek

            Map<String,String> list=new HashMap<>();//bu method ile birden fazla veri ekliyebiliyoruz
            list.put("liste",liste[i]);//koyacağım listenin ismi ve yazılaca değerler
            myRef.push().setValue(list);//burada fire base ile bağlantı kurup yazdırma işlemi
            i++;//diğer elemanlara erişmek için i yi arttırdım
        }
        //Burada fire base gönderdiğim veriler okumaya yarıyor bu kısım
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                System.out.println(dataSnapshot.child("sipariş"));
                //tüm verileri sisteme yazdırma ve alt verileri de yazdırma yalnız bir sorun var alt verileri sistem random atıyor ve isimler karışık olduğundan yazdırmıyor

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
