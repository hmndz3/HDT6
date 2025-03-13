// Importaciones necesarias
import javax.swing.SwingUtilities;

public class Main {
    //--------------------------------------------------------------------------  
    //Método principal que inicia la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazGraficaPokemon();
            }
        });
    }
}