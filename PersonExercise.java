import java.util.*;

class Person {
    String name;
    int age;
    double netIncome;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void speak() {
        System.out.println(name + " is speaking.");
    }

    void walk() {
        int steps = (int)(Math.random() * 100);
        System.out.println(name + " walked " + steps + " steps.");
    }

    void relax() {
        String[] methods = {"reading", "sleeping", "meditating"};
        int choice = (int)(Math.random() * methods.length);
        System.out.println(name + " is relaxing by " + methods[choice] + ".");
    }

    double calculateNetWorth(double annualSalary, double monthlySpending) {
        double yearlySpending = monthlySpending * 12;
        return annualSalary - yearlySpending;
    }
}

class Student extends Person {
    double grade;

    public Student(String name, int age, double grade) {
        super(name, age);
        this.grade = grade;
    }
}

class Teacher extends Person {
    int amiability;

    public Teacher(String name, int age, int amiability) {
        super(name, age);
        this.amiability = amiability;
    }
}

class Parent extends Person {
    int trust;

    public Parent(String name, int age, int trust) {
        super(name, age);
        this.trust = trust;
    }

    void PTconference(Student student, Teacher teacher) {
        System.out.println("Parent-Teacher Conference:");

        if (student.grade >= 85) {
            System.out.println("Teacher: " + student.name + " is doing very well!");
        } else {
            System.out.println("Teacher: " + student.name + " needs improvement.");

            if (trust >= 70) {
                if (teacher.amiability < 40) {
                    System.out.println("Parent: I don't believe you. Maybe it's your fault!");
                } else {
                    System.out.println("Parent: Okay, we will work on it at home.");
                }
            } else {
                System.out.println("Parent: This is unacceptable! Grounded!");
            }
        }
    }
}

public class PersonExercise {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 30, 75));
        students.add(new Student("Bob", 45, 82));
        students.add(new Student("Charlie", 20, 90));
        students.add(new Student("Diana", 25, 67));
        students.add(new Student("Ethan", 35, 88));

        Random rand = new Random();

        Student randomStudent = students.get(rand.nextInt(students.size()));
        Teacher randomTeacher = new Teacher("Mrs. Smith", 40, rand.nextInt(101));
        Parent randomParent = new Parent("Mr. Lee", 45, rand.nextInt(101));

        randomParent.PTconference(randomStudent, randomTeacher);

        Student random1 = students.get(rand.nextInt(students.size()));
        Student random2 = students.get(rand.nextInt(students.size()));
        while (random1 == random2) {
            random2 = students.get(rand.nextInt(students.size()));
        }

        randomRelationship(random1, random2);
    }

    static void randomRelationship(Person a, Person b) {
        String[] relations = {"friends", "colleagues", "enemies", "siblings", "neighbors"};
        int r = (int)(Math.random() * relations.length);
        System.out.println(a.name + " and " + b.name + " are " + relations[r] + ".");
    }
}