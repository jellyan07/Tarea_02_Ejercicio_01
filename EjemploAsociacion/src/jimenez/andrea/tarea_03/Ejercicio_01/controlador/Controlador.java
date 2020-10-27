package jimenez.andrea.tarea_03.Ejercicio_01.controlador;

import jimenez.andrea.tarea_03.Ejercicio_01.UI.UI;
import jimenez.andrea.tarea_03.Ejercicio_01.entidades.Computadora;
import jimenez.andrea.tarea_03.Ejercicio_01.entidades.Empleado;
import jimenez.andrea.tarea_03.Ejercicio_01.gestor.Gestor;

public class Controlador {
    private UI interfaz = new UI();
    private Gestor gestor = new Gestor();

    public void ejecutarPrograma() {
        int opcion = 0;
        do {
            interfaz.mostrarMenu();
            opcion = interfaz.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 9);
    }

    private void procesarOpcion (int opcion) {
        switch (opcion) {
            case 1:
                registrarComputadora();
                break;
            case 2:
                Empleado empleado = registrarEmpleadoParaComputadora();
                break;
            case 3:
                Listar();
                break;
            default:
                interfaz.imprimir("La opción no es válida");
                break;
        }
    }

    private void Listar () {
        for (Computadora computadora:
             gestor.getComputadoras()) {
            interfaz.imprimir(computadora.toString());
        }
    }

    private void registrarComputadora() {
        interfaz.imprimir("Ingrese el nombre de la computadora");
        String nombre = interfaz.leerTexto();
        interfaz.imprimir("Ingrese la marca de la computadora");
        String marca = interfaz.leerTexto();
        interfaz.mostrarMenu2();
        int opcion = interfaz.leerOpcion();
        Empleado empleado = procesarOpcion2(opcion);
    }

    private Empleado procesarOpcion2 (int opcion) {
        Empleado empleado = null;
        switch (opcion) {
            case 1:
                empleado = registrarEmpleadoParaComputadora();
                break;
            case 2:
                empleado = verificarEmpleadoExistente();
                break;
            default:
                interfaz.imprimir("Opción inválida");
                break;
        }
        return empleado;
    }

    private Empleado verificarEmpleadoExistente () {
        Empleado empleado_computadora = null;
        String cedula_empleado = null;
        do {
            interfaz.imprimir("Ingrese la cédula del empleado:");
            cedula_empleado = interfaz.leerTexto();

            /* Verificamos que el empleado exista en la base de datos */

            for (Empleado empleado : gestor.listarEmpleados())
            {
                if (empleado.getNombre().equals(cedula_empleado)) {
                    empleado_computadora = empleado;
                    break;
                }
            }

            if (empleado_computadora == null) {
                interfaz.imprimir("Este empleado no está registrado");
                interfaz.imprimir("Si desea registrar el empleado presione 1");
            }
        } while (empleado_computadora == null || cedula_empleado != "1");

        if (cedula_empleado.equals("1")) {
            empleado_computadora = registrarEmpleadoParaComputadora();
        }

        return empleado_computadora;
    }

    private Empleado registrarEmpleadoParaComputadora () {
        interfaz.imprimir("Ingrese la cédula del empleado");
        String cedula = interfaz.leerTexto();
        interfaz.imprimir("Ingrese el nombre completo del empleado");
        String nombre = interfaz.leerTexto();
        Empleado empleado = gestor.crearEmpleado(nombre, cedula);
        return empleado;
    }



}
