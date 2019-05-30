package com.example.t2_swipe;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout LayoutTotal;
    private TextView txtRegiao, txtEstados;
    private String[] regiao;
    private String[][] estado;
    private int cont, contEstados;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutTotal = (LinearLayout) findViewById(R.id.LayoutTotal);
        txtRegiao =  (TextView) findViewById(R.id.txtRegiao);
        txtEstados = (TextView) findViewById(R.id.txtEstados);
        cont = 0;
        contEstados = 0;


        regiao = new String[] {
                "Sul",
                "Sudeste",
                "Norte",
                "Nordeste",
                "Centro-Oeste",

        };

        estado = new String[][] {
                {"Paraná","Rio Grande do Sul", "Santa Catarina"},
                {"Espírito Santo","Minas Gerais","Rio de Janeiro","São Paulo"},
                {"Acre","Amapá","Amazonas","Pará","Rondônia","Roraima","Tocantins"},
                {"Alagoas","Bahia","Ceará","Maranhão","Paraíba","Pernambuco","Piauí","Sergipe","Rio Grande do Norte"},
                {"Distrito Federal","Goiás","Mato Grosso","Mato Grosso do Sul"},

        };

        txtRegiao.setText( regiao[cont]);
        txtEstados.setText(estado[cont][contEstados]);

        LayoutTotal.setOnTouchListener( new OnSwipeTouchListener(this){

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                contEstados ++;
                if (contEstados >= estado[cont].length){
                    contEstados = 0;
                }
                txtEstados.setText(estado[cont][contEstados]);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                contEstados --;
                if(contEstados < 0 ){
                    contEstados = estado[cont].length-1;
                }
                txtEstados.setText(estado[cont][contEstados]);
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();

                cont ++;
                if (cont >= regiao.length){
                    cont = 0;
                }
                txtRegiao.setText(regiao[cont]);
                contEstados = 0;
                txtEstados.setText(estado[cont][contEstados]);
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                cont --;
                if(cont < 0 ){
                    cont = regiao.length-1;
                }
                txtRegiao.setText( regiao[cont]);
                contEstados = 0;
                txtEstados.setText(estado[cont][contEstados]);
            }
        });
    }
}
