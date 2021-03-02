import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalsTest {
    @Test
    public void Animals_instantiatesName_of_the_animal_true_String() {
        Animals testAnimals = new Animals("Elephant");
        assertEquals("Elephant", testAnimals.getName());
    }
}