package domain;

public class Planet extends CelestialBody implements PotentiallyHabitable {
    private int numberOfMoons;
    private boolean atmospherePresence;
    private static final String DISPLAY_NAME = "Planet";

    public Planet(String name, double diameterInKm, double dayDurationInH, int numberOfMoons, boolean atmospherePresence) {
        super(name, diameterInKm, dayDurationInH);

        if(numberOfMoons < 0) {
            throw new IllegalArgumentException("Number of moons must not be a negative value");
        }

        this.numberOfMoons = numberOfMoons;
        this.atmospherePresence = atmospherePresence;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    public boolean isAtmospherePresence() {
        return atmospherePresence;
    }

    public String atmospherePresenceDefaultString(){

        if(atmospherePresence){
            return String.format("it has an atmosphere");
        }
        return String.format("it does not have an atmosphere");
    }

    public String moonDefaultString(){
        if(numberOfMoons == 0) {
            return String.format("It does not have any moon");
        }
            return String.format("It has %d moons", this.getNumberOfMoons());
    }

    @Override
    public String getCientificDescription() {
            return String.format("%s\n%s has a diameter of %.3f KM and %s. %s",
                    DISPLAY_NAME, super.getName(), this.getDiameterInKm(), this.atmospherePresenceDefaultString(), this.moonDefaultString());

    }

    @Override
    public boolean isHabitable() {
        return atmospherePresence;
    }

    @Override
    public String getHabitabilityReport() {
        if(isHabitable()){
            return String.format("%s, %s, therefore it is habitable", super.getName(), this.atmospherePresenceDefaultString());
        }
        return String.format("%s, %s, therefore it is not habitable", super.getName(), this.atmospherePresenceDefaultString());
    }
}
