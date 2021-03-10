import org.junit.*;

import static org.junit.Assert.*;

public class EndangeredTest {
//    @Rule
//    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Animals_instantiatesName_of_the_animal_true_String() {
        Endangered testEndangered = new Endangered("Elephant", "okay", "Newborn");
        assertEquals("Elephant", testEndangered.getName());
    }

    @Test
    public void save_successfully_List() {
        Endangered testEndangered = new Endangered("Elephant","okay", "Newborn");
        testEndangered.save();
        assertTrue(Endangered.getAllEndangered().get(0).equals(testEndangered));
    }

}