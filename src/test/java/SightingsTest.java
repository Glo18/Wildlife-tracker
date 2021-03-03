import org.junit.Test;
import static org.junit.Assert.*;

public class SightingsTest {

    @Test
    public void Sighting_location_true_string() {
        Sightings testSightings = new Sightings("Zone B", "Kayle", "rhino");
        assertEquals("Zone B", testSightings.getLocation());
    }
    @Test
    public void Sighting_ranger_true_string() {
        Sightings testSightings = new Sightings("Zone B", "Kayle", "rhino");
        assertEquals("Kayle", testSightings.getRangerName());
    }
    @Test
    public void Sighting_animal_true_string() {
        Sightings testSightings = new Sightings("Zone B", "Kayle", "rhino");
        assertEquals("rhino", testSightings.getAnimalName());
    }
}