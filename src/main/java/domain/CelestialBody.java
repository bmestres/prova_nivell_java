package domain;

public abstract class CelestialBody {
    private String name;
    private double diameterInKm;
    private double dayDurationInH;
    private static final String DISPLAY_NAME = "Celestial body";

    public CelestialBody(String name, double diameterInKm, double dayDurationInH) {

        checkInputData(name, diameterInKm, dayDurationInH);

        this.name = name;
        this.diameterInKm = diameterInKm;
        this.dayDurationInH = dayDurationInH;
    }

    private static void checkInputData(String name, double diameterInKm, double dayDurationInH) {
        if(name == null) {
            throw new IllegalArgumentException("Name must not be NULL");
        }

        if(name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        if(diameterInKm <= 0) {
            throw new IllegalArgumentException("Diameter must not be equal or less than 0");
        }

        if(dayDurationInH <= 0) {
            throw new IllegalArgumentException("Day duration must not be equal or less than 0");
        }
    }

    public String getName() {
        return name;
    }

    public double getDiameterInKm() {
        return diameterInKm;
    }

    public double getDayDurationInH() {
        return dayDurationInH;
    }

    public abstract String getCientificDescription();
}
