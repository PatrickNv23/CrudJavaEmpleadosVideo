
package datos;

import java.sql.*;
import java.sql.DriverManager;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/VideoCrudEmpleados";
    private static final String user = "root";
    private static final String password = "tucontraseña";
    
    public static Connection getConexion() throws SQLException{
        return DriverManager.getConnection(URL, user, password);
    }
    
    public static void cerrar(Connection conexion) throws SQLException{
        conexion.close();
    }
    
    public static void cerrar(Statement sentencia) throws SQLException{
        sentencia.close();
    }
    
    
    public static void cerrar(PreparedStatement sentencia) throws SQLException{
        sentencia.close();
    }
    
    public static void cerrar(ResultSet resultado) throws SQLException{
        resultado.close();
    }
}
