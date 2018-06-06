package com.example.opet.infoshopping.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.opet.infoshopping.Factory.DatabaseFactory;
import com.example.opet.infoshopping.Model.Cliente;
import com.example.opet.infoshopping.Util.BancoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by opet on 06/06/2018.
 */

public class ClienteDAO {


    private SQLiteDatabase db;
    private DatabaseFactory banco;


    public ClienteDAO(Context context) {
        banco = new DatabaseFactory(context);
    }

    public long insereDado(Cliente cliente) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoUtil.NOME_CLIENTE, cliente.getNome());
        valores.put(BancoUtil.ID_CLIENTE, cliente.getID());
        valores.put(BancoUtil.CPF_CLIENTE, cliente.getCPF());
        valores.put(BancoUtil.EMAIL, cliente.getEmail());

        resultado = db.insert(BancoUtil.TABELA_CLIENTE,  null, valores);
        db.close();

        return resultado;
    }

    public void deletaRegistro(int id){
        String where = BancoUtil.ID_CLIENTE + "=" + id;
        db = banco.getReadableDatabase();

        db.delete(BancoUtil.TABELA_CLIENTE, where,null);
        db.close();
    }

    public boolean atualizaCadastro(Cliente cliente){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = BancoUtil.ID_CLIENTE + " = " + cliente.getID();

        valores = new ContentValues();
        valores.put(BancoUtil.NOME_CLIENTE, cliente.getNome());
        valores.put(BancoUtil.EMAIL, cliente.getEmail());
        valores.put(BancoUtil.SENHA, cliente.getSenha());

        int resultado = db.update(BancoUtil.TABELA_CLIENTE,valores,where,null);
        db.close();
        if(resultado > 0)
            return true;
        else
            return false;
    }

}
