package com.example.opet.infoshopping.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by opet on 06/06/2018.
 */

public class BancoUtil extends SQLiteOpenHelper {

    private static final String NOME_BASE_DE_DADOS   = "INFOSHOPPING.db";

    private static final int    VERSAO_BASE_DE_DADOS = 1;

    public BancoUtil(Context context){

        super(context,NOME_BASE_DE_DADOS,null,VERSAO_BASE_DE_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append(" CREATE TABLE tb_cliente (");
        stringBuilderCreateTable.append("        id_cliente     INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable.append("        ds_nome        TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_cpf         LONG    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_email       TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_senha       TEXT    NOT NULL,            ");


        db.execSQL(stringBuilderCreateTable.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS tb_cliente");
        onCreate(db);

    }

    public SQLiteDatabase GetConexaoDataBase(){

        return this.getWritableDatabase();
    }
}
