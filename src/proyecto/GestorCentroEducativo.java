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

    public boolean inscribirEstudianteCurso(int idEstudiante, int idCurso)
    {
        Estudiante estudianteEncontrado = encontrarEstudiante(idEstudiante);
        Curso cursoEncontrado = encontrarCurso(idCurso);

        if (cursoEncontrado != null && estudianteEncontrado != null) {
            return cursoEncontrado.matricularEstudiante(estudianteEncontrado);
        }

        return false;
    }

    public boolean inscribirDocenteCurso(int idDocente, int idCurso)
    {
        Profesor profesorEncontrado = encontrarDocente(idDocente);
        Curso cursoEncontrado = encontrarCurso(idCurso);

        if (cursoEncontrado != null && profesorEncontrado != null) {
            return cursoEncontrado.matricularDocente(profesorEncontrado);
        }

        return false;
    }

    public Curso encontrarCurso(int idCurso)
    {
        if (idCurso > 0) {
            for (int i = 0; i < this.cursos.length; i++) {
                if (this.cursos[i].id == idCurso) {
                    return this.cursos[i];
                }
            }
        }

        return null;
    }

    public Estudiante encontrarEstudiante(int idEstudiante)
    {
        if (idEstudiante > 0) {
            for (int i = 0; i < this.personas.length; i++) {
                if (this.personas[i] instanceof Estudiante) {
                    Estudiante estudianteActual = (Estudiante) this.personas[i];

                    if (estudianteActual != null && estudianteActual.id == idEstudiante) {
                        return estudianteActual;
                    }
                }
            }
        }

        return null;
    }

    public Profesor encontrarDocente(int idDocente)
    {
        if (idDocente > 0) {
            for (int i = 0; i < this.personas.length; i++) {
                if (this.personas[i] instanceof Profesor) {
                    Profesor profesorActual = (Profesor) this.personas[i];

                    if (profesorActual != null && profesorActual.id == idDocente) {
                        return profesorActual;
                    }
                }
            }
        }

        return null;
    }

    public boolean reporteEstudiantes()
    {
        boolean reporteRealizado = true;
        StringBuilder estudiantes = new StringBuilder();
        estudiantes.append(String.format("%-10s%-20s%-25s%-25s\n", "Id", "Cedula", "Nombre", "Apellido"));
        boolean estudiantesAgregados = false;

        if (personas != null) {
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] != null && personas[i] instanceof Estudiante) {
                    Estudiante est = (Estudiante) personas[i];

                    estudiantes.append(String.format("%-10s%-20s%-25s%-25s\n",
                            est.id,
                            est.cedula,
                            est.nombre1,
                            est.apellido1));
                    estudiantesAgregados = true;
                }
            }

            if (!estudiantesAgregados) {
                estudiantes.append("\nNo hay estudiantes para mostrar.");
                reporteRealizado = false;
            }

            VisualizadorMensajes.mostrarMensaje(estudiantes.toString());
        }

        return reporteRealizado;
    }

    public boolean reporteCursos()
    {
        boolean reporteRealizado = true;

        StringBuilder sbCursos = new StringBuilder();
        sbCursos.append(String.format("%-20s%-20s\n", "Id", "Nombre"));
        boolean cursosAgregados = false;

        if (cursos != null) {
            for (int i = 0; i < cursos.length; i++) {
                if (cursos[i] != null) {
                    sbCursos.append(String.format("%-20s%-20s\n",
                            cursos[i].id,
                            cursos[i].nombre));
                    cursosAgregados = true;
                }
            }

            if (!cursosAgregados) {
                sbCursos.append("\nNo hay cursos para mostrar.");
                reporteRealizado = false;
            }

            VisualizadorMensajes.mostrarMensaje(sbCursos.toString());
        }

        return reporteRealizado;
    }

    public boolean reporteDocentes()
    {
        boolean reporteRealizado = true;
        StringBuilder docentes = new StringBuilder();
        docentes.append(String.format("%-10s%-20s%-25s%-25s\n", "Id", "Cedula", "Nombre", "Apellido"));
        boolean estudiantesAgregados = false;

        if (personas != null) {
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] != null && personas[i] instanceof Profesor) {
                    Profesor est = (Profesor) personas[i];

                    docentes.append(String.format("%-10s%-20s%-25s%-25s\n",
                            est.id,
                            est.cedula,
                            est.nombre1,
                            est.apellido1));
                    estudiantesAgregados = true;
                }
            }

            if (!estudiantesAgregados) {
                docentes.append("\nNo hay docentes para mostrar.");
                reporteRealizado = false;
            }

            VisualizadorMensajes.mostrarMensaje(docentes.toString());
        }

        return reporteRealizado;
    }

    public void reporteEstudiantesPorCursos()
    {

        for (int i = 0; i < this.cursos.length; i++) {
            if (this.cursos[i] != null) {
                Estudiante[] estudiantes = this.cursos[i].estudiantes;
                StringBuilder sb = new StringBuilder("Curso: " + this.cursos[i].nombre);

                for (int j = 0; j < estudiantes.length; j++) {
                    if (estudiantes[j] != null) {
                        sb.append("\nCedula: ").append(estudiantes[j].cedula)
                                .append(", Nombre: ").append(estudiantes[j].nombre1)
                                .append(", Apellido: ").append(estudiantes[j].apellido1);
                    }
                }

                VisualizadorMensajes.mostrarMensaje(sb.toString());
            }
        }
    }
}
