package proyecto;

import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args)
    {
        decisiones();
    }

    public static void decisiones()
    {

        int opcion, iteracionEstudiante = 0;
        int cantidadEstudiantes = Validador.obtenerNumeroValidoDadoUnMensaje("Ingrese la cantidad de estudiantes");
        int cantidadCursos = Validador.obtenerNumeroValidoDadoUnMensaje("Ingrese la cantidad de cursos");

        GestorCentroEducativo gestorCentro = new GestorCentroEducativo(cantidadEstudiantes, cantidadCursos);
        do {
            opcion = seleccionarOpcion();
            switch (opcion) {
                case 1:
                    if (iteracionEstudiante < cantidadEstudiantes) {
                        Estudiante estudiante = GeneradorInstancias.generarEstudiante(cantidadCursos);
                        if (estudiante != null) {
                            if (gestorCentro.agregarPersona(estudiante)) {
                                VisualizadorMensajes.mostrarMensaje("Estudiante registrado correctamente.");
                                iteracionEstudiante++;
                            } else {
                                VisualizadorMensajes.mostrarMensaje("No se ha podido registrar al estudiante.");
                            }
                        } else {
                            VisualizadorMensajes.mostrarMensaje("No se ha podido registrar al estudiante.");
                        }
                    } else {
                        VisualizadorMensajes.mostrarMensaje("No puede registrar mas estudiantes, ha alcanzado el limite.");
                    }
                    break;
                case 2:
                    Profesor profesor = GeneradorInstancias.generarProfesor();
                    if (profesor != null) {
                        if (gestorCentro.agregarPersona(profesor)) {
                            VisualizadorMensajes.mostrarMensaje("Profesor registrado correctamente.");
                        } else {
                            VisualizadorMensajes.mostrarMensaje("No se ha podido registrar al profesor.");
                        }
                    } else {
                        VisualizadorMensajes.mostrarMensaje("No se ha podido registrar al profesor.");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    opcion = 5;
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != 5);

    }

    public static int seleccionarOpcion()
    {
        int opcion = 0;
        boolean error = false;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        1. Generar estudiante
                                                                        2. Generar docente
                                                                        3. Gestionar cursos
                                                                        4. Reportes
                                                                        5. Salir
                                                                        Seleccione una opcion: """));
                error = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un numero.");
                error = true;
            }
        } while (error);
        return opcion;
    }

}
