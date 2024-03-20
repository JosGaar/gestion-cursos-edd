package proyecto;

import java.time.LocalDate;

public class Estudiante extends Persona {

    public int id;
    public int cantidadCursos;
    public static int incremento = 0;
    public Calificacion calificaciones[];
    public String direccion;
    public Curso[] cursos;

    public Estudiante(String direccion, String cedula, String nombre1, String nombre2,
            String apellido1, String apellido2, LocalDate fechaNacimiento, int cantidadCursos)
    {
        super(cedula, nombre1, nombre2, apellido1, apellido2, fechaNacimiento);
        this.direccion = direccion;
        this.id = ++incremento;
        this.cursos = new Curso[cantidadCursos];
    }

    @Override
    public String toString()
    {
        return "Estudiante{" + "direccion=" + direccion + ", cursos=" + cursos + '}';
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

    public boolean desmatricularDelCurso(Curso curso)
    {
        if (curso != null) {
            for (int i = 0; i < this.cursos.length; i++) {
                if (this.cursos[i] == curso) {
                    this.cursos[i] = null;
                    return true;
                }
            }

        }

        return false;
    }

}
