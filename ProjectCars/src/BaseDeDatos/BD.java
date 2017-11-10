package BaseDeDatos;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Vehiculo.Coche;
import Vehiculo.Usuario;

public class BD {
	private Connection conexion;
	private static Statement stmt;
	
	
		public void conectar(){
			try{
				conexion = DriverManager.getConnection("jdbc:sqlite:ProjectCars.db");
		    } catch (SQLException E) {
		        E.printStackTrace();
		    	throw new RuntimeException("No se ha podido realizar la conexion");
		        
		    }
		}
		public void desconectar(){
			try{
				conexion.close();
			}catch(SQLException E){
				E.printStackTrace();
			}
		}
		public void Sentencia(){
			try{
				stmt = conexion.createStatement();
			}catch(SQLException E){
				E.printStackTrace();
			}
		}
		
		public void closeSentencia(){
			try{
				stmt.close();
			}catch(SQLException E){
				E.printStackTrace();
			}
		}
		public static boolean compruebaNick(String nick){
			boolean comprobado = false;
			
			
			return comprobado;
		}
}
