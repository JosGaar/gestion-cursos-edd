package proyecto;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class ManejadorCadenas {

    public static String obtenerStringDesdeMensaje(String mensaje)
    {

        String mes = null;
        boolean error = false;

        do {
            try {
                mes = JOptionPane.showInputDialog(null, mensaje);
                error = false;
            } catch (HeadlessException e) {
                VisualizadorMensajes.mostrarMensaje("Error: " + e.getMessage());
                error = true;
            }
        } while (error);

        return mes;
    }

    public static int obtenerEnteroDesdeMensaje(String mensaje)
    {
        int cantidad = 0;
        boolean error = false;

        do {
            try {
                cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
                error = false;
            } catch (NumberFormatException nfe) {
                VisualizadorMensajes.mostrarMensaje("Error, ingrese un número.");
                error = true;
            }
        } while (error);

        return cantidad;
    }

}
