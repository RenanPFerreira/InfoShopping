package com.example.opet.infoshopping.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.opet.infoshopping.Model.Cliente;
import com.example.opet.infoshopping.Util.BancoUtil;

import java.util.ArrayList;
import java.util.List;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by opet on 13/06/2018.
 */

public class ClienteRepository {

    BancoUtil databaseUtil;

    /***
     * CONSTRUTOR
     * @param context
     */
    public ClienteRepository(Context context){

        databaseUtil =  new BancoUtil(context);

    }

    public void Salvar(Cliente cliente){

        ContentValues contentValues =  new ContentValues();
        /*MONTANDO OS PARAMETROS PARA SEREM SALVOS*/
        contentValues.put("ds_nome", cliente.getNome());
        contentValues.put("ds_cpf", cliente.getCPF());
        contentValues.put("ds_email", cliente.getEmail());
        contentValues.put("ds_senha", cliente.getSenha());

        /*EXECUTANDO INSERT DE UM NOVO REGISTRO*/
        databaseUtil.GetConexaoDataBase().insert("tb_cliente",null,contentValues);

    }

    public void Atualizar(Cliente cliente){

        ContentValues contentValues =  new ContentValues();

        /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
        contentValues.put("ds_nome", cliente.getNome());
        contentValues.put("ds_cpf", cliente.getCPF());
        contentValues.put("ds_email", cliente.getEmail());
        contentValues.put("ds_senha", cliente.getSenha());

        /*REALIZANDO UPDATE PELA CHAVE DA TABELA*/
        databaseUtil.GetConexaoDataBase().update("tb_cliente", contentValues, "id_cliente = ?", new String[]{Integer.toString(cliente.getID())});
    }

    public Integer Excluir(int codigo){

        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return databaseUtil.GetConexaoDataBase().delete("tb_cliente","id_cliente = ?", new String[]{Integer.toString(codigo)});
    }

    public Cliente GetCliente(int codigo){


        Cursor cursor =  databaseUtil.GetConexaoDataBase().rawQuery("SELECT * FROM tb_cliente WHERE id_cliente= "+ codigo,null);

        cursor.moveToFirst();

        Cliente cliente =  new Cliente();

        cliente.setID(cursor.getInt(cursor.getColumnIndex("id_cliente")));
        cliente.setNome(cursor.getString(cursor.getColumnIndex("ds_nome")));
        cliente.setCPF(cursor.getLong(cursor.getColumnIndex("ds_cpf")));
        cliente.setEmail(cursor.getString(cursor.getColumnIndex("ds_email")));
        cliente.setSenha(cursor.getString(cursor.getColumnIndex("ds_senha")));


        return cliente;

    }

    public List<Cliente> SelecionarTodos(){

        List<Cliente> clientes = new ArrayList<Cliente>();


        //MONTA A QUERY A SER EXECUTADA
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT id_cliente,      ");
        stringBuilderQuery.append("        ds_nome,         ");
        stringBuilderQuery.append("        ds_cpf,          ");
        stringBuilderQuery.append("        ds_email,        ");
        stringBuilderQuery.append("        ds_senha,        ");
        stringBuilderQuery.append("  FROM  tb_cliente       ");
        stringBuilderQuery.append(" ORDER BY ds_nome        ");


        //CONSULTANDO OS REGISTROS CADASTRADOS
        Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);

        /*POSICIONA O CURSOR NO PRIMEIRO REGISTRO*/
        cursor.moveToFirst();


        Cliente cliente;

        //REALIZA A LEITURA DOS REGISTROS ENQUANTO NÃO FOR O FIM DO CURSOR
        while (!cursor.isAfterLast()){

            /* CRIANDO UMA NOVA PESSOAS */
            cliente =  new Cliente();

            //ADICIONANDO OS DADOS DA PESSOA
            cliente.setID(cursor.getInt(cursor.getColumnIndex("id_cliente")));
            cliente.setNome(cursor.getString(cursor.getColumnIndex("ds_nome")));
            cliente.setCPF(cursor.getLong(cursor.getColumnIndex("ds_cpf")));
            cliente.setEmail(cursor.getString(cursor.getColumnIndex("ds_email")));
            cliente.setSenha(cursor.getString(cursor.getColumnIndex("ds_senha")));

            //ADICIONANDO UMA PESSOA NA LISTA
            clientes.add(cliente);

            //VAI PARA O PRÓXIMO REGISTRO
            cursor.moveToNext();
        }

        //RETORNANDO A LISTA DE PESSOAS
        return clientes;

    }
}