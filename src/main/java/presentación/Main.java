
package presentación;

import datos.EmpleadoDAO;
import dominio.Empleado;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        //  mostrar empleados (SELECT)
        
        
        EmpleadoDAO empleadoDao = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDao.mostrar();
        
        for(Empleado empleadoForEach: empleados){
            System.out.println(empleadoForEach);
        }
        
        
        
        
        
        // insertar un empleado (INSERT)
        
        /*
        EmpleadoDAO empleadoDao = new EmpleadoDAO();
        
        Empleado empleadoInsertar = new Empleado("Karla","Romero",40,1500.50);
        int registrosAfectador = empleadoDao.insertar(empleadoInsertar);
        List<Empleado> empleados = empleadoDao.mostrar();
        for(Empleado empleadoForEach: empleados){
            System.out.println(empleadoForEach);
        }*/
        
        
        
        
        
        // actualizar un empleado (UPDATE)
        
        /*
         EmpleadoDAO empleadoDao = new EmpleadoDAO();
        
        Empleado empleadoActualizar = new Empleado(7,"Karla","Romero",40,1800.50);
        int registrosAfectador = empleadoDao.actualizar(empleadoActualizar);
        List<Empleado> empleados = empleadoDao.mostrar();
        for(Empleado empleadoForEach: empleados){
            System.out.println(empleadoForEach);
        }*/
        
        
        
        
        
        
        // eliminar un empleado (DELETE)
        
        /*
        EmpleadoDAO empleadoDao = new EmpleadoDAO();
        
        Empleado empleadoEliminar = new Empleado(7);
        int registrosAfectador = empleadoDao.eliminar(empleadoEliminar);
        List<Empleado> empleados = empleadoDao.mostrar();
        for(Empleado empleadoForEach: empleados){
            System.out.println(empleadoForEach);
        }*/
        
    }
    
}
