import org.sql2o.Connection;

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

    public void setName(String name) {
        this.name = name;
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

}
