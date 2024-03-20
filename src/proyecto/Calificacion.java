package proyecto;

public class Calificacion {
    
    public String nombre;
    public int nota;

    public Calificacion(String nombre, int nota)
    {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getNota()
    {
        return nota;
    }

    @Override
    public String toString()
    {
        return "Calificacion{" + "nombre=" + nombre + ", nota=" + nota + '}';
    }

}
