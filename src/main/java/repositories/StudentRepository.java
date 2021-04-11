package repositories;


import datastore.DataStore;
import models.Student;

import java.util.List;

public class StudentRepository {

    private DataStore dataStore;

    public StudentRepository() {
        dataStore = DataStore.getInstance();
    }

    public Student checkStudent(int rollNumber) {
        return dataStore.getStudentMap().get(rollNumber);
    }

    public void addStudent(Student student) {
        dataStore.getStudentMap().put(student.getRollNo(), student);
    }

    public void addUnregisteredStudents(Student student) {
        dataStore.getUnregisteredStudents().add(student);
    }

    public List<Student> getUnregisteredStudents() {
        return dataStore.getUnregisteredStudents();
    }
}
