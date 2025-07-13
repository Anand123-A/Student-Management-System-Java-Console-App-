import java.util.*;
import java.io.*;

public class StudentManager {
    private List<StudManagement> studentList = new ArrayList<>();

    public void addStudent(StudManagement student) {
        studentList.add(student);
        System.out.println(" Student added successfully.");
    }

    public void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println(" No students found.");
        } else {
            for (StudManagement s : studentList) {
                System.out.println(s);
            }
        }
    }

    public StudManagement searchStudent(int id) {
        for (StudManagement s : studentList) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public boolean updateStudent(int id, String name, int age, String course) {
        StudManagement student = searchStudent(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        StudManagement student = searchStudent(id);
        if (student != null) {
            studentList.remove(student);
            return true;
        }
        return false;
    }

    public void saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (StudManagement s : studentList) {
                bw.write(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getCourse());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(" Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        studentList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String course = parts[3];
                studentList.add(new StudManagement(id, name, age, course));
            }
        } catch (FileNotFoundException e) {
            // Ignore if file doesn't exist
        } catch (IOException | NumberFormatException e) {
            System.out.println(" Error loading from file: " + e.getMessage());
        }
    }
}


