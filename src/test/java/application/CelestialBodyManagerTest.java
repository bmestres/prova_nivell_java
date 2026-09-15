package application;

import domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CelestialBodyManagerTest {

    List<CelestialBody> testList = List.of(
            new Planet("Default Planet With Atmosphere Name", 250.654, 22.564, 3, true),
            new Star("Default Star Nam", 342.876, 27.98, 86.754, "Default espectral type", "Default description"),
            new Moon("Default Moon Name", 279.879, 49.753, "Test Orbital Planet", true),
            new Planet("Default Planet Name", 250.654, 22.564, 3, false)
    );

    CelestialBodyManager testManager = new CelestialBodyManager(testList);

    @Test
    void registerCelestialBodyMustIncreaseListByOne() {

        int initialListSize = testManager.fetchAll().size();

        int expectedSize = initialListSize + 1;

        testManager.registerCelestialBody(new Star("Default Star Name 02", 342.876, 27.98, 86.754, "Default espectral type", "Default description"));

        int currentListSize = testManager.fetchAll().size();

        assertEquals(expectedSize, currentListSize);

    }

    @Test
    void fetchAllShouldReturnExpectedList() {
        List<CelestialBody> expectedList = List.of(
                new Planet("Default Planet With Atmosphere Name", 250.654, 22.564, 3, true),
                new Star("Default Star Nam", 342.876, 27.98, 86.754, "Default espectral type", "Default description"),
                new Moon("Default Moon Name", 279.879, 49.753, "Test Orbital Planet", true),
                new Planet("Default Planet Name", 250.654, 22.564, 3, false)
        );

        assertThat(expectedList).usingRecursiveComparison().isEqualTo(testManager.fetchAll());
    }

    @Test
    void filterPlanetsWithAtmosphereShouldReturnExpectedList() {

        List<Planet> expectedList = List.of(
                new Planet("Default Planet With Atmosphere Name", 250.654, 22.564, 3, true)
        );

        assertThat(expectedList).usingRecursiveComparison().isEqualTo(testManager.filterPlanetsWithAtmosphere());
    }

    @Test
    void filterMoonsByOrbitalPlanetShouldReturnExpectedList() {

        List<Moon> expectedList = List.of(
                new Moon("Default Moon Name", 279.879, 49.753, "Test Orbital Planet", true)
        );

        List<Moon> currentList = testManager.filterMoonsByOrbitalPlanet("Test Orbital Planet");
        assertThat(expectedList).usingRecursiveComparison().isEqualTo(expectedList);

    }

    @Test
    void filterHabitablesShouldReturnExpectedList(){
        List<Habitable> expectedList = List.of(
                new Planet("Default Planet With Atmosphere Name", 250.654, 22.564, 3, true),
                new Moon("Default Moon Name", 279.879, 49.753, "Test Orbital Planet", true)
        );

        assertThat(expectedList).usingRecursiveComparison().isEqualTo(testManager.filterHabitableBodies());
    }
}