package com.example.sqliteandroid.bd;

import android.provider.BaseColumns;

/**
 * En esta clase creamos las constantes para los nombres de las tablas y de las columnas de la base
 * **/

public class ContratoBD {

    public static abstract class ColumnasLista implements BaseColumns {
        public static final String TABLE_NAME = "listas";
        public static final String ID_LISTA = "id_lista";
        public static final String ID_USUARIO_APP = "id_usuario_app";
        public static final String ID_LUGAR = "id_lugar";
        public static final String NOMBRE_LISTA = "nombre_lista";
        public static final String DESCRIPCION_LISTA = "descripcion_lista";
        public static final String PUBLICA_LISTA = "publica_lista";
        public static final String F_CREACION_LISTA = "f_creacion_lista";
        public static final String F_PLANIFICADA_LISTA = "f_planificada_lista";
        public static final String F_FINALIZACION_LISTA = "f_finalizacion_lista";
        public static final String URGENTE_LISTA = "urgente_lista";
        public static final String IMPORTANTE_LISTA = "importante_lista";
        public static final String ESFERA_LISTA = "esfera_lista";
        public static final String MOTIVO_LISTA = "motivo_lista";
        public static final String LINK_LISTA = "link_lista";
    }

    public static abstract class ColumnasItem implements BaseColumns{
        public static final String TABLE_NAME = "items";
        public static final String ID_ITEM = "id_item";
        public static final String ID_LISTA = "id_lista";
        public static final String ITEM = "item";
    }

}
