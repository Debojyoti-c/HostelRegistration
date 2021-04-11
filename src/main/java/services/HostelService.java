package services;

import models.FoodType;
import models.Hostel;
import models.Student;
import repositories.HostelRepository;

import java.util.List;
import java.util.Map;

public class HostelService {

    private final Integer NUMBER_OF_GRADES = 2;
    private final Integer NUMBER_OF_FOOD_TYPES = 2;

    private HostelRepository hostelRepository;

    public HostelService() {
        hostelRepository = new HostelRepository();
    }

    public void addHostels(int totalStudents) {
        int capacityPerHostel = totalStudents / (NUMBER_OF_GRADES * NUMBER_OF_FOOD_TYPES);

        // Create 4 hostels
        Hostel h1 = new Hostel(capacityPerHostel, FoodType.V, "A");
        hostelRepository.initHostel(h1);

        Hostel h2 = new Hostel(capacityPerHostel, FoodType.V, "B");
        hostelRepository.initHostel(h2);

        Hostel h3 = new Hostel(capacityPerHostel, FoodType.NV, "A");
        hostelRepository.initHostel(h3);

        Hostel h4 = new Hostel(capacityPerHostel, FoodType.NV, "B");
        hostelRepository.initHostel(h4);
    }

    public void printStudentsInHostel() {
        Map<String, Hostel> hostelMap = hostelRepository.getHostelMap();
        for (Map.Entry<String, Hostel> entry: hostelMap.entrySet()) {
            System.out.print(entry.getKey() + ": [");
            List<Student> students = entry.getValue().getStudentList();
            for (Student student: students) {
                System.out.print(student.getRollNo() + ",");
            }
            System.out.println("]");
        }
    }
}
