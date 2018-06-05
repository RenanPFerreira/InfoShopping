package com.example.opet.infoshopping.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.opet.infoshopping.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrar(View view){

        Intent intent = new Intent(MainActivity.this, NovoCadastro.class);
        startActivity(intent);
    }

    public void logar(View view){

        Intent intent = new Intent(this, Entrar.class);
        startActivity(intent);
    }


}
