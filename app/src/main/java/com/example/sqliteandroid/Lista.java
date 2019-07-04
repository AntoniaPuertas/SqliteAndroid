package com.example.sqliteandroid;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.sqliteandroid.bd.ContratoBD;

import java.util.Date;

public class Lista {

    private int id_lista;
    private int id_usuario_app;
    private int id_lugar;
    private String nombre_lista;
    private String descripcion_lista;
    private String publica_lista;
    private String f_creacion_lista;
    private String f_planificada_lista;
    private String f_finalizacion_lista;
    private int urgente_lista;
    private int importante_lista;
    private String esfera_lista;
    private String motivo_lista;
    private String link_lista;
    private Date f_creacion_listaDate;
    private Date f_planificada_listaDate;
    private Date f_finalizacion_listaDate;


    public Lista(int id_lista, int id_usuario_app, int id_lugar, String nombre_lista, String descripcion_lista, String publica_lista, String f_creacion_lista, String f_planificada_lista, String f_finalizacion_lista, int urgente_lista, int importante_lista, String esfera_lista, String motivo_lista, String link_lista) {
        this.id_lista = id_lista;
        this.id_usuario_app = id_usuario_app;
        this.id_lugar = id_lugar;
        this.nombre_lista = nombre_lista;
        this.descripcion_lista = descripcion_lista;
        this.publica_lista = publica_lista;
        this.f_creacion_lista = f_creacion_lista;
        this.f_planificada_lista = f_planificada_lista;
        this.f_finalizacion_lista = f_finalizacion_lista;
        this.urgente_lista = urgente_lista;
        this.importante_lista = importante_lista;
        this.esfera_lista = esfera_lista;
        this.motivo_lista = motivo_lista;
        this.link_lista = link_lista;
    }

    public Lista(Cursor cursor){
        id_lista = cursor.getInt(cursor.getColumnIndex(ContratoBD.ColumnasLista.ID_LISTA));
        id_usuario_app = cursor.getInt(cursor.getColumnIndex(ContratoBD.ColumnasLista.ID_USUARIO_APP));
        id_lugar = cursor.getInt(cursor.getColumnIndex(ContratoBD.ColumnasLista.ID_LUGAR));
        nombre_lista = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.NOMBRE_LISTA));
        descripcion_lista = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.DESCRIPCION_LISTA));
        publica_lista = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.PUBLICA_LISTA));
        f_creacion_lista = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.F_CREACION_LISTA));
        f_planificada_lista = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.F_PLANIFICADA_LISTA));
        f_finalizacion_lista = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.F_FINALIZACION_LISTA));
        urgente_lista = cursor.getInt(cursor.getColumnIndex(ContratoBD.ColumnasLista.URGENTE_LISTA));
        importante_lista = cursor.getInt(cursor.getColumnIndex(ContratoBD.ColumnasLista.IMPORTANTE_LISTA));
        esfera_lista = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.ESFERA_LISTA));
        motivo_lista = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.MOTIVO_LISTA));
        link_lista = cursor.getString(cursor.getColumnIndex(ContratoBD.ColumnasLista.LINK_LISTA));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ContratoBD.ColumnasLista.ID_LISTA, id_lista);
        values.put(ContratoBD.ColumnasLista.ID_USUARIO_APP, id_usuario_app);
        values.put(ContratoBD.ColumnasLista.ID_LUGAR, id_lugar);
        values.put(ContratoBD.ColumnasLista.NOMBRE_LISTA, nombre_lista);
        values.put(ContratoBD.ColumnasLista.DESCRIPCION_LISTA, descripcion_lista);
        values.put(ContratoBD.ColumnasLista.PUBLICA_LISTA, publica_lista);
        values.put(ContratoBD.ColumnasLista.F_CREACION_LISTA, String.valueOf(f_creacion_lista));
        values.put(ContratoBD.ColumnasLista.F_PLANIFICADA_LISTA, String.valueOf(f_planificada_lista));
        values.put(ContratoBD.ColumnasLista.F_FINALIZACION_LISTA, String.valueOf(f_finalizacion_lista));
        values.put(ContratoBD.ColumnasLista.URGENTE_LISTA, urgente_lista);
        values.put(ContratoBD.ColumnasLista.IMPORTANTE_LISTA, importante_lista);
        values.put(ContratoBD.ColumnasLista.ESFERA_LISTA, esfera_lista);
        values.put(ContratoBD.ColumnasLista.MOTIVO_LISTA, motivo_lista);
        values.put(ContratoBD.ColumnasLista.LINK_LISTA, link_lista);

        return values;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getId_usuario_app() {
        return id_usuario_app;
    }

    public void setId_usuario_app(int id_usuario_app) {
        this.id_usuario_app = id_usuario_app;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getNombre_lista() {
        return nombre_lista;
    }

    public void setNombre_lista(String nombre_lista) {
        this.nombre_lista = nombre_lista;
    }

    public String getDescripcion_lista() {
        return descripcion_lista;
    }

    public void setDescripcion_lista(String descripcion_lista) {
        this.descripcion_lista = descripcion_lista;
    }

    public String getPublica_lista() {
        return publica_lista;
    }

    public void setPublica_lista(String publica_lista) {
        this.publica_lista = publica_lista;
    }

    public String getF_creacion_lista() {
        return f_creacion_lista;
    }

    public void setF_creacion_lista(String f_creacion_lista) {
        this.f_creacion_lista = f_creacion_lista;
    }

    public String getF_planificada_lista() {
        return f_planificada_lista;
    }

    public void setF_planificada_lista(String f_planificada_lista) {
        this.f_planificada_lista = f_planificada_lista;
    }

    public String getF_finalizacion_lista() {
        return f_finalizacion_lista;
    }

    public void setF_finalizacion_lista(String f_finalizacion_lista) {
        this.f_finalizacion_lista = f_finalizacion_lista;
    }



    public int getUrgente_lista() {
        return urgente_lista;
    }

    public void setUrgente_lista(int urgente_lista) {
        this.urgente_lista = urgente_lista;
    }

    public int getImportante_lista() {
        return importante_lista;
    }

    public void setImportante_lista(int importante_lista) {
        this.importante_lista = importante_lista;
    }

    public String getEsfera_lista() {
        return esfera_lista;
    }

    public void setEsfera_lista(String esfera_lista) {
        this.esfera_lista = esfera_lista;
    }

    public String getMotivo_lista() {
        return motivo_lista;
    }

    public void setMotivo_lista(String motivo_lista) {
        this.motivo_lista = motivo_lista;
    }

    public String getLink_lista() {
        return link_lista;
    }

    public void setLink_lista(String link_lista) {
        this.link_lista = link_lista;
    }
}
