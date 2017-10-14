package team42.cs2340.rattrackingapp.Model;

/**
 * The model class that holds all the rat sighting data itself.
 */
public class RatSightingData {
    private String uniqueKey;
    private String createdDate;
    private String locationType;
    private String incidentZip;
    private String incidentAddress;
    private String city;
    private String borough;
    private String latitude;
    private String longitude;

    /**
     * Get Rat Sighting Data's Unique Key.
     * @return Unique Key
     */
    public String getUniqueKey() {
        return uniqueKey;
    }

    /**
     * Get Rat Sighting Data's Created Date
     * @return createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Get Rat Sighting Data's Location Type
     * @return locationType
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Get Rat Sighting Data's Incident Zip
     * @return incidentZip
     */
    public String getIncidentZip() {
        return incidentZip;
    }

    /**
     * Get Rat Sighting Data's incident Address
     * @return incidentAddress
     */
    public String getIncidentAddress() {
        return incidentAddress;
    }

    /**
     * Get Rat Sighting Data's City
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Get Rat Sighting Data's Borough
     * @return borough
     */
    public String getBorough() {
        return borough;
    }

    /**
     * Get Rat Sighting Data's Latitude
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Get Rat Sighting Data's Longitude
     * @return longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets Rat Sighting Data's Unique Key
     * @param uniqueKey
     */
    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    /**
     * Sets Rat Sighting Data's Created Date
     * @param createdDate
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Sets Rat Sighting Data's Location Type
     * @param locationType
     */
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    /**
     * Sets Rat Sighting Data's Incident Zip
     * @param incidentZip
     */
    public void setIncidentZip(String incidentZip) {
        this.incidentZip = incidentZip;
    }

    /**
     * Sets Rat Sighting Data's Incident Address
     * @param incidentAddress
     */
    public void setIncidentAddress(String incidentAddress) {
        this.incidentAddress = incidentAddress;
    }

    /**
     * Sets Rat Sighting Data's City
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets Rat Sighting Data's Borough
     * @param borough
     */
    public void setBorough(String borough) {
        this.borough = borough;
    }

    /**
     * Sets Rat Sighting Data's Latitude
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     *Sets Rat Sighting Data's Longitude
     * @param longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
