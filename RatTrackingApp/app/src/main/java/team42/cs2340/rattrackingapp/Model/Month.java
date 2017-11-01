package team42.cs2340.rattrackingapp.Model;

/**
 * Created by Beatrice on 10/30/17.
 */

public enum Month {
    JANUARY ("January", 1),
    FEBRUARY ("February", 2),
    MARCH ("March", 3),
    APRIL ("April", 4),
    MAY ("May", 5),
    JUNE ("June", 6),
    JULY ("July", 7),
    AUGUST ("August", 8),
    SEPTEMBER ("September", 9),
    OCTOBER ("October", 10),
    NOVEMBER ("November", 11),
    DECEMBER ("December", 12);


    /** the full string representation of the borough name */
    private final String month;
    private final int number;


    /**
     * Constructor for the enumeration
     *
     * @param month   full name of the course
     */
    Month(String month, int number) {
        this.month = month;
        this.number = number;
    }


    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return month; }

    public int getMonth() { return number; }
}
