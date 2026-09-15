package domain;

public class Moon extends CelestialBody implements PotentiallyHabitable{
    private String orbitalPlanet;
    private boolean rockySurface;
    private static final String DEFAULT_NAME = "Moon";

    public Moon(String name, double diameterInKm, double dayDurationInH, String orbitalPlanet, boolean rockySurface) {
        super(name, diameterInKm, dayDurationInH);

        checkInputData(orbitalPlanet);

        this.orbitalPlanet = orbitalPlanet;
        this.rockySurface = rockySurface;
    }

    private static void checkInputData(String orbitalPlanet) {
        if(orbitalPlanet == null) {
            throw new IllegalArgumentException("Orbital planet must not be NULL");
        }

        if(orbitalPlanet.isBlank()){
            throw new IllegalArgumentException("Orbital planet must not be empty");
        }
    }

    public String getOrbitalPlanet() {
        return orbitalPlanet;
    }

    public boolean isRockySurface() {
        return rockySurface;
    }

    public String isRockySurfaceStringDescription() {
        if(isRockySurface()){
            return String.format("It has a rocky surface");
        }
        return String.format("It doesn't have a rocky surface");
    }

    @Override
    public String getCientificDescription() {
        return String.format("%s\nThe %s orbits around %s. %s and its diameter is %.3f KM",
                DEFAULT_NAME, super.getName(), this.getOrbitalPlanet(), this.isRockySurfaceStringDescription(), this.getDiameterInKm());
    }

    @Override
    public boolean isHabitable() {
        return isRockySurface();
    }

    @Override
    public String getHabitabilityReport() {
        if(isHabitable()){
            return String.format("%s, %s therefore is habitable", super.getName(), this.isRockySurfaceStringDescription());
        }
        return String.format("%s, %s therefore it is not habitable", super.getName(), this.isRockySurfaceStringDescription());
    }
}
