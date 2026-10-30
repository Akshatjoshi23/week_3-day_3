import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class StreamStudent {
    private String name;
    private String department;
    private int marks;

        public StreamStudent(String name, String department, int marks) {
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " - " + department + " - " + marks;
    }
}

public class StreamPractice {

    public static void main(String[] args) {

        ArrayList<StreamStudent> students = new ArrayList<>();

        students.add(new StreamStudent("Akshat", "CSE", 85));
        students.add(new StreamStudent("Rahul", "IT", 65));
        students.add(new StreamStudent("Aman", "CSE", 92));
        students.add(new StreamStudent("Priya", "IT", 38));
        students.add(new StreamStudent("Neha", "ECE", 76));

        // 1. Lambda expression
        students.forEach(s -> System.out.println(s));

        // 2. Functional interface - Predicate
        Predicate<StreamStudent> passed = s -> s.getMarks() >= 40;

        // 3. Filter students who passed
        System.out.println("\nPassed students:");

        students.stream()
                .filter(passed)
                .forEach(System.out::println);

        // 4. Map - get only student names
        System.out.println("\nStudent names:");

        List<String> names = students.stream()
                .map(StreamStudent::getName)
                .collect(Collectors.toList());

        System.out.println(names);

        // 5. Sort students by marks
        System.out.println("\nSorted by marks:");

        students.stream()
                .sorted(Comparator.comparingInt(StreamStudent::getMarks))
                .forEach(System.out::println);

        // 6. Group students by department
        System.out.println("\nStudents by department:");

        Map<String, List<StreamStudent>> groups = students.stream()
                .collect(Collectors.groupingBy(StreamStudent::getDepartment));

        groups.forEach((department, list) ->
                System.out.println(department + ": " + list));

        // 7. Calculate total marks
        int total = students.stream()
                .mapToInt(StreamStudent::getMarks)
                .sum();

        System.out.println("\nTotal marks: " + total);

        // 8. Calculate average marks
        double average = students.stream()
                .mapToInt(StreamStudent::getMarks)
                .average()
                .orElse(0.0);

        System.out.println("Average marks: " + average);

        // 9. Find student by name using Optional
        Optional<StreamStudent> result = students.stream()
                .filter(s -> s.getName().equalsIgnoreCase("Rahul"))
                .findFirst();

        System.out.println("\nSearch result:");

        System.out.println(
                result.map(StreamStudent::toString)
                      .orElse("Student not found")
        );

        // 10. Find student with highest marks
        Optional<StreamStudent> topper = students.stream()
                .max(Comparator.comparingInt(StreamStudent::getMarks));

        System.out.println("\nTopper:");

        System.out.println(
                topper.map(StreamStudent::toString)
                      .orElse("No students found")
        );
    }
}

