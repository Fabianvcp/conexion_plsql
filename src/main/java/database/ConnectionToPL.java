package database;

import models.Tickler;
import net.bytebuddy.asm.Advice;

import java.sql.*;

public class ConnectionToPL {

    private Connection connection;
/* datos de conexion*/
    private String plUser = "EXD21089";
    private String plPass = "fabian7284";
    private Integer port = 1521;
    private String dbname = "ARTPROD";
    private String host = "melideo.claro.amx";
    /* /datos de conexion */
    //variable con la conexion
    private String StringConnection = "jdbc:oracle:thin:@" + host + ":"+ this.port + ":" + this.dbname;
    //abrimos la conexion
    public void openConnection(){
        try {
            //ingresamos datos de conexion, usuario y contraseña
            this.connection = DriverManager.getConnection(this.StringConnection, this.plUser, this.plPass);
            //si es distinto a cerrado
            if(!this.connection.isClosed()){
                //mensaje si la conexion fue existosa
                System.out.println("Connected to Oracle successfully");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //cerramos la conexion
    public void closeConnection(){
        try {
            //si es distinta a conexion cerrada y igual a la conexion distinta a null
            if(!this.connection.isClosed() && this.connection != null){
                //se cerrara la conexion
                this.connection.close();
                System.out.println("Connection finished");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void testConnection(){
        this.openConnection();
        this.closeConnection();
    }

    //traemos los datos a buscar
    public Tickler getTickler(Long id){

        Tickler tickler = null;
        String query = "SELECT TCK_ID, TCK_DESCRIPTION FROM TICKLERS WHERE TCK_ID = " + id;


        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;

        try{
            //abrimos la conexion
            this.openConnection();
            //enviamos la query
            preparedstatement = this.connection.prepareStatement(query);
            //almacenamos el resultado
            resultset = preparedstatement.executeQuery();

            //con el while obtenemos lo que deseamos
            while(resultset.next()){
                Long ticklerIdFilter = resultset.getLong("TCK_ID");
                String ticklerDescriptionFilter = resultset.getString("TCK_DESCRIPTION");

                tickler = new Tickler(ticklerIdFilter, ticklerDescriptionFilter);
            }
            //imprimimos los resultados
            System.out.println("Id: " + tickler.getTKC_ID());
            System.out.println("Description: " + tickler.getTKC_DESCRIPTION());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //terminamos la conexion
            this.closeConnection();
        }

        //retornamos lo obtenido.
        return tickler;
    }

}
