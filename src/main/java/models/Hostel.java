package models;

import java.util.LinkedList;
import java.util.List;

public class Hostel {

    private Integer capacity;

    private FoodType foodType;

    private String classGrade;

    private List<Student> studentList;

    public Hostel(Integer capacity, FoodType foodType, String classGrade) {
        this.capacity = capacity;
        this.foodType = foodType;
        this.classGrade = classGrade;
        this.studentList = new LinkedList<>();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
