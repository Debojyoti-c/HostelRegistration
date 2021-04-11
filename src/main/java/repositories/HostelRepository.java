package repositories;


import datastore.DataStore;
import models.Hostel;

import java.util.Map;

public class HostelRepository {

    private DataStore dataStore;

    public HostelRepository() {
        dataStore = DataStore.getInstance();
    }

    public Hostel initHostel(Hostel hostel) {
        // Key of the map is grade_foodType
        // Eg. A_NV
        String key = hostel.getClassGrade() + hostel.getFoodType();
        dataStore.getHostelMap().put(key, hostel);
        return hostel;
    }

    public Hostel getHostel(String key) {
        return dataStore.getHostelMap().get(key);
    }

    public void updateHostel(String key, Hostel hostel) {
        dataStore.getHostelMap().put(key, hostel);
    }

    public Map<String, Hostel> getHostelMap() {
        return dataStore.getHostelMap();
    }
}
