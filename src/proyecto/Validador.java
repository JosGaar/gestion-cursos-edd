package proyecto;

import java.util.regex.Pattern;

public class Validador {

    public static boolean esCedulaValida(String cedula)
    {
        boolean cedulaCorrecta = false;

        try {
            if (cedula.length() == 10) {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            VisualizadorMensajes.mostrarMensaje("Una excepcion ocurrio en el proceso de validacion.");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            VisualizadorMensajes.mostrarMensaje("La cedula ingresada es incorrecta.");
        }
        return cedulaCorrecta;
    }

    public static boolean esFechaValida(String fecha)
    {
        String patron = "\\d{4}-\\d{2}-\\d{2}";
        return Pattern.matches(patron, fecha);
    }

    public static boolean esStringVacio(String cadena)
    {
        return cadena.trim().isEmpty();
    }

    // Validaciones
    public static String obtenerCedulaValida()
    {
        String cedula;
        do {
            cedula = ManejadorCadenas.obtenerStringDesdeMensaje("Ingrese la cedula");
            if (!Validador.esCedulaValida(cedula)) {
                VisualizadorMensajes.mostrarMensaje("Ingrese una cedula valida.");
            }

        } while (!Validador.esCedulaValida(cedula));

        return cedula;
    }

    public static String obtenerDireccionValida()
    {
        String direccion;
        do {
            direccion = ManejadorCadenas.obtenerStringDesdeMensaje("Ingrese la dirección");
            if (Validador.esStringVacio(direccion)) {
                VisualizadorMensajes.mostrarMensaje("Ingrese una direccion valida.");
            }

        } while (Validador.esStringVacio(direccion));

        return direccion.trim();
    }

    public static String obtenerPrimerNombreValido()
    {
        String nombre;
        do {
            nombre = ManejadorCadenas.obtenerStringDesdeMensaje("Ingrese el primer nombre");
            if (Validador.esStringVacio(nombre)) {
                VisualizadorMensajes.mostrarMensaje("Ingrese un nombre valido.");
            }

        } while (Validador.esStringVacio(nombre));

        return nombre.trim();
    }

    public static String obtenerSegundoNombreValido()
    {
        String nombre;
        do {
            nombre = ManejadorCadenas.obtenerStringDesdeMensaje("Ingrese el segundo nombre");
            if (Validador.esStringVacio(nombre)) {
                VisualizadorMensajes.mostrarMensaje("Ingrese un nombre valido.");
            }

        } while (Validador.esStringVacio(nombre));

        return nombre.trim();
    }

    public static String obtenerPrimerApellidoValido()
    {
        String apellido;
        do {
            apellido = ManejadorCadenas.obtenerStringDesdeMensaje("Ingrese el primer apellido");
            if (Validador.esStringVacio(apellido)) {
                VisualizadorMensajes.mostrarMensaje("Ingrese un apellido valido.");
            }

        } while (Validador.esStringVacio(apellido));

        return apellido.trim();
    }

    public static String obtenerSegundoApellidoValido()
    {
        String apellido;
        do {
            apellido = ManejadorCadenas.obtenerStringDesdeMensaje("Ingrese el segundo apellido");
            if (Validador.esStringVacio(apellido)) {
                VisualizadorMensajes.mostrarMensaje("Ingrese un apellido valido.");
            }

        } while (Validador.esStringVacio(apellido));

        return apellido.trim();
    }

    public static int validarCantidadCursos(int cursosCentro)
    {
        int cantidadCursos;
        boolean error = false;

        do {
            cantidadCursos = ManejadorCadenas.obtenerEnteroDesdeMensaje("Ingrese la cantidad de cursos");

            if (cantidadCursos >= 0) {
                error = cantidadCursos > cursosCentro;
            }

            if (error) {
                VisualizadorMensajes.mostrarMensaje("El estudiante no puede tener mas cursos de los que tiene el centro educativo.");
            }

        } while (error);

        return cantidadCursos;
    }

    public static String obtenerFechaValida()
    {
        String fechaNacimiento;
        do {
            fechaNacimiento = ManejadorCadenas.obtenerStringDesdeMensaje("Ingrese su fecha de nacimiento (yyyy-mm-dd)");

            if (!Validador.esFechaValida(fechaNacimiento)) {
                VisualizadorMensajes.mostrarMensaje("Ingrese una fecha de nacimiento valida.");
            }

        } while (!Validador.esFechaValida(fechaNacimiento));

        return fechaNacimiento;
    }

    public static int obtenerAniosDeExperienciaValido()
    {
        int aniosExperiencia;

        do {
            aniosExperiencia = ManejadorCadenas.obtenerEnteroDesdeMensaje("Ingrese los años de experiencia");
            if (aniosExperiencia < 0 || aniosExperiencia > 60) {
                VisualizadorMensajes.mostrarMensaje("Ingrese años de experiencia validos.");
            }

        } while (aniosExperiencia < 0 || aniosExperiencia > 60);

        return aniosExperiencia;
    }

    public static int obtenerSalarioValido()
    {
        int salario;

        do {
            salario = ManejadorCadenas.obtenerEnteroDesdeMensaje("Ingrese el salario");
            if (salario < 0) {
                VisualizadorMensajes.mostrarMensaje("Ingrese un salario valido.");
            }

        } while (salario < 0);

        return salario;
    }

    public static int obtenerNumeroValidoDadoUnMensaje(String mensaje)
    {
        int numero;
        do {
            numero = ManejadorCadenas.obtenerEnteroDesdeMensaje(mensaje);
            if (numero < 0) {
                VisualizadorMensajes.mostrarMensaje("El numero debe ser mayor a cero.");
            }

        } while (numero < 0);

        return numero;
    }

}
