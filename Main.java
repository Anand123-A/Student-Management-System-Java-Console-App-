import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.loadFromFile("student.txt");

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    manager.addStudent(new StudManagement(id, name, age, course));
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = Integer.parseInt(scanner.nextLine());
                    StudManagement student = manager.searchStudent(searchId);
                    if (student != null) System.out.println(student);
                    else System.out.println(" Student not found.");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("New Age: ");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    System.out.print("New Course: ");
                    String newCourse = scanner.nextLine();
                    if (manager.updateStudent(updateId, newName, newAge, newCourse))
                        System.out.println(" Student updated.");
                    else
                        System.out.println(" Student not found.");
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    if (manager.deleteStudent(deleteId))
                        System.out.println(" Student deleted.");
                    else
                        System.out.println(" Student not found.");
                    break;

                case 0:
                    manager.saveToFile("student.txt");
                    System.out.println(" Data saved. Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid choice.");
            }
        }
    }
}
