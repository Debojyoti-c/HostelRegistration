package controllers;


import dtos.RegistrationDTO;
import services.HostelService;
import services.StudentService;

public class RegistrationController {

    private HostelService hostelService;

    private StudentService studentService;

    public RegistrationController() {
        hostelService = new HostelService();
        studentService = new StudentService();
    }

    public void addHostels(int totalStudentCapacityInHostel) {
        hostelService.addHostels(totalStudentCapacityInHostel);
    }

    public void registerStudent(RegistrationDTO registrationDTO) {
        studentService.addStudents(registrationDTO);
    }

    public void print() {
        hostelService.printStudentsInHostel();
        studentService.printUnregisteredStudents();
    }
}
