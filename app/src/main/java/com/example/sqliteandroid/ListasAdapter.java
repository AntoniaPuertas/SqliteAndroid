package com.example.sqliteandroid;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.sqliteandroid.bd.ContratoBD;

public class ListasAdapter extends CursorAdapter {

    private LayoutInflater cursorInflater;

    public ListasAdapter(Context context, Cursor cursor, int flags){
        super(context, cursor, flags);
        cursorInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return cursorInflater.inflate(R.layout.item_lista, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtNombreLista = (TextView)view.findViewById(R.id.txtNombreLista);
        TextView txtDescripcionLista = (TextView)view.findViewById(R.id.txtDescripcionLista);

        String nombre = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.NOMBRE_LISTA));
        String descripcion = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.DESCRIPCION_LISTA));

        txtNombreLista.setText(nombre);
        txtDescripcionLista.setText(descripcion);
    }
}
