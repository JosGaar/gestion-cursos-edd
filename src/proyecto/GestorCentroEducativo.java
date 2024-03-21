package proyecto;

public class GestorCentroEducativo {

    public Curso[] cursos;
    public Persona[] personas;
    public int cantidadPersonas;
    public int cantidadCursos;

    public GestorCentroEducativo(int cantidadPersonas, int cantidadCursos)
    {
        this.personas = new Persona[cantidadPersonas];
        this.cursos = new Curso[cantidadCursos];
    }

    public void imprimirReporteInscritos()
    {
    }

    public void imprimirPersonas()
    {
        if (this.personas != null) {
            for (int i = 0; i < this.personas.length; i++) {
                if (personas[i] != null) {
                    System.out.println(personas[i].nomApell());
                }
            }
        }
    }

    public boolean agregarPersona(Persona persona)
    {
        if (persona != null) {
            for (int i = 0; i < this.personas.length; i++) {
                if (personas[i] == null) {
                    personas[i] = persona;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean agregarCurso(Curso curso)
    {
        if (curso != null) {
            for (int i = 0; i < this.cursos.length; i++) {
                if (cursos[i] == null) {
                    cursos[i] = curso;
                    return true;
                }
            }
        }

        return false;
    }

    /*
    public boolean eliminarCurso(int identificadorCurso)
    {
        if (identificadorCurso > 0) {
            for (int i = 0; i < this.cursos.length; i++) {
                if (cursos[i].getId() == identificadorCurso) {
                    return tieneProfesorElCurso(cursos[i]);
                }
            }
        }

        return false;
    }

    public boolean tieneProfesorElCurso(Curso curso)
    {
        if (curso != null) {
            if (curso.getProfesor() != null) {
                return true;
            }
        }

        return false;
    }*/
}
