package com.example.androidcomponentes;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class CaixasDeTexto extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;
    private CheckBox checkVerde, checkBranco, checkVermelho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_caixas_de_texto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.email);
        textoResultado = findViewById(R.id.resultado);

        checkVerde = findViewById(R.id.checkVerde);
        checkBranco = findViewById(R.id.checkBranco);
        checkVermelho = findViewById(R.id.checkVermelho);

    }

    public void enviar(View view){
        boolean resultadoVerde = checkVerde.isChecked();
        boolean resultadoBranco = checkBranco.isChecked();
        boolean resultadoVermelho = checkVermelho.isChecked();

        String texto = " Foi selecionado ";
        if(resultadoVerde){
            String corSelecionada = String.format(" %s",checkVerde.getText().toString());
            texto = texto.concat(corSelecionada);
        }
        if(resultadoBranco){
            String corSelecionada = String.format(" %s",checkBranco.getText().toString());
            texto = texto.concat(corSelecionada);
        }
        if(resultadoVermelho){
            String corSelecionada = String.format(" %s",checkVermelho.getText().toString());
            texto = texto.concat(corSelecionada);
        }
        String nome = campoNome.getText().toString();
        String email = String.valueOf(campoEmail.getText());

        textoResultado.setText(String.format("nome %s email %s%s", nome, email, texto));
    }

    public void limpar(View view){
        campoNome.setText("");
        campoEmail.setText("");
    }
}