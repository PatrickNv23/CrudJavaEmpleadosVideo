
package datos;

import dominio.Empleado;
import java.sql.*;
import java.util.*;

public class EmpleadoDAO {
    public static final String SQL_SELECT = "SELECT * FROM EMPLEADOS";
    public static final String SQL_INSERT = "INSERT INTO EMPLEADOS(nombre,apellido,edad,sueldo) VALUES (?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE EMPLEADOS SET NOMBRE = ?, APELLIDO = ?, EDAD = ?, SUELDO = ? WHERE codigoEmpleado = ?";
    public static final String SQL_DELETE = "DELETE FROM EMPLEADOS WHERE codigoEmpleado = ?";
    
    
    public List<Empleado> mostrar(){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();
        try{
            conexion = ConexionBD.getConexion();
            sentencia = conexion.prepareStatement(SQL_SELECT);
            resultado = sentencia.executeQuery();
            
            while(resultado.next()){
                empleado = new Empleado();
                empleado.setCodigoEmpleado(resultado.getInt("codigoEmpleado"));
                empleado.setNombre(resultado.getString("nombre"));
                empleado.setApellido(resultado.getString("apellido"));
                empleado.setEdad(resultado.getInt("edad"));
                empleado.setSueldo(resultado.getDouble("sueldo"));
                empleados.add(empleado);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            try{
                ConexionBD.cerrar(resultado);
                ConexionBD.cerrar(sentencia);
                ConexionBD.cerrar(conexion);
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return empleados;
    }
    
    
    public int insertar(Empleado empleado){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int registros = 0;
        
        try{
            conexion = ConexionBD.getConexion();
            sentencia = conexion.prepareStatement(SQL_INSERT);
            sentencia.setString(1, empleado.getNombre());
            sentencia.setString(2, empleado.getApellido());
            sentencia.setInt(3, empleado.getEdad());
            sentencia.setDouble(4, empleado.getSueldo());
            registros = sentencia.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            try{
                ConexionBD.cerrar(sentencia);
                ConexionBD.cerrar(conexion);
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    
    public int actualizar(Empleado empleado){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int registros = 0;
        
        try{
            conexion = ConexionBD.getConexion();
            sentencia = conexion.prepareStatement(SQL_UPDATE);
            sentencia.setString(1, empleado.getNombre());
            sentencia.setString(2, empleado.getApellido());
            sentencia.setInt(3, empleado.getEdad());
            sentencia.setDouble(4, empleado.getSueldo());
            sentencia.setInt(5, empleado.getCodigoEmpleado());
            registros = sentencia.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            try{
                ConexionBD.cerrar(sentencia);
                ConexionBD.cerrar(conexion);
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int eliminar(Empleado empleado){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int registros = 0;
        
        try{
            conexion = ConexionBD.getConexion();
            sentencia = conexion.prepareStatement(SQL_DELETE);
            sentencia.setInt(1, empleado.getCodigoEmpleado());
            registros = sentencia.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            try{
                ConexionBD.cerrar(sentencia);
                ConexionBD.cerrar(conexion);
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
}
