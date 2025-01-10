
package repositorylayer;

import datatransferlayer.DtoActivity;
import java.util.List;

public interface RepoActivity {
     int insert(DtoActivity dto);
      List<DtoActivity> getAllSortedByProximity();
     int delete(String id); 
}
