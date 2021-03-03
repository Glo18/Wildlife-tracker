import org.sql2o.Connection;

import java.util.List;

public class Animals {
    private String name;
    private int id;
    public String type;
    private final String DATABASE_TYPE = "animal";


    public Animals(String name) {
        this.name = name;
        this.setType(DATABASE_TYPE);
    }

    public String getName() {

        return name;
    }

    public int getId() {

        return id;
    }

    private void setId(int id) {

        this.id = id;
    }

    private void setType(String type) {

        this.type = type;
    }

    @Override
    public boolean equals(Object otherAnimals){
        if (!(otherAnimals instanceof Animals)) {
            return false;
        }else {
            Animals newAnimals = (Animals) otherAnimals;
            return this.getName().equals(newAnimals.getName()) &&
                    this.getId() == (newAnimals.getId());
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
            setId(id);
        }
    }

    public static List<Animals> getAllAnimals(){
        String sql = "SELECT * FROM animals where type='animal';";

        try (Connection con = DB.sql2o.open()){
            return   con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animals.class);

        }
    }

    public void delete() {
        try (Connection con = DB.sql2o.open()){
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
}
