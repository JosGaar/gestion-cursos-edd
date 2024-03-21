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
                    menuEstudiante(gestorCentro);
                    break;
                case 2:
                    menuDocente(gestorCentro);
                    break;
                case 3:
                    menuCurso(gestorCentro);
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

    public static int opcionGeneral()
    {
        int opcion = 0;
        boolean error = false;
        String input;

        do {
            try {
                input = JOptionPane.showInputDialog(null, """
                                                                        1. Gestion estudiantes
                                                                        2. Gestion docentes
                                                                        3. Gestion cursos
                                                                        4. Reportes
                                                                        5. Salir
                                                                        Seleccione una opcion: """);

                if (input == null) {
                    return 5;
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

    // Información sobre el estudiante
    public static void menuEstudiante(GestorCentroEducativo gestorCentro)
    {

        int opcion;

        try {
            do {
                opcion = opcionesEstudiante();

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
                        StringBuilder estudiantes = new StringBuilder();
                        estudiantes.append(String.format("%-20s%-25s%-25s\n", "Cedula", "Nombre", "Apellido"));
                        boolean estudiantesAgregados = false;

                        if (gestorCentro.personas != null) {
                            for (int i = 0; i < gestorCentro.personas.length; i++) {
                                if (gestorCentro.personas[i] != null && gestorCentro.personas[i] instanceof Estudiante) {
                                    Estudiante est = (Estudiante) gestorCentro.personas[i];

                                    estudiantes.append(String.format("%-20s%-25s%-25s\n",
                                            est.cedula,
                                            est.nombre1,
                                            est.apellido1));
                                    estudiantesAgregados = true;
                                }
                            }

                            if (!estudiantesAgregados) {
                                estudiantes.append("\nNo hay estudiantes para mostrar.");
                            }

                            VisualizadorMensajes.mostrarMensaje(estudiantes.toString());
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
        } catch (Exception e) {
        }

    }

    public static int opcionesEstudiante()
    {

        int opcion = 0;
        boolean error = false;
        String input;
        do {
            try {
                input = JOptionPane.showInputDialog(null, """
                                                                        1. Crear estudiante
                                                                        2. Mostrar estudiantes existentes
                                                                        3. Modificar estudiante
                                                                        4. Eliminar estudiante
                                                                        5. Regresar
                                                                        Seleccione una opcion: """);

                if (input == null) {
                    return 5;
                }

                opcion = Integer.parseInt(input);
                error = false;
            } catch (HeadlessException | NumberFormatException e) {
                VisualizadorMensajes.mostrarMensaje("Error: " + e.getMessage());
                error = true;
            }
        } while (error);

        return opcion;
    }

    // Informacion sobre los docentes
    public static void menuDocente(GestorCentroEducativo gestorCentro)
    {

        int opcion;

        try {
            do {
                opcion = opcionesDocente();

                switch (opcion) {
                    case 1:
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
                    case 2:
                        StringBuilder docentes = new StringBuilder();
                        docentes.append(String.format("%-20s%-20s%-20s\n", "Id", "Nombre", "Apellido"));
                        boolean docenteAsignado = false;

                        if (gestorCentro.personas != null) {
                            for (int i = 0; i < gestorCentro.personas.length; i++) {
                                if (gestorCentro.personas[i] != null && gestorCentro.personas[i] instanceof Profesor) {
                                    Profesor prof = (Profesor) gestorCentro.personas[i];

                                    docentes.append(String.format("%-20s%-20s%-20s\n",
                                            prof.id,
                                            prof.nombre1,
                                            prof.apellido1));
                                    docenteAsignado = true;
                                }
                            }

                            if (!docenteAsignado) {
                                docentes.append("\nNo hay docentes para mostrar.");
                            }

                            VisualizadorMensajes.mostrarMensaje(docentes.toString());
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
        } catch (Exception e) {
        }

    }

    public static int opcionesDocente()
    {
        int opcion = 0;
        boolean error = false;
        String input;
        do {
            try {
                input = JOptionPane.showInputDialog(null, """
                                                                        1. Crear docente
                                                                        2. Mostrar docentes existentes 
                                                                        3. Modificar docente
                                                                        4. Eliminar docente
                                                                        5. Regresar
                                                                        Seleccione una opcion: """);

                if (input == null) {
                    return 5;
                }

                opcion = Integer.parseInt(input);
                error = false;
            } catch (HeadlessException | NumberFormatException e) {
                VisualizadorMensajes.mostrarMensaje("Error: " + e.getMessage());
                error = true;
            }
        } while (error);

        return opcion;
    }

    // Información sobre los cursos
    public static void menuCurso(GestorCentroEducativo gestorCentro)
    {

        int opcion;

        try {
            do {
                opcion = opcionesCurso();

                switch (opcion) {
                    case 1:
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
                    case 2:
                        StringBuilder cursos = new StringBuilder();
                        cursos.append(String.format("%-20s%-20s\n", "Id", "Nombre"));
                        boolean cursosAgregados = false;

                        if (gestorCentro.cursos != null) {
                            for (int i = 0; i < gestorCentro.cursos.length; i++) {
                                if (gestorCentro.cursos[i] != null) {
                                    cursos.append(String.format("%-20s%-20s\n",
                                            gestorCentro.cursos[i].id,
                                            gestorCentro.cursos[i].nombre));
                                    cursosAgregados = true;
                                }
                            }

                            if (!cursosAgregados) {
                                cursos.append("\nNo hay cursos para mostrar.");
                            }

                            VisualizadorMensajes.mostrarMensaje(cursos.toString());
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
        } catch (Exception e) {
        }

    }

    public static int opcionesCurso()
    {
        int opcion = 0;
        boolean error = false;
        String input;
        do {
            try {
                input = JOptionPane.showInputDialog(null, """
                                                                        1. Crear curso
                                                                        2. Mostrar cursos existentes
                                                                        3. Modificar curso
                                                                        4. Eliminar curso
                                                                        5. Regresar
                                                                        Seleccione una opcion: """);

                if (input == null) {
                    return 5;
                }

                opcion = Integer.parseInt(input);
                error = false;
            } catch (HeadlessException | NumberFormatException e) {
                VisualizadorMensajes.mostrarMensaje("Error: " + e.getMessage());
                error = true;
            }
        } while (error);

        return opcion;
    }

    // Registros
}
