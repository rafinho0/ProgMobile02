package br.com.progmobile02.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.progmobile02.activity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializamos a variavel de binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Quando clicarmos em login, nos executaremos esse codigo para testarmos
        // se os campos de login e senha estao validos, ou seja, nao nulos
        // e nao maiores que a quantidade exigida
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Setamos a variavel como true e testaremos se ela esta valida
                boolean isValid = true;

                // Aqui faremos um if-else com uma operacao ternaria
                // se nao forem nulos, iremos pegar o texto e retornaremos a string toda junta, sem espacos
                // se forem nulos, retornaremos uma string vazia
                String login = binding.tieLogin.getText() != null ?
                               binding.tieLogin.getText().toString().trim() : "";
                String password = binding.tiePassword.getText() != null ?
                        binding.tiePassword.getText().toString().trim() : "";


                // Criamos a mensagem de erro e abaixo nos retornaremos ela se necessario
                String msgRequired = getString(R.string.msg_required_field);

                if (login.isEmpty()) {
                    isValid = false;
                    binding.tilLogin.setError(msgRequired);
                }
                else {
                    binding.tilLogin.setError(null);
                }

                if (password.isEmpty()) {
                    isValid = false;
                    binding.tilPassword.setError(msgRequired);
                }
                else {
                    binding.tilPassword.setError(null);
                }

                // Ativar quando criarmos uma outra tela
                if (isValid) {
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                }
            }
        });


        // Nos dois metodos abaixo nos iremos retornar uma mensagem dizendo que o link
        // esta funcionando
        binding.tvPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMessageLink("senha");
            }
        });

        binding.tvSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMessageLink("cadastro");
            }
        });
    }


    // Criei essa funcao para mostrar a mensagem sem precisar ter que repetir o codigo do toast
    public void showMessageLink(String elementName) {

        Toast.makeText(
                MainActivity.this,
                "Link de " + elementName +  " está funcionando e redirecionamento feito!",
                Toast.LENGTH_SHORT
        ).show();
    }
}