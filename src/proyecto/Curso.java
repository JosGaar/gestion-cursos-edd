package proyecto;

public class Curso {

    public int id;
    public static int incremento = 0;
    public String nombre;
    public int cantidadHoras;
    public int cantidadEstudiantes;
    public Estudiante[] estudiantes;
    public Profesor profesor;

    public Curso(String nombre, int cantidadHoras, int cantidadEstudiantes)
    {
        this.nombre = nombre;
        this.cantidadHoras = cantidadHoras;
        this.id = ++incremento;
        this.estudiantes = new Estudiante[cantidadEstudiantes];
    }

    @Override
    public String toString()
    {
        return "Curso{" + "nombre=" + nombre + ", cantidadHoras=" + cantidadHoras + ", profesor=" + profesor.apellido1 + '}';
    }

    public Profesor getProfesor()
    {
        return this.profesor;
    }

    public boolean matricularEstudiante(Estudiante estudiante)
    {
        for (int i = 0; i < this.estudiantes.length; i++) {
            if (this.estudiantes[i] == null) {
                this.estudiantes[i] = estudiante;
                estudiante.matricularEnCurso(this);
                return true;
            }
        }

        return false;
    }

    public boolean matricularDocente(Profesor docente)
    {
        if (docente != null) {
            this.profesor = docente;
            docente.matricularEnCurso(this);
            return true;
        }

        return false;
    }

    public boolean desmatricularEstudiante(Estudiante estudiante)
    {
        if (estudiante != null) {
            for (int i = 0; i < this.estudiantes.length; i++) {
                if (this.estudiantes[i] == estudiante) {
                    this.estudiantes[i] = null;
                    estudiante.desmatricularDelCurso(this);
                    return true;
                }
            }
        }

        return false;
    }

}
