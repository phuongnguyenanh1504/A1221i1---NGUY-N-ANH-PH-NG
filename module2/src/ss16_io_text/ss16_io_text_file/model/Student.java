package ss16_io_text_file.model;

public class Student implements Comparable<Student> {
    private String nameStudent;
    private double point;
    private String dateOfBirth;

    public Student() {
    }

    public Student(String nameStudent, double point, String dateOfBirth) {
        this.nameStudent = nameStudent;
        this.point = point;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameStudent='" + nameStudent + '\'' +
                ", point=" + point +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int compareTo(Student o) {
        if(this.point <o.getPoint()) {
            return 1;
        } else {
            return -1;
        }
    }
}