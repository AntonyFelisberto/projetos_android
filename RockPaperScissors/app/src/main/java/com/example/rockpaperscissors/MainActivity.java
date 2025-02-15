package com.example.rockpaperscissors;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selectedOption(View view) {
        ImageView imageResult = findViewById(R.id.result);
        TextView textResult = findViewById(R.id.textResult);

        String userOption = view.getResources().getResourceEntryName(view.getId());

        String[] optionsSystem = {"rock","paper","scissor"};
        int number = new Random().nextInt(3);
        String appOption = optionsSystem[number];

        switch (appOption){
            case "rock":
                imageResult.setImageResource(R.drawable.rock);
                break;
            case "paper":
                imageResult.setImageResource(R.drawable.paper);
                break;
            default:
                imageResult.setImageResource(R.drawable.scissor);
                break;
        }

        if (
            (appOption.equals("scissor") && userOption.equals("paper")) ||
            (appOption.equals("paper") && userOption.equals("rock")) ||
            (appOption.equals("rock") && userOption.equals("scissor"))
        ) {
            textResult.setText("Você perdeu");
        } else if (
            (userOption.equals("scissor") && appOption.equals("paper")) ||
            (userOption.equals("paper") && appOption.equals("rock")) ||
            (userOption.equals("rock") && appOption.equals("scissor"))
        ) {
            textResult.setText("Você ganhou");
        } else {
            textResult.setText("Empate");
        }
    }

}