import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Endagered {
    private int id;
    private String name;
    private String health;
    private String age;

    public Endagered(String name, String health, String age) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth(){
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public static List<Endagered> getAllEndagered() {
        String sql = "SELECT * FROM animals WHERE type = 'endangered';";

        try (Connection con = DB.sql2o.open()){
            return   con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endagered.class);

        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, health, age) VALUES (:name, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
            setId(id);
        }catch (Sql2oException ex ){
            System.out.println(ex);
        }
    }
}
