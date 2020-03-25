package com.example.baiKiemTra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Layout2 extends AppCompatActivity {
    Button btnthem;
    EditText edten,edgia;
    ArrayList<model> arrayList=new ArrayList<>();
    menuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);
        edten=(EditText)findViewById(R.id.edten) ;
        edgia=(EditText)findViewById(R.id.edgia) ;
        btnthem=(Button) findViewById(R.id.btnthem);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model models=new model();
                models.setMname(edten.getText().toString());
                models.setMgia(edgia.getText().toString());
                models.setMimg(R.drawable.m1);
                arrayList.add(models);
                //Toast.makeText(getApplicationContext(),"Món ăn vừa thêm : "+models.getMname()+"  giá :"+models.getMgia(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("array",arrayList);
                startActivity(intent);
            }
        });
    }
}
