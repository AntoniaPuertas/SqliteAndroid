package com.example.sqliteandroid;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.sqliteandroid.bd.ContratoBD;

public class Item {
    private int id_item;
    private int id_lista;
    private String item;

    public Item(int id_item, int id_lista, String item) {
        this.id_item = id_item;
        this.id_lista = id_lista;
        this.item = item;
    }

    public Item(Cursor cursor){
        id_item = cursor.getInt(cursor.getColumnIndex(ContratoBD.ColumnasItem.ID_ITEM));
        id_lista = cursor.getInt(cursor.getColumnIndex(ContratoBD.ColumnasItem.ID_LISTA));
        item = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasItem.ITEM));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ContratoBD.ColumnasItem.ID_ITEM, id_item);
        values.put(ContratoBD.ColumnasItem.ID_LISTA, id_lista);
        values.put(ContratoBD.ColumnasItem.ITEM, item);
        return values;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
