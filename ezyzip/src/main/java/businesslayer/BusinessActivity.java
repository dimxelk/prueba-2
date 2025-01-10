
package businesslayer;

import dataacceslayer.QActivity;
import datatransferlayer.DtoActivity;
import java.util.Calendar;

import java.util.List;
import repositorylayer.RepoActivity;


public class BusinessActivity {
    private final RepoActivity repoActivity;

    public BusinessActivity() {
        repoActivity = new QActivity();  // Inicializa el repositorio de actividades
    }

    // Método para insertar una nueva actividad
    public boolean insert(String name, int startDateDay, int startDateMonth, int startDateYear, 
                          int startDateHour, int startDateMinute, int endDateDay, int endDateMonth, 
                          int endDateYear, int endDateHour, int endDateMinute) {
        
        DtoActivity dtoActivity = new DtoActivity();
        
        // Establece el nombre de la actividad
        dtoActivity.setName(name);

        // Configura las fechas de inicio y fin usando Calendar
        Calendar startCal = Calendar.getInstance();
        startCal.set(Calendar.YEAR, startDateYear);
        startCal.set(Calendar.MONTH, startDateMonth - 1); // El mes empieza desde 0
        startCal.set(Calendar.DAY_OF_MONTH, startDateDay);
        startCal.set(Calendar.HOUR_OF_DAY, startDateHour);
        startCal.set(Calendar.MINUTE, startDateMinute);
        
        Calendar endCal = Calendar.getInstance();
              
              endCal.set(Calendar.DAY_OF_MONTH, endDateDay);
                      endCal.set(Calendar.MONTH, endDateMonth - 1); // El mes empieza desde 0
        endCal.set(Calendar.YEAR, endDateYear);
        endCal.set(Calendar.HOUR_OF_DAY, endDateHour);
  endCal.set(Calendar.MINUTE, endDateMinute);
  
        


        // Asigna las fechas al DTO
        dtoActivity.setStartDateTime(startCal.getTime());
        dtoActivity.setEndDateTime(endCal.getTime());


        // Llama a la capa de datos para insertar la actividad
        int rowsAffected = repoActivity.insert(dtoActivity);

        // Retorna true si la actividad fue insertada correctamente
        return rowsAffected > 0;
    }

    // Método para obtener todas las actividades ordenadas por proximidad (fecha de inicio)
    public List<DtoActivity> getAllSortedByProximity() {
        return repoActivity.getAllSortedByProximity();
    }

     public boolean delete(String id) {
        int rowsAffected = repoActivity.delete(id);  // Aquí se pasa un String
        return rowsAffected > 0;//aca devvuleve true 
    }
}


