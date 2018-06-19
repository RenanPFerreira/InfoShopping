package com.example.opet.infoshopping.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.opet.infoshopping.R;
import com.example.opet.infoshopping.Repository.ClienteRepository;
import com.example.opet.infoshopping.Util.Util;

/**
 * Created by opet on 04/06/2018.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText editLogin;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editLogin = (EditText) findViewById(R.id.editEmailLogin);
        editSenha = (EditText) findViewById(R.id.editSenhaLogin);

    }


    public void logarUsuario(View v){
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        ClienteRepository clienteRepository = new ClienteRepository(this);
        long idUsuario = clienteRepository.validaCliente(login, Util.toMD5(senha));
        if(idUsuario > 0){
            Toast.makeText(this, "Usuário Logado com Sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            intent.putExtra("ID_CLIENTE",idUsuario);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this, "Usuário não Cadastrado.", Toast.LENGTH_SHORT).show();
        }
    }
}
