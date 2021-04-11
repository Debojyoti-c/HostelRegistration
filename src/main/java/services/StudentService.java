package services;

import dtos.RegistrationDTO;
import models.FoodType;
import models.Hostel;
import models.Student;
import repositories.HostelRepository;
import repositories.StudentRepository;

import java.util.LinkedList;
import java.util.List;

public class StudentService {

    private StudentRepository studentRepository;

    private HostelRepository hostelRepository;

    public StudentService() {
        studentRepository = new StudentRepository();
        hostelRepository = new HostelRepository();
    }

    public Student addStudents(RegistrationDTO registrationDTO) {

        Integer rollNo = Integer.parseInt(registrationDTO.getRollNumber());
        FoodType foodType = registrationDTO.getFood().equals("V")? FoodType.V : FoodType.NV;
        String grade = registrationDTO.getGrade();

        // Silently ignore if student already present
        Student existingStudent = studentRepository.checkStudent(rollNo);
        if (existingStudent != null) {
            return existingStudent;
        }

        Student student = new Student(rollNo, grade, foodType);
        studentRepository.addStudent(student);

        addStudentToHostel(student);

        return student;
    }

    private void addStudentToHostel(Student student) {

        String key =  student.getClassGrade() + student.getFoodType();
        Hostel hostel = hostelRepository.getHostel(key);

        List<Student> list = hostel.getStudentList();
        if (list == null) {
            list = new LinkedList<>();
        }

        // Already Full
        if (hostel.getCapacity() == list.size()) {
            studentRepository.addUnregisteredStudents(student);
            return;
        }

        list.add(student);

        hostelRepository.updateHostel(key, hostel);
    }

    public void printUnregisteredStudents() {
        List<Student> unregisteredStudents = studentRepository.getUnregisteredStudents();
        System.out.print("NA : [");
        for (Student student: unregisteredStudents) {
            System.out.print(student.getRollNo() + ",");
        }
        System.out.println("]");
    }
}
