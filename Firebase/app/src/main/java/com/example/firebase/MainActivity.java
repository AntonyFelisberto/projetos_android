package com.example.firebase;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    private final FirebaseAuth usuario = FirebaseAuth.getInstance();

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

        //LOGIN
//        usuario.signInWithEmailAndPassword("kratos1111@gmail.com","senhaForteTestes@190")
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Log.i("Sign","Sucesso ao realizar sign");
//                        }else{
//                            Log.i("Sign","Erro ao realizar sign");
//                        }
//                    }
//                });

//        usuario.signOut(); //deslogar

//        usuario.createUserWithEmailAndPassword("kratos@gmail.com","senhaForteTestes@190")
//                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Log.i("CreateUser","Sucesso ao cadastrar usuario");
//                        }else{
//                            Log.i("CreateUser","Erro ao cadastrar usuario");
//                        }
//                    }
//                });

//        if(usuario.getCurrentUser() != null){
//            Log.i("Login","Usuario Logado");
//        }else{
//            Log.i("Login","Usuario não logado");
//        }

        //UPDATES (BASTA INSERIR OUTRO VALOR UTILIZANDO O MESMO CHILD),INSERTS E SELECTS
//        DatabaseReference usuariosDatabase = databaseReference.child("usuarios");
//        DatabaseReference produtosDatabase = databaseReference.child("produtos");

//        Usuario usuario = new Usuario("Artorias","Watcher",50);
//        Produto produto = new Produto("Nexus","LG",1000.00);
//
//        produtosDatabase.child("001").setValue(produto);
//        usuariosDatabase.child("001").setValue(usuario);
//        usuariosDatabase.push().setValue(usuario);    //gerando id unico

//        usuariosDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.i("Firebase",snapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


    }
}