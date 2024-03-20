package proyecto;

import java.time.LocalDate;

public class Trabajador extends Persona {
 
    public float salario;

    public Trabajador(float salario, String cedula, String nombre1, String nombre2, 
                      String apellido1, String apellido2, LocalDate fechaNacimiento)
    {
        super(cedula, nombre1, nombre2, apellido1, apellido2, fechaNacimiento);
        this.salario = salario;
    }

    @Override
    public String toString()
    {
        return "Trabajador{" + "salario=" + salario + '}';
    }
    
    
}
