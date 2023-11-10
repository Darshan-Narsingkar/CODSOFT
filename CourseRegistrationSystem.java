import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<String> enrolledStudents;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean enrollStudent(String studentName) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(studentName);
            return true;
        }
        return false;
    }

    public void dropStudent(String studentName) {
        enrolledStudents.remove(studentName);
    }

    @Override
    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description
                + "\nCapacity: " + capacity + "\nSchedule: " + schedule;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<String> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList();

        // Sample courses
        courses.add(new Course("CSCI101", "Introduction to Programming", "Basic programming concepts", 30, "MWF 10:00 AM"));
        courses.add(new Course("MATH201", "Calculus I", "Introductory calculus", 25, "TTH 1:30 PM"));
        courses.add(new Course("PHYS101", "Physics for Engineers", "Mechanics and thermodynamics", 40, "MWF 2:00 PM"));

        // Sample students
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(3, "Charlie"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Course Registration System");
            System.out.println("1. View Course Listing");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Available Courses:");
                    for (Course course : courses) {
                        System.out.println(course.toString());
                        System.out.println("Enrolled Students: " + course.getEnrolledStudents().size() + "/" + course.getCapacity());
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Enter your student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.print("Enter the course code you want to register for: ");
                    String courseCode = scanner.nextLine();

                    Student student = findStudent(students, studentID);
                    Course course = findCourse(courses, courseCode);

                    if (student != null && course != null) {
                        if (course.enrollStudent(student.getName())) {
                            student.registerCourse(courseCode);
                            System.out.println("Registration successful!");
                        } else {
                            System.out.println("Course is already full. Registration failed.");
                        }
                    } else {
                        System.out.println("Student or course not found. Registration failed.");
                    }
                    break;
                case 3:
                    System.out.print("Enter your student ID: ");
                    int studentIDToDrop = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.print("Enter the course code you want to drop: ");
                    String courseCodeToDrop = scanner.nextLine();

                    Student studentToDrop = findStudent(students, studentIDToDrop);
                    Course courseToDrop = findCourse(courses, courseCodeToDrop);

                    if (studentToDrop != null && courseToDrop != null) {
                        courseToDrop.dropStudent(studentToDrop.getName());
                        studentToDrop.dropCourse(courseCodeToDrop);
                        System.out.println("Course dropped successfully.");
                    } else {
                        System.out.println("Student or course not found. Dropping failed.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the Course Registration System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    private static Student findStudent(List<Student> students, int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourse(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
