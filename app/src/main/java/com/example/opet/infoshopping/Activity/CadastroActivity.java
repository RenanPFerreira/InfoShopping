package com.example.opet.infoshopping.Activity;

import com.example.opet.infoshopping.Model.Cliente;
import com.example.opet.infoshopping.R;
import com.example.opet.infoshopping.Repository.ClienteRepository;
import com.example.opet.infoshopping.Util.Util;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

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

        this.CriarComponentes();

    }

    protected  void CriarComponentes(){

        editTextNome = (EditText) this.findViewById(R.id.editNome);
        editTextCpf = (EditText) this.findViewById(R.id.editCpf);
        editTextEmail = (EditText) this.findViewById(R.id.editEmail);
        editTextSenha = (EditText) this.findViewById(R.id.editSenha);
        buttonSalvar = (Button) this.findViewById(R.id.salvar);
        buttonVoltar = (Button) this.findViewById(R.id.voltar);
    }

    protected  void Salvar_onClick() {

        if (editTextNome.getText().toString().trim().equals("")) {

            Util.Alert(this, this.getString(R.string.nome_obrigatorio));

            editTextNome.requestFocus();
        } else if (editTextCpf.getText().toString().trim().equals("")) {

            Util.Alert(this, this.getString(R.string.cpf_obrigatorio));

            editTextCpf.requestFocus();

        } else if (editTextEmail.getText().toString().trim().equals("")) {

            Util.Alert(this, this.getString(R.string.email_valido));

            editTextEmail.requestFocus();

        } else if (editTextSenha.getText().toString().trim().equals("")) {

            Util.Alert(this, this.getString(R.string.senha_valida));

            editTextSenha.requestFocus();

        } else {


            /*CRIANDO UM OBJETO PESSOA*/
            Cliente cliente = new Cliente();

            /*SETANDO O VALOR DO CAMPO NOME*/
            cliente.setNome(editTextNome.getText().toString().trim());

            cliente.setCPF(Long.parseLong(editTextCpf.getText().toString().trim()));

            cliente.setEmail(editTextEmail.getText().toString().trim());

            cliente.setSenha(editTextSenha.getText().toString().trim());

            /*SALVANDO UM NOVO REGISTRO*/
            new ClienteRepository(this).Salvar(cliente);

            /*MENSAGEM DE SUCESSO!*/
            Util.Alert(this, this.getString(R.string.registro_salvo_sucesso));

            LimparCampos();
        }
    }

        protected void LimparCampos(){

            editTextNome.setText(null);
            editTextEmail.setText(null);
            editTextCpf.setText(null);
            editTextSenha.setText(null);
        }




    }

