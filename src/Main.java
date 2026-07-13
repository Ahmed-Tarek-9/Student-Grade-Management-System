import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] namesOfStudents = new String[5];
        byte[][] marksOfStudents = new byte[5][3];
        int buffer;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the name of student " + (i + 1) + ":");
            namesOfStudents[i] = scanner.nextLine();
            System.out.println("Enter the marks of student " + (i + 1) + " in 3 subjects: (0-100)");
            for (int j = 0; j < 3; j++) {
                buffer = scanner.nextInt();
                if (buffer < 0 || buffer > 100) {
                    System.out.println("Invalid input. Please enter marks between 0 and 100.");
                    j--; // Decrement j to repeat the input for the same subject
                } else {
                    marksOfStudents[i][j] = (byte) buffer;
                }
            }
            scanner.nextLine(); // Consume the newline character after reading marks
        }

        do {
            displayMenu();
            buffer = scanner.nextInt();
            switch (buffer) {
                case 1:
                    printStudentNames(namesOfStudents);
                    break;

                case 2:
                    printStudentGrades(namesOfStudents, marksOfStudents);
                    break;

                case 3:
                    System.out.println("Enter the name of the student to search:");
                    scanner.nextLine(); // Consume the newline character
                    String searchName = scanner.nextLine();
                    searchStudentByName(namesOfStudents, marksOfStudents, searchName);
                    break;

                case 4:
                    byte passedCount = getCountOfPassedStudents(marksOfStudents);
                    System.out.println("Number of passed students: " + passedCount);
                    break;

                case 5:
                    printAverageOfSubjects(marksOfStudents);
                    break;

                case 6:
                    printHighestGradeInEachSubject(marksOfStudents);
                    break;

                case 0:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (buffer != 0);
    }

    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Show all students names");
        System.out.println("2. Show all students grades in each subject");
        System.out.println("3. Search student by name");
        System.out.println("4. Count passed students");
        System.out.println("5. Display average for each subject");
        System.out.println("6. Display highest grade in each subject");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
    }

    public static char getLetterGrade(byte marks) {
        if (marks >= 85) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 65) {
            return 'C';
        } else if (marks >= 50) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void printStudentNames(String[] namesOfStudents) {
        System.out.println("All students names:");
        for (String name : namesOfStudents) {
            System.out.println(name);
        }
    }

    public static void printStudentGrades(String[] namesOfStudents, byte[][] marksOfStudents) {
        System.out.println("All students grades in each subject:");
        for (int i = 0; i < namesOfStudents.length; i++) {
            System.out.print(namesOfStudents[i] + ": ");
            for (int j = 0; j < marksOfStudents[i].length; j++) {
                System.out.print("(" + marksOfStudents[i][j] + "% = " + getLetterGrade(marksOfStudents[i][j]) + ") ");
            }
            System.out.println();
        }
    }

    public static void searchStudentByName(String[] namesOfStudents, byte[][] marksOfStudents, String searchName) {
        boolean found = false;
        for (int i = 0; i < namesOfStudents.length; i++) {
            if (namesOfStudents[i].equalsIgnoreCase(searchName)) {
                found = true;
                System.out.print(namesOfStudents[i] + ": ");
                for (int j = 0; j < marksOfStudents[i].length; j++) {
                    System.out.print("(" + marksOfStudents[i][j] + "% = " + getLetterGrade(marksOfStudents[i][j]) + ") ");
                }
                System.out.println();
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static byte getCountOfPassedStudents(byte[][] marksOfStudents) {
        byte count = 0;
        for (byte[] marksOfStudent : marksOfStudents) {
            boolean passed = true;
            for (byte b : marksOfStudent) {
                if (b < 50) {
                    passed = false;
                    break;
                }
            }
            if (passed) {
                count++;
            }
        }
        return count;
    }

    public static void printAverageOfSubjects(byte[][] marksOfStudents) {
        double[] subjectAverages = new double[3];
        for (int j = 0; j < 3; j++) {
            short totalMarks = 0;
            for (int i = 0; i < 5; i++) {
                totalMarks += marksOfStudents[i][j];
            }
            subjectAverages[j] = totalMarks / 5.0;
        }
        System.out.println("Average marks for each subject:");
        for (int j = 0; j < subjectAverages.length; j++) {
            System.out.println("Subject " + (j + 1) + ": " + subjectAverages[j] + "%");
        }
    }

    public static void  printHighestGradeInEachSubject(byte[][] marksOfStudents) {
        byte[] highestGrades = new byte[3];
        for (int j = 0; j < 3; j++) {
            byte highest = 0;
            for (int i = 0; i < 5; i++) {
                if (marksOfStudents[i][j] > highest) {
                    highest = marksOfStudents[i][j];
                }
            }
            highestGrades[j] = highest;
        }
        System.out.println("Highest grades for each subject:");
        for (int j = 0; j < highestGrades.length; j++) {
            System.out.println("Subject " + (j + 1) + ": " + highestGrades[j] + "%");
        }
    }
}