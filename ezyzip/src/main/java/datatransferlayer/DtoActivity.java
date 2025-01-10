
package datatransferlayer;

import java.util.Date;

public class DtoActivity {
    private int id;
    private String name;
    private Date startDateTime;
    private Date endDateTime;    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

}
