package proyecto;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Cliente {

    public static int cantidadLimitesEstudiante;
    public static int contadorEstudiantesCreados = 0;

    public static int cantidadLimiteCursos;
    public static int contadorCursosCreados = 0;

    public static int cantidadLimiteDocentes;
    public static int contadorDocentesCreados = 0;

    public static void main(String[] args)
    {
        menuGeneral();
    }

    public static void menuGeneral()
    {

        int opcion;
        int cantidadEstudiantes = Validador.obtenerNumeroValidoDadoUnMensaje("Ingrese la cantidad de estudiantes");
        int cantidadDocentes = Validador.obtenerNumeroValidoDadoUnMensaje("Ingrese la cantidad de docentes");
        int cantidadCursos = Validador.obtenerNumeroValidoDadoUnMensaje("Ingrese la cantidad de cursos");

        Cliente.cantidadLimitesEstudiante = cantidadEstudiantes;
        Cliente.cantidadLimiteCursos = cantidadCursos;
        Cliente.cantidadLimiteDocentes = cantidadDocentes;

        GestorCentroEducativo gestorCentro = new GestorCentroEducativo(cantidadEstudiantes + cantidadDocentes, cantidadCursos);

        do {
            opcion = opcionGeneral();

            switch (opcion) {
                case 1:
                    if (Cliente.contadorEstudiantesCreados >= cantidadLimitesEstudiante) {
                        VisualizadorMensajes.mostrarMensaje("Se ha alcanzado el limite para crear estudiantes.");
                        break;
                    }
                    Estudiante estudiante = GeneradorInstancias.generarEstudiante(Cliente.cantidadLimiteCursos);
                    if (estudiante != null) {
                        if (gestorCentro.agregarPersona(estudiante)) {
                            VisualizadorMensajes.mostrarMensaje("Estudiante registrado correctamente.");
                            Cliente.contadorEstudiantesCreados++;
                        } else {
                            VisualizadorMensajes.mostrarMensaje("No se ha podido registrar al estudiante.");
                        }
                    } else {
                        VisualizadorMensajes.mostrarMensaje("No se ha podido registrar al estudiante.");
                    }
                    break;
                case 2:
                    if (Cliente.contadorDocentesCreados >= Cliente.cantidadLimiteDocentes) {
                        VisualizadorMensajes.mostrarMensaje("No se pueden crear mas docentes, limite alcanzado.");
                        break;
                    }

                    Profesor profesor = GeneradorInstancias.generarProfesor();
                    if (profesor != null) {
                        if (gestorCentro.agregarPersona(profesor)) {
                            VisualizadorMensajes.mostrarMensaje("Profesor registrado correctamente.");
                            Cliente.contadorDocentesCreados++;
                        } else {
                            VisualizadorMensajes.mostrarMensaje("No se ha podido registrar al profesor.");
                        }
                    } else {
                        VisualizadorMensajes.mostrarMensaje("No se ha podido registrar al profesor.");
                    }
                    break;
                case 3:
                    if (Cliente.contadorCursosCreados >= Cliente.cantidadLimiteCursos) {
                        VisualizadorMensajes.mostrarMensaje("No se puede crear mas cursos.");
                        break;
                    }

                    Curso curso = GeneradorInstancias.generarCurso();
                    if (curso != null) {
                        if (gestorCentro.agregarCurso(curso)) {
                            VisualizadorMensajes.mostrarMensaje("Curso registrado correctamente.");
                            Cliente.contadorCursosCreados++;
                        } else {
                            VisualizadorMensajes.mostrarMensaje("No se ha podido registrar al curso.");
                        }
                    } else {
                        VisualizadorMensajes.mostrarMensaje("No se ha podido registrar al curso.");
                    }
                    break;
                case 4:
                    VisualizadorMensajes.mostrarMensaje("Estudiantes disponibles");
                    boolean reporteEstudiantes = gestorCentro.reporteEstudiantes();
                    VisualizadorMensajes.mostrarMensaje("Cursos disponibles");
                    boolean reporteCursos = gestorCentro.reporteCursos();

                    if (reporteEstudiantes && reporteCursos) {
                        int idEstudiante = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del estudiante"));
                        int idCurso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingres el id del curso"));
                        if (gestorCentro.inscribirEstudianteCurso(idEstudiante, idCurso)) {
                            VisualizadorMensajes.mostrarMensaje("Estudiante matriculado correctamente.");
                        } else {
                            VisualizadorMensajes.mostrarMensaje("No se ha podido matricular al estudiante.");
                        }
                    } else {
                        VisualizadorMensajes.mostrarMensaje("No puede registrar un estudiante a un curso, porque no existe informacion de alguno de ellos.");
                    }
                    break;
                case 5:
                    VisualizadorMensajes.mostrarMensaje("Docentes disponibles");
                    boolean docentesReporte = gestorCentro.reporteDocentes();
                    VisualizadorMensajes.mostrarMensaje("Cursos disponibles");
                    boolean cursosReporte = gestorCentro.reporteCursos();

                    if (docentesReporte && cursosReporte) {
                        int idDocente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del docente"));
                        int idCurso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingres el id del curso"));
                        if (gestorCentro.inscribirDocenteCurso(idDocente, idCurso)) {
                            VisualizadorMensajes.mostrarMensaje("Docente matriculado correctamente.");
                        } else {
                            VisualizadorMensajes.mostrarMensaje("No se ha podido matricular al docente.");
                        }
                    } else {
                        VisualizadorMensajes.mostrarMensaje("No puede registrar un docente a un curso, porque no existe informacion de alguno de ellos.");
                    }
                    break;
                case 6:
                    VisualizadorMensajes.mostrarMensaje("Estudiantes del centro educativo");
                    gestorCentro.reporteEstudiantes();
                    VisualizadorMensajes.mostrarMensaje("Docentes del centro educativo");
                    gestorCentro.reporteDocentes();
                    VisualizadorMensajes.mostrarMensaje("Estudiantes inscritos por los cursos existentes");
                    gestorCentro.reporteEstudiantesPorCursos();
                    break;
                case 7:
                    opcion = 7;
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != 7);

    }

    public static int opcionGeneral()
    {
        int opcion = 0;
        boolean error = false;
        String input;

        do {
            try {
                input = JOptionPane.showInputDialog(null, """
                                                                        1. Registrar estudiante
                                                                        2. Registrar profesor
                                                                        3. Crear curso
                                                                        4. Inscribir estudiantes a curso
                                                                        5. Inscribir docente a curso
                                                                        6. Reportes
                                                                        7. Salir
                                                                        Seleccione una opcion: """);

                if (input == null) {
                    return 6;
                }

                opcion = Integer.parseInt(input);
                error = false;
            } catch (NumberFormatException e) {
                VisualizadorMensajes.mostrarMensaje("Error: Ingrese un número");
                error = true;
            }
        } while (error);

        return opcion;
    }
}
