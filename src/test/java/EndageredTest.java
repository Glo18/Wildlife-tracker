import org.junit.*;

import static org.junit.Assert.assertEquals;

public class EndageredTest {
    @Test
    public void Animals_instantiatesName_of_the_animal_true_String() {
        Endagered testEndagered = new Endagered("Rhino", "okay", "Newborn");
        assertEquals("Elephant", testEndagered.getName());
    }
}