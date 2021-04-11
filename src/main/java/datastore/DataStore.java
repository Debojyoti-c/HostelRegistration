package datastore;


import models.Hostel;
import models.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {

    /*
    * Maps RollNumber to Student, used to check duplicate
    * student registration
    */
    private Map<Integer, Student> studentMap;

    /*
     * Maps class+food_type -> to Hostel, used to map
     * students to hostel accordingly
     */
    private Map<String, Hostel> hostelMap;

    private List<Student> unregisteredStudents;

    private static DataStore instance;

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    private DataStore() {
        studentMap = new HashMap<>();
        hostelMap = new HashMap<>();
        unregisteredStudents = new ArrayList<>();
    }

    public Map<Integer, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<Integer, Student> studentMap) {
        this.studentMap = studentMap;
    }

    public Map<String, Hostel> getHostelMap() {
        return hostelMap;
    }

    public void setHostelMap(Map<String, Hostel> hostelMap) {
        this.hostelMap = hostelMap;
    }

    public List<Student> getUnregisteredStudents() {
        return unregisteredStudents;
    }

    public void setUnregisteredStudents(List<Student> unregisteredStudents) {
        this.unregisteredStudents = unregisteredStudents;
    }

    public static void setInstance(DataStore instance) {
        DataStore.instance = instance;
    }

    public void flush() {
        studentMap = new HashMap<>();
        hostelMap = new HashMap<>();
        unregisteredStudents = new ArrayList<>();
    }
}
