package proyecto;

import java.time.LocalDate;

public class Profesor extends Trabajador {
    
    public int id;
    public static int incremento = 0;
    public int aniosExperiencia;
    public Curso[] cursos;

    public Profesor(int aniosExperiencia, float salario, String cedula, String nombre1, 
                    String nombre2, String apellido1, String apellido2, LocalDate fechaNacimiento)
    {
        super(salario, cedula, nombre1, nombre2, apellido1, apellido2, fechaNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.id = ++incremento;
    }

    @Override
    public String toString()
    {
        return "Profesor{" + "aniosExperiencia=" + aniosExperiencia + '}';
    }
    
}
