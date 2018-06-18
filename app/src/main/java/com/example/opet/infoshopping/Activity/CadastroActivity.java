package com.example.opet.infoshopping.Activity;

import com.example.opet.infoshopping.Model.Cliente;
import com.example.opet.infoshopping.R;
import com.example.opet.infoshopping.Repository.ClienteRepository;
import com.example.opet.infoshopping.Util.Util;
import com.example.opet.infoshopping.Model.Cliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by opet on 04/06/2018.
 */


public class CadastroActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextCpf;
    EditText editTextEmail;
    EditText editTextSenha;
    Button buttonSalvar;
    Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        editTextEmail = (EditText) findViewById(R.id.editEmail);
        editTextSenha = (EditText) findViewById(R.id.editSenha);
    }

    public void gravarCliente(View v){
        Cliente cliente = new Cliente();
        String email = editTextEmail.getText().toString();
        String senha = editTextSenha.getText().toString();

        cliente.setEmail(email);
        cliente.setSenha(Util.toMD5(senha));

        ClienteRepository clienteRepository = new ClienteRepository(this);
        long result = clienteRepository.insereDado(cliente);
        if(result > 0){
            Toast.makeText(this, "Usuário Cadastrado!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CadastroActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this, "Usuário não Cadastrado.", Toast.LENGTH_SHORT).show();
        }
    }
}
