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

    public void carregaItemMenu (View v){
        switch (v.getId())
        {
            case R.id.Cadastro:
                carregarIntent(NovoCadastro.class);
            break;
            case R.id.Entrar:
                carregarIntent(Entrar.class);
            break;
        }
    }
    private void carregarIntent(Class classe){
        Intent intent = new Intent(MainActivity.this,classe);
        startActivity(intent);
    }
}
