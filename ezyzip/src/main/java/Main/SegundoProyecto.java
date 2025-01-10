
package Main;

import businesslayer.BusinessActivity;
import presentationlayer.MdiPrincipal;

public class SegundoProyecto {

    public static void main(String[] args) {
        // Configuración de Look and Feel para la interfaz
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SegundoProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Ejecución del programa principal en el Event Dispatch Thread (EDT)
        java.awt.EventQueue.invokeLater(() -> {
            // Ejemplo de instancia de tu capa de negocio y operación básica
             new MdiPrincipal().setVisible(true);
            BusinessActivity businessActivity = new BusinessActivity();

   

            // Mostrar todas las actividades ordenadas por proximidad
            System.out.println("Lista de actividades:");
            businessActivity.getAllSortedByProximity().forEach(activity -> {
                System.out.println("ID: " + activity.getId());
                System.out.println("Nombre: " + activity.getName());
                System.out.println("Hora Inicio: " + activity.getStartDateTime());
                System.out.println("Hora Fin: " + activity.getEndDateTime());
                System.out.println("-----------------------------");
            });

            
        });
    }
    }

