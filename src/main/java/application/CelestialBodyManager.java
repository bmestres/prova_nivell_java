package application;

import domain.CelestialBody;
import domain.Moon;
import domain.Planet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CelestialBodyManager {

    private List<CelestialBody> celestialBodyList;

    public CelestialBodyManager(List<CelestialBody> celestialBodyList) {
        this.celestialBodyList = new ArrayList<>(celestialBodyList);
    }

    public void registerCelestialBody(CelestialBody celestialBody) {
        if(celestialBody == null) {
            throw new IllegalArgumentException("Celestial body must not be NULL");
        }
        this.celestialBodyList.add(celestialBody);
    }

    public List<CelestialBody> fetchAll() {
        return List.copyOf(this.celestialBodyList);
    }

    public List<Planet> filterPlanetsWithAtmosphere() {
        return this.
                fetchAll()
                .stream()
                .filter(celestialBody -> celestialBody instanceof Planet)
                .map(celestialBody -> (Planet)celestialBody)
                .filter(planet -> planet.isAtmospherePresence())
                .collect(Collectors.toList());
    }

    public List<Moon> filterMoonsByOrbitalPlanet(String orbitalPlanet) {
        return this
                .fetchAll()
                .stream()
                .filter(celestialBody -> celestialBody instanceof Moon)
                .map(celestialBody -> (Moon)celestialBody)
                .filter(moon -> moon.getOrbitalPlanet().equalsIgnoreCase(orbitalPlanet))
                .collect(Collectors.toList());

    }


}
