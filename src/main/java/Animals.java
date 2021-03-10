import org.sql2o.Connection;

import java.util.List;

public class Animals implements DatabaseManagement {
    private String aniName;
    private int id;
    public boolean endangered;
    private final String DATABASE_TYPE = "animal";


    public Animals(String aniName) {
        this.aniName = aniName;
    }

//    public Animals(String name) {
//    }

    public String getAniName() {
        return aniName;
    }

    public void setAniName(String aniName) {
        this.aniName = aniName;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Object all() {
        return all();
    }

    @Override
    public boolean equals(Object otherAnimals){
        if (!(otherAnimals instanceof Animals)) {
            return false;
        }else {
            Animals newAnimals = (Animals) otherAnimals;
            return this.getAniName().equals(newAnimals.getAniName()) &&
                    this.getId() == (newAnimals.getId());
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (aniName, endangered) VALUES (:aniName, :endangered)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("aniName", this.aniName)
                    .addParameter("endangered", this.endangered)
                    .executeUpdate()
                    .getKey();
//            setId(id);
        }
    }

//        public void save() {
//            if (this.name.equals("") || this.type.equals("") || this.name.equals(null) || this.type.equals(null)) {
//                throw new IllegalArgumentException("Fields cannot be Empty");
//            }
//            try (Connection con = DB.sql2o.open()) {
//                String sql = "INSERT INTO animals (name,type) VALUES (:name,:type)";
//                this.id = (int) con.createQuery(sql, true)
//                        .addParameter("name", this.name)
//                        .addParameter("type", this.type)
//                        .executeUpdate()
//                        .getKey();
//            }
//        }

    public static List<Animals> getAllAnimals(){
        String sql = "SELECT * FROM animals WHERE endangered='false'";

        try (Connection con = DB.sql2o.open()){
            return   con.createQuery(sql)
//                    .throwOnMappingFailure(false)
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