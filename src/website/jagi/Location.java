package website.jagi;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null) {       //In case there are not exits and passed is only a null
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q", 0);  // each exit will have break with Q
    }

    // public void addExit(String direction, int location) {
    //     exits.put(direction, location);
    // }
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);  //Creates a copy of exits, so that exits could not been changed
    }

}
