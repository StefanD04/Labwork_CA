//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Insert students: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            student[] students = new student[n];

            // Въвеждане на информация за студентите
            for (int i = 0; i < n; i++) {
                System.out.println("\nStudent " + (i + 1) + ":");

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Faculty number: ");
                String faculty_number = scanner.nextLine();

                System.out.print("Grade: ");
                double grade = scanner.nextDouble();
                scanner.nextLine();

                students[i] = new student(name, faculty_number, grade);
            }

            for (int i = 0; i < n; i++) {
                if (students[i].grade >= 3) {
                    students[i].displayinfo();
                }
            }

            scanner.close();
        }

    }
