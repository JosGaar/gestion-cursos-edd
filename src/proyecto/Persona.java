package proyecto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona {

    public String cedula;
    public String nombre1;
    public String nombre2;
    public String apellido1;
    public String apellido2;
    public LocalDate fechaNacimiento;

    public Persona(String cedula, String nombre1, String nombre2, String apellido1, 
                   String apellido2, LocalDate fechaNacimiento)
    {
        this.cedula = cedula;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    @Override
    public String toString()
    {
        return "Persona{" + "cedula=" + cedula + ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    public String nomApell()
    {
        return "Nombres: " + this.nombre1 + " " + nombre2 + ", apellidos: " + this.apellido1 + " " + this.apellido2;
    }

    public int edad()
    {
        if (this.fechaNacimiento != null) {
            LocalDate fechaActual = LocalDate.now();
            Period periodo = Period.between(fechaNacimiento, fechaActual);

            return periodo.getYears();
        }
        return -1;
    }

}
