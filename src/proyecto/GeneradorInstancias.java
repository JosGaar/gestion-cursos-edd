package proyecto;

public final class GeneradorInstancias {

    public static Estudiante generarEstudiante(int cursosLimite)
    {

        String cedula, direccion, nombre1, nombre2, apellido1, apellido2, fechaNacimiento;
        int cantidadCursos;
        boolean continuar = false;

        VisualizadorMensajes.mostrarMensaje("Ingrese los datos a continuacion");
        cedula = Validador.obtenerCedulaValida();
        direccion = Validador.obtenerDireccionValida();
        nombre1 = Validador.obtenerPrimerNombreValido();
        nombre2 = Validador.obtenerSegundoNombreValido();
        apellido1 = Validador.obtenerPrimerApellidoValido();
        apellido2 = Validador.obtenerSegundoApellidoValido();
        fechaNacimiento = Validador.obtenerFechaValida();
        cantidadCursos = Validador.validarCantidadCursos(cursosLimite);

        return new Estudiante(direccion, cedula, nombre1, nombre2,
                apellido1, apellido2, Validador.parsearStringALocalDate(fechaNacimiento),
                cantidadCursos);
    }

    public static Profesor generarProfesor()
    {

        String cedula, nombre1, nombre2, apellido1, apellido2, fechaNacimiento;
        int aniosExperiencia, salario, cantidadCursos;

        VisualizadorMensajes.mostrarMensaje("Ingrese los datos a continuacion");
        cedula = Validador.obtenerCedulaValida();
        aniosExperiencia = Validador.obtenerAniosDeExperienciaValido();
        salario = Validador.obtenerSalarioValido();
        nombre1 = Validador.obtenerPrimerNombreValido();
        nombre2 = Validador.obtenerSegundoNombreValido();
        apellido1 = Validador.obtenerPrimerApellidoValido();
        apellido2 = Validador.obtenerSegundoApellidoValido();
        fechaNacimiento = Validador.obtenerFechaValida();
        cantidadCursos = Validador.obtenerNumeroValidoDadoUnMensaje("Ingrese la cantidad de cursos del profesor");

        return new Profesor(aniosExperiencia, salario, cedula, nombre1,
                nombre2, apellido1, apellido2, Validador.parsearStringALocalDate(fechaNacimiento), cantidadCursos);
    }

    public static Curso generarCurso()
    {

        String nombre;
        int cantidadHoras, cantidadEstudiantes;

        nombre = Validador.obtenerNombreCurso();
        cantidadHoras = Validador.obtenerNumeroValidoDadoUnMensaje("Ingrese la cantidad de horas del curso");
        cantidadEstudiantes = Validador.obtenerNumeroValidoDadoUnMensaje("Ingrese la cantidad de estudiantes del curso");

        return new Curso(nombre, cantidadHoras, cantidadEstudiantes);
    }

}
