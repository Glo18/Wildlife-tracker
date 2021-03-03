import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class Sightings {
    private int id;
    private String location;
    private String rangerName;
    private String animalName;

    public Sightings(String location, String rangerName, String animalName) {
        this.id = id;
        this.location = location;
        this.rangerName = rangerName;
        this.animalName = animalName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (location, rangerName, aniName) VALUES (:location, :rangerName, :aniName);";
            this.id = (int) con.createQuery(sql,true)
                    .throwOnMappingFailure(false)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("animalName", this.animalName)
                    .executeUpdate()
                    .getKey();
            setId(id);
        }catch (Sql2oException ex ){
            System.out.println(ex);
        }
    }
}
