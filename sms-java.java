import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Age: " + age +
               ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Add a new student
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        students.add(new Student(id, name, age, grade));
        System.out.println("✅ Student added successfully!");
    }

    // Display all students
    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Search student by ID
    public static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("✅ Student Found: " + s);
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    // Update student info
    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new Name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter new Age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter new Grade: ");
                s.setGrade(sc.nextLine());

                System.out.println("✅ Student updated successfully!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    // Delete student
    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("✅ Student deleted successfully!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("👋 Exiting... Goodbye!");
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 6);
    }
}
