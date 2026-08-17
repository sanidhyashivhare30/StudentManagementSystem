import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== STUDENT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Thank you for using Student Management System!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student ---");

        System.out.print("Enter student ID: ");
        int id = readInt();

        if (findStudent(id) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = readInt();

        System.out.print("Enter course: ");
        String course = sc.nextLine();

        System.out.print("Enter marks: ");
        double marks = readDouble();

        students.add(new Student(id, name, age, course, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        System.out.println("\n--- Search Student ---");
        System.out.print("Enter student ID: ");
        int id = readInt();

        Student student = findStudent(id);

        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.println("\n--- Update Student ---");
        System.out.print("Enter student ID: ");
        int id = readInt();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        student.setName(sc.nextLine());

        System.out.print("Enter new age: ");
        student.setAge(readInt());

        System.out.print("Enter new course: ");
        student.setCourse(sc.nextLine());

        System.out.print("Enter new marks: ");
        student.setMarks(readDouble());

        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter student ID: ");
        int id = readInt();

        Student student = findStudent(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(sc.nextLine().trim());
                if (value < 0 || value > 100) {
                    System.out.print("Enter marks between 0 and 100: ");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}