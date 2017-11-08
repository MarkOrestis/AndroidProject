package team42.cs2340.rattrackingapp.Model;


/**
 * Enum class for Borough containing the different types of borough!
 */

public enum Borough {
    MANHATTAN ("Manhattan"),
    STATEN_ISLAND ("Staten Island"),
    QUEENS ("Queens"),
    BROOKLYN ("Brooklyn"),
    BRONX ("Bronx");

    /** the full string representation of the borough name */
    private final String borough;


    /**
     * Constructor for the enumeration
     *
     * @param borough   full name of the course
     */
    Borough(String borough) {
        this.borough = borough;
    }


    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return borough; }
}