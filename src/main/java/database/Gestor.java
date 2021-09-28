package database;

import models.Tickler;

public class Gestor {

    public static void getTickler(){
        //llamamos la funcion dentro la class de conexion y le pasamos el valor que buscamos
        Tickler tickler = new ConnectionToPL().getTickler(2429818337L);
    }
}
