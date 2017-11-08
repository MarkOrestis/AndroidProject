package team42.cs2340.rattrackingapp.Model;

/**
 * Enum class of Month that helps to have a relation between the number of the month with the name
 * of the month.
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


    /** The final String representation of the month. */
    private final String month;
    /** The final int representation of the number for the month. */
    private final int number;


    /**
     * Constructor for the enumeration
     *
     * @param month full name of the course
     */
    Month(String month, int number) {
        this.month = month;
        this.number = number;
    }


    /**
     * The toString method to return the private variable month.
     * @return the display string representation of the course
     */
    public String toString() { return month; }

    /**
     * The public method to get the private variable month number.
     * @return the interger representation of the month
     */
    public int getMonth() { return number; }
}
