package javaexamples.generics;

public class GenericsDemo {

    public static void main(String[] args) {
        Gen<String, Integer> obj = new Gen<>("Nitin", 1);
        System.out.println(obj.getName());
        System.out.println(obj.getValue());
        Gen<String, String> obj2 = new Gen<>("Aman", "One");
        System.out.println(obj2.getName());
        System.out.println(obj2.getValue());
    }
}

class Gen<T1, T2> {
    T1 name;
    T2 value;

    Gen(T1 o1, T2 o2) {
        name = o1;
        value = o2;
    }

    public T1 getName() {
        return name;
    }

    public T2 getValue() {
        return value;
    }
}

/*
OP:
Nitin
1
Aman
One
 */
