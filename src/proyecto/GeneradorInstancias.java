package proyecto;

import javax.swing.JOptionPane;

public final class GeneradorInstancias {

    // Generacion de estudiante
    public static Estudiante generarEstudiante(int cursosCentro)
    {

        String cedula, direccion, nombre1, nombre2, apellido1, apellido2, fechaNacimiento;
        int cantidadCursos;
        boolean continuar = false;

        JOptionPane.showMessageDialog(null, "Ingrese los datos acontinuacion");

        cedula = Validador.obtenerCedulaValida();
        direccion = Validador.obtenerDireccionValida();
        nombre1 = Validador.obtenerPrimerNombreValido();
        nombre2 = Validador.obtenerSegundoNombreValido();
        apellido1 = Validador.obtenerPrimerApellidoValido();
        apellido2 = Validador.obtenerSegundoApellidoValido();
        fechaNacimiento = Validador.obtenerFechaValida();
        cantidadCursos = Validador.validarCantidadCursos(cursosCentro);

        return new Estudiante(direccion, cedula, nombre1, nombre2,
                apellido1, apellido2, Validador.parsearStringALocalDate(fechaNacimiento),
                cantidadCursos);
    }

    // Generacion de docente
    public static Profesor generarProfesor()
    {

        String cedula, nombre1, nombre2, apellido1, apellido2, fechaNacimiento;
        int aniosExperiencia, salario;

        JOptionPane.showMessageDialog(null, "Ingrese los datos acontinuacion");
        aniosExperiencia = Validador.obtenerAniosDeExperienciaValido();
        salario = Validador.obtenerSalarioValido();
        cedula = Validador.obtenerCedulaValida();
        nombre1 = Validador.obtenerPrimerNombreValido();
        nombre2 = Validador.obtenerSegundoNombreValido();
        apellido1 = Validador.obtenerPrimerApellidoValido();
        apellido2 = Validador.obtenerSegundoApellidoValido();
        fechaNacimiento = Validador.obtenerFechaValida();

        return new Profesor(aniosExperiencia, salario, cedula, nombre1,
                nombre2, apellido1, apellido2, Validador.parsearStringALocalDate(fechaNacimiento));
    }

}
