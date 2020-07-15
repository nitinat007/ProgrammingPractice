package javaexamples.enums;

enum Student {
    Smith(11), Donald(15), Sam(13), Amit(9);
    private int age;

    int getAge() {
        return age;
    }

    Student(int age)  //constructor defined in enum Student
    {
        this.age = age;
    }
}

class EnumDemo {
    public static void main(String args[]) {
        System.out.println("Age of Smith is " + Student.Smith.getAge() + "years");
    }
}

/*
O/P:
Age of Smith is 11years
 */