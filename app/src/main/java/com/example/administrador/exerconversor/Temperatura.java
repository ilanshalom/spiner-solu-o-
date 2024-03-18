package com.example.administrador.exerconversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Temperatura extends AppCompatActivity {
    private Spinner sp;
    private EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura_constraint);
        sp = (Spinner)findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calcular(sp.getSelectedItem().toString()); //enviamos o item selecionado na lista
                //ou: calcular(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //se queremos calcular também quando seja digitado algo:
        txt = (EditText)findViewById(R.id.valor);
        txt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                calcular(sp.getSelectedItem().toString()); //enviamos o item selecionado na lista
                return false;
            }
        });
    }

    public void calcular(String opc){ //recebe o item selecionado na lista
        //começamos pegando o valor digitado pelo usuário:
        double v = 0.0, c = 0.0, f = 0.0, k= 0.0;
        try {
            v = Float.parseFloat( ((EditText)findViewById(R.id.valor)).getText().toString() );
        } catch(Exception ex){
            return; //se o valor digitado estiver errado, abandonamos o cálculo
        }
        if(opc.equals("celsius")) {
            c = v;
            f = 9.0/5.0*c + 32.0;
            k = c + 273.0;
        }
        if(opc.equals("farenheit")) {
            f = v;
            c = (f-32)/9.0*5.0f;
            k = c + 273.0;
        }
        if(opc.equals("kelvin")) {
            k = v;
            c = k-273.0;
            f = 9.0/5.0*c + 32.0;
        }
        //mostramos as conversões na tela:
        TextView tx1 = (TextView)findViewById(R.id.txt1);
        TextView tx2 = (TextView)findViewById(R.id.txt2);
        TextView tx3 = (TextView)findViewById(R.id.txt3);
        tx1.setText("" + c);
        tx2.setText("" + f);
        tx3.setText("" + k);
    }
}
