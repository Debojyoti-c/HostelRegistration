package models;


public class Student {

    private Integer rollNo;

    private String classGrade;

    private FoodType foodType;

    private Hostel hostel;

    public Student(Integer rollNo, String classGrade, FoodType foodType) {
        this.rollNo = rollNo;
        this.classGrade = classGrade;
        this.foodType = foodType;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }
}
