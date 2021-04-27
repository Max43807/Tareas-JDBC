/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareasjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Maxi
 */
public class TareasJDBC {

    //Crear un objeto Conexion:
    static Connection cn = new ConexionJDBC().getConnection();

    //Leer la pantalla
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        System.out.println("Listado de Tareas: \n====================================");
        System.out.println("Conectado a la base de datos: " + cn.getCatalog());

        String sql = "select *from tareas"; //Consulta sql

        //Crear un objeto sentencias preparada:
        PreparedStatement ps = cn.prepareStatement(sql);

        //Crear un conjunto de resultados:
        ResultSet rs = ps.executeQuery();

        //Formateador de fechas:
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (rs.next()) {

            //Imprimir registros:
            System.out.println("\nTarea n°" + rs.getString("id"));
            System.out.print("===========================\n");
            System.out.println(
                     "Descripcion: " + rs.getString("descri") + 
                              " Fecha: " + sdf.format(Date.valueOf(rs.getString("fec"))) +
                              " Estado: " + (rs.getString("fin").equals("0") ? "Pendiente" : "Finalizada") +  "\n");

        }
    }

}
