/**
 * Class that represents a generic bus stop with an ID, a name and a pair of coordinates.
 * @author francesco.rossato
 */
public class Stop implements Comparable{
    /**
     * The final {@link Integer} representing the stop's ID.
     */
    private final int ID;
    /**
     * The final {@link String} representing the stop's name.
     */
    private final String NAME;
    /**
     * The final {@link Double} representing the stop's longitude.
     */
    private final double LONGITUDE;
    /**
     * The final {@link Double} representing the stop's latitude.
     */
    private final double LATITUDE;

    /**
     * The one and only constructor with all the parameters.
     * @param ID The stop's ID.
     * @param NAME The stop's name.
     * @param LATITUDE The stop's latitude.
     * @param LONGITUDE The stop's longitude.
     */
    public Stop(int ID, String NAME, double LATITUDE, double LONGITUDE) {
        this.ID = ID;
        this.NAME = NAME;
        this.LONGITUDE = LONGITUDE;
        this.LATITUDE = LATITUDE;
    }

    /**
     * Gets the {@link Integer} with the stop's ID.
     * @return The {@link Integer} with the stop's ID.
     */
    public int getID() {
        return ID;
    }

    /**
     * Gets the {@link String} with the stop's name.
     * @return The {@link String} with the stop's name.
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * Gets the {@link Double} with the stop's longitude.
     * @return The {@link Double} with the stop's longitude.
     */
    public double getLONGITUDE() {
        return LONGITUDE;
    }

    /**
     * Gets the {@link Double} with the stop's latitude.
     * @return The {@link Double} with the stop's latitude.
     */
    public double getLATITUDE() {
        return LATITUDE;
    }

    /**
     * Gets the representation of the stop with all its properties.
     * @return The {@link String} "ID: " + {@link Stop#ID} + "\nName: " + {@link Stop#NAME} + "\nLatitude: " + {@link Stop#LATITUDE} + "\nLongitude: " + {@link Stop#LONGITUDE}
     */
    public String toString(){
        return "ID: " + ID + "\nName: " + NAME + "\nLatitude: " + LATITUDE + "\nLongitude: " + LONGITUDE;
    }

    @Override
    public int compareTo(Object o) {
        Stop s = (Stop) o;
        return (int) (LATITUDE - s.getLATITUDE());
    }
}
