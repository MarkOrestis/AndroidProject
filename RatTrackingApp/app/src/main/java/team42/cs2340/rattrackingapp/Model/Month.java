package team42.cs2340.rattrackingapp.Model;

/**
 * Created by beatrice on 10/20/17.
 */

public enum Month {
    JANUARY ("January"),
    FEBRUARY ("February"),
    MARCH ("March"),
    APRIL ("April"),
    MAY ("May"),
    JUNE ("June"),
    JULY ("July"),
    AUGUST ("August"),
    SEPTEMBER ("September"),
    OCTOBER ("October"),
    NOVEMBER ("November"),
    DECEMBER ("December");


    /** the full string representation of the borough name */
    private final String month;


    /**
     * Constructor for the enumeration
     *
     * @param month   full name of the course
     */
    Month(String month) {
        this.month = month;
    }


    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return month; }
}
