package com.example.sqliteandroid.bd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqliteandroid.Item;
import com.example.sqliteandroid.Lista;

public class BaseDatosHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "miBaseDB";

    public BaseDatosHelper(Context context ){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Aquí creamos las tablas
        db.execSQL("CREATE TABLE " + ContratoBD.ColumnasLista.TABLE_NAME + " (" +
                ContratoBD.ColumnasLista.ID_LISTA + " integer primary key not null," +
                ContratoBD.ColumnasLista.ID_USUARIO_APP + " integer  not null," +
                ContratoBD.ColumnasLista.ID_LUGAR + " integer  not null," +
                ContratoBD.ColumnasLista.NOMBRE_LISTA + " TEXT  not null," +
                ContratoBD.ColumnasLista.DESCRIPCION_LISTA + " TEXT  not null," +
                ContratoBD.ColumnasLista.PUBLICA_LISTA + " TEXT  not null," +
                ContratoBD.ColumnasLista.F_CREACION_LISTA + " DATE  not null," +
                ContratoBD.ColumnasLista.F_PLANIFICADA_LISTA + " DATE  not null," +
                ContratoBD.ColumnasLista.F_FINALIZACION_LISTA + " DATE  not null," +
                ContratoBD.ColumnasLista.URGENTE_LISTA + " int  not null," +
                ContratoBD.ColumnasLista.IMPORTANTE_LISTA + " int  not null," +
                ContratoBD.ColumnasLista.ESFERA_LISTA + " TEXT  not null," +
                ContratoBD.ColumnasLista.MOTIVO_LISTA + " TEXT  not null," +
                ContratoBD.ColumnasLista.LINK_LISTA+ " TEXT  not null)");

        db.execSQL("CREATE TABLE "+ ContratoBD.ColumnasItem.TABLE_NAME +" ( " +
                ContratoBD.ColumnasItem.ID_ITEM + " integer primary key  not null," +
                ContratoBD.ColumnasItem.ID_LISTA + " integer  not null," +
                ContratoBD.ColumnasItem.ITEM+ " TEXT  not null," +
                "FOREIGN KEY(item_listaFK) REFERENCES " + ContratoBD.ColumnasLista.TABLE_NAME + "("+ContratoBD.ColumnasLista.ID_LISTA+"))");

        //insertar datos de prueba
        mockData(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    //datos de prueba
    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockLista(sqLiteDatabase, new Lista(1, 1,
                1, "Nombre lista 1",
                "descripción 1", "publica", "2019-07-02", "2019-07-09", "2019-07-09", 5,5,"personal", "",""));
        mockLista(sqLiteDatabase, new Lista(2, 2,
                2, "Nombre lista 2",
                "descripción 2", "privada", "2019-07-03", "2019-07-10", "2019-07-10", 4,4,"amistad", "",""));
        mockLista(sqLiteDatabase, new Lista(3, 3,
                3, "Nombre 3",
                "descripción 1", "publica", "2019-07-05", "2019-07-12", "2019-07-12", 2,2,"laboral", "",""));
        mockLista(sqLiteDatabase, new Lista(4, 4,
                4, "Nombre 4",
                "descripción 1", "publica", "2019-07-06", "2019-07-13", "2019-07-13", 0,0,"amistad", "",""));

        mockItem(sqLiteDatabase, new Item(1,1,"item 1"));
        mockItem(sqLiteDatabase, new Item(2,1,"item 2"));
        mockItem(sqLiteDatabase, new Item(3,1,"item 3"));
        mockItem(sqLiteDatabase, new Item(4,1,"item 4"));
        mockItem(sqLiteDatabase, new Item(5,1,"item 5"));
        mockItem(sqLiteDatabase, new Item(6,1,"item 6"));
        mockItem(sqLiteDatabase, new Item(7,1,"item 7"));
        mockItem(sqLiteDatabase, new Item(8,1,"item 8"));
        mockItem(sqLiteDatabase, new Item(9,2,"item 1"));
        mockItem(sqLiteDatabase, new Item(10,2,"item 2"));
        mockItem(sqLiteDatabase, new Item(11,2,"item 3"));
        mockItem(sqLiteDatabase, new Item(12,2,"item 4"));
        mockItem(sqLiteDatabase, new Item(13,3,"item 1"));
        mockItem(sqLiteDatabase, new Item(14,3,"item 2"));
        mockItem(sqLiteDatabase, new Item(15,4,"item 1"));


    }

    public long mockLista(SQLiteDatabase db, Lista lista) {
        return db.insert(
                ContratoBD.ColumnasLista.TABLE_NAME,
                null,
                lista.toContentValues());
    }

    public long mockItem(SQLiteDatabase db, Item item) {
        return db.insert(
                ContratoBD.ColumnasItem.TABLE_NAME,
                null,
                item.toContentValues());
    }


    //consultas sobre la tabla listas
    public long guardarLista(Lista lista){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                ContratoBD.ColumnasLista.TABLE_NAME,
                null,
                lista.toContentValues()
        );
    }

    public Cursor getAllListas(){
        return getReadableDatabase()
                .query(
                        ContratoBD.ColumnasLista.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getListaById(String id){
        Cursor c = getReadableDatabase().query(
                ContratoBD.ColumnasLista.TABLE_NAME,
                null,
                ContratoBD.ColumnasLista.ID_LISTA + " LIKE ?",
                 new String[]{id},
                null,
                null,
                null);
        return c;
    }

    public int deleteLista(String id){
        return getWritableDatabase().delete(
                ContratoBD.ColumnasLista.TABLE_NAME,
                ContratoBD.ColumnasLista.ID_LISTA + " LIKE ?",
                new String[]{id}
        );
    }


    public int updateLista(Lista lista, String id){
        return getWritableDatabase().update(
                ContratoBD.ColumnasLista.TABLE_NAME,
                lista.toContentValues(),
                ContratoBD.ColumnasLista.ID_LISTA + " LIKE ?",
                new String[]{id}
        );
    }

    //consultas sobre la tabla items
    public long guardarItem(Item item){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                ContratoBD.ColumnasItem.TABLE_NAME,
                null,
                item.toContentValues()
        );
    }

    public Cursor getAllItems(){
        return getReadableDatabase()
                .query(
                        ContratoBD.ColumnasItem.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getItemById(String id){
        Cursor c = getReadableDatabase().query(
                ContratoBD.ColumnasItem.TABLE_NAME,
                null,
                ContratoBD.ColumnasItem.ID_ITEM + " LIKE ?",
                new String[]{id},
                null,
                null,
                null);
        return c;
    }

    public int deleteItem(String id){
        return getWritableDatabase().delete(
                ContratoBD.ColumnasItem.TABLE_NAME,
                ContratoBD.ColumnasItem.ID_ITEM + " LIKE ?",
                new String[]{id}
        );
    }

    public int updateItem(Item item, String id){
        return getWritableDatabase().update(
                ContratoBD.ColumnasItem.TABLE_NAME,
                item.toContentValues(),
                ContratoBD.ColumnasItem.ID_ITEM + " LIKE ?",
                new String[]{id}
        );
    }

}
