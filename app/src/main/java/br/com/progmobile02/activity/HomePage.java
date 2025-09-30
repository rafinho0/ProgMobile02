package br.com.progmobile02.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.progmobile02.activity.databinding.ActivityHomePageBinding;

public class HomePage extends AppCompatActivity {

    private int counterInt = 0;
    private TextView counterStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Dessa vez nao utilizei o View Binding pois nao consegui fazer dessa forma
        setContentView(R.layout.activity_home_page);


        // Referenciamos o botao de sair
        TextView tvSignOut = findViewById(R.id.tvSignOut);

        // Cada atributo referenciando o id do elemento
        counterStr = findViewById(R.id.counter);
        Button add = findViewById(R.id.add);
        Button reset = findViewById(R.id.reset);
        Button subtract = findViewById(R.id.subtract);

        // Funcao para atualizar o contador
        updateCounter();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterInt++;
                updateCounter();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterInt = 0;
                updateCounter();
            }
        });


        // Deixei a opção do número poder ser negativo
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterInt--;
                updateCounter();
            }
        });


        tvSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("HomePage", "Saindo via findViewById.");

                // Aqui iremos limpar a pilha da memoria
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
                finish();
            }
        });
    }

    private void updateCounter() {

        counterStr.setText(String.valueOf(counterInt));
    }
}