import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Учень{" +
                "ім'я = '" + name + '\'' +
                ", вік = " + age +
                ", оцінка = " + grade +
                '}';
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Іван" + "", 23, 88.5),
                new Student("Микола", 21, 92.0),
                new Student("Катерина", 25, 79.5),
                new Student("Олександра", 19, 85.0),
                new Student("Василь", 22, 91.0)
        ));

        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getAge() > 22)
                .collect(Collectors.toList());
        System.out.println("Учні старші за 22 роки: " + filteredStudents);

        List<String> studentNames = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("Імена учнів: " + studentNames);

        int totalAge = students.stream()
                .map(Student::getAge)
                .reduce(0, Integer::sum);
        System.out.println("Загальний вік учнів: " + totalAge);
    }
}
