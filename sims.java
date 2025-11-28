import java.util.*;

// Base class
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Encapsulation: getters/setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Student class inherits Person
class Student extends Person {
    private String studentId;
    private String course;

    public Student(String name, int age, String studentId, String course) {
        super(name, age); // calling parent constructor
        this.studentId = studentId;
        this.course = course;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    // Polymorphism: overriding displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId + ", Course: " + course);
    }
}

// Management System
class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("✅ Student added successfully!");
    }

    public void removeStudent(String studentId) {
        students.removeIf(s -> s.getStudentId().equals(studentId));
        System.out.println("❌ Student removed successfully!");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                s.displayInfo();
                System.out.println("-------------------");
            }
        }
    }

    public Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\n--- Student Information Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Find Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    sms.addStudent(new Student(name, age, id, course));
                    break;

                case 2:
                    System.out.print("Enter Student ID to remove: ");
                    String removeId = sc.nextLine();
                    sms.removeStudent(removeId);
                    break;

                case 3:
                    sms.displayAllStudents();
                    break;

                case 4:
                    System.out.print("Enter Student ID to find: ");
                    String findId = sc.nextLine();
                    Student found = sms.findStudent(findId);
                    if (found != null) {
                        found.displayInfo();
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
