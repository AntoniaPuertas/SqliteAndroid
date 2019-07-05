package com.example.sqliteandroid;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sqliteandroid.bd.BaseDatosHelper;
import com.example.sqliteandroid.bd.ContratoBD;

public class MainActivity extends AppCompatActivity {

    ListasAdapter listasAdapter;
    Cursor cursor;
    ListView lvListas;
    Context context;
    BaseDatosHelper baseDatosHelper;

    public static final String ID_LISTA_SELECCIONADA = "id_lista_seleccionada";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        lvListas = findViewById(R.id.lvListas);
        listasAdapter = new ListasAdapter(context, cursor, 0);
        lvListas.setAdapter(listasAdapter);

        baseDatosHelper = new BaseDatosHelper(context);

        lvListas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Cursor itemSeleccionado = (Cursor) listasAdapter.getItem(position);
                String idListaSeleccionada = itemSeleccionado.getString(itemSeleccionado.getColumnIndex(ContratoBD.ColumnasLista.ID_LISTA));

                Intent intent = new Intent(MainActivity.this, DetalleListaActivity.class);
                intent.putExtra(ID_LISTA_SELECCIONADA, idListaSeleccionada);
                startActivity(intent);
            }
        });

        new CargarListas().execute();

    }

    private class CargarListas extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return baseDatosHelper.getAllListas();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                listasAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }
}
