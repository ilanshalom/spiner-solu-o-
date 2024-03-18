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

public class Tempo extends AppCompatActivity {
    private Spinner sp;
    private EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo_constraint);
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
        //Para calcular também quando o usuário digita algo, atendemos evento de teclado onKey:
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
        //Começamos pegando o valor digitado pelo usuário:
        float v = 0.0f;
        try {
            v = Float.parseFloat( ((EditText)findViewById(R.id.valor)).getText().toString() );
        } catch(Exception ex){
            return;  //se o dado digitado estiver errado ou incompleto, abandonamos o cálculo
        }
        float ms = 0.0f, seg = 0.0f, min = 0.0f, hora = 0.0f, dia = 0.0f ;
        if(opc.equals("ms")) {
            ms = v; seg = ms/1000; min = seg/60; hora = min/60; dia = hora/24;
        }
        if(opc.equals("seg")) {
            seg = v; ms = seg*1000; min = seg/60; hora = min/60; dia = hora/24;
        }
        if(opc.equals("min")) {
            min = v; seg = min*60; ms = seg*1000; hora = min/60; dia = hora/24;
        }
        if(opc.equals("hora")) {
            hora = v; min = hora*60; seg = min*60; ms = seg*1000; dia = hora/24;
        }
        if(opc.equals("dia")) {
            dia = v; hora = dia*24; min = hora*60; seg = min*60; ms = seg*1000;
        }
        //mostramos as conversões na tela:
        TextView tx1 = (TextView)findViewById(R.id.txt1);
        TextView tx2 = (TextView)findViewById(R.id.txt2);
        TextView tx3 = (TextView)findViewById(R.id.txt3);
        TextView tx4 = (TextView)findViewById(R.id.txt4);
        TextView tx5 = (TextView)findViewById(R.id.txt5);
        tx1.setText("" + ms);
        tx2.setText("" + seg);
        tx3.setText("" + min);
        tx4.setText("" + hora);
        tx5.setText("" + dia);
    }
}
