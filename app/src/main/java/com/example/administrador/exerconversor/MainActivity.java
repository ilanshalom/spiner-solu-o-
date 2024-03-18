package com.example.administrador.exerconversor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
                                    implements View.OnClickListener{
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Class classe=null;
        switch (v.getId()){
            case R.id.button1: classe = Tempo.class;       break;
            case R.id.button2: classe = Volume.class;      break;
            case R.id.button3: classe = Peso.class;        break;
            case R.id.button4: classe = Area.class;        break;
            case R.id.button5: classe = Comprimento.class; break;
            case R.id.button6: classe = Temperatura.class; break;
        }
        Intent my = new Intent(getApplicationContext(),classe);
        startActivity(my);
    }
}
