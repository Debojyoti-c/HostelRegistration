package dtos;


public class RegistrationDTO {

    private String rollNumber;

    private String grade;

    private String food;

    public RegistrationDTO(String rollNumber, String grade, String food) {
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.food = food;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
