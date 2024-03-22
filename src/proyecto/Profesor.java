package proyecto;

import java.time.LocalDate;

public class Profesor extends Trabajador {

    public int id;
    public static int incremento = 0;
    public int aniosExperiencia;
    public int cantidadCursos;
    public Curso[] cursos;

    public Profesor(int aniosExperiencia, float salario, String cedula, String nombre1,
            String nombre2, String apellido1, String apellido2, LocalDate fechaNacimiento, int cantidadCursos)
    {
        super(salario, cedula, nombre1, nombre2, apellido1, apellido2, fechaNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.id = ++incremento;
        this.cursos = new Curso[cantidadCursos];
    }

    @Override
    public String toString()
    {
        return "Profesor{" + "aniosExperiencia=" + aniosExperiencia + '}';
    }

    public boolean matricularEnCurso(Curso curso)
    {
        if (curso != null) {
            for (int i = 0; i < this.cursos.length; i++) {
                if (this.cursos[i] == null) {
                    this.cursos[i] = curso;
                    return true;
                }
            }
        }
        return false;
    }

}
