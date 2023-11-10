import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        int totalMarks = 0;
        double averagePercentage;

        // Input marks for each subject and calculate the total marks
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks entered. Marks should be between 0 and 100.");
                return;
            }

            totalMarks += marks;
        }

        // Calculate the average percentage
        averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

        // Determine the grade based on the average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
