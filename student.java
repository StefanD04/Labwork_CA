public class student {
    String name;
    String faculty_number;
    double grade;

    public student(String name, String faculty_number, double grade)
    {
        this.name = name;
        this.faculty_number = faculty_number;
        this.grade = grade;
    }


    public void displayinfo() {
        System.out.println("Name: " + name);
        System.out.println("Faculty number: " + faculty_number);
        System.out.println("Grade: " + grade);
        System.out.println("-------------");

    }
}
