package domain;

public class Star extends CelestialBody{
    private double surfaceTemperature;
    private String espectralType;
    private String defaultDescription;
    private static final String DEFAULT_NAME = "Star";

    public Star(String name, double diameterInKm, double dayDurationInH, double surfaceTemperature, String espectralType, String defaultDescription) {
        super(name, diameterInKm, dayDurationInH);

        if(espectralType == null) {
            throw new IllegalArgumentException("Name must not be NULL");
        }

        if(espectralType.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        if(defaultDescription == null) {
            throw new IllegalArgumentException("Description must not be NULL");
        }

        if(defaultDescription.isBlank()) {
            throw new IllegalArgumentException("Description must not be empty");
        }
        
        this.surfaceTemperature = surfaceTemperature;
        this.espectralType = espectralType;
        this.defaultDescription = defaultDescription;
    }

    public double getSurfaceTemperature() {
        return surfaceTemperature;
    }

    public String getEspectralType() {
        return espectralType;
    }

    public String getDefaultDescription() {
        return defaultDescription;
    }

    @Override
    public String getCientificDescription() {
        return String.format("%s\n%s is a Star of type %s with a surface temperature of %.3f. %s",
                DEFAULT_NAME, super.getName(), this.getEspectralType(), this.getSurfaceTemperature(), this.getDefaultDescription());
    }
}
