package team42.cs2340.rattrackingapp.Model;


/**
 * An enum class for location type that contains the different location types in it
 */

public enum LocationType{
    TWO_FAMILY ("1-2 Family dwelling"),
    FAMILY_APT ("3+ Family apartment"),
    FAMILY_MIXED ("3+ Family mixed use building"),
    COMMERCIAL ("Commercial building"),
    LOT ("Vacant lot"),
    CONSTRUCTION ("Construction sight"),
    HOSPITAL ("Hospital"),
    SEWER ("Catch basin / sewer");

    /** the full string representation of the borough name */
    private final String locationType;


    /**
     * Constructor for the enumeration
     *
     * @param locationType   full name of the course
     */
    LocationType(String locationType) {
        this.locationType = locationType;
    }


    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return locationType; }
}