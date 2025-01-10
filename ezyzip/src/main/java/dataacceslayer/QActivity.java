
package dataacceslayer;

import datatransferlayer.DtoActivity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import repositorylayer.RepoActivity;

public class QActivity implements RepoActivity{
private String query;
private List<DtoActivity> listActivity;
private DataBaseConnection dbc;
private int quantityRowsAffected; 

    @Override
    public int insert(DtoActivity dto) {
        dbc= new DataBaseConnection();
query="insert into activities (nombre_de_actividad, hora_inicio, hora_fin) values (?,?,?)";
try{
    PreparedStatement ps= dbc.connection.prepareStatement(query);
    ps.setString(1,dto.getName());
    ps.setTimestamp(2,new java.sql.Timestamp(dto.getStartDateTime().getTime()));
    ps.setTimestamp(3, new java.sql.Timestamp(dto.getEndDateTime().getTime()));
    quantityRowsAffected= ps.executeUpdate();
    dbc.connection.close();
    
    return quantityRowsAffected; 
}catch(SQLException e){
    System.out.println(e.getMessage());
    return 0; 
}
    }

    @Override
    public List<DtoActivity> getAllSortedByProximity() {
dbc= new DataBaseConnection(); 
            listActivity = new ArrayList<>(); //LISTACTIVIT ES UNA VARIABLE TIPO LIST<FDTOACTIVITIES>, ALAMACENA OBEJTOS DE ESE TIPO Y LOQ UE AHEC AHORA ES CREAR UN ARRAYLIST QUE TAMBIEN SOLA CEPTE ESE TIPO DE OBJETS 
query= "SELECT*FROM activities ORDER BY hora_inicio ASC"; 
try{
    PreparedStatement ps= dbc.connection.prepareStatement(query);
    ResultSet rows=ps.executeQuery();
    while(rows.next()){
         DtoActivity dtoActivity = new DtoActivity();
            dtoActivity.setId(rows.getInt("id"));
            dtoActivity.setName(rows.getString("nombre_de_actividad"));
            dtoActivity.setStartDateTime(rows.getTimestamp("hora_inicio"));
            dtoActivity.setEndDateTime(rows.getTimestamp("hora_fin"));
        listActivity.add(dtoActivity);
    }
    dbc.connection.close(); 
    return listActivity; 
}catch(SQLException ex){
    System.out.println(ex.getMessage());
    return listActivity;
}
    }

    @Override
    public int delete(String id) {
dbc = new DataBaseConnection();
        query = "DELETE FROM activities WHERE id = ?";
        try {
            PreparedStatement ps = dbc.connection.prepareStatement(query);
            ps.setString(1, id);  // Aquí se pasa un String
            int rowsAffected = ps.executeUpdate();
            dbc.connection.close();
            return rowsAffected;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
        }

   


}

 