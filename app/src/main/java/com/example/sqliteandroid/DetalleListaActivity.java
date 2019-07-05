package com.example.sqliteandroid;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqliteandroid.bd.BaseDatosHelper;

public class DetalleListaActivity extends AppCompatActivity {

    TextView txtNombre;
    TextView txtDescripcion;
    TextView txtEsfera;
    TextView txtMotivo;

    String id_lista;

    BaseDatosHelper baseDatosHelper;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_lista);

        context = this;

        txtNombre = findViewById(R.id.txtNombre);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtEsfera = findViewById(R.id.txtEsfera);
        txtMotivo = findViewById(R.id.txtMotivo);

        id_lista = getIntent().getExtras().getString(MainActivity.ID_LISTA_SELECCIONADA);

        baseDatosHelper = new BaseDatosHelper(context);
        new GetListaById().execute();
    }


    private void mostrarLista(Lista lista){
        txtNombre.setText(lista.getNombre_lista());
        txtDescripcion.setText(lista.getDescripcion_lista());
        txtEsfera.setText(lista.getEsfera_lista());
        txtMotivo.setText(lista.getMotivo_lista());
    }

    private void mostrarError(){
        Toast.makeText(context, "Error al cargar la información", Toast.LENGTH_LONG).show();
    }

    private class GetListaById extends AsyncTask<Void, Void, Cursor>{

        @Override
        protected Cursor doInBackground(Void... voids) {
            return baseDatosHelper.getListaById(id_lista);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if(cursor != null && cursor.moveToLast()){
                mostrarLista(new Lista(cursor));
            }else{
                mostrarError();
            }
        }
    }

}
