package jimenez.andrea.tarea_03.Ejercicio_01.gestor;

import jimenez.andrea.tarea_03.Ejercicio_01.entidades.Computadora;
import jimenez.andrea.tarea_03.Ejercicio_01.entidades.Empleado;

import java.util.ArrayList;

public class Gestor {
    ArrayList<Computadora> computadoras;
    ArrayList<Empleado> empleados;

    public Gestor() {
        this.computadoras = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    public Empleado crearEmpleado (String nombre, String cedula) {
        Empleado empleado = new Empleado(nombre, cedula);
        empleados.add(empleado);
        return empleado;
    }

    public ArrayList<Empleado> listarEmpleados () {
        return this.empleados;
    }

    public ArrayList<Computadora> getComputadoras () {
        return this.computadoras;
    }

    public ArrayList<Empleado> getEmpleados () {
        return this.empleados;
    }

}
