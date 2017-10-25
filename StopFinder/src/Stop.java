
public class Stop {
    private final int ID;
    private final String NAME;
    private final double LONGITUDE;
    private final double LATITUDE;

    public Stop(int ID, String NAME, double LATITUDE, double LONGITUDE) {
        this.ID = ID;
        this.NAME = NAME;
        this.LONGITUDE = LONGITUDE;
        this.LATITUDE = LATITUDE;
    }

    public int getID() {
        return ID;
    }
    public String getNAME() {
        return NAME;
    }
    public double getLONGITUDE() {
        return LONGITUDE;
    }
    public double getLATITUDE() {
        return LATITUDE;
    }

    public String toString(){
        return "ID: " + ID + "\nName: " + NAME + "\nLatitude: " + LATITUDE + "\nLongitude: " + LONGITUDE;
    }
}
